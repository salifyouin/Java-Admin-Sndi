package com.sndi.admin.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class TTypeFonction  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
 private Long id;
 private String tyfCod;
 private String tyfLibelle;
 
 @OneToMany(mappedBy="ttypeFonction")
 private Collection<TFonction>tFonctions;
 
 @OneToMany(mappedBy="ttypeFonctions")
 private Collection<TTFonctionAction>ttFonctionActions;

public TTypeFonction() {
	super();
	// TODO Auto-generated constructor stub
}

public TTypeFonction(String tyfCod, String tyfLibelle, Collection<TFonction> tFonctions) {
	super();
	this.tyfCod = tyfCod;
	this.tyfLibelle = tyfLibelle;
	this.tFonctions = tFonctions;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getTyfCod() {
	return tyfCod;
}

public void setTyfCod(String tyfCod) {
	this.tyfCod = tyfCod;
}

public String getTyfLibelle() {
	return tyfLibelle;
}

public void setTyfLibelle(String tyfLibelle) {
	this.tyfLibelle = tyfLibelle;
}

public Collection<TFonction> gettFonctions() {
	return tFonctions;
}

public void settFonctions(Collection<TFonction> tFonctions) {
	this.tFonctions = tFonctions;
}

public Collection<TTFonctionAction> getTtFonctionActions() {
	return ttFonctionActions;
}

public void setTtFonctionActions(Collection<TTFonctionAction> ttFonctionActions) {
	this.ttFonctionActions = ttFonctionActions;
}
 

 
}
