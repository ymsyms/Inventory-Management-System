package edu.iss.inventory.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.inventory.model.TransactionDetail;

public interface TransactionDetailRepository extends JpaRepository<TransactionDetail, Integer>  {

	@Query("SELECT td FROM TransactionDetail td where td.transactionId = :transactionId")
	ArrayList<TransactionDetail> findTransactionDetailsByTransactionId(@Param("transactionId") String transactionId);
	
	@Query("SELECT td FROM TransactionDetail td where td.partNo = :partNo")
	ArrayList<TransactionDetail> findTransactionDetailsBypartNo(@Param("partNo") String partNo);
}
