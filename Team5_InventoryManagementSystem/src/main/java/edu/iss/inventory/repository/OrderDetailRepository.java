package edu.iss.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.inventory.model.OrderDetail;


public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

	@Query("SELECT od FROM orderdetail od where od.partNo = :partNo")
	OrderDetail findOrderDetailByPartNo(@Param("partNo") String partNo);
	
	@Query("SELECT od FROM orderdetail od where od.orderId = :orderId")
	OrderDetail findOrderDetailByOrderId(@Param("orderId") String orderId);
}
