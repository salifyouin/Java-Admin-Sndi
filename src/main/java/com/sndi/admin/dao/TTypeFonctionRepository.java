package com.sndi.admin.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sndi.admin.entities.TTypeFonction;

public interface TTypeFonctionRepository extends JpaRepository<TTypeFonction, Long>{
	@Query("select tf from TTypeFonction tf where tf.tyfLibelle like:x order by tf.id desc")
	public Page<TTypeFonction> chercherTypeFonction(@Param("x")String mc,Pageable pageable);

}
