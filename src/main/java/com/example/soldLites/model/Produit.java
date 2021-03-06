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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name ="table_Produit")
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Produit")
	private long idProduit; 
	
	@Column(name = "nom_Produit")
	private String nomProduit;
	
	@Column(name = "marque_Produit")
	private String marqueProduit;
	
	@Column(name = "des_Produit")
	private String descriptionProduit;
	
	@Column(name = "cbarre_Produit")
	private String codebarreProduit;
	
	@Column(name = "couleur_Produit")
	private String couleurProduit;
	
	@Column(name = "qte_Produit")
	private String qteProduit;
	
	@Column(name = "mvt_Produit")
	private String mvtProduit;
	
	@Column(name = "ht_Produit")
	private double prixHTProduit;
	
	@Column(name = "ttc_Produit")
	private double prixTTCProduit;
	
	@Column(name = "tva_Produit")
	private double prixTVAProduit;
	
	@ManyToOne(
			cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Rayon")
	private Rayon rayon;
	
	@ManyToOne(
			cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Four")
	private Fournisseur fournisseur;
	
	@OneToMany(
			cascade = CascadeType.ALL,
			orphanRemoval = true
			//fetch = FetchType.EAGER
			)
	@JoinColumn(name = "id_Produit")
	List<Entree> entreeList = new ArrayList<>();
	
	@OneToMany(
			cascade = CascadeType.ALL,
			orphanRemoval = true,
			fetch = FetchType.EAGER)
	@JoinColumn(name = "id_Produit")
	List<Sortie> sortieList = new ArrayList<>();
	
	@ManyToMany(
			fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			}
			)
	@JoinTable(
			name = ("table_Commande_Produit"), 
			joinColumns = @JoinColumn(name="id_Produit"),
			inverseJoinColumns = @JoinColumn(name="id_Command")
			)
	private List<Commande> commandsList = new ArrayList<>();
	
	@ManyToMany(
			fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			}
			)
	@JoinTable(
			name = ("Table_Utilisateur_Produit"), 
			joinColumns = @JoinColumn(name="id_Produit"),
			inverseJoinColumns = @JoinColumn(name = "id_util")
			)
	private List<Utilisateur> utilisateursList = new ArrayList<>();

	public long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(long idProduit) {
		this.idProduit = idProduit;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public String getMarqueProduit() {
		return marqueProduit;
	}

	public void setMarqueProduit(String marqueProduit) {
		this.marqueProduit = marqueProduit;
	}

	public String getDescriptionProduit() {
		return descriptionProduit;
	}

	public void setDescriptionProduit(String descriptionProduit) {
		this.descriptionProduit = descriptionProduit;
	}

	public String getCodebarreProduit() {
		return codebarreProduit;
	}

	public void setCodebarreProduit(String codebarreProduit) {
		this.codebarreProduit = codebarreProduit;
	}

	public String getCouleurProduit() {
		return couleurProduit;
	}

	public void setCouleurProduit(String couleurProduit) {
		this.couleurProduit = couleurProduit;
	}

	public String getMvtProduit() {
		return mvtProduit;
	}

	public void setMvtProduit(String mvtProduit) {
		this.mvtProduit = mvtProduit;
	}

	public double getPrixHTProduit() {
		return prixHTProduit;
	}

	public void setPrixHTProduit(double prixHTProduit) {
		this.prixHTProduit = prixHTProduit;
	}

	public double getPrixTTCProduit() {
		return prixTTCProduit;
	}

	public void setPrixTTCProduit(double prixTTCProduit) {
		this.prixTTCProduit = prixTTCProduit;
	}

	public double getPrixTVAProduit() {
		return prixTVAProduit;
	}

	public void setPrixTVAProduit(double prixTVAProduit) {
		this.prixTVAProduit = prixTVAProduit;
	}

	public Rayon getRayon() {
		return rayon;
	}

	public void setRayon(Rayon rayon) {
		this.rayon = rayon;
	}


	
	public List<Commande> getCommandsList() {
		return commandsList;
	}

	public void setCommandsList(List<Commande> commandsList) {
		this.commandsList = commandsList;
	}

	public List<Utilisateur> getUtilisateursList() {
		return utilisateursList;
	}

	public void setUtilisateursList(List<Utilisateur> utilisateursList) {
		this.utilisateursList = utilisateursList;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	
	public String getStockProduit() {
		return qteProduit;
	}

	public void setStockProduit(String stockProduit) {
		this.qteProduit = stockProduit;
	}
	
	public String getQteProduit() {
		return qteProduit;
	}

	public void setQteProduit(String qteProduit) {
		this.qteProduit = qteProduit;
	}

	public List<Entree> getEntreeList() {
		return entreeList;
	}

	public void setEntreeList(List<Entree> entreeList) {
		entreeList = entreeList;
	}

	public List<Sortie> getSortieList() {
		return sortieList;
	}

	public void setSortieList(List<Sortie> sortieList) {
		sortieList = sortieList;
	}
	
	// les methodes utilitaires

	public void addCommande(Commande commande) {
		commandsList.add(commande);
		commande.getProduit().add(this);
	}
	public void removeCommande(Commande commande) {
		commandsList.remove(commande);
		commande.getProduit().remove(this);
	}

	
	//les methodes utilitaires 
	
	public void addUtilisateur(Utilisateur utilisateur) {
		utilisateursList.add(utilisateur);
		utilisateur.getProduit().add(this);
	}
	public void removeUtilisateur(Utilisateur utilisateur) {
		utilisateursList.remove(utilisateur);
		utilisateur.getProduit().remove(this);
	}
	
	
	//les methodes utilitaires 
	
		public void addEntree(Entree entree) {
			entreeList.add(entree);
			entree.setProduit(this);
		}
		public void removeUtilisateur(Entree entree) {
			utilisateursList.remove(entree);
			entree.setProduit(null);
		}
		
		//les methodes utilitaires 
		
		public void addSortie(Sortie sortie) {
			sortieList.add(sortie);
			sortie.setProduit(this);
		}
		public void removeUtilisateur(Sortie sortie) {
			sortieList.remove(sortie);
			sortie.setProduit(null);
		}

		
	
	
}
