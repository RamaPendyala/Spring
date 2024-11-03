package com.sathya.mvc.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.mvc.entity.RestaurantEntity;
import com.sathya.mvc.model.RestaurantModel;
import com.sathya.mvc.repository.RestaurantRepository;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public void saveRestaurantItem(RestaurantModel restaurantModel) {
        RestaurantEntity restaurantEntity = new RestaurantEntity();
        // Map fields from model to entity
        restaurantEntity.setItemName(restaurantModel.getItemName());
        restaurantEntity.setDescription(restaurantModel.getDescription());
        restaurantEntity.setCategory(restaurantModel.getCategory());
        restaurantEntity.setPrice(restaurantModel.getPrice());
        restaurantEntity.setIngredients(restaurantModel.getIngredients());
        restaurantEntity.setSpicinessLevel(restaurantModel.getSpicinessLevel());
        restaurantEntity.setAvailability(restaurantModel.getAvailability());
        restaurantEntity.setVisitedOn(LocalDate.now());
        restaurantEntity.setManagerName(System.getProperty("user.name"));

        // Save the entity
        restaurantRepository.save(restaurantEntity);
    }

    public List<RestaurantEntity> getAllItems() {
        return restaurantRepository.findAll();
    }

    public void deleteItemById(Long id) {
        restaurantRepository.deleteById(id); 
    }

    public RestaurantModel getItemById(Long id) {
        Optional<RestaurantEntity> optionalEntity = restaurantRepository.findById(id);
        if (optionalEntity.isPresent()) {
            RestaurantEntity entity = optionalEntity.get();
            return convertToModel(entity);
        }
        return null; // Or handle as you prefer
    }
    private RestaurantModel convertToModel(RestaurantEntity entity) {
        RestaurantModel model = new RestaurantModel();
      
        model.setItemName(entity.getItemName());
        model.setDescription(entity.getDescription());
        model.setCategory(entity.getCategory());
        model.setPrice(entity.getPrice());
        model.setIngredients(entity.getIngredients());
        model.setSpicinessLevel(entity.getSpicinessLevel());
        model.setAvailability(entity.getAvailability());
        restaurantRepository.save(entity);
        return model;
    }
    
    public void updateItem(RestaurantModel restaurantModel) {
        Optional<RestaurantEntity> optionalEntity = restaurantRepository.findById(restaurantModel.getId());
        if (optionalEntity.isPresent()) {
            RestaurantEntity entity = optionalEntity.get();
            // Update fields
            entity.setItemName(restaurantModel.getItemName());
            entity.setDescription(restaurantModel.getDescription());
            entity.setCategory(restaurantModel.getCategory());
            entity.setPrice(restaurantModel.getPrice());
            entity.setIngredients(restaurantModel.getIngredients());
            entity.setSpicinessLevel(restaurantModel.getSpicinessLevel());
            entity.setAvailability(restaurantModel.getAvailability());

            // Save the updated entity
            restaurantRepository.save(entity);
        }
    }

   
       
    }

