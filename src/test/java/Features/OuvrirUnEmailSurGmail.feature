Feature: Lecture des emails

  Scenario: Ouvrir un email sur Gmail
    Given L'utilisateur est sur la page de connexion outlook
    When L'utilisateur se connecte avec l'adresse email 
    And  Créé par vous
    And je saisis un  mot de passe  correct "<password>"
    And L'utilisateur ouvre l'email avec le sujet "Sujet de l'email"
    Then L'utilisateur doit voir le contenu de l'email
    
    
    | emailCorrect                        | password|
    | takwa.haggui@esprit.tn          | Hajouda123@|
 