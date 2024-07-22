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
      | identifiantP |pswP               |linkText     |
      |    34104052     | 34104052          |Espace Parent|

  @tag2
  Scenario Outline: Authentification avec un identifiant incorrect
    Given Je suis sur la page d'accueil d'ESBonline
    When Je clique sur "Espace Parent"
    And Une page d'authentification pour espace Parent s'affiche
    And J'entre un identifiant "<identifiant>" pour l'utilisateur
    And je saisis un mot de passe incorrect "<motdepassecorrect>"
    And je clique sur le bouton de connexion
    Then Un message d'erreur indiquant que l'identifiant est incorrect devrait s'afficher
    
    Examples:
    | identifiant8  | motdepassecorrect |
      | 19100kft01025 | 34104052          |
    