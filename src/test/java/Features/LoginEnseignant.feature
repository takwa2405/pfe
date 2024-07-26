@tag
Feature: Authentification pour Espace Enseignant
  
 

  @tag2
  Scenario: Authentification avec un identifiant incorrect
    Given Je suis sur la page d'accueil d'ESBonlineE
    When Je clique sur Enseignant "Espace Enseignants"
    And Une page d'authentification pour espace Enseignant s'affiche
    And J'entre un identifiant incorrect "<identifiant7E>" pour Enseignant
    And Je clique sur l'étape suivante Enseignant
    And le champ du mot de passe est affiché pour espace enseignant
    And  je saisis un mot de passe correct Enseignant "<pswPE>"
    And je clique sur le bouton de connexion Enseignant
    Then revien au page connexion
    Examples:
      | identifiant7E  |pswPE        |
      | V0509-22       | V-0509-22   |
      
   @tag4
  Scenario: Authentification avec identifiant valide et un mot de passe incorrect
    Given Je suis sur la page d'accueil d'ESBonlineE
    When Je clique sur Enseignant "Espace Enseignants"
    And Une page d'authentification pour espace Enseignant s'affiche
    And J'entre un identifiant valide pour Enseignant "<identifiant9E>"
    And Je clique sur l'étape suivante Enseignant
    And le champ du mot de passe est affiché pour espace enseignant 
    And je saisis un mot de passe incorrect Enseignant "<motdepasseincorrectE>"
   And je clique sur le bouton de connexion Enseignant  
   Then revien au page connexion enseignant
      Examples:
      | identifiant9E | motdepasseincorrectE |
      | V-0509-22     | V-0509-22A           |
    
     
   @tag5  
  Scenario: je saisis un identifiant vide enseignant 
    Given Je suis sur la page d'accueil d'ESBonlineE
    When Je clique sur Enseignant "Espace Enseignants"
    And Une page d'authentification pour espace Enseignant s'affiche
    And Je clique sur l'étape suivante Enseignant
    Then revien au page connexion et affiche identifiant incorrect 
    Examples:
      | identifiant7E  |pswPE        |
      |                | V-0509-22   |
  
       
 @tag6
  Scenario: Authentification avec un identifiant valide et de mot de passe vide
   Given Je suis sur la page d'accueil d'ESBonlineE
    When Je clique sur Enseignant "Espace Enseignants"
     And Une page d'authentification pour espace Enseignant s'affiche
     And J'entre un identifiant valide pour Enseignant "<identifiant9E>"
    And Je clique sur l'étape suivante Enseignant
    And le champ du mot de passe est affiché pour espace enseignant
    And je clique sur le bouton de connexion Enseignant
    Then affichage d'un message Password incorrect

    Examples:
      | identifiant9E | mdpvideE |
      | V-0509-22     |          |
       
