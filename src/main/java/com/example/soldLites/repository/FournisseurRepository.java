package com.example.soldLites.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.soldLites.model.Fournisseur;

public interface FournisseurRepository  extends JpaRepository<Fournisseur, Long> {

}
