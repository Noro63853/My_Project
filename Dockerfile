FROM maven:3.6.3-openjdk-15
MAINTAINER priotix

WORKDIR /home/app

COPY pom.xml settings.xml /home/app/

COPY src /home/app/src

CMD mvn -f /home/app/pom.xml -s /home/app/settings.xml install
