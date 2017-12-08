package edu.iss.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SupplierRepositry extends JpaRepository<Supplier, Integer>  {

	@Query("SELECT s FROM supplier s where s.supplierId = :supplierId")
	Product findSupplierBysupplierId(@Param("supplierId") String supplierId);
	
	@Query("SELECT s FROM supplier s where s.supplierName = :supplierName")
	Product findSupplierBysupplierName(@Param("supplierName") String supplierName);
}
