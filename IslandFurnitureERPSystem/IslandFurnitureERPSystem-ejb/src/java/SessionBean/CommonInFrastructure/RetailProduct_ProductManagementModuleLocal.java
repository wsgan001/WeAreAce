/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean.CommonInFrastructure;

import Entity.Factory.BOMEntity;
import Entity.Factory.ProductEntity;
import Entity.Factory.RetailProductEntity;
import Entity.Factory.SetEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dan
 */
@Local
public interface RetailProduct_ProductManagementModuleLocal {

    public List<ProductEntity> ListProduct();

    public Boolean DeleteProduct(Long productId) throws Exception;

    public Boolean DeleteRetailProduct(Long retailProductId) throws Exception;

    public List<RetailProductEntity> ListRetailProduct();

    public void ModifyProduct(Long productId, String name, String description, Double price, Double memberPrice, String unit) throws Exception;

    public void AddProduct(String name, String description, Double price, Double memberPrice, String unit);

    public void ModifyRetailProduct(Long retailProductId, String name, String unit, Double price, String description) throws Exception;

    public void AddRetailProduct(String name, String description, Double price, String unit);

    public List<SetEntity> listSetList();

    public void ModifySet (Long setId, String name, String description, Double price, Double memberPrice);
    
    public Boolean DeleteSet(Long setId);
    
    public SetEntity createSet(String setName, String description);
    
    public SetEntity getSet(Long setId);
    
    public void addItem(Long setId, Long productId);
    
    public void deleteSetProduct(Long setId, Long itemId);

}
