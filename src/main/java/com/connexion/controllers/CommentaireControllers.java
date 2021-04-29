package com.connexion.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.connexion.bean.CommentaireBean;
import com.connexion.models.Commentaire;
import com.connexion.repository.CommentaireRepository;
import com.connexion.serviceCommentaire.CommentaireService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/")
public class CommentaireControllers {

	@Autowired
	CommentaireRepository commentaireRepository;

	@Autowired
	CommentaireService commentaireService;

	/**
	 * get list of commentaire join voiture and user who comment it
	 * 
	 * @return
	 */
	@GetMapping("/commentaires")
	public ResponseEntity<List<Commentaire>> getAllCommentaire() {
		List<Commentaire> commentaires = new ArrayList<Commentaire>();
		commentaires = this.commentaireRepository.findAllAboutCommentaire();
		if (commentaires.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(commentaires, HttpStatus.OK);
	}

	/**
	 * insert into commentaire
	 * 
	 * @param commentaireBean
	 * @return
	 */
	@PostMapping("/commentaires")
	public String createCommentaire(@RequestBody CommentaireBean commentaireBean) {

		this.commentaireService.saveCommentaire(commentaireBean);

		return "commentaire enregistrer";
	}
}
