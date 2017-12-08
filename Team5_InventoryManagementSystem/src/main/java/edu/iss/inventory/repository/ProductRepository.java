package edu.iss.inventory.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.inventory.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>  {

	@Query("SELECT p FROM product p where p.partNo = :partNo")
	Product findProductByPartNo(@Param("partNo") String partNo);
	
	@Query("SELECT p FROM product p where p.carDealer = :carDealer")
	Product findProductByCarDealer(@Param("carDealer") String carDealer);	
	
	@Query("SELECT p FROM product p where p.color = :color and p.carDealer = :carDealer")
	Product findProductByDealerNColor(@Param("color") String color, @Param("carDealer") String carDealer);
	
	@Query("SELECT p FROM product p where p.avaliableQty <= p.reorderLevel")
	ArrayList<Product> findProductsToReorder();
}
