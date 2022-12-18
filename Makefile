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
	mvn checkstyle:check package -Dmaven.test.skip=true -Dcheckstyle.config.location=google_checks.xml

.PHONY: up
up: build
	java -jar ./target/demo-latest.jar

.PHONY: curl
curl:
	curl -v http://127.0.0.1:8080/v1/books

.PHONY: docker-build
docker-build:
	DOCKER_BUILDKIT=1 docker-compose build

.PHONY: k8s-up
k8s-up: docker-build
	cd k8s/ && kubectl apply -k . && cd -
	kubectl -n apps rollout restart deployment demo-svc

.PHONY: k8s-down
k8s-down:
	cd k8s/ && kubectl delete -k . && cd -

.PHONY: k8s-logs
k8s-logs:
	kubectl -n apps logs -f -l appID=demo-svc

.PHONY: k8s-curl
k8s-curl:
	if [ $$(which minikube) != "" ]; then curl -f -v -H 'Host: demo-svc.local' http://$$(minikube ip)/User/getName; fi

.PHONY: k8s-health
k8s-health:
	if [ $$(which minikube) != "" ]; then curl -f -v -H 'Host: demo-svc.local' http://$$(minikube ip)/actuator; fi
