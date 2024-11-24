Feature: Login functionality

  Scenario: Ingreso de nombre de usuario con datos almacenados en la BD
    Given el usuario se encuentra en la página de login
    When ingresa el nombre de usuario y la contraseña válidos
    Then debe ser redirigido a la página principal
