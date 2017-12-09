package edu.iss.inventory.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.inventory.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>  {

	@Query("SELECT o FROM Order o where o.orderId = :orderId")
	Order findOrderByOrderId(@Param("orderId") String orderId);
	
	@Query("SELECT o FROM Order o where o.userId = :userId")
	ArrayList<Order> findOrderByUserId(@Param("userId") String userId);
	
	@Query("SELECT o FROM Order o where o.supplierId = :supplierId")
	ArrayList<Order> findOrderBysupplierId(@Param("supplierId") String supplierId);
}
