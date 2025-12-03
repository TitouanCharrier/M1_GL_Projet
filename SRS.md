# Spécification des Exigences Logicielles (SRS)

## Introduction

#### Objectif du Document

Ce document, la Spécification des Exigences Logicielles (SRS), décrit en détail les exigences fonctionnelles et non fonctionnelles pour le développement de l'application web d'échange hyperlocal, nommée ici "LocalXChange". Il servira de référence pour les équipes de conception, de développement, de test et de validation.

#### Portée du Projet (Produit)

Le produit est une application web qui connecte les utilisateurs résidant à proximité pour faciliter l'échange, le prêt ou le don de biens physiques et de services/compétences. L'application vise à réduire la consommation et à renforcer les liens sociaux dans les communautés locales.

#### Public Cible et Utilisations Prévues

Public Cible : Résidents d'une zone géographique définie, souhaitant partager des ressources.

Utilisations Prévues : Publier des annonces (objets et compétences), rechercher des ressources, initier et gérer des transactions d'échange, noter et évaluer les partenaires d'échange.

#### Définitions, Acronymes et Abréviations


- **Utilisateur** :	

Tout individu inscrit et connecté à l'application.
- Contributeur** :	

Utilisateur qui propose un objet ou une compétence à l'échange/prêt.

- Bénéficiaire	Utilisateur qui demande l'objet ou la compétence.
Échange	Transaction approuvée d'objet contre objet, compétence contre compétence, ou objet contre compétence.

- API Interface de Programmation d'Application (Application Programming Interface)

## Description Générale

#### Besoins Utilisateurs et Hypothèses

- Besoins : 

Les utilisateurs ont besoin d'une plateforme simple et sécurisée pour partager des biens et des compétences au niveau local, avec un système de confiance clair (réputation).

- Hypothèses : 

La plateforme reposera sur une localisation géographique précise ou générale fournie par l'utilisateur. La majorité des utilisateurs disposeront d'un accès internet standard et d'un navigateur web moderne.

#### Exigences des Utilisateurs (Rôles)

- Utilisateur Non Authentifié	

S'inscrire, se connecter, consulter certaines annonces publiques (selon les règles de confidentialité).

- Utilisateur Authentifié	

Gérer son profil, créer des annonces, rechercher/filtrer les annonces, envoyer/gérer les demandes, utiliser la messagerie, laisser des avis.

## Exigences Fonctionnelles Détaillées (EF)

Cette section détaille les fonctionnalités requises par le système.

