package com.example.soldLites.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.soldLites.model.Produit;

public interface ProduitRepository  extends JpaRepository<Produit, Long> {

	
	/*
	@Query("select p from Produit p where p.idProduit=:x order by p.prixHTProduit desc")
	public Page<Produit> getAllPage(@Param("x")int code, Pageable pageable);
	
	
	public Page<Produit> getAllPageProduit( Pageable pageable);
	
	*/
}
