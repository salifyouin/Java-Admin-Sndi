package com.sndi.admin.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class TTFonctionAction implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long id;
	@ManyToOne
	@JoinColumn(name="CODE_TYPFONCT")
	private TTypeFonction ttypeFonctions;
	@ManyToOne
	@JoinColumn(name="CODE_SYS_ACT")
	private SysAction sysAction;
	public TTFonctionAction() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TTypeFonction getTtypeFonctions() {
		return ttypeFonctions;
	}
	public void setTtypeFonctions(TTypeFonction ttypeFonctions) {
		this.ttypeFonctions = ttypeFonctions;
	}
	public SysAction getSysAction() {
		return sysAction;
	}
	public void setSysAction(SysAction sysAction) {
		this.sysAction = sysAction;
	}
	
	
	
	

}
