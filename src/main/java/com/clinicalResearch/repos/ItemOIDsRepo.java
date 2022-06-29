package com.clinicalResearch.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinicalResearch.entity.ItemOIDs;

@Repository
public interface ItemOIDsRepo extends JpaRepository<ItemOIDs,Integer> {

	List<ItemOIDs> findByStudyID(int studyId);

	List<ItemOIDs> findByStudyIDAndFormOID(int studyId, String formOid);

}
