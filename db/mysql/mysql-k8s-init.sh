#!/bin/bash

kubectl run mysql-client --rm --tty -i --restart='Never' --image docker.io/bitnami/mysql:8.0.31-debian-11-r10 --namespace db --env MYSQL_ROOT_PASSWORD=$(kubectl get secret --namespace db mysql -o jsonpath="{.data.mysql-root-password}" | base64 -d) --command -- bash -c 'mysql -h mysql.db.svc.cluster.local -uroot -p"$MYSQL_ROOT_PASSWORD" -e ""'
