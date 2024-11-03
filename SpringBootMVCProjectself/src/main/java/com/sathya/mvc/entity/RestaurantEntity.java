package com.sathya.mvc.entity;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long Id;
	private String itemName;
	private String description;
	private String category;
	private double price;
	private String Ingredients;
	private String spicinessLevel;
	private String availability;
	private LocalDate visitedOn;
	private String managerName;
	
    
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getIngredients() {
		return Ingredients;
	}
	public void setIngredients(String ingredients) {
		Ingredients = ingredients;
	}
	public String getSpicinessLevel() {
		return spicinessLevel;
	}
	public void setSpicinessLevel(String spicinessLevel) {
		this.spicinessLevel = spicinessLevel;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public LocalDate getVisitedOn() {
		return visitedOn;
	}
	public void setVisitedOn(LocalDate visitedOn) {
		this.visitedOn = visitedOn;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	

}
