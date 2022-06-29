package com.clinicalResearch.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.clinicalResearch.entity.Procedures;

@Repository
public interface ProceduresRepo extends JpaRepository<Procedures,Integer> {
	List<Procedures> findByStudyID(int studyId);
}
