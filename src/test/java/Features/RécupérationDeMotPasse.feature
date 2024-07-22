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
  Scenario: L'utilisateur ouvre un email sur Outlook
   Given L'utilisateur est sur la page de connexion Outlook
   And L'utilisateur se connecte avec l'adresse email "<emailCorrect>"
    And L'utilisateur sélectionne le compte professionnel
    And je saisis un mot de passe correct "<password>"
    And L'utilisateur approuve la demande de connexion manuellement
    And L'utilisateur répond à la question rester connecté
   Then L'utilisateur ouvre l'email pour la récupération de mot de passe
  
    
    
    Examples:
      | emailCorrect           | password   |
      | takwa.haggui@esprit.tn |   Hajouda@haykel123@ |
    
   
  @tag3
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
       
 
