# BRING GLOBAL PROJECT

## API DOCUMENTATION

The api documentation (Swagger Ui) can be accessed in the following url:

```
http://localhost:8080/bring-project/swagger-ui.html

```

## FRAMEWORK

Just using spring mvc with xml configuration (spring boot wasn't allowed to this project)

## RUN LOCALLY

You can run locally in the following ways:

### BUILD DOCKER IMAGE

in the project folder run the following commands:

```
mvn install
docker image build -t vitorgcarrilho/bring-project ./
docker container run -it --publish 8080:8080 bringGlobal/bring-project
```

### PULL IMAGE FROM DOCKER HUB

if you prefer you can pull the docker image instead of use maven to build the project 

```
docker pull vitorgcarrilho/bring-project
docker container run -it --publish 8080:8080 bringGlobal/bring-project

```

## TEST COVERAGE

The classes are covered at least 80% (Using jacoco as test coverage plugin).

If you want to see jacoco report just run:

```
mvn clean test
```

then just open the file `index.html` inside the folder `/bring-project/target/site/jacoco/`
