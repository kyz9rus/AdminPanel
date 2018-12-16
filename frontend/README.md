# frontend part

## Build Setup

Перед запуском приложения необходим создать схему базы данных, настройки подключения заданы в файле backend/src/main/resources/application.properties

После создания базы данных рекомендуется запустить sql скрипты из файла backend/src/main/resources/sql-sctipts.sql
``` bash
# Commands run in root directory (AdminPanel)

# After running the command node,  
# npm and all project dependency will be installed.
# Also frontend part of project will build
maven install

# In first, some files from frontend directory will be moved
# to backend part; after that the application will run!
maven --projects backend spring-boot:run

```

После запуска приложения будет прослушиваться порт 8080. Изменить порт можно в файле frontend/src/http-common.js