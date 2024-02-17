#!/bin/bash

set -e
curl -f -v -H 'Host: java-springboot-svc.local' http://127.0.0.1/v1/books
