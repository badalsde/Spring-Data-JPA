# SpringData
Spring Data is a high-level project from Spring whose objective is to unify and ease the access to different types of data access technologies including both SQL and NoSQL databases. It simplifies the data access layer by removing the repository (DAO) implementations entirely from your application. Now, the only artifact that needs to be explicitly defined is the interface. 

Spring Data contains a core project and many sub-projects as shown below:

1. Core Project provides concepts applicable to all Spring Data projects. It contains Spring Data Commons. It contains interfaces which are technology independent and supports commonly used database operations.
2. Sub Projects provide support for most of the data access technologies. Some of the sub projects are as follows:

Sub Project	           
* Spring Data JPA	      -    Provides integration with relational databases using ORM frameworks
* Spring Data MongoDB	  -    Provides integration with MongoDB
* Spring Data REST	    -    Provides functionality to Spring Data repositories as REST services
* Spring Data Redis	    -    Provides repositories for Redis
