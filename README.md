Репозиторий представляет собой back-end проекта Ams

БД - PostgreSql
В SQl Shell выполняем следующие действия
CREATE USER ams WITH PASSWORD 'ams';
CREATE SCHEMA AUTHORIZATION ams;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA ams TO 'ams';

Полезные ссылки:

Spring Boot upload file to PostgreSQL database
https://frontbackend.com/spring-boot/spring-boot-upload-file-to-postgresql-database
