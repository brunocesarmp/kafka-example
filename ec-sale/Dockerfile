FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD ./target/ec-sale-0.0.1-SNAPSHOT.jar ec-sale.jar
ENTRYPOINT [ "java", "-jar", "/ec-sale.jar" ]