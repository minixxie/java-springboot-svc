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

## Spring boot
References:
1. [修改 SpringBoot 默认响应为 utf-8](https://blog.csdn.net/howeres/article/details/124751106)

## SLF4J
References:
1. [使用SLF4J和Logback](https://www.liaoxuefeng.com/wiki/1252599548343744/1264739155914176)
2. [Logging in Spring Boot](https://www.baeldung.com/spring-boot-logging)
3. [Spring Boot Logging with application.yml](https://howtodoinjava.com/spring-boot2/logging/configure-logging-application-yml/)
4. [JSON Logging Best Practices](https://www.loggly.com/use-cases/json-logging-best-practices/)
5. [Disable Spring Boot Banner at Startup](https://www.baeldung.com/spring-boot-disable-banner)
6. [How can I change a key name in the JSON output using Logback?](https://stackoverflow.com/questions/59718108/how-can-i-change-a-key-name-in-the-json-output-using-logback)
7. [Logging to Graylog with Spring Boot](https://www.baeldung.com/graylog-with-spring-boot)
8. [Hibernate: Don’t use show_sql to log SQL queries](https://medium.com/javarevisited/hibernate-dont-use-show-sql-to-log-sql-queries-8698cb3013b9)

## MyBatis
References:
1. [MyBatis with Spring](https://www.baeldung.com/spring-mybatis)
2. [使用IDEA创建SpringBoot+MyBatis+MySql项目实现登录注册功能](https://bbs.huaweicloud.com/blogs/350657)
3. [How to solve "Mapper method has an unsupported return type"](https://stackoverflow.com/questions/66239665/how-to-solve-mapper-method-has-an-unsupported-return-type)

## MyBatis Thymeleaf
References:
1. [MyBatis Thymeleaf User’s Guide](https://mybatis.org/thymeleaf-scripting/user-guide.html)
2. [Quick Start](https://github.com/mybatis/thymeleaf-scripting/wiki/Quick-Start)
3. [java.lang.reflect.InaccessibleObjectException: Unable to make protected final java.lang.Class when upgrade from java 11 to 17](https://stackoverflow.com/questions/68168691/java-lang-reflect-inaccessibleobjectexception-unable-to-make-protected-final-ja)


## Jaeger
References:
1. [opentracing-contrib/java-spring-jaeger](https://github.com/opentracing-contrib/java-spring-jaeger)

## OpenTelemetry
References:
1. [OpenTelemetry Instrumentation for Java](https://github.com/open-telemetry/opentelemetry-java-instrumentation)
2. [logback输出json格式日志（包括mdc）发送到kafka](https://www.cnblogs.com/bigben0123/p//10613257.html)
3. [Using Micrometer to trace your Spring Boot app](https://springbootlearning.medium.com/using-micrometer-to-trace-your-spring-boot-app-1fe6ff9982ae)
4. [Spring Boot 3 Observability with Grafana](https://piotrminkowski.com/2022/11/03/spring-boot-3-observability-with-grafana)
5. [Observability with Spring Boot 3](https://spring.io/blog/2022/10/12/observability-with-spring-boot-3)
