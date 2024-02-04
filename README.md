https://www.youtube.com/watch?v=Nv2DERaMx-4

(This might not be necessary) Download and install maven to use mvn
https://maven.apache.org/install.html

To use maven in command line, like clean, cd into a quickstart folder, then do 
    `./mvnw clean`
Seems to build successfully but vs code opens a file called cmd.py
When doing maven clean from intellij, click on maven on the right side, look for the correct pom.xml > Lifecycle > clean. This method doesn't open the cmd.py file in vs code.

manual lifecycle phases:
clean - deletes target folder
validate - ?

Lifecycles phases are:
compile - generates target folder and generates bytecode aka .class files
test - runs unit tests and generates generated-test-sources folder in target folder
package - generates jar file
verify - runs checks and integration tests

It will do the phases above the target phase.

To run spring-boot app,
    `./mvnw spring-boot:run`


=============================================
JDBC is for manual sql queries to the database. JPA hibernate is a higher level abstraction.

putting this in application.properties spring.jpa.hibernate.ddl-auto=update will create database schema for us


PUT replaces the whole object in the database while PATCH replaces only parts of the object