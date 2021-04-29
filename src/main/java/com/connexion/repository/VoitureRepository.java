package com.connexion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.connexion.models.Voiture;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture, Long> {

}
