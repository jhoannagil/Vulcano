#Author: jhegil@bancolombia.com.co

@tag
Feature: Realizar adición desde una cuenta de ahorros a un fondo de inversi�n
  Como usuario de la fiduciaria
  Quiero realizar una adición a una cuenta de inversión
  Para incrementar el saldo de la cuenta de inversión

  @exitoso
  Scenario: Adicion a fondo
    Given que el usuario necesita adicionar a un fondo de inversión desde una cuenta de depositos
    When realiza una solicitud de adición desde el canal 
    And Ingresa los datos necesarios
   
    |tipId |nroId          |tipCta |nroCta     |fondo |nroEnc       |valor          |equipo |usuario |fecha   |sistemaOrigen |idJob |claveTef |comision          |plazo |indDeb |tipIdTr |numIdTr |clvTefDB |indMovDep |valorGMF       |tipCtaPte |nunmeroCuentaPuente  |
    |3     |000000007012400|1      |40612400028|085   |1010000000009|000000012200000| 1     | 1      |20180117|SVE           |123   |123456   |00000000000000000 |30    |1      |1       |15      |10       |1         |000000000000000|7         |40672400080          |    
  
    Then verifica el aumento del saldo en el fondo de inversión
    #And que el saldo de la cuenta de depositos disminuya
    
    
  

 