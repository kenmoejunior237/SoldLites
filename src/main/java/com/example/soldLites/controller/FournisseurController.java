package com.example.soldLites.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.soldLites.model.Fournisseur;
import com.example.soldLites.model.Rayon;
import com.example.soldLites.service.FournisseurService;
import org.springframework.stereotype.Controller;


@Controller
public class FournisseurController { 

	@Autowired
	private FournisseurService fournisseurService;
	
	@GetMapping("/fournisseur") 
	public String ViewFournisseurPage(Model model) {
	Iterable<Fournisseur> listeFournisseur = fournisseurService.getAllFournisseur();
	 model.addAttribute("listeFournisseur", listeFournisseur );
	 return "fournisseur"; // contient la page d'affichage du fournisseur
	}
	@PostMapping("/fournisseur/save")
	public String SaveProduit(@ModelAttribute("fournisseur") Fournisseur fournisseur) {
		fournisseurService.addFournisseur(fournisseur);
	    return "redirect:/fournisseur"; 
	}
	
	@GetMapping("/fournisseur/editFournisseur/{idFournisseur}")
	public String editFournisseur(@PathVariable(value = "idFournisseur") int idFournisseur, Model model) {
		Fournisseur f = fournisseurService.updateFournisseur(idFournisseur);
		 model.addAttribute("fournisseur", f);
	 return "formUpdateFournisseur";
	}
	
	@GetMapping("/fournisseur/deleteFournisseur/{idFournisseur}")
	public String deleteFournisseur(@PathVariable(value = "idFournisseur") int idFournisseur) {
		this.fournisseurService.deleteFournisseurById(idFournisseur);
		return "redirect:/fournisseur"; 
	}
	@GetMapping("/showFournisseurFrom") 
	public String showFournisseurFrom(Model model) {
		Fournisseur f = new Fournisseur();
	 model.addAttribute("fournisseur", f ); 
	 return "formNewFournisseur"; // contient la page d'enregistrement du Fournisseur
	} 
}
