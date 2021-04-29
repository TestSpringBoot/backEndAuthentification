package com.connexion.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.connexion.models.Voiture;
import com.connexion.repository.VoitureRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/")
public class VoitureController {

	@Autowired
	VoitureRepository voitureRepository;

	/**
	 * get list voiture
	 * 
	 * @return
	 */
	@GetMapping("/voitures")
	public ResponseEntity<List<Voiture>> getAllVoiture() {
		List<Voiture> voitureList = new ArrayList<Voiture>();
		voitureRepository.findAll().forEach(voitureList::add);
		if (voitureList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Voiture>>(voitureList, HttpStatus.OK);
	}

	/**
	 * create voiture with marque and modele
	 * 
	 * @param voiture
	 * @return
	 */
	@PostMapping("/createVoiture")
	public Voiture createVoiture(@RequestBody Voiture voiture) {
		voiture.setCommented(true);
		this.voitureRepository.save(voiture);

		return voiture;
	}

	/**
	 * get voiture by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/voitures/{id}")
	public ResponseEntity<Voiture> getVoitureById(@PathVariable("id") long id) {
		Optional<Voiture> voiture = voitureRepository.findById(id);

		if (voiture.isPresent()) {
			return new ResponseEntity<Voiture>(voiture.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Voiture>(HttpStatus.NOT_FOUND);
		}
	}

}
