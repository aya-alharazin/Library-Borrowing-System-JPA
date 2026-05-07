# Library Management System (JavaFX + JPA)

A desktop app for managing library borrow records using JavaFX UI and JPA (EclipseLink) with MySQL.

## Tech Stack

- Java 17+
- JavaFX
- JPA 2.2 (EclipseLink provider)
- MySQL 8+

## Project Structure

```text
src/
├── app/
│   └── Main.java
├── config/
│   └── JPAUtil.java
├── controllers/
│   └── BorrowController.java
├── dao/
│   ├── BookDAO.java
│   ├── BorrowDAO.java
│   └── StudentDAO.java
├── models/
│   ├── Book.java
│   ├── Borrow.java
│   └── Student.java
├── views/
│   └── Borrow.fxml
├── styles/
│   └── BorrowFormStyle.css
└── META-INF/
    └── persistence.xml
```

## Core Architecture

- **UI Layer**: `Borrow.fxml` + `BorrowController.java`
- **Data Access Layer**: DAO classes (`BookDAO`, `StudentDAO`, `BorrowDAO`)
- **Persistence Layer**: `JPAUtil` + `persistence.xml`
- **Domain Layer**: JPA entities (`Book`, `Student`, `Borrow`)

The controller handles user actions and delegates DB work to DAO classes.

## Entity Relationships

- `Borrow` has:
  - `@ManyToOne Book book`
  - `@ManyToOne Student student`
- IDs are stored in DB through join columns:
  - `book_id`
  - `student_id`

## Current Features

- View all borrow records
- Borrow a book
- Return a borrowed book
- Delete a borrow record
- Filter currently borrowed books
- Search by selected book ID + student ID

## How EntityManager Is Used

- `EntityManagerFactory` is created once in `JPAUtil` and reused.
- Each DAO method:
  1. creates a new `EntityManager`
  2. executes query/transaction
  3. closes the `EntityManager`
- Write operations use transaction boundaries:
  - `persist()` for insert
  - `merge()` for update/detached entities
  - `remove(merge(entity))` pattern for delete

## Setup

### 1) Configure database connection

Edit `META-INF/persistence.xml`:

```xml
<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/library-system?zeroDateTimeBehavior=CONVERT_TO_NULL"/>
<property name="javax.persistence.jdbc.user" value="root"/>
<property name="javax.persistence.jdbc.password" value=""/>
<property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
```

### 2) Schema generation mode

Current setting:

```xml
<property name="javax.persistence.schema-generation.database.action" value="create"/>
```

`create` recreates tables at startup. For normal usage, switch to:

- `none` (no schema changes), or
- another mode that fits your workflow.

### 3) Add dependencies

Ensure these are on the classpath:

- JavaFX SDK
- MySQL JDBC driver
- EclipseLink JPA libraries (or your IDE-managed JPA provider)

## Run

Run `app/Main.java`.

When the app closes, `Main.stop()` calls `JPAUtil.closeEMF()` to release JPA resources.

## Notes

- `BorrowController` table columns bind to entity getters (`borrowId`, `bookId`, `studentId`, dates, status).
- Quick search buttons use DAO-level JPQL queries.
- This project uses `RESOURCE_LOCAL` transactions (no container-managed transactions).
