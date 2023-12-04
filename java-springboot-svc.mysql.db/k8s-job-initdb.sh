#!/bin/bash

set -e

scriptPath=$(cd $(dirname "$0") && pwd)

# use MYSQL_PWD env var
mysql -A --default-character-set=utf8mb4 -h$HOST -u$USER < db.sql

# use MYSQL_PWD env var
mysql -A --default-character-set=utf8mb4 -h$HOST -u$USER < user.sql

migrate -source file:///db/migrations -database "mysql://$USER:$MYSQL_PWD@tcp($HOST:3306)/java-springboot-svc" up

DB=java-springboot-svc "$scriptPath"/verify-schema-version.sh
