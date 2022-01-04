package com.example.soldLites.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.soldLites.model.Utilisateur;

public interface UtilisateurRepository  extends JpaRepository<Utilisateur, Long> {

}
