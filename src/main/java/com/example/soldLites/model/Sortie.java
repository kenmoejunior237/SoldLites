package com.example.soldLites.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="table_Sortie")
public class Sortie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Sortie")
	private long idSortie;
	
	@Column(name = "qte_Sortie")
	private double qteSortie;
	
	@Column(name = "date_Sortie")
	private String dateSortie;
	
	@Column(name = "prix_Sortie")
	private double prixSortie;
	
	@ManyToOne(
			cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Produit")
	private Produit produit;

	public long getIdSortie() {
		return idSortie;
	}

	public void setIdSortie(long idSortie) {
		this.idSortie = idSortie;
	}

	public double getQteSortie() {
		return qteSortie;
	}

	public void setQteSortie(double qteSortie) {
		this.qteSortie = qteSortie;
	}

	public String getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(String dateSortie) {
		this.dateSortie = dateSortie;
	}

	public double getPrixSortie() {
		return prixSortie;
	}

	public void setPrixSortie(double prixSortie) {
		this.prixSortie = prixSortie;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	
	
	
}
