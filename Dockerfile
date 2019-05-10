FROM openjdk
LABEL maintainer="choonhow@gmail.com"
#MAINTAINER ChoonHow "choonhow@gmail.com"

ENV DB_DBNAME books
ENV DB_COLLECTION books
ENV DB_HOST localhost

COPY run.sh /run.sh
RUN chmod +x /run.sh

COPY target/customer-0.0.1-SNAPSHOT.jar /bs.jar

CMD ["/run.sh"]

EXPOSE 8080
