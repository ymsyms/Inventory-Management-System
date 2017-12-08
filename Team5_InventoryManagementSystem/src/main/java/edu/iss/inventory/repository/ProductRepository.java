package edu.iss.inventory.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Integer>  {

	@Query("SELECT p FROM product p where p.partNo = :partNo")
	Product findProductById(@Param("partNo") String partNo);
	
	@Query("SELECT p FROM product p where p.carDealer = :carDealer")
	Product findProductByCarDealer(@Param("carDealer") String carDealer);	
}
