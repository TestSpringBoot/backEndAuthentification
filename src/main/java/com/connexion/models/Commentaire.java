package com.connexion.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "commentaire")
public class Commentaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
	@Size(max = 255)
	private String detailsCommentaire;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "voiture_id", referencedColumnName = "id")
	private Voiture voiture;

	public Commentaire() {

	}

	public Commentaire(@NotBlank @Size(max = 255) String detailsCommentaire, User user, Voiture voiture) {
		super();
		this.detailsCommentaire = detailsCommentaire;
		this.user = user;
		this.voiture = voiture;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDetailsCommentaire() {
		return detailsCommentaire;
	}

	public void setDetailsCommentaire(String detailsCommentaire) {
		this.detailsCommentaire = detailsCommentaire;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

}
