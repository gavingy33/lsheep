FROM jetty:latest

MAINTAINER gavingy33@hotmail.com

ENV JAVA_OPTIONS "-Duser.timezone=Asia/Shanghai"
ENV JETTY_HOME="/var/lib/jetty"
ENV LOGS_DIR=$JETTY_HOME/logs

RUN mkdir $LOGS_DIR

ADD lsheep-sso/lsheep-sso-restful/target/sso-restful.war $JETTY_HOME/webapps/sso-restful.war
ADD lsheep-customer/lsheep-customer-web/target/customer-web.war $JETTY_HOME/webapps/customer-web.war
ADD lsheep-customer/lsheep-customer-restful/target/customer-restful.war $JETTY_HOME/webapps/customer-restful.war

CMD ["/bin/sh", "-c", "java -jar -Xmx256m -Xms256m /usr/local/jetty/start.jar 2>$LOGS_DIR/stdout.log 1>$LOGS_DIR/error.log"]
