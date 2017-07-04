##########################################################
# Dockerfile which builds a simple java 9 restservice
##########################################################
FROM openjdk:9-b161-jre

COPY target/mottak-1.0-SNAPSHOT.jar bin/

EXPOSE 4567

WORKDIR /bin
CMD sh java --permit-illegal-access -jar mottak-1.0-SNAPSHOT.jar
