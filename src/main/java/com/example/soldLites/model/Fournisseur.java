package com.example.soldLites.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Table_Four")
public class Fournisseur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Four")
	private long idFournisseur; 
	
	@Column(name = "nom_Four")
	private String nomFournisseur;
	
	@Column(name = "tel_Four")
	private String telFournisseur;
	
	@Column(name = "adr_Four")
	private String adrFournisseur;
	
	@Column(name = "ville_Four")
	private String villeFournisseur;
	
	@Column(name = "pays_Four")
	private String paysFournisseur;
	
	@OneToMany(
			cascade = CascadeType.ALL,
			orphanRemoval = true
			//fetch = FetchType.EAGER
			)
	@JoinColumn(name = "id_Four")
	List<Produit> produitList = new ArrayList<>();

	public long getIdFournisseur() {
		return idFournisseur;
	}

	public void setIdFournisseur(long idFournisseur) {
		this.idFournisseur = idFournisseur;
	}

	public String getNomFournisseur() {
		return nomFournisseur;
	}

	public void setNomFournisseur(String nomFournisseur) {
		this.nomFournisseur = nomFournisseur;
	}

	public String getTelFournisseur() {
		return telFournisseur;
	}

	public void setTelFournisseur(String telFournisseur) {
		this.telFournisseur = telFournisseur;
	}

	public String getAdrFournisseur() {
		return adrFournisseur;
	}

	public void setAdrFournisseur(String adrFournisseur) {
		this.adrFournisseur = adrFournisseur;
	}

	public String getVilleFournisseur() {
		return villeFournisseur;
	}

	public void setVilleFournisseur(String villeFournisseur) {
		this.villeFournisseur = villeFournisseur;
	}

	public String getPaysFournisseur() {
		return paysFournisseur;
	}

	public void setPaysFournisseur(String paysFournisseur) {
		this.paysFournisseur = paysFournisseur;
	}

	
	public List<Produit> getProduitList() {
		return produitList;
	}

	public void setProduitList(List<Produit> produitList) {
		this.produitList = produitList;
	}
	
	//les methodes utilitaires 

	public void addProduit(Produit facture) {
		produitList.add(facture);
		facture.setFournisseur(this);
	}
	public void removeProduit(Produit produit) {
		produitList.remove(produit);
		produit.setFournisseur(null);
	}

}
