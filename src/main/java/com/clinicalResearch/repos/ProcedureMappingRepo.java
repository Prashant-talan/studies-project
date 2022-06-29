package com.clinicalResearch.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinicalResearch.entity.ProcedureMapping;

@Repository
public interface ProcedureMappingRepo extends JpaRepository<ProcedureMapping,Integer>{

	List<ProcedureMapping> findByStudyID(int studyId);

}
