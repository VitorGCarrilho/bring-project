FROM tomcat:8.5

LABEL maintainer="vitorg.carrilho@gmail.com"

ENV LANG C.UTF-8

ADD target/*.war /usr/local/tomcat/webapps/bring-project.war