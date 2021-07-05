# Authentification et gestion de securité API en spring boot
API REST pour gérer l'inscription d'utilisateur, l'authentification, l'ajout d'une voiture, voir liste voiture, commenter une voiture si connecté et voir liste voiture si connecté

1.	Prérequis 
Créer une base de donnée mysql et configurer l'application application.properties dans src/main/resources/
Après avoir lancé le projet : il faut exécuter la requête suivante pour avoir les rôles des utilisateurs:
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');


2.	Inscription à la table utilisateur avant d’avoir authentifié
Inscription avec méthode post avec l’API : http://localhost:8080/api/auth/signup  avec un body comme la suivante :
    {
        "username": "admnin",
        "password": "12345678",
        "email": "admin@gmail.com",
        "roles": 1
    }


3.	Athentification 
Authentification avec méthode post pour avoir le token suivant l'API: http://localhost:8080/api/auth/signin
    {
        "username": "admnin",
        "password": "12345678"
    }


4.	Ajouter une voiture
Plus : Pour ajouter une voiture (RG : utilisateur non connecté), l'API utilisé est http://localhost:8080/api/createVoiture
    {
        "marque": "nissan",
        "modele": "bassé"
    }
    
    
5.	Lister voiture
L'application permet d'avoir une liste des voitures (RG : utilisateur non connecté) avec l’API: http://localhost:8080/api/voitures


6.	Commenter voiture
Chaque utilisateur (utilisateur connecté) peut commenter une voiture avec l’API http://localhost:8080/api/addCommentaires  ayant le body comme la suivante:
    {
        "detailsCommentaire": "tsaraaaaaa",
        "userId": 1,
        "voitureId": 1
    }


7.	Liste commentaire
Liste commentaires (RG : On ne doit pouvoir accéder aux commentaires seulement si on est connecté) : http://localhost:8080/api/commentaires
