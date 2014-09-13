/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity.CommonInfrastructure;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author dan
 */
@Entity
@Table(name="StoreUser")
public class StoreUserEntity extends UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String storeId; //storeId is a string made up of one 'S' and 5 digit number eg.S000001

    public StoreUserEntity() {
    }
    
    
    public StoreUserEntity(String department, String idNumber, Integer userLevel, String lastName, String midName,
            String firstName, String position,  Calendar birthday, String gender, 
            String title, String address, String postalCode, String email, String departmentId, Boolean deleteFlag) {
        super(department,idNumber, userLevel,lastName,midName, firstName, position, 
                birthday,gender,title, address, postalCode, email, deleteFlag);
        storeId = departmentId;
    }

    public void editStoreUserEntity(String department, Integer userLevel, String lastName, String midName,
            String firstName, String position,  Calendar birthday, String gender, 
            String title, String address, String postalCode, String email, String departmentId, Boolean deleteFlag) {
        super.editUserEntity(department, userLevel, lastName, midName, firstName,
                position, birthday, gender, title, address, postalCode, email, deleteFlag);
        storeId = departmentId;
        
    }
    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }
    
    
}
