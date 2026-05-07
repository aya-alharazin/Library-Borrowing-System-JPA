/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 *
 * @author aya
 */
@Entity
@Table(name = "borrow")
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int     borrowId;
    
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student     student;
    
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book     book;
    @Column(name="borrow_date")
    private LocalDate  borrowDate;   
    @Column(name = "return_date")
    private LocalDate  returnDate;   
    private boolean  status;

    

    public Borrow() {}

    public Borrow(Student student, Book book, 
                  LocalDate borrowDate) {
        this.student  = student;
        this.book     = book;
        this.borrowDate = borrowDate;
    }

    public Borrow(int borrowId, Student student, Book book,
                  LocalDate borrowDate, LocalDate returnDate, boolean status) {
        this.borrowId   = borrowId;
        this.student  = student;
        this.book     = book;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.status     = status;
    }

   

    public int getBorrowId()                      { return borrowId; }
    public void setBorrowId(int borrowId)         { this.borrowId = borrowId; }



    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }


    public boolean getStatus()                     { return status; }
    public void setStatus(boolean status)          { this.status = status; }

   

    @Override
    public String toString() {
        return
               "borrowId="    + borrowId   +
               ", student=" + student  +
               ", book="    + book     +
               ", borrowDate="+ borrowDate +
               ", returnDate="+ returnDate + 
               ", status="    + status +"\n";
             
}

}