/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.entity;

import java.sql.Timestamp;
import javax.persistence.Entity;

/**
 *
 * @author sybille
 */
@Entity
public class Tome extends Element {
    private Book book;
    
    /**
     *
     */
    public Tome() {
    }

    /**
     *
     * @param name
     * @param creator
     * @param lastEditor
     * @param session
     * @param workSpaceID
     */
    public Tome(String name, String creator, String lastEditor, boolean session, Long workSpaceID) {
        super(name, creator, lastEditor, session, workSpaceID);
    }

    /**
     *
     * @param name
     * @param creator
     * @param lastEditor
     * @param session
     * @param workSpaceID
     * @param book
     */
    public Tome(String name, String creator, String lastEditor, boolean session, Long workSpaceID, Book book) {
        super(name, creator, lastEditor, session, workSpaceID);
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }    
}
