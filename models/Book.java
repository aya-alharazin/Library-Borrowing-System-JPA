/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author aya
 */
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;
    private String title;

    
    public Book() {}

    public Book(String title ) {
        this.title= title;
    }

    public Book(int bookId, String title) {
        this.bookId= bookId;
        this.title= title;
    }


    public int getBookId()                        { return bookId; }

    public String getTitle()                      { return title; }
    public void setTitle(String title)            { this.title = title; }



    @Override
    public String toString() {
        return "bookId="    + bookId+
               ", title="   + title+"\n";
    }
    
}
