/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.entity;

import java.util.Set;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author sybille
 */
@Entity
public class Enterprise extends Organisation {

    @OneToMany(cascade=ALL, mappedBy="enterprise")
    Set<Department> departments;

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }
    
    public Enterprise() {
    }

    public Enterprise(String name, String description) {
        super(name, description);
    }    
}