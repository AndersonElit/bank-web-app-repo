
#build image
#
#docker build -t users-api:latest -f deployment/Dockerfile .
#
#run container
#docker run -i --rm -p 8080:8080 users-api:latest

FROM amazoncorretto:17-alpine
VOLUME /tmp
COPY ../applications/app-service/build/libs/user-manager.jar app.jar
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=70 -Djava.security.egd=file:/dev/./urandom"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS  -jar user-manager.jar" ]
