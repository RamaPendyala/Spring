package com.sathya.mvc.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sathya.mvc.entity.ProductEntity;
import com.sathya.mvc.model.ProductModel;
import com.sathya.mvc.service.ProductService;

import jakarta.validation.Valid;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
  @GetMapping("/productform")
    public String getProductForm(Model model) {  
        ProductModel productModel = new ProductModel();
        model.addAttribute("productModel", productModel);  
        model.addAttribute("page","productform" ); 
        return "index";  
    }

 @PostMapping("/saveProduct")
    public String saveProduct(@Valid ProductModel productModel,BindingResult bindingResult ,Model model) {
	 model.addAttribute("page","saveProduct" );
	 if(bindingResult.hasErrors()) {
     	return "add-product";
     }
        productService.saveProductData(productModel);
        return "index";  
    }
 @GetMapping("/getproduct")
    public String getProducts(Model model) {
        List<ProductEntity> products = productService.getAllProducts();
        model.addAttribute("products", products);
        model.addAttribute("page","getproduct" );
        return "index"; 
}
 @GetMapping("/searchform")
 public String getSearchForm(Model model) {
	 ProductModel productModel = new ProductModel();
     model.addAttribute("productModel", productModel);
     model.addAttribute("page","searchform" );
     return "index"; 
 }
 @GetMapping("/searchProduct")
 public String searchProduct(@RequestParam long proId, Model model) {
     ProductEntity product = productService.getProductById(proId);
     model.addAttribute("page","searchProduct" );
     if (product != null) {
         model.addAttribute("product", product);
     } else {
         model.addAttribute("error", "Product not found!");
     }
     return "index"; 
 }
 @GetMapping("/delete")
 public String deleteProduct(@RequestParam("id") Long proID) {
     productService.deleteProductById(proID);
     return "redirect:/getproduct"; 
 }
 
 @GetMapping("/edit")
 public String showEditForm(@RequestParam("proId") Long proId, Model model) {
     // Fetch the product by ID and add it to the model
     ProductEntity productModel = productService.getProductById(proId);
     model.addAttribute("productModel", productModel);
     model.addAttribute("categories", Arrays.asList("Mobile", "Camera", "Printer", "Laptop", "Accessories"));

     model.addAttribute("proId", proId);
     
     return "edithtml";  
 }

 
 @PostMapping("/update")

 public String saveUpdatedPRoduct (Long proId, ProductModel productModel)
 {
 productService.updateService (proId, productModel);
 return "redirect:getproduct";
}
 

 @GetMapping("/contact")
 public String showContactForm(Model model) {
	 model.addAttribute("page", "contact");
     return "index"; 
 }
 
 @GetMapping("/aboutus")
 public String aboutUsForm(Model model) {
     model.addAttribute("page", "aboutus");
     return "index";
 }
 @GetMapping("/")
 public String getHomePage() {
     return "index"; 
 }
 
}
