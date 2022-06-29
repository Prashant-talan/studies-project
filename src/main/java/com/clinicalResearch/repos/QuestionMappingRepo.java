package com.clinicalResearch.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.clinicalResearch.entity.QuestionMapping;

@Repository
public interface QuestionMappingRepo extends JpaRepository<QuestionMapping,Integer> {

	List<QuestionMapping> findAllByStudyID(int studyId);

}
