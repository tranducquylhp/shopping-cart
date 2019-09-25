package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@PropertySource("classpath:global_config_app.properties")
public class ProductController {

    @Autowired
    Environment env;

    @Autowired
    private ProductService productService;

    @RequestMapping("/products")
    public ModelAndView listProducts() {
        Iterable<Product> products = productService.findAll();

        ModelAndView modelAndView = new ModelAndView("/product/list", "products", products);
        return modelAndView;
    }

    @RequestMapping("/product/view/{id}")
    public ModelAndView view(@PathVariable long id){
        Product product = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/product/view","product", product);
        return modelAndView;
    }
}