package edu.iss.inventory.service;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import edu.iss.inventory.model.Product;

public interface ProductService {

	ArrayList<Product> findAllProducts();

	Product createProduct(Product prd);

	Product changeProduct(Product prd);

	void removeProduct(Product prd);
	
	Product findProducts(String id);
	
	ArrayList<Product> searchProduct(Product product);

}