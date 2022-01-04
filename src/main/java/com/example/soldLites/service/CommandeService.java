package com.example.soldLites.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.soldLites.model.Commande;
import com.example.soldLites.model.Produit;
import com.example.soldLites.repository.CommandeRepository;

@Service
public class CommandeService {

	@Autowired
	private CommandeRepository commandeRepository; 
	
	
	public Iterable<Commande> getAllCommande(){
		return commandeRepository.findAll();
	}

	public Optional<Commande> getCommandeById(long id){
		return commandeRepository.findById(id);
	}
	
	public Commande addCommande(Commande commande) {
		return commandeRepository.save(commande);
	}
	public void deleteCommandeById(long id) {
		commandeRepository.deleteById(id);
	}
	
	public Commande updateCommande(long id) {
		Optional<Commande> optional = commandeRepository.findById(id);
		Commande commande = null;
		if(optional.isPresent()) {
			commande = optional.get();
		}else {
			throw new RuntimeException("commande not found for id : : "+id);
		}
		return commande;
	}
}
