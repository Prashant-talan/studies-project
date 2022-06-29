package com.clinicalResearch.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinicalResearch.entity.FolderOIDs;

@Repository
public interface FolderOIDsRepo extends JpaRepository<FolderOIDs,Integer> {

	List<FolderOIDs> findByStudyID(int studyId);

}
