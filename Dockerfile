# Use a base image with Java and Tomcat installed
FROM tomcat:10.1.10-jdk17

# Maintainer information
LABEL maintainer="Faycal Raghibi <faycalraghibi24@gmail.com>"

# Remove the default Tomcat applications
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the WAR file from the target directory to the Tomcat webapps directory
COPY target/spring.example-0.0.1-SNAPSHOT.jar /usr/local/tomcat/webapps/app.war
# Expose port 8081
EXPOSE 8081

# Modify the default port Tomcat listens on
RUN sed -i 's/8080/8081/g' /usr/local/tomcat/conf/server.xml

# Start Tomcat
CMD ["catalina.sh", "run"]



