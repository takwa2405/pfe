@tag
Feature: Authentification pour Espace Etudiant
  
  @tag1
  Scenario: Authentification avec un identifiant désactivé
    Given Je suis sur la page d'accueil d'ESBonline
    When Je clique sur "Espace Etudiants"
    And Une page d'authentification pour espace étudiant s'affiche
   And J'entre un identifiant "<identifiant6>" désactivé pour l'utilisateur
    And Je clique sur l'étape suivante
    And Un message d'erreur indiquant que le compte est désactivé devrait s'afficher
    Then une capture d'écran est générée de l'espace etudiant etudiant avec identifiant disactivé "<nomDefichierDeCapture1>"

    Examples:
      | identifiant6 |nomDefichierDeCapture1 |
      | 231MTB2134   | captureEtudiantdésactivé.png|
                       

  @tag2
  Scenario: Authentification avec un identifiant incorrect
    Given Je suis sur la page d'accueil d'ESBonline
    When Je clique sur "Espace Etudiants"
    And Une page d'authentification pour espace étudiant s'affiche
    And J'entre un identifiant incorrect "<identifiant7>" pour l'utilisateur
    And Je clique sur l'étape suivante
    And Un message d'erreur indiquant que l'identifiant est incorrect devrait s'afficher
    Then une capture d'écran est générée de l'espace etudiant etudiant avec identifiant incorrect "<nomDefichierDeCapture2>"

    Examples:
      | identifiant7  |nomDefichierDeCapture2 |
      | 183JFT0092   |captureEtudiantIncorrect.png|

  @tag3
  Scenario: Authentification avec un identifiant invalide
  Given Je suis sur la page d'accueil d'ESBonline
    When Je clique sur "Espace Etudiants"
    And Une page d'authentification pour espace étudiant s'affiche
    And je saisis un identifiant invalide "<identifiant8>"
    And Je clique sur l'étape suivante
   And Un message d'erreur indiquant que l'identifiant est incorrect devrait s'afficher
   Then une capture d'écran est générée de l'espace etudiant etudiant avec identifiant invalide "<nomDefichierDeCapture3>"

    Examples:
      | identifiant8  |nomDefichierDeCapture3 |
      | 1910001025    |captureEtudiantInvalide.png|

  @tag4
  Scenario: Authentification avec identifiant valide et un mot de passe incorrect
    Given Je suis sur la page d'accueil d'ESBonline
    When Je clique sur "Espace Etudiants"
     And Une page d'authentification pour espace étudiant s'affiche
    And je saisis un identifiant  valide de l'utilisateur "<identifiant9>"
    And Je clique sur l'étape suivante
    And le champ du mot de passe est affiché
    And je saisis un mot de passe incorrect "<motdepasseincorrect>"
   And je clique sur le bouton de connexion   
    And un message d'erreur indiquant que le mot de passe est incorrect est affiché
    Then une capture d'écran est générée de l'espace etudiant etudiant identifiant valide et un mot de passe incorrect "<nomDefichierDeCapture4>"
   

    Examples:
      | identifiant9 | motdepasseincorrect |nomDefichierDeCapture4 |
      | 191MTB1025   | rtyuarbrevert1234  |captureEtudiantMotDePasseInvalide.png|
      

  @tag5
  Scenario: Authentification avec un identifiant vide
    Given Je suis sur la page d'accueil d'ESBonline
    When Je clique sur "Espace Etudiants"
     And Une page d'authentification pour espace étudiant s'affiche
    And Je clique sur l'étape suivante 
    And un message d'erreur indiquant que l'identifiant est requis est affiché
    Then une capture d'écran est générée de l'espace etudiant etudiant identifiant vide "<nomDefichierDeCapture5>"

    Examples:
      | identifiantvide  |nomDefichierDeCapture5 |
      |                  |captureEtudiantIdentifiantVide.png|

  @tag6
  Scenario: Authentification avec un identifiant valide et de mot de passe vide
   Given Je suis sur la page d'accueil d'ESBonline
    When Je clique sur "Espace Etudiants"
     And Une page d'authentification pour espace étudiant s'affiche
    And je saisis un identifiant  valide de l'utilisateur "<identifiant11>"
    And Je clique sur l'étape suivante
    And le champ du mot de passe est affiché
   And je laisse le champ du mot de passe vide "<mdpvide>"
    And je clique sur le bouton de connexion
    Then un message d'erreur indiquant que le mot de passe est requis est affiché

    Examples:
      | identifiant11 | mdpvide |
      | 191MTB1025    |         |


  @tag7
  Scenario: Authentification avec un identifiant et mot de passe valides
    Given Je suis sur la page d'accueil d'ESBonline
    When Je clique sur "Espace Etudiants"
     And Une page d'authentification pour espace étudiant s'affiche
    And je saisis un identifiant  valide de l'utilisateur "<identifiantvalide>"
    And Je clique sur l'étape suivante
    And le champ du mot de passe est affiché
    And je saisis un  mot de passe  valide "<motdepassecorrecte>"
    And je clique sur le bouton de connexion
    And l'utilisateur est redirigé vers son espace étudiant
    And je clique sur le bouton de déconnexion
    Then l'utilisateur est déconnecté et redirigé vers la page de connexion

    Examples:
      | identifiantvalide | motdepassecorrecte |
      | 191MTB1025        | arbrevert1234      |


 

