package com.connexion.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "voitures")
public class Voiture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String marque;

	@NotBlank
	@Size(max = 50)
	private String modele;

	private boolean commented;

	public Voiture(@NotBlank @Size(max = 20) String marque, @NotBlank @Size(max = 50) String modele) {
		super();
		this.marque = marque;
		this.modele = modele;
	}

	public Voiture(@NotBlank @Size(max = 20) String marque, @NotBlank @Size(max = 50) String modele,
			@Size(max = 1) boolean commented) {
		super();
		this.marque = marque;
		this.modele = modele;
		this.commented = commented;
	}

	public Voiture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public boolean isCommented() {
		return commented;
	}

	public void setCommented(boolean commented) {
		this.commented = commented;
	}

}
