#!/bin/bash

cli="docker run --rm -t --net=local -e PGPASSWORD=hello123 postgis/postgis:15-3.3-alpine psql -hpostgis-15-3-3 -Upostgres"

step0=$(cat 00-db.sql | tr '\012' ' ')
$cli -c "$step0"
#step00=$(cat 00-schema.sql | tr '\012' ' ')
#$cli -c "$step00"

step1=$(cat 01-user.sql | tr '\012' ' ')
$cli -c "$step1"

step2=$(cat 02-tables.sql | tr '\012' ' ')
$cli java-springboot-svc -c "$step2"
step3=$(cat 03-data.sql | tr '\012' ' ')
$cli java-springboot-svc -c "$step3"

