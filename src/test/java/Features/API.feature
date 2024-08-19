Feature: Tester l'API predictTestResult

Scenario: Envoyer les données et vérifier la réponse
    When j'envoie les données à l'API predictTestResult
   And la réponse de l'API doit avoir le statut 200
   Then  je imprime la réponse de l'API
   

