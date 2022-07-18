package com.example.soldLites.service;

import com.example.soldLites.repository.ClientRepository;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.soldLites.model.Client;
import com.example.soldLites.model.Commande;
import com.example.soldLites.model.Produit;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository; 
	
	
	public Iterable<Client> getAllClients(){
		return clientRepository.findAll();
	}

	public Optional<Client> getClientById(long id){
		return clientRepository.findById(id);
	}
	
	public Client addClient(Client client) {
		return clientRepository.save(client);
	}
	public void deleteClientById(long id) {
		clientRepository.deleteById(id);
	}
	
	public Client updateClient(long id) {
		Optional<Client> optional = clientRepository.findById(id);
		Client client = null;
		if(optional.isPresent()) {
			client = optional.get();
		}else {
			throw new RuntimeException("client not found for id : : "+id);
		}
		return client;
	}
	
}
