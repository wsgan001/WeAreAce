/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean.CommonInFrastructure;

import Entity.Factory.ProductEntity;
import Entity.Factory.RetailProductEntity;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author dan
 */
@Stateless
public class RetailProduct_ProductManagementModule implements RetailProduct_ProductManagementModuleLocal {

    @PersistenceContext
    private EntityManager em;

    public RetailProduct_ProductManagementModule() {
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void AddProduct(String name, String description, Double price, String unit) {
        System.out.println("RetailProduct_ProductManagementModule: AddProduct(): ");
        ProductEntity pe = new ProductEntity(name, description, price, unit,Boolean.FALSE);
        em.persist(pe);
        em.flush();
    }

    @Override
    public void DeleteProduct(Long productId) {
        System.out.println("RetailProduct_ProductManagementModule: DeleteProduct(): ");
        ProductEntity pe = em.find(ProductEntity.class, productId);
        pe.setDeleteFlag(Boolean.TRUE);
        em.persist(pe);
        em.flush();
        
    }

    @Override
    public void ModifyProduct(Long productId, String name, String description,
            Double price, String unit) {
        System.out.println("RetailProduct_ProductManagementModule: ModifyProduct(): ");
        ProductEntity pe = em.find(ProductEntity.class, productId);
        pe.setName(name);
        pe.setDescription(description);
        pe.setPrice(price);
        pe.setUnit(unit);
        
        em.persist(pe);
        em.flush();
        
    }

    @Override
    public List<ProductEntity> ListProduct() {
        System.out.println("RetailProduct_ProductManagementModule: ListProduct(): ");
        Query q = em.createQuery("SELECT t FROM ProductEntity t");
        List requiredProductList = new ArrayList();
        for(Object o:q.getResultList()){
            ProductEntity u = (ProductEntity) o;          
            if(!u.isDeleteFlag())requiredProductList.add(u);         
        }       
        return requiredProductList;
    }

    //public void SearchProduct(){}
    
    @Override
    public void AddRetailProduct(String name, String description, String unit) {
        System.out.println("RetailProduct_ProductManagementModule: AddRetailProduct(): ");
        RetailProductEntity pe = new RetailProductEntity(name, description, unit, Boolean.FALSE);
        
        em.persist(pe);
        em.flush();
        
    }

    @Override
    public void DeleteRetailProduct(Long retailProductId) {
        System.out.println("RetailProduct_ProductManagementModule: DeleteRetialProduct(): ");
        RetailProductEntity pe = em.find(RetailProductEntity.class, retailProductId);
        pe.setDeleteFlag(Boolean.TRUE);
        
        em.persist(pe);
        em.flush();
    }

    @Override
    public void ModifyRetailProduct(Long retailProductId, String name, String unit,String description) {
        System.out.println("RetailProduct_ProductManagementModule: ModifyRetailProduct(): ");
        RetailProductEntity pe = em.find(RetailProductEntity.class, retailProductId);
        pe.setName(name);
        pe.setDescription(description);
        pe.setUnit(unit);
        
        em.persist(pe);
        em.flush();
        
    }

    @Override
    public List<RetailProductEntity> ListRetailProduct() {
        System.out.println("RetailProduct_ProductManagementModule: ListRetailProduct(): ");
        Query q = em.createQuery("SELECT t FROM RetailProductEntity t");
        List requiredRetailProductList = new ArrayList();
        for(Object o:q.getResultList()){
            RetailProductEntity u = (RetailProductEntity) o;          
            if(!u.isDeleteFlag())requiredRetailProductList.add(u);         
        }       
        return requiredRetailProductList;
    }
    
    //public void SearchRetailProduct(){}

}
