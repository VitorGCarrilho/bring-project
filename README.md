# BRING GLOBAL PROJECT

## *API DOCUMENTATION*

The api documentation (Swagger Ui) can be accessed in the following url:

```
http://localhost:8080/bring-project/swagger-ui.html

```

## FRAMEWORK

Just using spring mvc with xml configuration (spring boot wasn't allowed to this project)

## SECURITY

Using spring security with basic auth with an in memory user just for the test (Do not deploy production like this)
user: `user`
password: `password`

## RUN LOCALLY

You can run locally in the following ways:

###### BUILD DEPLOYMENT FILE

You can build the deployment file with the following command: 

```
mvn install
```

then the war file will be in `target` folder, then you just need to add it to tomcat 8.5

###### BUILD DOCKER IMAGE

in the project folder run the following commands:

```
mvn install
docker image build -t bringGlobal/bring-project ./
docker container run -it --publish 8080:8080 bringGlobal/bring-project
```

###### PULL IMAGE FROM DOCKER HUB

if you prefer you can pull the docker image instead of use maven to build the project (https://hub.docker.com/r/vitorgcarrilho/bring-project)

```
docker pull vitorgcarrilho/bring-project
docker container run -it --publish 8080:8080 vitorgcarrilho/bring-project

```

## TEST COVERAGE

The classes are covered at least 80% (Using jacoco as test coverage plugin).

If you want to see jacoco report just run:

```
mvn clean test
```

then just open the file `index.html` inside the folder `/bring-project/target/site/jacoco/`
