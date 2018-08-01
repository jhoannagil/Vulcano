#Author: jhegil@bancolombia.com.co

@tag
Feature: Realizar un retiro desde un fondo de inversión a una cuenta de ahorros
  Como usuario de la fiduciaria
  Quiero realizar un retiro desde una cuenta de inversión
  Para disminuir el saldo de la cuenta de inversión

  
  Scenario: Retiro de fondo
    Given que el usuario necesita retirar de un fondo de inversión hacia una cuenta de depositos
    When realiza una solicitud de retiro desde el canal
    Then verifica la disminuci�n del saldo en el fondo de inversión
    And que el saldo de la cuenta de depositos aumente

  