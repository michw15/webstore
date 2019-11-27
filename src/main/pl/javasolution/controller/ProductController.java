package main.pl.javasolution.controller;

import main.pl.javasolution.domain.Product;
import main.pl.javasolution.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
        model.addAttribute("products", productService.getProductsByCategory(productCategory));
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
    public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct, BindingResult result){
        String[] suppressedFields = result.getSuppressedFields();
        if (suppressedFields.length>0) {
            throw new RuntimeException("Próba wiazania niedozwolonych pol: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }
        productService.addProduct(newProduct);
        return "redirect:/products";
    }

    @InitBinder
    public void initialiseBinder(WebDataBinder binder){
        binder.setDisallowedFields("unitsInOrder","discontinued");
    }
}
