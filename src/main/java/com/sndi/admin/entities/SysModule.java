package com.sndi.admin.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class SysModule implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long id;
	private String SymCode;
	private String SymDescription;
	private String SymEtat;
	private String SymLibelle;
	private long SymSequence;
	@OneToMany(mappedBy="sysModule")
	private Collection<SytTraitement>sysTraitements;
	public SysModule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SysModule(String symCode, String symDescription, String symEtat, String symLibelle, long symSequence) {
		super();
		SymCode = symCode;
		SymDescription = symDescription;
		SymEtat = symEtat;
		SymLibelle = symLibelle;
		SymSequence = symSequence;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSymCode() {
		return SymCode;
	}
	public void setSymCode(String symCode) {
		SymCode = symCode;
	}
	public String getSymDescription() {
		return SymDescription;
	}
	public void setSymDescription(String symDescription) {
		SymDescription = symDescription;
	}
	public String getSymEtat() {
		return SymEtat;
	}
	public void setSymEtat(String symEtat) {
		SymEtat = symEtat;
	}
	public String getSymLibelle() {
		return SymLibelle;
	}
	public void setSymLibelle(String symLibelle) {
		SymLibelle = symLibelle;
	}
	public long getSymSequence() {
		return SymSequence;
	}
	public void setSymSequence(long symSequence) {
		SymSequence = symSequence;
	}
	public Collection<SytTraitement> getSysTraitements() {
		return sysTraitements;
	}
	public void setSysTraitements(Collection<SytTraitement> sysTraitements) {
		this.sysTraitements = sysTraitements;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
