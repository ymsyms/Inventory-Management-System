package edu.iss.inventory.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.inventory.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>  {

	
	@Query("SELECT p FROM Product p where p.partNo = :partNo")
	Product findProductByPartNo(@Param("partNo") String partNo);
	
	@Query("SELECT p FROM Product p where p.carDealer = :carDealer")
	ArrayList<Product> findProductByCarDealer(@Param("carDealer") String carDealer);	
	
	@Query("SELECT p FROM Product p where p.color = :color and p.carDealer = :carDealer")
	ArrayList<Product> findProductByDealerNColor(@Param("color") String color, @Param("carDealer") String carDealer);
	
	@Query("SELECT p FROM Product p where p.avaliableQty <= p.reorderLevel")
	ArrayList<Product> findProductsToReorder();
}
