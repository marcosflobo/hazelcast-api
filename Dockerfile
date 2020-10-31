FROM openjdk:14-alpine
COPY build/libs/hazelcast-api-*-all.jar hazelcast-api.jar
CMD ["java", "-Xmx128m", "-jar", "hazelcast-api.jar"]
