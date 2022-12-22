#!/bin/bash

scriptPath=$(cd $(dirname "$0") && pwd)

source "$scriptPath"/../.mode.rc
source "$scriptPath"/config.rc

curl -w "\nHTTP %{http_code} time:%{time_total}s\n" -v \
	-H "Content-Type: application/json; charset=utf-8" \
	-H "X-Request-ID: $(uuidgen | tr [A-Z] [a-z])" \
	-X GET $url/v1/books/$1
