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
public class TFonction implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long id;
	private String fonLibelle;
	@ManyToOne
	@JoinColumn(name="CODE_Typ_FONCT")
	private TTypeFonction ttypeFonction;
	@OneToMany(mappedBy="tfonction")
	private Collection<TAssignation>tAssignation;
	public TFonction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TFonction(String fonLibelle) {
		super();
		this.fonLibelle = fonLibelle;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFonLibelle() {
		return fonLibelle;
	}
	public void setFonLibelle(String fonLibelle) {
		this.fonLibelle = fonLibelle;
	}
	public TTypeFonction getTtypeFonction() {
		return ttypeFonction;
	}
	public void setTtypeFonction(TTypeFonction ttypeFonction) {
		this.ttypeFonction = ttypeFonction;
	}
	public Collection<TAssignation> gettAssignation() {
		return tAssignation;
	}
	public void settAssignation(Collection<TAssignation> tAssignation) {
		this.tAssignation = tAssignation;
	}
	
}
