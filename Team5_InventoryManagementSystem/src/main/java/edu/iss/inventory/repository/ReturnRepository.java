package edu.iss.inventory.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.inventory.model.Return;

public interface ReturnRepository extends JpaRepository<Return, Integer>  {

	@Query("SELECT r FROM Return r where r.returnId = :returnId")
	Return findReturnByReturnId(@Param("returnId") String returnId);
	
	@Query("SELECT r FROM Return r where r.partNo = :partNo")
	ArrayList<Return> findReturnByPartNo(@Param("partNo") String partNo);
}
