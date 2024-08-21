
     @tag
Feature: Récupération du mot de passe et ouverture d'email sur Outlook

  @tag18
 Scenario Outline: Récupération de mot de passe pour un utilisateur et ouverture de l'email sur Outlook
    Given Je suis sur la page d'accueil d'ESBonlineRCM
    When Une page d'authentification pour espace étudiant s'afficheRCM
    And J'entre un identifiant "<identifiantvalide>" valide1 pour l'utilisateur
    And Je clique sur l'étape suivanteRCM
    And L'utilisateur clique sur Mot de passe oublie
    And L'utilisateur entre son adresse e-mail "<email>"
    And Je clique sur Récupérer mot de passe
    Then Un message de confirmation "Un e-mail a été envoyé pour réinitialiser le mot de passe" doit s'afficher
    And Je bascule vers l'onglet Outlook
    Given L'utilisateur est sur la page de connexion Outlook
    When L'utilisateur se connecte avec l'adresse email "<emailCorrect>"
    And L'utilisateur sélectionne le compte professionnel
    And je saisis un mot de passe correct "<password>"
    And L'utilisateur approuve la demande de connexion manuellement
    And L'utilisateur répond à la question rester connecté
   And L'utilisateur ouvre l'email pour la récupération de mot de passe
   And j'attends jusqu'à avoir le message de récupération
   Then une capture d'écran est générée de notre email de récupération avec le nom "<nomDefichierDeCapture>"


    Examples:
      | email                           | identifiantvalide | emailCorrect           | password            |passwordenvoye|nomDefichierDeCapture    |  
      | takwa.haggui@esprit.tn          | 191MTB1025        | takwa.haggui@esprit.tn | Hajouda@haykel123@  |arbrevert1234 |captureDeRecuperation.png|
     
     
     
  @tag19
Scenario Outline: Récupération de mot de passe pour un email invalide

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
       
 
     