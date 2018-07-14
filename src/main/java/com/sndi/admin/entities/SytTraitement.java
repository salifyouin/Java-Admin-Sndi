package com.sndi.admin.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class SytTraitement implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long id;
	private String SytCode;
	private String sytDescription;
	private Number sytDisplayable;
	private String sytlibelle;
	private Number sytSequence;
	private String sytPath;
	@ManyToOne
	@JoinColumn(name="CODE_SYS_MOD")
	private SysModule sysModule;
	@OneToMany(mappedBy="sytTraitement")
	private Collection<SysAction>sysActions;
	public SytTraitement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SytTraitement(String sytCode, String sytDescription, Number sytDisplayable, String sytlibelle,
			Number sytSequence, String sytPath) {
		super();
		SytCode = sytCode;
		this.sytDescription = sytDescription;
		this.sytDisplayable = sytDisplayable;
		this.sytlibelle = sytlibelle;
		this.sytSequence = sytSequence;
		this.sytPath = sytPath;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSytCode() {
		return SytCode;
	}
	public void setSytCode(String sytCode) {
		SytCode = sytCode;
	}
	public String getSytDescription() {
		return sytDescription;
	}
	public void setSytDescription(String sytDescription) {
		this.sytDescription = sytDescription;
	}
	public Number getSytDisplayable() {
		return sytDisplayable;
	}
	public void setSytDisplayable(Number sytDisplayable) {
		this.sytDisplayable = sytDisplayable;
	}
	public String getSytlibelle() {
		return sytlibelle;
	}
	public void setSytlibelle(String sytlibelle) {
		this.sytlibelle = sytlibelle;
	}
	public Number getSytSequence() {
		return sytSequence;
	}
	public void setSytSequence(Number sytSequence) {
		this.sytSequence = sytSequence;
	}
	public String getSytPath() {
		return sytPath;
	}
	public void setSytPath(String sytPath) {
		this.sytPath = sytPath;
	}
	public SysModule getSysModule() {
		return sysModule;
	}
	public void setSysModule(SysModule sysModule) {
		this.sysModule = sysModule;
	}
	public Collection<SysAction> getSysActions() {
		return sysActions;
	}
	public void setSysActions(Collection<SysAction> sysActions) {
		this.sysActions = sysActions;
	}
	
}
