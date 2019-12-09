package main.pl.javasolution.controller;

import main.pl.javasolution.domain.Product;
import main.pl.javasolution.exception.NoProductsFoundUnderCategoryException;
import main.pl.javasolution.exception.ProductNotFoundException;
import main.pl.javasolution.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping
    public String list(Model model){
        model.addAttribute("products",productService.getAllProducts());
        return "products";
    }

    @RequestMapping("/all")
    public ModelAndView allProducts() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products",productService.getAllProducts());
        modelAndView.setViewName("products");
        return modelAndView;
    }

    @RequestMapping("/{category}")
    public String getProductByCategory(Model model, @PathVariable("category") String productCategory){
        List<Product> products = productService.getProductsByCategory(productCategory);
        if (products == null || products.isEmpty()){
            throw new NoProductsFoundUnderCategoryException();
        }
        model.addAttribute("products", products);
        return "products";
    }

    @RequestMapping("/filter/{ByCriteria}")
    public String getProductsByFilter(@MatrixVariable(pathVar ="ByCriteria")Map<String, List<String>> filterParams, Model model){
        model.addAttribute("products", productService.getProductsByFilter(filterParams));
        return "products";
    }

    @RequestMapping("/product")
    public String getProductById(@RequestParam("id") String productId, Model model){
        model.addAttribute("product", productService.getProductById(productId));
        return "product";
    }

    @RequestMapping("/{category}/{ByPrice}")
    public String getProductsByFilterManufacturt(@RequestParam("manufacturer") String manufacturer, Model model,
                                                 @PathVariable("category") String category,
                                                 @MatrixVariable(pathVar ="ByPrice")Map<String,String> filterParams ) {
        model.addAttribute("products", productService.getFilterProductManufacturer(manufacturer, category, filterParams));
        return "products";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewProductForm(Model model){
        Product product = new Product();
        model.addAttribute("newProduct",product);
        return "addProduct";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct, BindingResult result, HttpServletRequest request){
        String[] suppressedFields = result.getSuppressedFields();
        if (suppressedFields.length>0) {
            throw new RuntimeException("Próba wiazania niedozwolonych pol: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }
        MultipartFile productImage = newProduct.getProductImage();
        MultipartFile productFile = newProduct.getProductFile();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        if (productImage != null && !productImage.isEmpty()){
            try {
                productImage.transferTo(new File(rootDirectory+"WEB-INF\\images\\"+newProduct.getProductId()+".jpg"));
            } catch (Exception e) {
                throw new RuntimeException("Niepowodzenie podczas proby zapisu obrazka", e);
            }
        }
        if (productFile != null && !productFile.isEmpty()) {
            try {
                productFile.transferTo(new File(rootDirectory+"WEB-INF\\pdf\\"+newProduct.getProductId()+".pdf"));
            } catch (Exception e) {
                throw new RuntimeException("Niepowodzenie podczas proby zapisu pliku", e);
            }
        }
        productService.addProduct(newProduct);
        return "redirect:/products";
    }

    @InitBinder
    public void initialiseBinder(WebDataBinder binder){
        binder.setDisallowedFields("unitsInOrder","discontinued");
        binder.setAllowedFields("productId","name","unitPrice","description","manufacturer","category","unitsInStock","productImage","condition","productFile");
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handleError(HttpServletRequest request, ProductNotFoundException exception){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("invalidProductId", exception.getProductId());
        modelAndView.addObject("exception",exception);
        modelAndView.addObject("url", request.getRequestURI()+"?"+request.getQueryString());
        modelAndView.setViewName("productNotFound");
        return modelAndView;
    }
}
