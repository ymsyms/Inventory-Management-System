package edu.iss.inventory.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.inventory.model.OrderDetail;


public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

	@Query("SELECT od FROM OrderDetail od where od.partNo = :partNo")
	ArrayList<OrderDetail> findOrderDetailByPartNo(@Param("partNo") String partNo);
	
	@Query("SELECT od FROM OrderDetail od where od.orderId = :orderId")
	ArrayList<OrderDetail> findOrderDetailByOrderId(@Param("orderId") String orderId);
}
