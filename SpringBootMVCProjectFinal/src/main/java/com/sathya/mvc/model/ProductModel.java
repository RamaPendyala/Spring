package com.sathya.mvc.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
	
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProBrand() {
		return proBrand;
	}
	public void setProBrand(String proBrand) {
		this.proBrand = proBrand;
	}
	public double getProPrice() {
		return proPrice;
	}
	public  void setProPrice(double proPrice) {
		this.proPrice = proPrice;
	}
	public String getProDescription() {
		return proDescription;
	}
	public void setProDescription(String proDescription) {
		this.proDescription = proDescription;
	}
	public String getProCategory() {
		return proCategory;
	}
	public void setProCategory(String proCategory) {
		this.proCategory = proCategory;
	}
//	
//	public Long getProId() {
//		return proId;
//	}
//	public void setProId(Long proId) {
//		this.proId = proId;
//	}
//	private Long proId;
	 @NotBlank(message = "Product name cannot be blank")
	   @Size(min = 2, max = 100, message = "Product name must be between 2 and 100 characters")
	private String proName;
	 @NotBlank(message = "Product brand cannot be blank")
	    @Size(min = 2, max = 50, message = "Product brand must be between 2 and 50 characters")
	private String proBrand;
	 @NotNull(message = "Product price cannot be null")
	    @DecimalMin(value = "0.01", message = "Product price must be greater than zero")
	private double proPrice;
	 @NotBlank(message = "Product description is required.")
	    @Size(max = 500, message = "Description cannot exceed 500 characters.")
	private String proDescription;
	 @NotBlank(message = "Product category cannot be blank")
	    @Size(min = 2, max = 50, message = "Product category must be between 2 and 50 characters")
	private String proCategory;
	

}
