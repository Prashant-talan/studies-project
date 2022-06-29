package com.clinicalResearch.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinicalResearch.entity.FormOIDs;

@Repository
public interface FormOIDsRepo extends JpaRepository<FormOIDs,Integer> {

	List<FormOIDs> findByStudyID(int studyId);

}
