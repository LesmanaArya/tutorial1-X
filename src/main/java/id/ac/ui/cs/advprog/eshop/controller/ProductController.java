package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.service.CarServiceImpl;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        service.editProduct(productName, product);
        return "redirect:../list";
    }

    @GetMapping("/delete/{productName}")
    public String deleteProduct(@PathVariable String productName) {
        service.deleteProductByName(productName);
        return "redirect:../list";
    }

    @Controller
    @RequestMapping("/car")
    class CarController extends ProductController {
        @Autowired
        private CarServiceImpl carservice;

        @GetMapping("/createCar")
        public String createCarPage(Model model) {
            Car car = new Car();
            model.addAttribute("car", car);
            return "createCar";
        }

        @PostMapping("/createCar")
        public String createCarPost(@ModelAttribute Car car, Model model) {
            carservice.create(car);
            return "redirect:listCar";
        }

        @GetMapping("/listCar")
        public String carListPage(Model model) {
            List<Car> allCars = carservice.findAll();
            model.addAttribute("cars", allCars);
            return "carList";
        }

        @GetMapping("/editCar/{carId}")
        public String editCarPage(@PathVariable String carId, Model model) {
            Car car = carservice.findById(carId);
            model.addAttribute("car", car);
            return "editCar";
        }

        @PostMapping("/editCar")
        public String editCar(@ModelAttribute Car car, Model model) {
            System.out.println(car.getCarId());
            carservice.update(car.getCarId(), car);

            return "redirect:listCar";
        }

        @PostMapping("/deleteCar")
        public String deleteCar(@RequestParam("carId") String carId) {
            carservice.deleteCarById(carId);
            return "redirect:listCar";
        }
    }
}