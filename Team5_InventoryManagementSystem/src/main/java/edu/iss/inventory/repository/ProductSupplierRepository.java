package edu.iss.inventory.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.inventory.model.ProductSupplier;

public interface ProductSupplierRepository extends JpaRepository<ProductSupplier, Integer>  {

	@Query("SELECT p FROM productsupplier p where p.partNo = :partNo")
	ProductSupplier findProductSupplierByProductId(@Param("partNo") String partNo);
	
	@Query("SELECT p FROM productsupplier p where p.supplierId = :supplierId")
	ProductSupplier findProductSupplierBySupplierId(@Param("supplierId") String supplierId);
}
