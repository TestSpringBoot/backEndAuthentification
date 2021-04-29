package com.connexion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.connexion.models.Commentaire;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

	@Query("FROM Commentaire c inner join Voiture v on v.id = c.voiture")
	List<Commentaire> findAllAboutCommentaire();

}
