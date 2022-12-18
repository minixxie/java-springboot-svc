SHELL := /bin/bash

.PHONY: tools
tools:
	sdk install java 19.0.1-amzn && sdk use java 19.0.1-amzn

.PHONY: build
build:
	@source ./.mode.rc ; \
	if [ "$$MODE" == DOCKER ]; then \
		DOCKER_BUILDKIT=1 docker-compose build; \
	elif [ "$$MODE" == K8S ]; then \
		DOCKER_BUILDKIT=1 docker-compose build; \
	else \
		mvn package -Dmaven.test.skip=true; \
	fi

.PHONY: up
up: build down
	@source ./.mode.rc ; \
	if [ "$$MODE" == DOCKER ]; then \
		DOCKER_BUILDKIT=1 docker-compose up -d; \
	elif [ "$$MODE" == K8S ]; then \
		cd k8s/ && kubectl apply -k . && cd -; \
		kubectl -n apps rollout restart deployment demo-svc; \
	else \
		java -jar ./target/demo-latest.jar; \
	fi

.PHONY: down
down:
	@source ./.mode.rc ; \
	if [ "$$MODE" == DOCKER ]; then \
		docker rm -f demo-svc; \
	elif [ "$$MODE" == K8S ]; then \
		cd k8s/ && kubectl delete -k . && cd -; \
	else \
		echo "NOOP"; \
	fi

.PHONY: logs
logs:
	@source ./.mode.rc ; \
	if [ "$$MODE" == DOCKER ]; then \
		docker logs -f demo-svc; \
	elif [ "$$MODE" == K8S ]; then \
		kubectl -n apps logs -f -l appID=demo-svc; \
	else \
		echo "NOOP"; \
	fi

.PHONY: curl
curl:
	curl -v http://127.0.0.1:8080/v1/books

.PHONY: k8s-curl
k8s-curl:
	if [ $$(which minikube) != "" ]; then curl -f -v -H 'Host: demo-svc.local' http://$$(minikube ip)/User/getName; fi

.PHONY: k8s-health
k8s-health:
	if [ $$(which minikube) != "" ]; then curl -f -v -H 'Host: demo-svc.local' http://$$(minikube ip)/actuator; fi
