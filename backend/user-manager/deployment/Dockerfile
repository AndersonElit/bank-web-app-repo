FROM amazoncorretto:17-alpine

# Create a non-root user
RUN adduser -D -g '' appuser

VOLUME /tmp

COPY ../build/libs/user-manager.jar /app/user-manager.jar
COPY ../build/tmp/jar/MANIFEST.MF /app/META-INF/MANIFEST.MF

# Replace with a non-root user
USER appuser

ENTRYPOINT [ "sh", "-c", "java -jar /app/user-manager.jar" ]
