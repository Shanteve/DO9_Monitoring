FROM maven:3.9-eclipse-temurin-8 AS builder

WORKDIR /build
COPY pom.xml ./
RUN mvn dependency:go-offline -B
COPY src/ src/
RUN mvn package -DskipTests -B

FROM arm64v8/eclipse-temurin:8-jre-jammy

RUN groupadd --system appgroup && \
    useradd --system --gid appgroup --home /app --shell /sbin/nologin appuser
WORKDIR /app
COPY --from=builder --chown=appuser:appgroup /build/target/*.jar app.jar
COPY --chmod=755 wait-for-it.sh ./
EXPOSE 8085
USER appuser

CMD ["./wait-for-it.sh", "-t", "60", "postgres:5432", "--", \
    "java", "-jar", "app.jar"]