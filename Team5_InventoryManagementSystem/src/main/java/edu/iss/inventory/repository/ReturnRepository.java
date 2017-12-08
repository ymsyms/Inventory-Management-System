package edu.iss.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.inventory.model.Return;

public interface ReturnRepository extends JpaRepository<Return, Integer>  {

	@Query("SELECT r FROM return r where r.returnId = :returnId")
	Return findReturnByReturnId(@Param("returnId") String returnId);
	
	@Query("SELECT r FROM return r where r.partNo = :partNo")
	Return findReturnByPartNo(@Param("partNo") String partNo);
}
