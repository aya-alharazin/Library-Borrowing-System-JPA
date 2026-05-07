# 📚 Library Management System

> A JavaFX + JPA (EclipseLink) desktop application for managing book borrowing records with a dark-themed UI.

![Java](https://img.shields.io/badge/Java-17%2B-orange?style=flat-square&logo=java)
![JavaFX](https://img.shields.io/badge/JavaFX-21-blue?style=flat-square)
![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1?style=flat-square&logo=mysql)
![JPA](https://img.shields.io/badge/JPA-EclipseLink-green?style=flat-square)
![License](https://img.shields.io/badge/License-MIT-yellow?style=flat-square)

🎓 **Course:** Advanced Java
👩‍🏫 **Teaching Assistant:** Aya N. Alharazin — IUGaza

---

## Overview

A desktop Library Management System that demonstrates how to build a Java application using **JPA (EclipseLink)** for database access and **JavaFX** for the UI. The project covers the full CRUD cycle using the DAO pattern, JPA entity annotations, JPQL queries, and transaction management — replacing raw JDBC with a cleaner ORM-based approach.

---

## Features

- Add, update, delete, and view borrow records
- Search by book ID and student ID
- Filter currently borrowed books
- Mark books as returned
- Dark-themed JavaFX UI with combo boxes, date pickers, and table view

---

## Tech Stack

| Layer | Technology |
|---|---|
| UI | JavaFX 21, FXML, CSS |
| Persistence | JPA 3.x + EclipseLink |
| Database | MySQL 8.0 |
| Language | Java 17+ |

---

## Project Structure

```text
src/
├── app/            → Main.java
├── config/         → JPAUtil.java (EntityManagerFactory singleton)
├── controllers/    → BorrowController.java
├── dao/            → BookDAO, StudentDAO, BorrowDAO
├── models/         → Book, Student, Borrow (@Entity classes)
├── views/          → Borrow.fxml
├── styles/         → BorrowFormStyle.css
└── META-INF/       → persistence.xml
```

---

## Getting Started

1. **Configure** `src/META-INF/persistence.xml` with your MySQL URL, username, and password.
2. **Create** the `library-system` database in MySQL. EclipseLink will generate the tables automatically.
3. **Add** `eclipselink.jar`, `mysql-connector-j.jar`, and `jakarta.persistence-api.jar` to your classpath.
4. **Run** `app/Main.java`.

---

## Key JPA Concepts Covered

- `@Entity`, `@Id`, `@GeneratedValue`, `@Column`
- `@ManyToOne`, `@JoinColumn` for relationships
- `EntityManagerFactory` and `EntityManager`
- `em.persist()`, `em.merge()`, `em.remove()`, `em.find()`
- JPQL queries
- Manual transaction management

---

## Lecture Video

[![Watch the lecture](https://img.shields.io/badge/YouTube-Watch%20Lecture-red?style=for-the-badge&logo=youtube)](https://youtu.be/qvqxeeke8dg?si=mSMy2p4cIlEaU5JE)


---
## License

Licensed under the MIT License — free to use for learning and educational purposes.
