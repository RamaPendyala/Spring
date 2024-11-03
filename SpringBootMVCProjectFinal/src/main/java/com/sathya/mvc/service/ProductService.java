package com.sathya.mvc.service;
	import java.time.LocalDate;
	import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;


	import com.sathya.mvc.entity.ProductEntity;
	import com.sathya.mvc.model.ProductModel;
	import com.sathya.mvc.repository.ProductRepository;

	@Service
	public class ProductService {
			@Autowired
			ProductRepository productRepository;
			private double price;
			
			public void saveProductData(ProductModel productModel)
			{
				double price = productModel.getProPrice();
				String category = productModel.getProCategory();
				double dprice = 0.0; 
				
				 switch (category) {
		         case "mobile":
		             dprice = price * 0.1; 
		             break;
		         case "laptop":
		        	 dprice = price * 0.15;
		             break;
		         case "printer":
		        	 dprice = price * 0.2;
		             break;
		         case "camera":
		        	 dprice = price * 0.25;
		             break;
				 }
				 
			 //Read the data from Model set the data to entity 
			 ProductEntity productEntity = new ProductEntity();
			 productEntity.setProName(productModel.getProName());
			 productEntity.setProPrice(productModel.getProPrice()); 
			 productEntity.setProCategory(productModel.getProCategory()); 
			 productEntity.setProDescription(productModel.getProDescription()); 
			 productEntity.setProBrand(productModel.getProBrand());
			 
			 productEntity.setProDisPrice(dprice);
			 productEntity.setCreatedAt(LocalDate.now());
			 productEntity.setCreatedBy(System.getProperty("user.name"));
				 
				 productRepository.save(productEntity);	 
			}
			
			 public List<ProductEntity> getAllProducts() {
			        List<ProductEntity> products = productRepository.findAll();
			        return products;
			        
			}
			 public ProductEntity getProductById(long proId) {
				    return productRepository.findById(proId).orElse(null); 
				}
			 public void deleteProductById(Long proID) {
			        productRepository.deleteById(proID);
			    }
			 public ProductModel editProduct(long proId) {
			        Optional<ProductEntity> optionalProduct = productRepository.findById(proId);
			        ProductModel productModel = new ProductModel();

			        if (optionalProduct.isPresent()) {
			            ProductEntity productEntity = optionalProduct.get();
			            productModel.setProName(productEntity.getProName());
			            productModel.setProPrice(productEntity.getProPrice());
			            productModel.setProBrand(productEntity.getProBrand());
			            productModel.setProCategory(productEntity.getProCategory());
			            productModel.setProDescription(productEntity.getProDescription());
			        }
			        return productModel;
			    }

			    public void updateService(long id, ProductModel productModel) {
			        Optional<ProductEntity> productEntityOptional = productRepository.findById(id);
			        if (productEntityOptional.isPresent()) {
			            ProductEntity productEntity = productEntityOptional.get();
			            double price = productModel.getProPrice();
			            String category = productModel.getProCategory();
			            double dprice = calculateDiscountedPrice(price, category);

			            productEntity.setProName(productModel.getProName());
			            productEntity.setProPrice(price);
			            productEntity.setProCategory(category);
			            productEntity.setProDescription(productModel.getProDescription());
			            productEntity.setProBrand(productModel.getProBrand());
			            productEntity.setProDisPrice(dprice);

			            productRepository.save(productEntity);
			        }
			    }

			    private double calculateDiscountedPrice(double price, String category) {
			        double dprice = 0.0;
			        switch (category) {
			            case "mobile":
			                dprice = price * 0.1;
			                break;
			            case "laptop":
			                dprice = price * 0.15;
			                break;
			            case "printer":
			                dprice = price * 0.2;
			                break;
			            case "camera":
			                dprice = price * 0.25;
			                break;
			            default:
			                // Handle unknown category or no discount
			                break;
			        }
			        return dprice;
			    }
			}	