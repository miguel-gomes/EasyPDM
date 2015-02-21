/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.security;

import fr.upem.easypdm.entity.Element;
import fr.upem.easypdm.entity.Organisation;
import fr.upem.easypdm.entity.Users;
import static fr.upem.security.EntityType.BOOK;
import static fr.upem.security.EntityType.CHAPTER;
import static fr.upem.security.EntityType.PARAGRAPH;
import static fr.upem.security.EntityType.TOME;
import static fr.upem.security.Operation.CREATE;
import static fr.upem.security.Operation.DELETE;
import static fr.upem.security.Operation.MODIFY;
import static fr.upem.security.Operation.READ;
import java.util.HashMap;
/**
 *
 * @author Denis
 */
public class RACWriter implements RAC {
    final private static HashMap<EntityType, Permission> permissions;
    
    static {
        permissions = new HashMap<>();
        permissions.put(BOOK, new Permission(BOOK,READ));
        permissions.put(TOME, new Permission(TOME,READ));
        permissions.put(CHAPTER, new Permission(CHAPTER,READ));
        permissions.put(PARAGRAPH, new Permission(PARAGRAPH,READ,MODIFY,CREATE,DELETE));
    }
    
    private Organisation org;
    private Users user;
    
    public RACWriter(Organisation org, Users user) {
        this.org = org;
        this.user = user;
    } 
    
    @Override
    public boolean isPermitOperation(EntityType type, Operation op, Element e) {
        Permission permission = permissions.get(type);
        if(permission == null) {
            return false;
        }
        
        if(!permission.isPermitOperation(op)) {
            return false;
        }
        /* Si op sur un Element et element not null */
        if(e != null && type.isElement()) {
            
            if(org.getId() != e.getOrganisation().getId()) {
                return false;
            }
            
            if(e.isLock()) {
                return false;
            }
            
            switch(op) {
                case DELETE:
                    if(!e.getMaturity().isDeletable()) {
                        return false;
                    }
                    break;
                case READ:
                    if(!e.getMaturity().isReadable()) {
                        return false;
                    }
                    break;
                case MODIFY:
                    if(!e.getMaturity().isWritable()) {
                        return false;
                    }
                    break;
            }
        }
        
        return true;
    }
}
