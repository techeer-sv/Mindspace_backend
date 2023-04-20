# Mindspace_backend-

### 백엔드 실행 순서
0. env 파일을 최상위 폴더(build.gradle과 같은 위치)에 넣기
1. `./gradlew clean build` spring boot 빌드
2. `docker-compose up -d --build` docker 띄우기

### databae 접속 순서
0. (다른 방법도 가능!) 띄워진 docker mysql에서 터미널로 접속
1. `mysql -uroot -p`
  1-1. 비밀번호는 env파일에 있어요!
2. `use mindspace;`
3. `select * from 테이블명` //각 테이블에 있는 데이터 확인 가능합니다!
