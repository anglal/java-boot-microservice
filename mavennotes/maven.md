Build with package from cmd windows
mvnw clean package -Pdev


Print logs on file instead of console while running springboot app from console
mvnw clean package -Pdev >> log.txt
mvnw clean package -Pdev > log.txt

Check if the project is valid maven project
- maven validate
- mvnw validate

Troubleshoot
Pom has access issues to artifactory
copy password from artifactory to settins in .m2 folder under user


