# Тестовое задание к вакансии Java Developer:

## Технологии: 
- среда разработки intellij idea
- сборщик Gradle
- Spring
- Spring Boot 2.0
- Spring Data JPA
- база данных H2
- контейнер сервлетов Tomcat, Jetty
- Junit
- Mockito
- Bootstrap
- Angular 8
- PrimeNG
- TypeScript

## Задания:

1. Сделать 3 сущности «Заказ», «Строка Заказа» и «Товар», которые
сохраняются в базу данных: **Order**(id, client, date, address), **Order_line**(id, order_id, goods_id, count), **Goods**(id, name, price)

2. Реализовать методы:
- добавление нового заказа
- изменение существующего заказа
- удаление заказа
- получение всех заказов
- получение определенного заказа по id
- добавление нового товара
- изменение существующего товара
- удаление товара
- получение всех товаров
- получение определенного товара по id


3. Приложение должно быть разделено по слоям **DAO**, **Service**, **Controller**. Написать тесты для каждого слоя:
- для DAO используется JUnit, Spring, Spring Data JPA и база данных H2
- для Service используется JUnit, Spring, Mockito (не обращается к базе, использует Mock объекты)
- для Controller используется JUnit, Spring (не обращается к Service, использует MockMVC объекты)

4. Реализовать вывод на клиента:
- журнала заказов и справочника товаров в двух вкладках (сделать переключения между
журналами через вкладки)
- возможность добавления, изменения, удаления и редактирования заказа и справочника товаров

# Реализация. Вид приложения:

## Справочник товаров

![Image alt](https://github.com/virtualonee/test-application/blob/main/images/2.png)

## Журнал заказов

![Image alt](https://github.com/virtualonee/test-application/blob/main/images/4.png)

## Заказы клиента

![Image alt](https://github.com/virtualonee/test-application/blob/main/images/6.png)
