package com.example.soldLites.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.soldLites.model.Facture;
import com.example.soldLites.service.FactureService;

@Controller
public class FactureControler {
	
	@Autowired
	FactureService factureService;

	@GetMapping("/facture")
	public String ViewHomePage(Model model) {
	 Iterable<Facture> listeFacture = factureService.getAllFacture();	
	 model.addAttribute("listeFacture", listeFacture);
	 return "facture"; // contient la page d'affichage du facture
	}
	@PostMapping("/facture/save")
	public String SaveFacture(@ModelAttribute("facture") Facture facture) {
		factureService.addFacture(facture);
	    return "redirect:/facture"; 
	}
	@GetMapping("/showFactureFrom") 
	public String showFactureFrom(Model model) {
		Facture f = new Facture();
	 model.addAttribute("facture", f ); 
	 return "formNewFacture"; // contient la page d'enregistrement du facture
	} 
}
