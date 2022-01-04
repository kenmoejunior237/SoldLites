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
	
	@Column(name = "email_client")
	private String emailClient;
	
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
			orphanRemoval = true
			//fetch = FetchType.EAGER
			)
	@JoinColumn(name = "id_Client")
	List<Commande> commandList = new ArrayList<>();
	
	@OneToMany(
			cascade = CascadeType.ALL,
			orphanRemoval = true,
			fetch = FetchType.EAGER)
	@JoinColumn(name = "id_Client")
	List<Facture> factureListClient  = new ArrayList<>();
	public long getIdClient() {
		return idClient;
	}
	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getEmailClient() {
		return emailClient;
	}
	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}
	public String getPrenomClient() {
		return prenomClient;
	}
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}
	public String getAdresseClient() {
		return adresseClient;
	}
	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}
	public long getTelClient() {
		return telClient;
	}
	public void setTelClient(long telClient) {
		this.telClient = telClient;
	}
	public String getSexeClient() {
		return sexeClient;
	}
	public void setSexeClient(String sexeClient) {
		this.sexeClient = sexeClient;
	}
	public List<Commande> getCommandList() {
		return commandList;
	}
	public void setCommandList(List<Commande> commandList) {
		this.commandList = commandList;
	}
	public List<Facture> getFactureList() {
		return factureListClient;
	}
	public void setFactureList(List<Facture> factureList) {
		this.factureListClient = factureList;
	}
	
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
		factureListClient.add(facture);
		facture.setClient(this);
	}
	public void removeFacture(Facture facture) {
		factureListClient.remove(facture);
		facture.setClient(null);
	}

	
	
	
}
