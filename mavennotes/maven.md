Build with package from cmd windows
- mvnw clean install package -Pdev


Print logs on file instead of console while running springboot app from console
- mvnw clean package -Pdev >> log.txt
- mvnw clean package -Pdev > log.txt

Check if the project is valid maven project
- maven validate
- mvnw validate

Troubleshoot
Pom has access issues to artifactory
- copy password from artifactory to settins in .m2 folder under user
Pom has other issues
- Delete .m2 folder and start over


Create effective POM
- mvn help:effective-pom > pom.xml
- mvnw help:effective-pom > pom.xml

Delete target directory
- mvn clean
- mvnw clean

Compile project
- mvn compile
- mvnw compile

Compile Unit test cases

- mvnw compile test
- mvn compile test

Powersehll
- ./mvnw command
- ./mvn command

First clean, then compile then test then create jar/war
- mvnw clean compile test package OR
- mvnw package
