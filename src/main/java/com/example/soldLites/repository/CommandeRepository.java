package com.example.soldLites.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.soldLites.model.Commande;


public interface CommandeRepository  extends JpaRepository<Commande, Long>{

}
