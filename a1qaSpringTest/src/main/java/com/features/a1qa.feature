Feature: Test for A1QA
  Автоматизация тестирования. Тестовое задание
  Разработать автоматический тест на SeleniumWebdriver
  c возможностями запуска на Firefox и Google Chrome

  1) Переход на http://store.steampowered.com/
  2) В меню Games(Игры) выбираем Actions(Экшены):
  3) Переходим на вкладку Specials(Скидки)
  4) Выбираем игру из условия максимальной скидки(только на 1-ой странице, навигация не требуется)
  4.1) В случае появления вопроса о возрасте – заполняем валидными данными и жмем Enter
  5) На странице с описанием игры проверяем корректность цены и скидки. За эталон взять те цифры, что на шаге 4.
  6) Переходим по ссылке Install Steam в верхнем правом углу.
  7) Качаем setup файл (шаг подразумевает ожидание окончания загрузки файла)



  @a1qa
  Scenario: Verify that user can use store.steampowered.com
    Given I open store.steampowered.com
    When I select category "Игры"
    And  I select option " Экшен "
    And  I select section " Скидки "
    Then I should choose game with max sale

    And  Verify visible question about age "Пожалуйста, введите дату вашего рождения:"
    When Set confident
      | ageDay | ageMonth | ageYear |
      | 12 | February | 1987  |
    And I press button " Войти "

    And  Verify price and sale
    And  I select link "Steam"
    Then Save setup file
