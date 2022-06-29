package com.clinicalResearch.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinicalResearch.entity.ProcedureQuestionSelect;

@Repository
public interface ProcedureQuestionSelectRepo extends JpaRepository<ProcedureQuestionSelect,Integer> {

	List<ProcedureQuestionSelect> findByStudyIDAndQuestionUUID(int studyId , String quesUid);

}
