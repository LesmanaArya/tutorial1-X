package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductAlreadyExistsException;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/create")
    public String createProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "CreateProduct";
    }

    @PostMapping("/create")
    public String createProductPost(@ModelAttribute Product product, Model model) {
        service.create(product);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String productListPage(Model model) {
        List<Product> allProduct = service.findAll();
        allProduct.sort(Comparator.comparing(Product::getProductName));
        model.addAttribute("products", allProduct);
        return "ListProduct";
    }

    @GetMapping("/edit/{productName}")
    public String editProductPage(@PathVariable String productName, Model model) {
        Product product = service.findProductByName(productName);
        model.addAttribute("product", product);
        return "EditProduct";
    }

    @PostMapping("/edit/{productName}")
    public String editProductPost(@PathVariable String productName, Model model, @ModelAttribute Product product) {
        try {
            service.editProduct(productName, product);
        } catch (ProductAlreadyExistsException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "EditProduct";
        }
        return "redirect:../list";
    }

    @GetMapping("/delete/{productName}")
    public String deleteProduct(@PathVariable String productName) {
        service.deleteProductByName(productName);
        return "redirect:../list";
    }
}