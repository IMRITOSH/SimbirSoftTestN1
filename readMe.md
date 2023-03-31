# SimbirSoftTestN1 - это первое задание для SimbirSoft SDET практикум

## Тест-кейс № 01. Создание клиента(Customer)

#### *Предусловие:*

1.	Открыть браузер
2.	Перейти на страницу банк-менеджера: https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager

#### *Шаги:*
1.	Нажать на вкладку Add Customer
2.	На открывшейся вкладке заполнить поля First name, Last name, Post code значением test
3.	Нажать на кнопку Add Customer

#### *Ожидаемый результат:*
1.	Появилось уведомление с сообщением: Customer added successfully with customer id: (id созданного клиента)


## Тест-кейс № 02. Сортировка клиентов по имени (First Name)

#### *Предусловие:*
1.	Открыть браузер
2.	Перейти на страницу банк-менеджера: https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager

#### *Шаги:*
1.	Нажать на вкладку Customers
2.	На открывшейся вкладке кликнуть по полю First name

#### *Ожидание:* 
1.	Данные из столбца First name рассортированы по алфавиту


## Тест-кейс № 03. Поиск клиента

#### *Предусловие:*
1.	Открыть браузер
2.	Перейти на страницу банк-менеджера: https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager
3.	Нажать на вкладку Add Customer
4.	На открывшейся вкладке заполнить поля First name, Last name, Post code значением Imran, Tepsurkarv, E585IB
5.	Нажать на кнопку Add Customer
6.	Нажать на кнопку OK в появившимся окне с сообщением

#### *Шаги:* 
1.	Нажать на вкладку Customers
2.	Заполнить поле Search Customer значением Imran

#### *Ожидание:*
1.	Отобразились данные о клиенте, значение First name которого мы ввели

___

## Структура проекта:

- `pages` - Page Objects используемых страниц
- `tests` - тесты
- `utils` - инициализация Webdriver
- `pom.xml` - конфигурация сборщика Maven
- `webdrivers` - вебдрайверы для браузера

## Тесты
- Добавление клиента
- Сортировка клиентов по имени
- Поиск клиента по имени

## Запуск
- `mvn clean test` (Запуск всех тестов и создание отчетов в allure-results)
- `mvn allure:serve` (Отображение отчетов в отдельном окне браузера)