| ID | Domaine | Exigence Fonctionnelle | Description |
| :---: | :--- | :--- | :--- |
| **EF1.1** | Authentification | Inscription Utilisateur | Le système doit permettre à un nouvel utilisateur de s'inscrire avec une adresse email valide, un nom complet et une localisation générale (ville/code postal). |
| **EF1.2** | Authentification | Connexion Sécurisée | Le système doit authentifier un utilisateur existant via son email et son mot de passe. Le mot de passe doit être chiffré. |
| **EF1.3** | Authentification | Gestion du Profil | L'utilisateur doit pouvoir modifier son nom, sa biographie, sa photo de profil et sa localisation. |
| **EF1.4** | Authentification | Vérification Téléphonique | Le système doit permettre à l'utilisateur de vérifier son numéro de téléphone (via un code SMS ou autre). |
| **EF2.1** | Objets/Biens | Créer une Annonce | L'utilisateur doit pouvoir soumettre une annonce d'objet incluant : titre, description (max 500 mots), catégorie, jusqu'à 5 images, disponibilité (à prêter/à donner) et un champ de commentaire optionnel pour spécifier un échange souhaité. |
| **EF2.2** | Objets/Biens | Recherche d'Annonces | Le système doit permettre la recherche par mots-clés dans le titre et la description. |
| **EF2.3** | Objets/Biens | Filtrage des Annonces | L'utilisateur doit pouvoir filtrer les annonces par catégorie et par distance par rapport à sa localisation. |
| **EF2.4** | Objets/Biens | Visualisation Détail | Le système doit afficher une page détaillée de l'annonce avec toutes les informations et un lien vers le profil du créateur. |
| **EF2.5** | Objets/Biens | Gestion des Annonces | L'utilisateur doit pouvoir modifier, désactiver/archiver ou supprimer ses propres annonces. |
| **EF3.1** | Compétences | Proposer une Compétence | L'utilisateur doit pouvoir créer une annonce de compétence incluant : titre, description, catégories de compétences, disponibilités, et un champ de commentaire pour spécifier un échange souhaité. |
| **EF3.2** | Compétences | Parcourir/Rechercher Compétences | Le système doit permettre la recherche par mots-clés et le filtrage des annonces de compétences par type et par distance. |
| **EF4.1** | Transaction | Envoyer Demande d'Échange | Le bénéficiaire doit pouvoir envoyer une demande d'échange, en spécifiant : l'objet ou la compétence qu'il offre en retour (si applicable) et la date/période d'échange souhaitée. |
| **EF4.2** | Transaction | Voir les Demandes | Le donateur doit avoir un tableau de bord pour visualiser toutes les demandes reçues, avec leur statut (en attente, acceptée, refusée). |
| **EF4.3** | Transaction | Accepter/Refuser Demande | Le donateur doit pouvoir accepter ou refuser une demande en un clic. |
| **EF4.4** | Transaction | Messagerie (Chat) | Une fois la demande acceptée, un fil de discussion (chat) doit être automatiquement activé entre les deux utilisateurs pour la logistique. |
| **EF4.5** | Transaction | Clôture de l'Échange | Les deux parties doivent pouvoir marquer la transaction comme "Terminée" une fois l'échange réalisé. |
| **EF5.1** | Réputation | Avis et Notation | Après la clôture (EF4.5), le système doit inviter les deux utilisateurs à laisser une notation (1 à 5 étoiles) et un commentaire public l'un pour l'autre. |
| **EF5.2** | Réputation | Affichage de la Réputation | La note moyenne (en étoiles) et le nombre d'avis doivent être visibles sur le profil de l'utilisateur et sur toutes ses annonces. |
| **EF6.1** | Notification | Notification In-App | L'utilisateur doit recevoir des notifications directement dans l'application pour : nouvelle demande reçue, message reçu sur le chat, statut de demande mis à jour. |
| **EF6.2** | Notification | Notification par Email | L'utilisateur doit recevoir des notifications par email pour les mêmes événements que EF6.1 (avec une option pour désactiver les emails). |

---

## Exigences Non Fonctionnelles (ENF)

| ID | Domaine | Exigence Non Fonctionnelle | Description |
| :---: | :--- | :--- | :--- |
| **ENF1.1** | Performance | Temps de Chargement | Toutes les pages, à l'exception des pages de recherche complexes, doivent se charger en moins de 3 secondes sur une connexion haut débit standard. |
| **ENF1.2** | Performance | Temps de Recherche | La recherche d'annonces (EF2.2, EF3.2) doit retourner les résultats en moins de 1 seconde pour un volume initial de 10 000 annonces. |
| **ENF1.3** | Performance | Scalabilité | L'architecture logicielle doit pouvoir supporter une croissance jusqu'à 10 000 utilisateurs actifs simultanés. |
| **ENF2.1** | Sécurité | Protection des Données | Les mots de passe des utilisateurs doivent être chiffrés. |
| **ENF2.2** | Sécurité | Protection contre les Vulnérabilités | Le système doit être protégé contre les vulnérabilités courantes du web, notamment les attaques XSS et SQL Injection. |
| **ENF2.3** | Sécurité | Confidentialité | L'adresse email et le numéro de téléphone des utilisateurs ne doivent être visibles par aucune autre partie, sauf via la messagerie après acceptation. |
| **ENF3.1** | Ergonomie | Interface Utilisateur (UI) | L'interface utilisateur doit être claire, cohérente et suivre les principes de design réactif. |
| **ENF3.2** | Ergonomie | Facilité d'Utilisation | Un nouvel utilisateur doit pouvoir créer un compte et publier sa première annonce en moins de 5 minutes. |
| **ENF4.1** | Maintenabilité | Structure du Code | Le code doit être documenté, modulaire et suivre les conventions de codage établies. |
| **ENF4.2** | Maintenabilité | Déploiement | Le déploiement doit être automatisé (ex : CI/CD). |
