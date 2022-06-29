package com.clinicalResearch.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinicalResearch.entity.ProcedureQuestion;

@Repository
public interface ProcedureQuestionRepo extends JpaRepository<ProcedureQuestion,Integer> {

	List<ProcedureQuestion> findByStudyIDAndProcedureUUID(int studyId, String procedureUid);

}
