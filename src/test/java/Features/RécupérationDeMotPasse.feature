@tag
Feature: Mot de passe oublié
     
@tag1
Scenario Outline: Récupération de mot de passe pour un utilisateur
    Given Je suis sur la page d'accueil d'ESBonlineRCM
   
   When Une page d'authentification pour espace étudiant s'afficheRCM
    And J'entre un identifiant "<identifiantvalide>" valide1 pour l'utilisateur
    And Je clique sur l'étape suivanteRCM
    And L'utilisateur clique sur Mot de passe oublie
    And L'utilisateur entre son adresse e-mail "<email>"
    And Je clique sur Récupérer mot de passe
    Then Un message de confirmation "Un e-mail a été envoyé pour réinitialiser le mot de passe" doit s'afficher
    
    Examples:
      
      
    | email                           | identifiantvalide |
    | takwa.haggui@esprit.tn          |   191MTB1025      |
 
 @tag2
 Scenario: Récupération de mot de passe pour un email invalide

     Given Je suis sur la page d'accueil d'ESBonlineRCM
      And J'entre un identifiant "<identifiantvalide>" valide1 pour l'utilisateur
      And Je clique sur l'étape suivanteRCM
      And L'utilisateur clique sur Mot de passe oublie
       And L'utilisateur entre son adresse e-mailinvalide "<emailinvalide>"
    And Je clique sur Récupérer mot de passe
    Then Un message d'erreur doit s'afficher

 
    Examples:
    | emailinvalide                   | identifiantvalide |
    | takwa.hagguiesprit.tn          |   191MTB1025        |
    