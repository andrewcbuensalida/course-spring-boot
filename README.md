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


## JDBCTemplate is for manual sql queries to the database, like in 7_databases_sql > 9_dao_delete. This needs a schema.sql in the resources folder. Note that this is different from spring data jdbc.

## JPA hibernate by extending CrudRepository, like in 11_deployment, is a higher level abstraction.

putting this in application.properties spring.jpa.hibernate.ddl-auto=update will create database schema for us

PUT replaces the whole object in the database while PATCH replaces only parts of the object

##
H2 database is an in-memory database for testing purposes

## 
In order for Explorer > Maven > 11_deployment > lifecycles > test to work, command prompt in IDE has to have the correct jdk version. To check the version, 
`mvn --version`
And also check the local mvn with
`"c:\swe\code\course-spring-boot\11_deployment\mvnw.cmd" --version`
Sometimes you have to close all the vs code windows if you recently changed your environment variables JAVA_HOME path.
If you want to temporarily set the environment variable in that specific terminal, 
`set JAVA_HOME=C:\Program Files\Java\jdk-17`
To check the environment variable,
`echo %JAVA_HOME%`
or
`mvn --version`
The error when the jdk version in the app is 17 but the maven compiler version is 21 is:
`[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.8.1:compile (default-compile) on project api: Fatal error compiling: java.lang.NoSuchFieldError: Class com.sun.tools.javac.tree.JCTree$JCImport does not have member field 'com.sun.tools.javac.tree.JCTree qualid' -> [Help 1]`
The error when the jdk version in the app is 21 but the maven compiler version is 17 is something like:
`version 21 not compatible`


## 
When running, was getting this error:
`Error: Could not find or load main class org.apache.maven.wrapper.MavenWrapperMain`

So went in each app's folder and ran this:
`mvn -N io.takari:maven:wrapper`
This created a .mvn folder