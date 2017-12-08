package edu.iss.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<Order, Integer>  {

	@Query("SELECT o FROM order o where o.orderId = :orderId")
	Product findOrderByOrderId(@Param("orderId") String orderId);
	
	@Query("SELECT o FROM order o where o.userId = :userId")
	Product findOrderByUserId(@Param("userId") String userId);
	
	@Query("SELECT o FROM order o where o.supplierId = :supplierId")
	Product findOrderBysupplierId(@Param("supplierId") String supplierId);
}
