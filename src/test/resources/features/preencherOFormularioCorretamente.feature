Feature: Enviando o Formulario

  Scenario: Corretamente
    Given Dado nome, data e testes
    When Quando sao preenchidos corretamente
    Then Entao validamos


  Scenario: Vazio
    Given Dado nome, data e testes vazios
    When Quando aperta o botao
    Then Entao validamos a mensagem de erro

  Scenario: Com Nome e Data
    Given Dado nome, data corretos e testes vazio
    When Quando sao preenchidos
    Then Entao validamos a mensagem de erro

  Scenario: Com Nome e Teste Area
    Given Dado nome, testes corretos e data vazio
    When Quando sao preenchidos os campos corretos
    Then Entao validamos a mensagem de erro

  Scenario: Com Data e Teste Area
    Given Dado data, testes corretos e nome vazio
    When Quando sao preenchidos os campos validos
    Then Entao validamos a mensagem de erro

  Scenario: Com Apenas Nome
    Given Dado nome correto e testes, data vazios
    When Quando o campo nome e preenchido correto
    Then Entao validamos a mensagem de erro

  Scenario: Com Apenas Data
    Given Dado data correto e testes, nome vazios
    When Quando o campo data e preenchido correto
    Then Entao validamos a mensagem de erro

  Scenario: Com Apenas Teste Area
    Given Dado testes correto e data, nome vazios
    When Quando o campo teste e preenchido correto
    Then Entao validamos a mensagem de erro
