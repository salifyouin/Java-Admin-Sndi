package com.sndi.admin.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sndi.admin.entities.SysModule;

public interface SysModuleRepository extends JpaRepository<SysModule, Long>{
	@Query("select m from SysModule m where m.SymLibelle like:x order by m.id desc")
	public Page<SysModule> chercherModule(@Param("x")String mc,Pageable pageable);

}
