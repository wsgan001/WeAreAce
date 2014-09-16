/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity.Factory;


import Entity.Factory.FactoryBin.FactoryBinStoredProductEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author zhengyuan
 */
@Entity
@Table(name = "FactoryProduct")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class FactoryProductEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long factoryProductId;
    private Double inventory = 0D;
    private Double minimumInventory = 50D;
    private Boolean deleteFlag;
    //inventory record entity -- factory product entity : M <--> 1
    @OneToMany(cascade= {CascadeType.PERSIST},mappedBy="factoryProduct")
    private List<InventoryRecordEntity> record= new ArrayList<>();;
    
    //factory entity -- factory product entity: 1 <--> M 
    @ManyToOne
    private FactoryEntity factory;

    //factory product entity -- factory bin stored product entity: 1 <--> M 
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "factoryProduct")
    private Collection<FactoryBinStoredProductEntity> factoryBinStoredProducts = new ArrayList<>();
    
    //factory product entity -- product entity    M <--> 1
    @ManyToOne
    private ProductEntity product;

    public FactoryProductEntity() {
    }

    public Long getFactoryProductId() {
        return factoryProductId;
    }

    public void setFactoryProductId(Long factoryProductId) {
        this.factoryProductId = factoryProductId;
    }

    public FactoryEntity getFactory() {
        return factory;
    }

    public void setFactory(FactoryEntity factory) {
        this.factory = factory;
    }

    public Collection<FactoryBinStoredProductEntity> getFactoryBinStoredProducts() {
        return factoryBinStoredProducts;
    }

    public void setFactoryBinStoredProducts(Collection<FactoryBinStoredProductEntity> factoryBinStoredProducts) {
        this.factoryBinStoredProducts = factoryBinStoredProducts;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Double getInventory() {
        return inventory;
    }

    public void setInventory(Double inventory) {
        this.inventory = inventory;
    }

    public List<InventoryRecordEntity> getRecord() {
        return record;
    }

    public void setRecord(List<InventoryRecordEntity> record) {
        this.record = record;
    }

    public Double getMinimumInventory() {
        return minimumInventory;
    }

    public void setMinimumInventory(Double minimumInventory) {
        this.minimumInventory = minimumInventory;
    }

    public Boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    
}
