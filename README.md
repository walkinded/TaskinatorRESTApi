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

# Что не молучилось (по причине неопытности или сложности)
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

# DataBase:
-- phpMyAdmin SQL Dump
-- version 4.9.7
-- https://www.phpmyadmin.net/
--
-- Хост: localhost:8889
-- Время создания: Мар 22 2021 г., 19:11
-- Версия сервера: 5.7.32
-- Версия PHP: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- База данных: `taskinator_db`
--

-- --------------------------------------------------------

--
-- Структура таблицы `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(4);

-- --------------------------------------------------------

--
-- Структура таблицы `priority`
--

CREATE TABLE `priority` (
  `priority_id` bigint(20) NOT NULL,
  `task_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `priority`
--

INSERT INTO `priority` (`priority_id`, `task_id`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `priority_task`
--

CREATE TABLE `priority_task` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `priority_task`
--

INSERT INTO `priority_task` (`id`, `name`) VALUES
(1, 'LOW'),
(2, 'MEDIUM'),
(3, 'HARD');

-- --------------------------------------------------------

--
-- Структура таблицы `projects`
--

CREATE TABLE `projects` (
  `id` bigint(20) NOT NULL,
  `created` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `updated` datetime(6) DEFAULT NULL,
  `task_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `projects`
--

INSERT INTO `projects` (`id`, `created`, `description`, `title`, `updated`, `task_id`, `user_id`, `end_date`, `start_date`) VALUES
(1, '2021-03-22 16:56:24.000000', 'TEst for test', 'TEST', NULL, 1, 1, NULL, NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'USER'),
(2, 'ADMIN'),
(3, 'MANAGER');

-- --------------------------------------------------------

--
-- Структура таблицы `tasks`
--

CREATE TABLE `tasks` (
  `id` bigint(20) NOT NULL,
  `created` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `updated` datetime(6) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `tasks`
--

INSERT INTO `tasks` (`id`, `created`, `description`, `title`, `updated`, `user_id`, `end_date`, `start_date`, `name`) VALUES
(1, '2021-03-22 17:22:23.000000', 'Test task', 'TASK', NULL, 1, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `created` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `updated` datetime(6) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`id`, `created`, `email`, `lastname`, `name`, `password`, `updated`, `username`) VALUES
(1, '2021-03-22 15:51:20.000000', 'user1@gmail.com', 'Turcov', 'Ron', '12345', NULL, 'TomTur'),
(2, '2021-03-22 18:51:25.000000', 'User2@gmail.com', 'Ronald', 'John', '12345', NULL, 'JohnR');

-- --------------------------------------------------------

--
-- Структура таблицы `user_roles`
--

CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `user_roles`
--

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 1);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `priority`
--
ALTER TABLE `priority`
  ADD PRIMARY KEY (`priority_id`,`task_id`),
  ADD KEY `FK1e16nvje4ofkn2l005rfdu7kw` (`task_id`);

--
-- Индексы таблицы `priority_task`
--
ALTER TABLE `priority_task`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `projects`
--
ALTER TABLE `projects`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKlf6h7tpalmyjv3mhmki0kfv8a` (`task_id`),
  ADD KEY `FKhswfwa3ga88vxv1pmboss6jhm` (`user_id`);

--
-- Индексы таблицы `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `tasks`
--
ALTER TABLE `tasks`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6s1ob9k4ihi75xbxe2w0ylsdh` (`user_id`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `user_roles`
--
ALTER TABLE `user_roles`
  ADD KEY `FKrhfovtciq1l558cw6udg0h0d3` (`role_id`),
  ADD KEY `FKhfh9dx7w3ubf1co1vdev94g3f` (`user_id`);

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `priority`
--
ALTER TABLE `priority`
  ADD CONSTRAINT `FK16s39s2jnnwql81ls1q8gc0gr` FOREIGN KEY (`priority_id`) REFERENCES `tasks` (`id`),
  ADD CONSTRAINT `FK1e16nvje4ofkn2l005rfdu7kw` FOREIGN KEY (`task_id`) REFERENCES `priority_task` (`id`),
  ADD CONSTRAINT `FKlgge2iinjs19vudlarabwqc29` FOREIGN KEY (`priority_id`) REFERENCES `priority_task` (`id`),
  ADD CONSTRAINT `FKo6m19iykec6vmwrcccgin1rie` FOREIGN KEY (`task_id`) REFERENCES `tasks` (`id`),
  ADD CONSTRAINT `FKos5m68mfx304qj6f2kognmgec` FOREIGN KEY (`task_id`) REFERENCES `users` (`id`);

--
-- Ограничения внешнего ключа таблицы `projects`
--
ALTER TABLE `projects`
  ADD CONSTRAINT `FKhswfwa3ga88vxv1pmboss6jhm` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKlf6h7tpalmyjv3mhmki0kfv8a` FOREIGN KEY (`task_id`) REFERENCES `tasks` (`id`),
  ADD CONSTRAINT `FKsn4jg73bb8dut3etrfw0vwuhc` FOREIGN KEY (`task_id`) REFERENCES `projects` (`id`);

--
-- Ограничения внешнего ключа таблицы `tasks`
--
ALTER TABLE `tasks`
  ADD CONSTRAINT `FK6s1ob9k4ihi75xbxe2w0ylsdh` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Ограничения внешнего ключа таблицы `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKrhfovtciq1l558cw6udg0h0d3` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);

