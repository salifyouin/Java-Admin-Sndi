package com.sndi.admin.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sndi.admin.entities.TOperateur;


public interface TOperateurRepository extends JpaRepository<TOperateur, Long> {
	@Query("select o from TOperateur o where o.opeNom like:x order by o.id desc" )
	public Page<TOperateur> chercherOperateurs(@Param("x")String mc,Pageable pageable);
	List<TOperateur>findByOpeNom(String op);
	
}
