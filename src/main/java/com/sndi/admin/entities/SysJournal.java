package com.sndi.admin.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class SysJournal implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long id ;
	private Date SyjDate;
	private String SyjDescription;
	@ManyToOne
	@JoinColumn(name="CODE_ASSIGN")
    private TAssignation tAssignation;
	@ManyToOne
	@JoinColumn(name="CODE_SYS_ACT")
    private SysAction sysAction;
	public SysJournal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SysJournal(Date syjDate, String syjDescription) {
		super();
		SyjDate = syjDate;
		SyjDescription = syjDescription;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getSyjDate() {
		return SyjDate;
	}
	public void setSyjDate(Date syjDate) {
		SyjDate = syjDate;
	}
	public String getSyjDescription() {
		return SyjDescription;
	}
	public void setSyjDescription(String syjDescription) {
		SyjDescription = syjDescription;
	}
	public TAssignation gettAssignation() {
		return tAssignation;
	}
	public void settAssignation(TAssignation tAssignation) {
		this.tAssignation = tAssignation;
	}
	public SysAction getSysAction() {
		return sysAction;
	}
	public void setSysAction(SysAction sysAction) {
		this.sysAction = sysAction;
	}
	
    
}
