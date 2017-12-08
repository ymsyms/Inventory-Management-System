package edu.iss.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReturnRepository extends JpaRepository<Return, Integer>  {

	@Query("SELECT r FROM return r where r.returnId = :returnId")
	Product findReturnByReturnId(@Param("returnId") String returnId);
	
	@Query("SELECT r FROM return r where r.partNo = :partNo")
	Product findReturnByPartNo(@Param("partNo") String partNo);
}
