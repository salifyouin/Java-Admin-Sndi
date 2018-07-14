package com.sndi.admin.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sndi.admin.entities.TFonction;

public interface TFonctionRepository extends JpaRepository<TFonction, Long>{
	@Query("select f from TFonction f where f.fonLibelle like:x order by f.id desc" )
	public Page<TFonction> chercherFonction(@Param("x")String mc,Pageable pageable);

}
