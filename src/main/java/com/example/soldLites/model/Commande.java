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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "table_Commande")
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Commande") 
	private long idCommande; 
	
	public double getTotalCommande() {
		return totalCommande;
	}

	public void setTotalCommande(double totalCommande) {
		this.totalCommande = totalCommande;
	}

	public List<Facture> getFactureListCommande() {
		return factureListCommande;
	}

	public void setFactureListCommande(List<Facture> factureListCommande) {
		this.factureListCommande = factureListCommande;
	}
	@Column(name = "date_Commande")
	private String dateCommande;
	
	@Column(name = "total_Commande")
	private double totalCommande;
	
	
	@OneToMany(
			cascade = CascadeType.ALL,
			orphanRemoval = true
			//fetch = FetchType.EAGER
			)
	@JoinColumn(name = "id_Commande")
	List<Facture> factureListCommande = new ArrayList<>();
	
	@ManyToOne(
			cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Client")
	private Client client;
	
	@ManyToMany(
			mappedBy = "commandsList"
			)
	private List<Produit> produit = new ArrayList<>();

	public long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(long idCommande) {
		this.idCommande = idCommande;
	}

	public String getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(String dateCommande) {
		this.dateCommande = dateCommande;
	}

	public List<Facture> getFactureList() {
		return factureListCommande;
	}

	public void setFactureList(List<Facture> factureList) {
		this.factureListCommande = factureList;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Produit> getProduit() {
		return produit;
	}

	public void setProduit(List<Produit> produit) {
		this.produit = produit;
	}
	
	//les methodes utilitaires 
	
			public void addFacture(Facture facture) {
				factureListCommande.add(facture);
				facture.setCommand(this);
			}
			public void removeFacture(Facture facture) {
				factureListCommande.remove(facture);
				facture.setCommand(null);
			}
	
}
