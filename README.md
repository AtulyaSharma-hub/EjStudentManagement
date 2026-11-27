# EjStudentManagement

Project : Student Managment

## Implementation Workflow

The application follows a layered architecture, separating request handling, business logic and database operations.

1. **Application:** Initializes Spring Boot, configures components and establishes the database connection.
2. **Controller:** Handles incoming HTTP requests and returns appropriate REST responses.
3. **Service:** Processes business logic and coordinates application operations.
4. **Repository:** Performs database operations using Spring Data JPA.
5. **Entity:** Maps Java objects to relational database tables using JPA annotations.
6. **Database:** PostgreSQL stores and maintains persistent application records.

**Execution Flow:**

`Client → Controller → Service → Repository → Hibernate/JPA → PostgreSQL`

Responses travel back through the same layers to the client.


Key concepts and learning outcomes :
3	Spring Boot	Auto-configuration, application setup and dependency management.
4	Dependency Injection (DI)	Managing object dependencies using Spring IoC container.
5	Spring Web / REST APIs	Creating REST endpoints using GET, POST, PUT and DELETE.
6	Spring MVC	Request handling using controllers and HTTP methods.
7	PostgreSQL Connectivity	Connecting Spring Boot applications with PostgreSQL.
8	Spring Data JPA	Database operations using repository interfaces and JpaRepository.
9	Hibernate & ORM	Mapping Java objects to relational database tables.
10	Entity Mapping	Using @Entity, @Id and @GeneratedValue.
11	CRUD Operations	Creating, retrieving, updating and deleting database records.
12	Derived Query Methods	Generating database queries through repository method names.
13	Sorting & Pagination	Retrieving sorted and paginated database records.
14	Entity Relationships	Implementing One-to-Many relationships and foreign keys.
15	Cascade & Orphan Removal	Managing dependent entity persistence and deletion.
16	Jakarta Bean Validation	Validating request data using @NotBlank, @Email and @Valid.
17	Exception Handling	Handling invalid requests and appropriate HTTP error responses.
18	Spring Security	Understanding authentication, authorization and endpoint protection.
19	MockMvc Testing	Testing Spring MVC controllers and REST endpoints without starting a real HTTP server.
Instructions for running the Application : 
## Instructions for Running the Application

### Prerequisites

- Java 21 (Eclipse Temurin)
- Eclipse IDE
- Maven
- PostgreSQL

### Step 1: Clone the Repository

```bash
git clone https://github.com/AtulyaSharma-hub/EjStudentManagement 
```

```bash
cd StudentManagement
```

### Step 2: Import into Eclipse

1. Open Eclipse IDE.
2. Import the project folder.

### Step 3: Configure PostgreSQL

- Update the package repositories:

sudo apt update

Install PostgreSQL:

sudo apt install postgresql postgresql-contrib

Verify the installation:

psql --version

Step 3: Start PostgreSQL Server

Start the PostgreSQL service:

sudo service postgresql start

Check its status:

sudo service postgresql status

Step 4: Create the Application Database

Access PostgreSQL using its default superuser:

sudo -u postgres psql

Set the password for the PostgreSQL user:

ALTER USER postgres WITH PASSWORD 'postgres';

Create the application database:

CREATE DATABASE postgres_demo;

List available databases:

\l

Exit the PostgreSQL terminal:

\q

Step 5: Verify Database Connectivity

Connect to the newly created database using the PostgreSQL user:

psql -U postgres -h localhost -p 5432 -d postgres_demo

Enter the configured password when prompted.

If the connection is successful, the PostgreSQL terminal will open.

### Step 4: Run the Application

Open a terminal in the project root directory (where `pom.xml` is located).

Execute:

```bash
mvn clean install
```

Once the build completes successfully, run:

```bash
mvn spring-boot:run
```

Alternatively, open the main application class in Eclipse:

`StudentManagementApplication.java → Run As → Java Application`

### Step 5: Verify Application

Once successfully started, the application runs at:

```text
http://localhost:8080
```

Test the Hello endpoint:

```bash
curl -i http://localhost:8080/hello
```

### Step 6: Run Tests

Execute the following command to run the application's automated tests:

```bash
mvn test
```

This executes the configured JUnit and MockMvc test cases.

### Step 7: Stop the Application

Press `Ctrl + C` in the terminal to stop the running application.
