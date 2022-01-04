package com.example.soldLites.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.soldLites.model.Fournisseur;
import com.example.soldLites.repository.FournisseurRepository;


@Service
public class FournisseurService {

	@Autowired
	private FournisseurRepository fournisseurRepository; 
	
	
	public Iterable<Fournisseur> getAllFournisseur(){
		return fournisseurRepository.findAll();
	}

	public Optional<Fournisseur> getFournisseurById(long id){
		return fournisseurRepository.findById(id);
	}
	
	public Fournisseur addFournisseur(Fournisseur fournisseur) {
		return fournisseurRepository.save(fournisseur);
	}
	public void deleteFournisseurById(long id) {
		 fournisseurRepository.deleteById(id);
	}
	public Fournisseur updateFournisseur(long id) {
		Optional<Fournisseur> optional = fournisseurRepository.findById(id);
		Fournisseur fournisseur = null;
		if(optional.isPresent()) {
			fournisseur = optional.get();
		}else {
			throw new RuntimeException("fournisseur not found for id : : "+id);
		}
		return fournisseur;
	}
}
