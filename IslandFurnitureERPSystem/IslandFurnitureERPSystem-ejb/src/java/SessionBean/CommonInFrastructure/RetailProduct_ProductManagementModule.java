/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBean.CommonInFrastructure;

import javax.ejb.Stateful;

/**
 *
 * @author dan
 */
@Stateful
public class RetailProduct_ProductManagementModule implements RetailProduct_ProductManagementModuleLocal {

    public RetailProduct_ProductManagementModule() {
    }
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public void AddProduct() {
    }

    @Override
    public void DeleteProduct() {
    }

    @Override
    public void ModifyProduct() {
    }

    @Override
    public void ListProduct(){}
    
    @Override
    public void AddRetailProduct() {
    }

    @Override
    public void DeleteRetailProduct() {
    }

    @Override
    public void ModifyRetailProduct() {
    }
    
    @Override
    public void ListRetailProduct(){}
    
}