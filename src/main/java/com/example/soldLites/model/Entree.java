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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="table_Entree")
public class Entree {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Entree")
	private long idEntree;
	
	@Column(name = "qte_Entree")
	private double qteEntree;
	
	@Column(name = "date_Entree")
	private String dateEntree;
	
	@Column(name = "prix_Entree")
	private double prixEntree;
	
	@ManyToOne(
			cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Produit")
	private Produit produit;

	public long getIdEntree() {
		return idEntree;
	}

	public void setIdEntree(long idEntree) {
		this.idEntree = idEntree;
	}

	public double getQteEntree() {
		return qteEntree;
	}

	public void setQteEntree(double qteEntree) {
		this.qteEntree = qteEntree;
	}

	public String getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(String dateEntree) {
		this.dateEntree = dateEntree;
	}

	public double getPrixEntree() {
		return prixEntree;
	}

	public void setPrixEntree(double prixEntree) {
		this.prixEntree = prixEntree;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	
}
