FROM amazoncorretto:17-alpine
VOLUME /tmp
COPY build/libs/user-manager.jar user-manager.jar
ENV JAVA_OPTS=" -Xshareclasses:name=cacheapp,cacheDir=/cache,nonfatal -XX:+UseContainerSupport -XX:MaxRAMPercentage=70 -Djava.security.egd=file:/dev/./urandom"
USER root
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS  -jar user-manager.jar" ]
