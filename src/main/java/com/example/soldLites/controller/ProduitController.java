package com.example.soldLites.controller;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import com.example.soldLites.helpers.ZXingHelper;
import com.example.soldLites.service.ProduitService;
import com.example.soldLites.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class ProduitController {

	@Autowired
	private ProduitService produitService;
	
	/*
	@GetMapping("/produit")
	public String ViewPage(Model model, int idProduit,
			@RequestParam(name="page", defaultValue="0")int page,
			@RequestParam(name="size", defaultValue="3")int size)  {
		model.addAttribute("idProduit", idProduit);
	 Page<Produit> listeProduit = produitService.getAllPage(idProduit,page,size);	
	 model.addAttribute("listeP", listeProduit.getContent());
	 int[] pages = new int [listeProduit.getTotalPages()];
	 model.addAttribute("pages", pages);
	 return "produit"; // contient la page d'affichage du produit
	}

	
	
	@GetMapping("/produit")
	public String ViewPage(Model model, 
			@RequestParam(name="page", defaultValue="0")int page,
			@RequestParam(name="size", defaultValue="3")int size)  {
	 Page<Produit> listeProduit = produitService.getAllPageProduit(page,size);	
	 model.addAttribute("listeP", listeProduit.getContent());
	 int[] pages = new int [listeProduit.getTotalPages()];
	 model.addAttribute("pages", pages);
	 return "produit"; // contient la page d'affichage du produit
	}
		*/
	
	@GetMapping("/produitConsulter")
	public String consulterProduit(Model model, long idProduit) {
	  model.addAttribute("idProduit", idProduit);
	 try {
		 Produit cp = produitService.consulterProduit(idProduit);
			model.addAttribute("produit", cp);
		} catch (Exception e) {
			model.addAttribute("error", e);
		}
	 return "produit"; // contient la page d'affichage du produit
	}
	 
	@GetMapping("/produit")
	public String ViewProduit(Model model) {
	 Iterable<Produit> listeProduit = produitService.getAllProduit();	
	 model.addAttribute("listeProduit", listeProduit);
	 return "produit"; // contient la page d'affichage du produit
	}
	 
	@PostMapping("/produit/save")
	public String SaveProduit(@ModelAttribute("produit") Produit produit) {
		produitService.addProduit(produit);
	    return "redirect:/produit"; 
	}
	@GetMapping("/showProductFrom") 
	public String showProductFrom(Model model) {
		Produit p = new Produit();
	 model.addAttribute("produit", p ); 
	 return "formNewProduit"; // contient la page d'enregistrement du produit
	} 
	
	
	
	@RequestMapping(value = "qrcode/{id}" , method = RequestMethod.GET) 
	public void qrcode(@PathVariable("id") String id,HttpServletResponse reponse) throws Exception {
		reponse.setContentType("image/png")  ;
		OutputStream outputStream  = reponse.getOutputStream();
		outputStream.write(ZXingHelper.getQRCodeImage(id, 50, 50));
		outputStream.flush();
		outputStream.close();
	}
	@RequestMapping(value = "barcode/{id}" , method = RequestMethod.GET) 
	public void barcode(@PathVariable("id") String id,HttpServletResponse reponse) throws Exception {
		reponse.setContentType("image/png")  ;
		OutputStream outputStream  = reponse.getOutputStream();
		outputStream.write(ZXingHelper.getBarCodeImage(id, 50, 50));
		outputStream.flush();
		outputStream.close();
	}
	
	@GetMapping("/produit/editProduit/{idProduit}")
	public String editProduit(@PathVariable(value = "idProduit") int idProduit, Model model) {
		Produit p = produitService.updateProduit(idProduit);
		 model.addAttribute("produit", p);
	 return "formUpdateProduit";
	}
	
	@GetMapping("/produit/deleteProduit/{idProduit}")
	public String deleteProduct(@PathVariable(value = "idProduit") int idProduit) {
		this.produitService.deleteProduitById(idProduit);
		return "redirect:/produit";
	}
	
	@RequestMapping("/login/home")
	public String HomePage(Model model) {
	 return "home";
	}
}
