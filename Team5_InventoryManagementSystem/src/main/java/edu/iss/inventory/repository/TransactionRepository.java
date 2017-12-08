package edu.iss.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.inventory.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>  {

	@Query("SELECT t FROM transaction t where t.transactionId = :transactionId")
	Transaction findTransactionByTransactionId(@Param("transactionId") String transactionId);
	
	@Query("SELECT t FROM transaction t where t.userId = :userId")
	Transaction findTransactionByuserId(@Param("userId") String userId);
}
