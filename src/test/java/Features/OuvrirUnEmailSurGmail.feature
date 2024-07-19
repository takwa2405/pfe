@tag
Feature: Ouvrir un email sur Outlook

@tag1
  Scenario: L'utilisateur ouvre un email sur Outlook
    Given L'utilisateur est sur la page de connexion Outlook
    When L'utilisateur se connecte avec l'adresse email "takwa.haggui@esprit.tn"
    And L'utilisateur sélectionne le compte professionnel
    And je saisis un mot de passe correct "<password>"
    And L'utilisateur approuve la demande de connexion manuellement
    And L'utilisateur répond à la question rester connecté
   Then L'utilisateur ouvre l'email pour la récupération de mot de passe
  
    
    
    Examples:
      | emailCorrect           | password   |
      | takwa.haggui@esprit.tn |   Hajouda@haykel123@ |
