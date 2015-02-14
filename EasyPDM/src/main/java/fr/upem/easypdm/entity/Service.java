/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author sybille
 */
@Entity
public class Service extends Organisation {
    
    @ManyToOne
    @JoinColumn(name="departement_id")
    private Department department;

    public Service() {
    }

    public Service(Department department) {
        this.department = department;
    }

    public Service(String name, String description) {
        super(name, description);
    }

    public Service(Department department, String name, String description) {
        super(name, description);
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
