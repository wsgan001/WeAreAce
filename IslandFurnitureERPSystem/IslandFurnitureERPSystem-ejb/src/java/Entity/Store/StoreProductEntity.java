/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity.Store;

import Entity.Factory.FactoryProductEntity;
import Entity.Factory.ProductEntity;
import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "StoreProduct")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class StoreProductEntity  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeProductId;
    
    //store product entity -- factory product entity: M <--> 1 
    @ManyToOne
    private FactoryProductEntity factoryProduct;
    
    //store product entity -- stores entity: M <--> 1
    @ManyToOne
    private StoreEntity store;
    
    @ManyToOne
    private ProductEntity product;
    
    @OneToMany
    private Collection<ReturnedItemMovementRecordEntity> returnedItemMovementRecords = null;
    private Boolean selfPick;

    public StoreProductEntity() {
    }

    public StoreProductEntity(FactoryProductEntity factoryproduct, StoreEntity store,Boolean selfPick) {
        this.factoryProduct = factoryproduct;
        this.store = store;
        this.selfPick = selfPick;
    }
    

    public Long getStoreProductId() {
        return storeProductId;
    }

    public void setStoreProductId(Long storeProductId) {
        this.storeProductId = storeProductId;
    }

    public FactoryProductEntity getFactoryProduct() {
        return factoryProduct;
    }

    public void setFactoryProduct(FactoryProductEntity factoryProduct) {
        this.factoryProduct = factoryProduct;
    }

    

    public StoreEntity getStore() {
        return store;
    }

    public void setStore(StoreEntity store) {
        this.store = store;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Collection<ReturnedItemMovementRecordEntity> getReturnedItemMovementRecords() {
        return returnedItemMovementRecords;
    }

    public void setReturnedItemMovementRecords(Collection<ReturnedItemMovementRecordEntity> returnedItemMovementRecords) {
        this.returnedItemMovementRecords = returnedItemMovementRecords;
    }

    
    public Boolean getSelfPick() {
        return selfPick;
    }

    public void setSelfPick(Boolean selfPick) {
        this.selfPick = selfPick;
    }

    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (storeProductId != null ? storeProductId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the storeProductId fields are not set
        if (!(object instanceof StoreProductEntity)) {
            return false;
        }
        StoreProductEntity other = (StoreProductEntity) object;
        if ((this.storeProductId == null && other.storeProductId != null) || (this.storeProductId != null && !this.storeProductId.equals(other.storeProductId))) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return "Entity.Store.StoreProductEntity[ id=" + storeProductId + " ]";
    }
    
}
