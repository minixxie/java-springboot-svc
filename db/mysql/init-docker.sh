#!/bin/bash

mysqlcli="docker run --rm -t --net=local mysql:8.0.31-oracle mysql -A --default-character-set=utf8 -hmysql-8-0-31 -uroot -phello123"

step0=$(cat 00-db.sql | tr '\012' ' ')
$mysqlcli -e "$step0"
step1=$(cat 01-user.sql | tr '\012' ' ')
$mysqlcli -e "$step1"
step2=$(cat 02-tables.sql | tr '\012' ' ')
$mysqlcli -e "$step2"
step3=$(cat 03-data.sql | tr '\012' ' ')
$mysqlcli -e "$step3"
