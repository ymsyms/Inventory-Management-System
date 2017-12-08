package edu.iss.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>  {

	@Query("SELECT t FROM transaction t where t.transactionId = :transactionId")
	Product findTransactionByTransactionId(@Param("transactionId") String transactionId);
	
	@Query("SELECT t FROM transaction t where t.userId = :userId")
	Product findTransactionByuserId(@Param("userId") String userId);
}
