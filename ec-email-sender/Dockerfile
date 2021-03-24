FROM openjdk:11
VOLUME /tmp
EXPOSE 8081
ADD ./target/ec-email-sender-0.0.1-SNAPSHOT.jar ec-email-sender.jar
ENTRYPOINT [ "java", "-jar", "/ec-email-sender.jar" ]