package com.sndi.admin.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class TOperateur implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long id;
	 private String opeMatricule;
     private String opeNom;
     private String opeContact;
     private String opeEtatCivil;
     private String opeEmail;
     private String opeLogin;
     private String mdp;
 	 private Boolean mdpStatut;
     @OneToMany(mappedBy="tOperateur")
 	private Collection<TMotdepass>tMotdepass;
	public TOperateur() {
		// TODO Auto-generated constructor stub
	}
	public TOperateur(String opeMatricule, String opeNom, String opeContact, String opeEtatCivil, String opeEmail,
			String opeLogin, String mdp, Boolean mdpStatut) {
		super();
		this.opeMatricule = opeMatricule;
		this.opeNom = opeNom;
		this.opeContact = opeContact;
		this.opeEtatCivil = opeEtatCivil;
		this.opeEmail = opeEmail;
		this.opeLogin = opeLogin;
		this.mdp = mdp;
		this.mdpStatut = mdpStatut;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOpeMatricule() {
		return opeMatricule;
	}
	public void setOpeMatricule(String opeMatricule) {
		this.opeMatricule = opeMatricule;
	}
	public String getOpeNom() {
		return opeNom;
	}
	public void setOpeNom(String opeNom) {
		this.opeNom = opeNom;
	}
	public String getOpeContact() {
		return opeContact;
	}
	public void setOpeContact(String opeContact) {
		this.opeContact = opeContact;
	}
	public String getOpeEtatCivil() {
		return opeEtatCivil;
	}
	public void setOpeEtatCivil(String opeEtatCivil) {
		this.opeEtatCivil = opeEtatCivil;
	}
	public String getOpeEmail() {
		return opeEmail;
	}
	public void setOpeEmail(String opeEmail) {
		this.opeEmail = opeEmail;
	}
	public String getOpeLogin() {
		return opeLogin;
	}
	public void setOpeLogin(String opeLogin) {
		this.opeLogin = opeLogin;
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
	public Collection<TMotdepass> gettMotdepass() {
		return tMotdepass;
	}
	public void settMotdepass(Collection<TMotdepass> tMotdepass) {
		this.tMotdepass = tMotdepass;
	}
	
}
