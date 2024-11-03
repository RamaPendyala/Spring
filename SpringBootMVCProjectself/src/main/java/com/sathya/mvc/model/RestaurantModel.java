package com.sathya.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantModel {
public long Id;
public long getId() {
	return Id;
}
public void setId(long id) {
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
private String itemName;
private String description;
private String category;
private double price;
private String Ingredients;
private String spicinessLevel;
private String availability;//7

}
