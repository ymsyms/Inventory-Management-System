package edu.iss.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransactionDetailsRepositry extends JpaRepository<TransactionDetails, Integer>  {

	@Query("SELECT td FROM transactiondetails td where td.transactionId = :transactionId")
	Product findTransactionDetailsByTransactionId(@Param("transactionId") String transactionId);
	
	@Query("SELECT td FROM transactiondetails td where td.partNo = :partNo")
	Product findTransactionDetailsBypartNo(@Param("partNo") String partNo);
}
