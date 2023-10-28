#!/bin/bash

scriptPath=$(cd $(dirname "$0") && pwd)

source "$scriptPath"/../.mode.rc
source "$scriptPath"/config.rc

curl -w "\nHTTP %{http_code} time:%{time_total}s\n" -v \
	-X GET $url/actuator/prometheus
