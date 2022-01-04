package com.example.soldLites.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.soldLites.model. Client;
import com.example.soldLites.service.ClientService;

@Controller
public class ClientController {
	
	@Autowired
	private ClientService clientService; 
	
	@GetMapping("/client")
	public String ViewHomePage(Model model) {
	 Iterable< Client> listeClient = clientService.getAllClients();	
	 model.addAttribute("listeClient", listeClient);
	 return "client"; // contient la page d'affichage du client
	}
	@PostMapping("/client/save")
	public String SaveClient(@ModelAttribute("client")  Client client) {
		clientService.addClient(client);
	    return "redirect:/client"; 
	}
	@GetMapping("/showClientFrom") 
	public String showClientFrom(Model model) {
		 Client p = new  Client();
	 model.addAttribute("client", p ); 
	 return "formNewClient"; // contient la page d'enregistrement du client
	}
	
	@GetMapping("/saved")
	public String age(Model model) {
	 	 return "saved"; // contient la page d'affichage du client
	}
}
