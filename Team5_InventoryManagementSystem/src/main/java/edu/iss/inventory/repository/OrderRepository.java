package edu.iss.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.inventory.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>  {

	@Query("SELECT o FROM order o where o.orderId = :orderId")
	Order findOrderByOrderId(@Param("orderId") String orderId);
	
	@Query("SELECT o FROM order o where o.userId = :userId")
	Order findOrderByUserId(@Param("userId") String userId);
	
	@Query("SELECT o FROM order o where o.supplierId = :supplierId")
	Order findOrderBysupplierId(@Param("supplierId") String supplierId);
}
