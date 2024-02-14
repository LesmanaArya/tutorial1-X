FROM docker.io/library/eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /src/advshop
COPY src/main/java/id/ac/ui/cs/advprog/eshop/controller .
RUN ./gradlew clean bootJar

FROM docker.io/library/eclipse-temurin:21-jre-alpine AS runner

ARG USER_NAME=advshop
ARG USER_UID=1000

RUN addgroup -g ${USER_UID} ${USER_NAME} \
    && adduser -h /opt/advshop -D -u ${USER_UID} -G {USER_NAME} ${USER_NAME}

USER ${USER_NAME}
WORKDIR /opt/advshop
COPY --from=builder --chown=${USER_UID}:${USER_UID} /src/advshop/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java"]
CMD ["-jar", "app.jar"]