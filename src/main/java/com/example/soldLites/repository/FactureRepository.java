package com.example.soldLites.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.soldLites.model.Facture;


public interface FactureRepository  extends JpaRepository<Facture, Long>{

}
