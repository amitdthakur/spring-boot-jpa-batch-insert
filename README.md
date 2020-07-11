# Spring-boot-jpa-Hibernate-batch-insert

Implementation of JPA Hibernate batch insert with Hikari data source connection pool.

This project consist logic to insert multiple employee objects using batch batch insert way.

Composite key for the entity is implemented with the help of @IdClass

* Added spot bugs,checkstyle and owsap plugin.
* Added profile yaml file.To activate the profile add system property based on env -Dspring.active.profile=dev 

### How to import

*  Clone the repository .
*  Import this project as maven project to start working.

### How to run

*  Type `mvn clean package`.
*  Go to target folder and type `java -Dspring.profiles.active -jar jarfileName`.

## Note
Please replace the data base details in yml file.


## Credits
Sam
Amit(thakuramitcomp@gmail.com)

