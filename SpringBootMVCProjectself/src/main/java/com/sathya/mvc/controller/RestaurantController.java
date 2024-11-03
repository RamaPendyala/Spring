package com.sathya.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sathya.mvc.entity.RestaurantEntity;
import com.sathya.mvc.model.RestaurantModel;
import com.sathya.mvc.service.RestaurantService;

@Controller
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/resform")
    public String getResForm(Model model) {
        model.addAttribute("restaurantModel", new RestaurantModel());
        return "add-item"; // Ensure this view exists
    }

    @PostMapping("/saveitem")
    public String saveItem(@ModelAttribute RestaurantModel restaurantModel) { 
        restaurantService.saveRestaurantItem(restaurantModel);
        return "success"; // Ensure this view exists
    }

    @GetMapping("/getitem")
    public String getItems(Model model) {
        List<RestaurantEntity> items = restaurantService.getAllItems();
        model.addAttribute("items", items);
        return "item_list"; 
    }

    @PostMapping("/delete")
    public String deleteItem(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        restaurantService.deleteItemById(id);
        redirectAttributes.addFlashAttribute("successMessage", "Item deleted successfully!");
        return "redirect:/getitem"; 
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam("id") Long id, Model model) {
        RestaurantModel restaurantModel = restaurantService.getItemById(id); // Fetch item by ID
        model.addAttribute("restaurantModel", restaurantModel); // Add the existing item to the model
        return "eidt-form"; // Ensure this view exists
    }
    
    

    @PostMapping("/update")
    public String updateItem(@ModelAttribute("restaurantModel") RestaurantModel restaurantModel) {
        restaurantService.updateItem(restaurantModel); 
        return "redirect:/getitem"; 
    }
}
