package com.example.soldLites.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.soldLites.model.Rayon;


@Repository
public interface RayonRepository  extends JpaRepository<Rayon, Long> {
	

}
