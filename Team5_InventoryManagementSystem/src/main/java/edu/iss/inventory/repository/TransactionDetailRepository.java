package edu.iss.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.inventory.model.TransactionDetail;
import edu.iss.inventory.model.TransactionDetailId;

public interface TransactionDetailRepository extends JpaRepository<TransactionDetail, TransactionDetailId>  {

	@Query("SELECT td FROM transactiondetail td where td.transactionId = :transactionId")
	TransactionDetail findTransactionDetailsByTransactionId(@Param("transactionId") String transactionId);
	
	@Query("SELECT td FROM transactiondetail td where td.partNo = :partNo")
	TransactionDetail findTransactionDetailsBypartNo(@Param("partNo") String partNo);
}
