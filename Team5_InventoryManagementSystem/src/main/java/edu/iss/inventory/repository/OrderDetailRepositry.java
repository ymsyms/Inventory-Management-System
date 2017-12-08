package edu.iss.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderDetailRepositry extends JpaRepository<OrderDetail, Integer> {

	@Query("SELECT od FROM orderdetail od where od.partNo = :partNo")
	Product findOrderDetailByPartNo(@Param("partNo") String partNo);
	
	@Query("SELECT od FROM orderdetail od where od.orderId = :orderId")
	Product findOrderDetailByOrderId(@Param("orderId") String orderId);
}
