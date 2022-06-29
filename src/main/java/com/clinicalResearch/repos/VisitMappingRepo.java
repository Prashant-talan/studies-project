package com.clinicalResearch.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.clinicalResearch.entity.VisitMapping;

@Repository
public interface VisitMappingRepo extends JpaRepository<VisitMapping,Integer> {

	List<VisitMapping> findByStudyID(int studyId);

}
