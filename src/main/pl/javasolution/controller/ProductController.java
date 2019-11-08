package main.pl.javasolution.controller;

import main.pl.javasolution.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

    }
