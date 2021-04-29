package com.connexion.bean;

public class VoitureBean {

	private long idVoiture;
	private String marque;
	private String modele;
	private String commentaire;

	public VoitureBean() {

	}

	public VoitureBean(long idVoiture, String marque, String modele, String commentaire) {
		super();
		this.idVoiture = idVoiture;
		this.marque = marque;
		this.modele = modele;
		this.commentaire = commentaire;
	}

	public long getIdVoiture() {
		return idVoiture;
	}

	public void setIdVoiture(long idVoiture) {
		this.idVoiture = idVoiture;
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

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

}
