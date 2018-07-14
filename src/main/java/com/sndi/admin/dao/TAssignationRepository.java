package com.sndi.admin.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sndi.admin.entities.TAssignation;

public interface TAssignationRepository extends JpaRepository<TAssignation, Long>{
	@Query("select a from TAssignation a where a.assCourant like:x order by a.id desc" )
	public Page<TAssignation> chercherAssignations(@Param("x")String mc,Pageable pageable);

}
