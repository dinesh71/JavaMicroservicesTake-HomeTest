# JavaMicroservicesTake-HomeTest


1. Install Java 17 maven 3 Docker
2. Build:  mvn clean install
3. Run posgres &kafka:  docker-compose up -d
4. Run order Service: mvn spring-boot:run
http://localhost:8080/swagger-ui/index.html#/Orders/createOrder
5. Run Payment Service
mvn spring-boot:run
http://localhost:8081/swagger-ui/index.html#/Payments/fetchOrders
6. Run Notify Service
mvn spring-boot:run
http://localhost:8082/swagger-ui/index.html#/Orders/fetchNotifications