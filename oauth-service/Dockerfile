FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD target/oauth-service-0.1.0.jar app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 1234
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "/configcheck.sh && java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]