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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "table_Rayon")
public class Rayon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Rayon")
	private long idRayon; 
	
	@Column(name = "nom_Rayon")
	private String nomRayon;
	
	@OneToMany(
			cascade = CascadeType.ALL,
			orphanRemoval = true,
			fetch = FetchType.EAGER)
	@JoinColumn(name = "id_Rayon")
	
	

	List<Produit> produitList = new ArrayList<>();

	public long getIdRayon() {
		return idRayon;
	}

	public void setIdRayon(long idRayon) {
		this.idRayon = idRayon;
	}

	public String getNomRayon() {
		return nomRayon;
	}

	public void setNomRayon(String nomRayon) {
		this.nomRayon = nomRayon;
	}

	public List<Produit> getProduitList() {
		return produitList;
	}

	public void setProduitList(List<Produit> produitList) {
		this.produitList = produitList;
	}
	
	
	
	
	 public Rayon(String nomRayon) {
		super();
		this.nomRayon = nomRayon;
	}
	 
	 public Rayon() {
			
		}

	//les methodes utilitaires 
	
		public void addProduit(Produit produit) {
			produitList.add(produit);
			produit.setRayon(this);
		}
		public void removeProduit(Produit produit) {
			produitList.remove(produit);
			produit.setRayon(null);
		}

	
	

}
