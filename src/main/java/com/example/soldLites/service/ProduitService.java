package com.example.soldLites.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.soldLites.model.Produit;
import com.example.soldLites.repository.ProduitRepository;


@Service
@Transactional
public class ProduitService {

	@Autowired
	private ProduitRepository produitRepository; 
	
	/*
	public Page<Produit> getAllPage(int code, int page, int size){
		return produitRepository.getAllPage(code,new QPageRequest(page, size));
	}
	
	public Page<Produit> getAllPageProduit( int page, int size){
		return produitRepository.getAllPageProduit(new QPageRequest(page, size));
	}
	*/
	public void calculTTC(long idProduit, double montant) {
		Produit cp = consulterProduit(idProduit);
		cp.setPrixTTCProduit(cp.getPrixHTProduit()*(1/1.1925));  /// mise a jour
		produitRepository.saveAndFlush(cp);
	}
	
	public void calculTVA(long idProduit, double montant) {
		Produit cp = consulterProduit(idProduit);
		cp.setPrixTTCProduit(cp.getPrixHTProduit()+montant);  /// mise a jour
		produitRepository.saveAndFlush(cp);
	}
	
	public Iterable<Produit> getAllProduit(){
		return produitRepository.findAll();
	}
	
	public Produit consulterProduit(long idProduit) {
		Optional<Produit> cp = produitRepository.findById(idProduit);
		if(cp==null) throw new RuntimeException("produit "+idProduit+" introuvable");
		return null;
	}

	public Optional<Produit> getProduitById(long id){
		return produitRepository.findById(id);
	}
	
	public Produit addProduit(Produit produit) {
		return produitRepository.save(produit);
	}
	
	public void deleteProduitById(long id) {
		produitRepository.deleteById(id);
	}
	
	public Produit updateProduit(long id) {
		Optional<Produit> optional = produitRepository.findById(id);
		Produit produit = null;
		if(optional.isPresent()) {
			produit = optional.get();
		}else {
			throw new RuntimeException("produit not found for id : : "+id);
		}
		return produit;
	}
}
