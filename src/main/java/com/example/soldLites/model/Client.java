package com.example.soldLites.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
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
@Table(name = "TableClient")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Client")
	private long idClient;
	
	@Column(name = "nom_client")
	private String nomClient;
	
	@Column(name = "prenom_client")
	private String prenomClient;
	
	@Column(name = "adresse_client")
	private String adresseClient;
	
	@Column(name = "tel_client")
	private long telClient;
	
	@Column(name = "sexe_client")
	private String sexeClient;
	
	@OneToMany(
			cascade = CascadeType.ALL,
			orphanRemoval = true,
			fetch = FetchType.EAGER)
	@JoinColumn(name = "id_Client")
	List<Commande> commandList = new ArrayList<>();
	List<Facture> factureList  = new ArrayList<>();
	
	 //les methodes utilitaires ou helpers methods
	
		public void addCommande(Commande commande) {
			commandList.add(commande);
			commande.setClient(this);
		}
		public void removeCommande(Commande commande) {
			commandList.remove(commande);
			commande.setClient(null);
		}

		 //les methodes utilitaires 
		
		public void addFacture(Facture facture) {
			factureList.add(facture);
			facture.setClient(this);
		}
		public void removeFacture(Facture facture) {
			factureList.remove(facture);
			facture.setClient(null);
		}

	
	
	
}
