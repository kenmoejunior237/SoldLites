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
@Table(name = "table_Facture")
public class Facture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Facture")
	private long idFacture; 
	
	@Column(name = "date_Facture")
	private String dateFacture;
	
	@Column(name = "remise_Facture")
	private String remiseFacture;
	
	@ManyToOne(
			cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Commande")
	private Commande command;
	
	@ManyToOne(
			cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Client")
	private Client client;

	public long getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(long idFacture) {
		this.idFacture = idFacture;
	}

	public String getDateFacture() {
		return dateFacture;
	}

	public void setDateFacture(String dateFacture) {
		this.dateFacture = dateFacture;
	}

	public String getRemiseFacture() {
		return remiseFacture;
	}

	public void setRemiseFacture(String remiseFacture) {
		this.remiseFacture = remiseFacture;
	}

	public Commande getCommand() {
		return command;
	}

	public void setCommand(Commande command) {
		this.command = command;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
