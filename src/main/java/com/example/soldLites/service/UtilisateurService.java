package com.example.soldLites.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.soldLites.model.Produit;
import com.example.soldLites.model.Utilisateur;
import com.example.soldLites.repository.UtilisateurRepository;

@Service
public class UtilisateurService {

	@Autowired
	private UtilisateurRepository utilisateurRepository; 
	
	
	public Iterable<Utilisateur> getAllUtilisateur(){
		return utilisateurRepository.findAll();
	}

	public Optional<Utilisateur> getUtilisateurById(long id){
		return utilisateurRepository.findById(id);
	}
	
	public Utilisateur addUtilisateur(Utilisateur utilisateur) {
		return utilisateurRepository.save(utilisateur);
	}
	public void deleteUtilisateurById(long id) {
		utilisateurRepository.deleteById(id);
	}
	
	public Utilisateur updateUtilisateur(long id) {
		Optional<Utilisateur> optional = utilisateurRepository.findById(id);
		Utilisateur utilisateur = null;
		if(optional.isPresent()) {
			utilisateur = optional.get();
		}else {
			throw new RuntimeException("utilisateur not found for id : : "+id);
		}
		return utilisateur;
	}
}
