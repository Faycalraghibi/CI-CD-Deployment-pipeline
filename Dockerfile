# Use a base image with Java and Tomcat installed
FROM tomcat:9-jre8

# Maintainer information
LABEL maintainer="Faycal Raghibi <faycalraghibi24@gmail.com>"

# Remove the default Tomcat applications
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the WAR file from the target directory to the Tomcat webapps directory
COPY target/your-application.war /usr/local/tomcat/webapps/ROOT.war

# Expose port 8081
EXPOSE 8081

# Modify the default port Tomcat listens on
RUN sed -i 's/8080/8081/g' /usr/local/tomcat/conf/server.xml

# Start Tomcat
CMD ["catalina.sh", "run"]

