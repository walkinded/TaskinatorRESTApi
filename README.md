# TaskinatorRESTApi
Задача Taskinator: реализовать RestApi запросы

Taskinator - это платформа для управления проектами. В ней есть все основные инструменты для совместной работы нескольких людей: список задач, приоритеты задач, удобная канва (аля Trello), личный кабинет пользователя (с возможностью регистрации), система ролей

# Что я использовал:
1. Java 8
2. Gradle
3. Spring Boot 2.4.4
4. String Web
5. Spring Security
6. Spring Data JPA
7. Spring Boot DevTools
8. Lombok
9. MySQL Driver
10. MapStruct

# Что не получилось (по причине неопытности или сложности)
1. Управление проектами
  - Удалить участника из проекта

2. Управление задачами
  - Убрать участника из задачи
  - Назначать участника на задачу (выбор исполнителя задач, только из списка участников текущего проекта)

3. Управление клиентами
  - Просмотреть задачи и проекты клиента

# URLs:
User:
  - /api/user/all              - все пользователи
  - /api/user/{id}             - пользователь по id
  - /api/user/new              - создать пользоватетя
  - /api/user/{id}/remove      - удалить по id
  - /api/user/edit/{id}        - изменить по id

Project:
  - /api/project/all           - все проекты
  - /api/project/{id}          - проект по id
  - /api/project/new           - создать проект
  - /api/project/{id}/remove   - удалить по id
  - /api/project/edit/{id}     - изменить по id

Task:
  - /api/task/all              - все проекты
  - /api/task/{id}             - проект по id
  - /api/task/new              - создать проект
  - /api/task/{id}/remove      - удалить по id
  - /api/task/edit/{id}        - изменить по id

# Права:
ADMIN: Admin/admin

USER: User/password

# DataBase
Файл прикреплен к общему проекту под названием "taskinator_db.sql"
