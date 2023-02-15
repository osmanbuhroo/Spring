FROM openjdk:11 as builder
RUN mkdir -p /app/source
COPY . /app/source
WORKDIR /app/source
RUN chmod +x ./mvnw
RUN ./mvnw clean package

from openjdk:11.0.4-jre-slim-buster
COPY --from=builder /app/source/target/*.jar /app/app.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/app/app.jar"]
