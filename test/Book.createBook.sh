#!/bin/bash

function uuid()
{
	id=$(uuidgen | tr [A-Z] [a-z])
	echo $id;
}

source ../.mode.rc
source ./config.rc

postData=$(cat<<EOF
{
	"id": 8899,
	"isbn": "$(uuid)",
	"title": "This is a book title $(uuid)"
}
EOF
)

curl -w "\nHTTP %{http_code} time:%{time_total}s\n" -v \
	-H "Content-Type: application/json; charset=utf-8" \
	-H "X-Request-ID: $(uuidgen | tr [A-Z] [a-z])" \
	-d "$postData" \
	-X POST $url/v1/books
