FROM eclipse-temurin:19.0.1_10-jdk as jdk

RUN cd /usr/local \
	&& wget https://dlcdn.apache.org/maven/maven-3/3.9.4/binaries/apache-maven-3.9.4-bin.tar.gz \
	&& tar xzf apache-maven-3.9.4-bin.tar.gz \
	&& ln -sf /usr/local/apache-maven-3.9.4/bin/mvn /usr/local/bin/mvn \
	&& rm -rf /usr/local/apache-maven-3.9.4-bin.tar.gz

ARG APP_NAME

WORKDIR /app

ADD pom.xml .
#RUN --mount=type=cache,target=/root/.m2 mvn dependency:go-offline

ADD . .
RUN --mount=type=cache,target=/root/.m2 mvn checkstyle:check package -Dmaven.test.skip=true -Dcheckstyle.config.location=google_checks.xml
#RUN mvn package -Dmaven.test.skip=true

FROM eclipse-temurin:19.0.1_10-jre

ARG APP_NAME
ENV APP_NAME=${APP_NAME}

COPY --from=jdk /app/target/demo-latest.jar /app.jar
ADD ./src/main/resources/application.localdocker.yml /config/application.localdocker.yml
ADD ./src/main/resources/application.yml /config/application.local.yml

ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar /opentelemetry-javaagent.jar

COPY        --from=wtfcoderz/static-healthcheck /healthcheck /
HEALTHCHECK --interval=5s --timeout=2s --start-period=30s --retries=2 CMD ["/healthcheck", "-http", "http://127.0.0.1:8080/actuator/health"]
# HTTP port
EXPOSE 8080
# xxl-job HTTP port
EXPOSE 9999
