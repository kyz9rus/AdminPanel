# Welcome to the AdminPanel project

## Build Setup

Перед запуском приложения необходимо создать базу данных, настройки подключения задаются в файле backend/src/main/resources/application.properties

Все сущности hibernate создаст сам

Следующие команды запускаются в корневой директории (AdminPanel)

Данная команда при необходимости установит node, npm и все 
необходимые для запуска приложения зависимости.
Также произойдет сборка фронтенд части приложения и проигнорируется
запуск тестов
``` bash
mvn clean install -Dmaven.test.skip=true
```
С тестами
``` bash
mvn clean install
```

Команда запуска приложения.
``` bash 
mvn --projects backend spring-boot:run
```

Команда запуска тестов
``` bash
mvn test
```
После запуска приложения рекомендуется запустить sql скрипты из файла backend/src/main/resources/sql-sctipts.sql

При завершении выполнения команды mvn run будет прослушиваться порт 8080. Изменить порт можно в файле frontend/src/http-common.js

Обратите внимание, что в файле application.properties установлен флаг: spring.jpa.hibernate.ddl-auto=create. 
Замените его при надобоности. 