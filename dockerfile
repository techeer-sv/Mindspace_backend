FROM openjdk:11-jdk

# 컨테이너 내에서 사용할 수 있는 변수 지정
ARG JAR_FILE=./build/libs/*-SNAPSHOT.jar

# 해당 변수를 컨테이너의 app.jar로 복사한다.
COPY ${JAR_FILE} app.jar

EXPOSE 8080

# 컨테이너가 시작되면 스크립트 실행
ENTRYPOINT [ "java", "-jar", "/app.jar" ]