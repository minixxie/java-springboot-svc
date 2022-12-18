SHELL := /bin/bash

.PHONY: tools
tools:
	sdk install java 19.0.1-amzn && sdk use java 19.0.1-amzn

.PHONY: lint
lint:
	#mvn checkstyle:checkstyle
	# Use google_checks.xml from here and set severity=error: https://github.com/checkstyle/checkstyle/blob/checkstyle-9.3/src/main/resources/google_checks.xml
	@echo "Check details here: https://checkstyle.sourceforge.io/config_javadoc.html"
	mvn checkstyle:check -Dcheckstyle.config.location=google_checks.xml

.PHONY: build
build:
	@source ./.mode.rc ; \
	if [ "$$MODE" == DOCKER ]; then \
		DOCKER_BUILDKIT=1 docker-compose build; \
	elif [ "$$MODE" == K8S ]; then \
		DOCKER_BUILDKIT=1 docker-compose build; \
	else \
		mvn checkstyle:check package -Dmaven.test.skip=true -Dcheckstyle.config.location=google_checks.xml; \
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
