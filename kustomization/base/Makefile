.PHONY: up
up:
	kubectl apply -k .

.PHONY: down
down:
	kubectl delete -k .

.PHONY: ps
ps:
	kubectl -n apps get all -L app=java-springboot-svc
