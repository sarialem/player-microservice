# player-microservice
A Spring based REST API that exposes 2 endpoints to read player data, it import this data from the [player.csv](src/main/resources/static/Player.csv) file after startup.

Exposed Endpoints:
- **GET** Single Player by ID: http://localhost:8080/api/v1/players/{id}
- **GET** All Players: http://localhost:8080/api/v1/players, with the following query params for pagination:
  - `size`: **default**=`20`, **maximum**=`100`, the size of the results returned in a single page. 
  - `page`: **default**=`0` the page number, zero indexed.

You can check out and try the API using it's exposed swagger ui on the following url:
http://localhost:8080/swagger-ui.html

# Running the service
## Requirements
you can run it using docker-compose, so you need that:
- docker with docker-compose installed
- Port 8080 to available and not used by anything else
## Running it
In the project's root directory, Build then run using docker-compose:
```bash
docker-compose build
docker-compose up
```
The service should be running on port 8080

# Running the tests
## Requirements
- JDK19
## Running them
If you are using linux/mac, In the root of the project run:
```bash
./gradlew test
```

If you are using windows,In the root of the project run:
```bash
gradlew.bat test
```

# How does it work
- Built using the Spring Boot framework
- On Startup, it uses Spring Batch to run a batch job that imports the file `Players.csv` into an in-memory database
- Using Spring Rest, it exposes the two endpoints mentions above
- Uses springdoc's openapi library to expose OpenAPI spec along with Swagger UI