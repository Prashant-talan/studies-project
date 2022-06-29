package com.clinicalResearch.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinicalResearch.entity.Visits;

@Repository
public interface VisitsRepo extends JpaRepository<Visits,Integer> {
	
	List<Visits> findByStudyID(int studyId);
	Visits findByStudyIDAndVisitUUID(int studyId,String visitUuid);
	
}
