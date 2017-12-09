package edu.iss.inventory.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.inventory.model.ProductSupplier;

public interface ProductSupplierRepository extends JpaRepository<ProductSupplier, Integer>  {
//specified return type as array lists as multiple supplier will be returned per productID
	@Query("SELECT p FROM productsupplier p where p.partNo = :partNo")
	ArrayList<ProductSupplier> findProductSupplierByProductId(@Param("partNo") String partNo);
	//specified return type as array lists as multiple supplier will be returned per SupplierID	
	@Query("SELECT p FROM productsupplier p where p.supplierId = :supplierId")
	ArrayList<ProductSupplier> findProductSupplierBySupplierId(@Param("supplierId") String supplierId);
}
