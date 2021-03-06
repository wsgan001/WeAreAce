/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBean.CommonInFrastructure;

import Entity.Factory.ProductEntity;
import Entity.Factory.RetailProductEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author dan
 */
@Remote
public interface RetailProduct_ProductManagementModuleRemote {

    public List<ProductEntity> ListProduct();

    public Boolean DeleteProduct(Long productId) throws Exception;

    public Boolean DeleteRetailProduct(Long retailProductId) throws Exception;

    public List<RetailProductEntity> ListRetailProduct();

    public void ModifyProduct(Long productId, String name, String description, Double price, Double memberPrice, String unit) throws Exception;
   
    public void AddProduct(String name, String description, Double price, Double memberPrice, String unit);

    public void ModifyRetailProduct(Long retailProductId, String name, String unit, Double price, String description) throws Exception;

    public void AddRetailProduct(String name, String description, Double price, String unit);

    
    
}
