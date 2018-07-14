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
public class SysAction implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long id;
	private String SyaCode;
	private String SyaDescription;
	private String SyaImage;
	private String SyaLibelle;
	private Number SyaSequence;
	@ManyToOne
	@JoinColumn(name="CODE_SYS_TRAIT")
	private SytTraitement sytTraitement;
	
	@OneToMany(mappedBy="sysAction")
	private Collection<TTFonctionAction>ttFonctionActions;
	
	@OneToMany(mappedBy="sysAction")
	private Collection<SysJournal>sysJournals;

	public SysAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SysAction(String syaCode, String syaDescription, String syaImage, String syaLibelle, Number syaSequence) {
		super();
		SyaCode = syaCode;
		SyaDescription = syaDescription;
		SyaImage = syaImage;
		SyaLibelle = syaLibelle;
		SyaSequence = syaSequence;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSyaCode() {
		return SyaCode;
	}

	public void setSyaCode(String syaCode) {
		SyaCode = syaCode;
	}

	public String getSyaDescription() {
		return SyaDescription;
	}

	public void setSyaDescription(String syaDescription) {
		SyaDescription = syaDescription;
	}

	public String getSyaImage() {
		return SyaImage;
	}

	public void setSyaImage(String syaImage) {
		SyaImage = syaImage;
	}

	public String getSyaLibelle() {
		return SyaLibelle;
	}

	public void setSyaLibelle(String syaLibelle) {
		SyaLibelle = syaLibelle;
	}

	public Number getSyaSequence() {
		return SyaSequence;
	}

	public void setSyaSequence(Number syaSequence) {
		SyaSequence = syaSequence;
	}

	public SytTraitement getSytTraitement() {
		return sytTraitement;
	}

	public void setSytTraitement(SytTraitement sytTraitement) {
		this.sytTraitement = sytTraitement;
	}

	public Collection<TTFonctionAction> getTtFonctionActions() {
		return ttFonctionActions;
	}

	public void setTtFonctionActions(Collection<TTFonctionAction> ttFonctionActions) {
		this.ttFonctionActions = ttFonctionActions;
	}

	public Collection<SysJournal> getSysJournals() {
		return sysJournals;
	}

	public void setSysJournals(Collection<SysJournal> sysJournals) {
		this.sysJournals = sysJournals;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
