Feature: Authentification

 Feature: Authentification

  @tag1
  Scenario Outline: Authentification avec un identifiant avec des espaces au début
    Given Je suis sur la page d'accueil d'ESBonlineP
    When Je clique sur le "<linkText>"
    And Une page d'authentification pour espace Parent s'affiche
    And J'entre un identifiant "<identifiantP>" avec des espaces au début 
    And je saisis un mot de passe correctP "<pswP>"
    And je clique sur le bouton de connexion suivant
    Then l'utilisateur est redirigé vers son espace Parent
    Examples:
      | identifiantP    |pswP               |linkText     |
      |    34104052     | 34104052          |Espace Parent|

  @tag2
  Scenario Outline: Authentification avec un identifiant incorrect
    Given Je suis sur la page d'accueil d'ESBonlineP
      When Je clique sur le "<linkText>"
    And Une page d'authentification pour espace Parent s'affiche
    And J'entre un identifiant incorrectP "<identifiantIncoP>" pour l'utilisateur
     And je saisis un mot de passe correctP "<pswP>"
      And je clique sur le bouton de connexion suivant
    Then  um message d'erreur Erreur du serveur dans l'application 
    
    Examples:
    | identifiantIncoP    | pswP              |
    | 19100kft01025       | 34104052          |
    
    @tag3
  Scenario Outline: Authentification avec identifiant valide et un mot de passe incorrect
     Given Je suis sur la page d'accueil d'ESBonlineP
    When Je clique sur le "<linkText>"
    And Une page d'authentification pour espace Parent s'affiche
       And J'entre un identifiant valide "<identifiantvalideP>"
       And  je saisis un mot de passe incorrectP "<motdepasseincorrectP>"
       And je clique sur le bouton de connexion suivant
    Then  message d'erreur verifier vos parametres
    
    Examples:
      | identifiantvalideP | motdepasseincorrectP |
      | 34104052           | rtyuarbrevert1234   |
    
    
  @tag5
  Scenario Outline: Authentification avec un identifiant vide
     Given Je suis sur la page d'accueil d'ESBonlineP
    When Je clique sur le "<linkText>"
    And Une page d'authentification pour espace Parent s'affiche
    And je saisis un mot de passe correctP2 "<pswP1>"
     And je clique sur le bouton de connexion suivant
    Then un message d'erreur indiquant que cin incorrect
    Examples:
      | identifiantvide | pswP1         |
      |                 | 34104052     |
      
      
 @tag6
  Scenario Outline: Authentification avec un identifiant valide et de mot de passe vide
  Given Je suis sur la page d'accueil d'ESBonlineP
    When Je clique sur le "<linkText>"
    And Une page d'authentification pour espace Parent s'affiche
     And J'entre un identifiant valide "<identifiantvalideP>"
      And je clique sur le bouton de connexion suivant
    Then   message d'erreur verifier vos parametres
    Examples:
      | identifiantvalideP |
      | 34104052           | 
      
 @tag7
  Scenario Outline: Authentification avec un identifiant et mot de passe valides
    Scenario Outline: Authentification des un identifiants valide 
    Given Je suis sur la page d'accueil d'ESBonlineP
    When Je clique sur le "<linkText>"
    And Une page d'authentification pour espace Parent s'affiche
   And J'entre un identifiant valide "<identifiantvalideP>"
    And je saisis un mot de passe correctP "<pswP>"
    And je clique sur le bouton de connexion suivant
    Then l'utilisateur est redirigé vers son espace Parent 
    Examples:
      | identifiantvalideP|pswP               |linkText     |
      |34104052           |34104052           |Espace Parent|
  
         