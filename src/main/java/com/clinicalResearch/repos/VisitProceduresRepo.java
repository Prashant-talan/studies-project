package com.clinicalResearch.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.clinicalResearch.entity.VisitProcedures;

@Repository
public interface VisitProceduresRepo extends JpaRepository<VisitProcedures,Integer> {

	List<VisitProcedures> findByStudyIDAndProcedureUUID(int studyId, String procedureUuid);

}
