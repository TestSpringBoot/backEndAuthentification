package com.connexion.serviceCommentaire.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connexion.bean.CommentaireBean;
import com.connexion.models.Commentaire;
import com.connexion.models.User;
import com.connexion.models.Voiture;
import com.connexion.repository.CommentaireRepository;
import com.connexion.repository.UserRepository;
import com.connexion.repository.VoitureRepository;
import com.connexion.serviceCommentaire.CommentaireService;

@Service
public class ServiceCommentaireImpl implements CommentaireService {

	@Autowired
	CommentaireRepository repositoryCommentaire;

	@Autowired
	UserRepository userRepository;

	@Autowired
	VoitureRepository voitureRepository;

	@Override
	public void saveCommentaire(CommentaireBean commentaireBean) {
		Commentaire commentaireEntity = new Commentaire();

		Optional<User> userOpt = userRepository.findById(commentaireBean.getUserId());

		Optional<Voiture> voitureOpt = voitureRepository.findById(commentaireBean.getVoitureId());

		commentaireEntity.setDetailsCommentaire(commentaireBean.getDetailsCommentaire());
		commentaireEntity.setUser(userOpt.get());
		commentaireEntity.setVoiture(voitureOpt.get());
		this.repositoryCommentaire.save(commentaireEntity);

		// update voiture for to be commented
		if (commentaireEntity.getUser() != null && commentaireEntity.getDetailsCommentaire() != null
				&& commentaireEntity.getVoiture() != null) {
			if (voitureOpt.isPresent()) {
				Voiture voitureEntity = new Voiture();
				voitureOpt.get().setCommented(true);
				this.voitureRepository.save(voitureOpt.get());
			}

		}
	}

}
