# Java Springboot

This is to record what need to be done on top of a freshly generated Springboot project, in order to:
1. Be able to use Makefile to make the commands easier
2. Be able to use Dockerfile to use docker build and run
3. Be able to use yaml to deploy the application into k8s cluster (with kustomize)
4. Have a simple RESTful endpoint to return a string as an example


For what can be done with this sample project, just check `Makefile`:
1. build the application with docker, with JDK (you'll need to install JDK in advance with `make tools`):
```BASH
make build
```

2. run the application after building:
```BASH
make up
```

3. test by calling one endpoint:
```BASH
make curl
```

Or the above can be done in docker and k8s:
1. build the application with docker:
```BASH
make docker-build
```

2. deploy the application into k8s:
```BASH
make k8s-up
```

3. test by calling one endpoint:
```BASH
make k8s-curl
```