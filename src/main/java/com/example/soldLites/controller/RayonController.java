package com.example.soldLites.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.soldLites.model.Rayon;
import com.example.soldLites.service.RayonService;

import net.sf.jasperreports.engine.JRException;


@Controller
public class RayonController {

	@Autowired
	private RayonService rayonService;
	
	@GetMapping("/rayon")
	public String ViewHomePage(Model model) {
	Iterable<Rayon> listeRayon = rayonService.getAllRayon();
	 model.addAttribute("listeRayon", listeRayon);
	 return "rayon"; // contient la page d'affichage du rayons
	}
	@PostMapping("/rayon/save")
	public String SaveRayon(@ModelAttribute("rayon") Rayon rayon) {
		rayonService.addRayon(rayon);
	    return "redirect:/rayon"; 
	}
	@GetMapping("/rayon/editrayon/{idRayon}")
	public String editRayon(@PathVariable(value = "idRayon") int idRayon, Model model) {
		Rayon r = rayonService.updateRayon(idRayon);
		 model.addAttribute("rayon", r);
	 return "formUpdateRayon";
	}
	
	@GetMapping("/rayon/deleteRayon/{idRayon}")
	public String deleteProduct(@PathVariable(value = "idRayon") int idRayon) {
		this.rayonService.deleteRayonById(idRayon);
		return "redirect:/rayon"; 
	}
	@GetMapping("/showRayonFrom") 
	public String showProductFrom(Model model) {
		Rayon r = new Rayon();
	 model.addAttribute("rayon", r ); 
	 return "formNewRayon"; // contient la page d'enregistrement du rayon
	} 
	@GetMapping("/report/{format}") 
	public String generatedReport (@PathVariable String format) throws FileNotFoundException, JRException{
		return rayonService.exportReport(format);
	}
	
}
 