package edu.iss.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.inventory.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer>  {

	@Query("SELECT s FROM Supplier s where s.supplierId = :supplierId")
	Supplier findSupplierBysupplierId(@Param("supplierId") String supplierId);
	
	@Query("SELECT s FROM Supplier s where s.supplierName = :supplierName")
	Supplier findSupplierBysupplierName(@Param("supplierName") String supplierName);
}
