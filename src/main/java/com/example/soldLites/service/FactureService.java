package com.example.soldLites.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.soldLites.model.Facture;
import com.example.soldLites.model.Produit;
import com.example.soldLites.repository.FactureRepository;

@Service
public class FactureService {

	@Autowired
	private FactureRepository factureRepository; 
	
	
	public Iterable<Facture> getAllFacture(){
		return factureRepository.findAll();
	}

	public Optional<Facture> getFactureById(long id){
		return factureRepository.findById(id);
	}
	
	public Facture addFacture(Facture facture) {
		return factureRepository.save(facture);
	}
	public void deleteFactureById(long id) {
		factureRepository.deleteById(id);
	}
	
	public Facture updateFacture(long id) {
		Optional<Facture> optional = factureRepository.findById(id);
		Facture facture = null;
		if(optional.isPresent()) {
			facture = optional.get();
		}else {
			throw new RuntimeException("facture not found for id : : "+id);
		}
		return facture;
	}
}
