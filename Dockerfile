FROM amazoncorretto:11

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar","-Dfile.encoding=UTF-8"]
#CMD ["-Dfile.encoding=UTF-8"]