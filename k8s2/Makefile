.PHONY: up
up:
	kubectl apply -k .

.PHONY: down
down:
	kubectl delete -k .

.PHONY: ps
ps:
	kubectl -n apps get all -L appID=java-springboot2-svc
