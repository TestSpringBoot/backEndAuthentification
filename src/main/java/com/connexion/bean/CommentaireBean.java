package com.connexion.bean;

public class CommentaireBean {

	private long id;
	private String detailsCommentaire;
	private long userId;
	private long voitureId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDetailsCommentaire() {
		return detailsCommentaire;
	}

	public void setDetailsCommenataire(String detailsCommenatire) {
		this.detailsCommentaire = detailsCommentaire;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getVoitureId() {
		return voitureId;
	}

	public void setVoitureId(long voitureId) {
		this.voitureId = voitureId;
	}

}
