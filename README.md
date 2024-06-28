Репозиторий представляет собой back-end проекта Ams

БД - PostgreSql
В SQl Shell выполняем следующие действия
CREATE USER ams WITH PASSWORD 'ams';
CREATE SCHEMA AUTHORIZATION ams;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA ams TO 'ams';
