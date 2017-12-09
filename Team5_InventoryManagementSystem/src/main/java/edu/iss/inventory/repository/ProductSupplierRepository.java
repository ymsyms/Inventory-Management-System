package edu.iss.inventory.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.inventory.model.ProductSupplier;
import edu.iss.inventory.model.ProductSupplierId;

public interface ProductSupplierRepository extends JpaRepository<ProductSupplier, ProductSupplierId>  {
//specified return type as array lists as multiple supplier will be returned per productID
	@Query("SELECT p FROM ProductSupplier p where p.partNo = :partNo")
	ArrayList<ProductSupplier> findProductSupplierByProductId(@Param("partNo") String partNo);
	
	
	//specified return type as array lists as multiple supplier will be returned per SupplierID	
	@Query("SELECT p FROM ProductSupplier p where p.supplierId = :supplierId")
	ArrayList<ProductSupplier> findProductSupplierBySupplierId(@Param("supplierId") Integer supplierId);

    @Query("SELECT p FROM ProductSupplier p where p.supplierId = :supplierId and p.partNo = :partNo")
  	ProductSupplier findProductSupplier(@Param("supplierId") String supplierId,@Param("partNo") String partNo);
}
