package com.example.soldLites.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.soldLites.model.Commande;
import com.example.soldLites.service.CommandeService;

@Controller
public class CommandeController {
	
	@Autowired
	CommandeService commandeService;

	@GetMapping("/commande")
	public String ViewHomePage(Model model) {
	 Iterable<Commande> listeCommande = commandeService.getAllCommande();	
	 model.addAttribute("listeCommande", listeCommande);
	 return "commande"; // contient la page d'affichage du Commande
	}
	@PostMapping("/commande/save")
	public String SaveCommande(@ModelAttribute("commande") Commande commande) {
		commandeService.addCommande(commande);
	    return "redirect:/commande"; 
	}
	@GetMapping("/showCommandeFrom") 
	public String showCommandeFrom(Model model) {
		Commande c = new Commande();
	 model.addAttribute("commande", c ); 
	 return "formNewCommande"; // contient la page d'enregistrement du Commande
	} 
}
