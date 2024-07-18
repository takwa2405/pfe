@tag
Feature: Récupération du mot de passe pour l'espace étudiant sur ESBonline
@tag1
  Scenario: Récupération du mot de passe oublié
    Given Je suis sur la page d'accueil d'ESBonline
    When Je clique sur "espace etudiant"
    And J'entre un identifiant valide pour l'utilisateur
    And Je clique sur l'étape suivante
    And Je clique sur "Mot de passe oublié"
    And J'entre l'adresse e-mail
    And Je clique sur "Récupérer le Mot de passe"
    Then Je m'attends à ce que l'e-mail de récupération soit envoyé

@tag2
 Scenario: Récupération de mot de passe pour un email invalide

     Given Je suis sur la page d'accueil d'ESBonlineRCM
     @when   And J'entre un identifiant "<identifiantvalide>" valide1 pour l'utilisateur
      And Je clique sur l'étape suivanteRCM
      And L'utilisateur clique sur Mot de passe oublie
       And L'utilisateur entre son adresse e-mailinvalide "<emailinvalide>"
    And  Je clique sur Récupérer mot de passe
      
    Then Un message d'erreur "L'adresse email n'est pas reconnue ou invalide" doit s'afficher

 
    Examples:
    | emailinvalide                   | identifiantvalide |
    | takwa.hagguiesprit.tn          |   191MTB1025        |
    