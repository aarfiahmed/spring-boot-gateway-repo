# spring-boot-gateway-repo

# Description
* This project demonstrate the spring boot gateway functionality.

# Project Details

### 1. gateway-api
* **Description:** It is simple API Gateway to route the request to product service or order service<br> based on the route configuration. 
* **Dependency:** This project includes the spring boot gateway dependency.
* **Endpoints:** 
    ````
   Product Service Endpoints
   1. GET:  /api/v1/products
   2. GET:  /api/v1/products/{id}
   3. POST: /api/v1/products  {"id": 2,"name": "mobile", "price": "2000"}
   
  Order Service Endpoints
   4. GET   /api/v1/orders
   5. GET   /api/v1/orders/{id}
   6. POST  /api/v1/orders  {"orderId": 1,"productId": 55, "orderAmount": "1500"}
           
          
* **Route Configuration:** Below configuration used to route the path-
  ````
  spring:
  cloud:
    gateway:
      routes:
        - id: product_service_route
          uri: http://localhost:8181
          predicates:
            - Path=/api/v1/products
          filters:
            - SetPath=/v1/products
        - id: product_service_route
          uri: http://localhost:8181
          predicates:
            - Path=/api/v1/products/{id}
          filters:
            - SetPath=/v1/products/{id}

        - id: order_service_route
          uri: http://localhost:8282
          predicates:
            - Path=/api/v1/orders
          filters:
            - SetPath=/v1/orders
        - id: order_service_route
          uri: http://localhost:8282
          predicates:
            - Path=/api/v1/orders/{id}
          filters:
            - SetPath=/v1/orders/{id}

* **Logging Configuration:** Below configuration enabled logging for spring boot internal to see the route matching information-
  ````
  logging:
  level:
    root: INFO
    org.springframework.cloud.gateway.route.RouteDefinitionLocator: INFO
    org.springframework.cloud.gateway: TRACE
  
### 2. product-service
* **Description:** This service will return the product related information
* **Endpoints:**
   ````
   1. GET:  /api/v1/products
   2. GET:  /api/v1/products/{id}
   3. POST: /api/v1/products  {"id": 2,"name": "mobile", "price": "2000"}


### 3. order-service  
* **Description:** This service will return the order related information
* **Endpoints:**
   ````
   1. GET   /api/v1/orders
   2. GET   /api/v1/orders/{id}
   3. POST  /api/v1/orders  {"orderId": 1,"productId": 55, "orderAmount": "1500"}
      

# Author
* Aarfi Siddique