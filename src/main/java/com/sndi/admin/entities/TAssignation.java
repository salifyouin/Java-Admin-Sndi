package com.sndi.admin.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class TAssignation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long id;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date assDateDeb;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date assDateFin;
	private String assCourant;
	private Boolean assStatut;
	@ManyToOne
	@JoinColumn(name="CODE_FONCT")
    private TFonction tfonction;
    @ManyToOne
	@JoinColumn(name="CODE_OPE")
    private TOperateur tOperateur;
    @OneToMany(mappedBy="tAssignation")
    private Collection<SysJournal>sysJournal;
	public TAssignation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TAssignation(Date assDateDeb, Date assDateFin, String assCourant, Boolean assStatut) {
		super();
		this.assDateDeb = assDateDeb;
		this.assDateFin = assDateFin;
		this.assCourant = assCourant;
		this.assStatut = assStatut;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getAssDateDeb() {
		return assDateDeb;
	}
	public void setAssDateDeb(Date assDateDeb) {
		this.assDateDeb = assDateDeb;
	}
	public Date getAssDateFin() {
		return assDateFin;
	}
	public void setAssDateFin(Date assDateFin) {
		this.assDateFin = assDateFin;
	}
	public String getAssCourant() {
		return assCourant;
	}
	public void setAssCourant(String assCourant) {
		this.assCourant = assCourant;
	}
	public Boolean getAssStatut() {
		return assStatut;
	}
	public void setAssStatut(Boolean assStatut) {
		this.assStatut = assStatut;
	}
	public TFonction getTfonction() {
		return tfonction;
	}
	public void setTfonction(TFonction tfonction) {
		this.tfonction = tfonction;
	}
	public TOperateur gettOperateur() {
		return tOperateur;
	}
	public void settOperateur(TOperateur tOperateur) {
		this.tOperateur = tOperateur;
	}
	public Collection<SysJournal> getSysJournal() {
		return sysJournal;
	}
	public void setSysJournal(Collection<SysJournal> sysJournal) {
		this.sysJournal = sysJournal;
	}
    
    
}
