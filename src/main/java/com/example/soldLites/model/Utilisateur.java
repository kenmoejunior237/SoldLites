package com.example.soldLites.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "TableUtilisateur")
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_util")
	private long idUtilisateur; 
	
	@Column(name = "nom_util")
	private String nomUtilisateur;
	
	@Column(name = "prenom_util")
	private String prenomUtilisateur;
	
	@Column(name = "login_util")
	private String loginUtilisateur;
	
	@Column(name = "email_util")
	private String emailUtilisateur;
	
	@Column(name = "pwd_util")
	private String pwdUtilisateur;
	
	@Column(name = "date_util")
	private String dateNaisUtilisateur;
	
	@Column(name = "statut_util")
	private String statutUtilisateur;
	
	@Column(name = "sexe_util")
	private String sexeUtilisateur;
	
	@Column(name = "photo_util")
	private String photoUtilisateur;
	
	@ManyToMany(
			mappedBy = "utilisateurs"
			)
	private List<Produit> produit = new ArrayList<>();

	public long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}

	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}

	public String getLoginUtilisateur() {
		return loginUtilisateur;
	}

	public void setLoginUtilisateur(String loginUtilisateur) {
		this.loginUtilisateur = loginUtilisateur;
	}

	public String getEmailUtilisateur() {
		return emailUtilisateur;
	}

	public void setEmailUtilisateur(String emailUtilisateur) {
		this.emailUtilisateur = emailUtilisateur;
	}

	public String getPwdUtilisateur() {
		return pwdUtilisateur;
	}

	public void setPwdUtilisateur(String pwdUtilisateur) {
		this.pwdUtilisateur = pwdUtilisateur;
	}

	public String getDateNaisUtilisateur() {
		return dateNaisUtilisateur;
	}

	public void setDateNaisUtilisateur(String dateNaisUtilisateur) {
		this.dateNaisUtilisateur = dateNaisUtilisateur;
	}

	public String getStatutUtilisateur() {
		return statutUtilisateur;
	}

	public void setStatutUtilisateur(String statutUtilisateur) {
		this.statutUtilisateur = statutUtilisateur;
	}

	public String getSexeUtilisateur() {
		return sexeUtilisateur;
	}

	public void setSexeUtilisateur(String sexeUtilisateur) {
		this.sexeUtilisateur = sexeUtilisateur;
	}

	public String getPhotoUtilisateur() {
		return photoUtilisateur;
	}

	public void setPhotoUtilisateur(String photoUtilisateur) {
		this.photoUtilisateur = photoUtilisateur;
	}

	public List<Produit> getProduit() {
		return produit;
	}

	public void setProduit(List<Produit> produit) {
		this.produit = produit;
	}
	
	
	
}
