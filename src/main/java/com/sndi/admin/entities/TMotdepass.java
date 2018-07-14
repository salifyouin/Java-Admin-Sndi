package com.sndi.admin.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TMotdepass implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String mdp;
	private Boolean mdpStatut;
	private Date mdpDate;
	@ManyToOne
	@JoinColumn(name="CODE_OPE")
	private TOperateur tOperateur;
	public TMotdepass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TMotdepass(String mdp, Boolean mdpStatut, Date mdpDate) {
		super();
		this.mdp = mdp;
		this.mdpStatut = mdpStatut;
		this.mdpDate = mdpDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public Boolean getMdpStatut() {
		return mdpStatut;
	}
	public void setMdpStatut(Boolean mdpStatut) {
		this.mdpStatut = mdpStatut;
	}
	public Date getMdpDate() {
		return mdpDate;
	}
	public void setMdpDate(Date mdpDate) {
		this.mdpDate = mdpDate;
	}
	public TOperateur gettOperateur() {
		return tOperateur;
	}
	public void settOperateur(TOperateur tOperateur) {
		this.tOperateur = tOperateur;
	}
	
	
}
