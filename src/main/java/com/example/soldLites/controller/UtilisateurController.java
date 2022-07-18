package com.example.soldLites.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.soldLites.model.Rayon;
import com.example.soldLites.model.Utilisateur;
import com.example.soldLites.service.UtilisateurService;

@Controller
public class UtilisateurController {
	
	@Autowired
	UtilisateurService utilisateurService;

	@GetMapping("/utilisateur")
	public String ViewHomePage(Model model) {
	 Iterable<Utilisateur> listeUtilisateur = utilisateurService.getAllUtilisateur();	
	 model.addAttribute("listeUtilisateur", listeUtilisateur);
	 return "utilisateur"; // contient la page d'affichage du utilisateur
	}
	@PostMapping("/utilisateur/save")
	public String SaveUtilisateur(@ModelAttribute("utilisateur") Utilisateur utilisateur) {
		utilisateurService.addUtilisateur(utilisateur);
	    return "redirect:/utilisateur"; 
	}
	@GetMapping("/showUtilisateurFrom") 
	public String showUtilisateurFrom(Model model) {
		Utilisateur u = new Utilisateur();
	 model.addAttribute("utilisateur", u ); 
	 return "formNewUtilisateur"; // contient la page d'enregistrement du utilisateur
	} 
	
	@GetMapping("/utilisateur/editUtilisateur/{idUtilisateur}")
	public String editUtilisateur(@PathVariable(value = "idUtilisateur") int idUtilisateur, Model model) {
		Utilisateur r = utilisateurService.updateUtilisateur(idUtilisateur);
		 model.addAttribute("utilisateur", r);
	 return "formUpdateUtilisateur";
	}
	
	@GetMapping("/utilisateur/deleteUtilisateur/{idUtilisateur}")
	public String deleteProduct(@PathVariable(value = "idUtilisateur") int idUtilisateur) {
		this.utilisateurService.deleteUtilisateurById(idUtilisateur);
		return "redirect:/utilisateur"; 
	}
}
