/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author sybille
 */
@Entity
public class Tome extends Element implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String creator;
    private String lastEditor;
    private boolean session;
    private Long workSpaceID;
    private Timestamp editStamp; 

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
     * @param id
     * @param name
     * @param creator
     * @param lastEditor
     * @param session
     * @param workSpaceID
     * @param editStamp
     */
    public Tome(Long id, String name, String creator, String lastEditor, boolean session, Long workSpaceID, Timestamp editStamp) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.lastEditor = lastEditor;
        this.session = session;
        this.workSpaceID = workSpaceID;
        this.editStamp = editStamp;
    }
     
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getCreator() {
        return super.getCreator(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCreator(String creator) {
        super.setCreator(creator); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Timestamp getEditStamp() {
        return super.getEditStamp(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEditStamp(Timestamp editStamp) {
        super.setEditStamp(editStamp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLastEditor() {
        return super.getLastEditor(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLastEditor(String lastEditor) {
        super.setLastEditor(lastEditor); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        return super.getName(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setName(String name) {
        super.setName(name); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long getWorkSpaceID() {
        return super.getWorkSpaceID(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setWorkSpaceID(Long workSpaceID) {
        super.setWorkSpaceID(workSpaceID); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSession(boolean session) {
        super.setSession(session); //To change body of generated methods, choose Tools | Templates.
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public boolean isSession() {
        return super.isSession(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tome)) {
            return false;
        }
        Tome other = (Tome) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.upem.entity.Tome[ id=" + id + " ]";
    }
    
}