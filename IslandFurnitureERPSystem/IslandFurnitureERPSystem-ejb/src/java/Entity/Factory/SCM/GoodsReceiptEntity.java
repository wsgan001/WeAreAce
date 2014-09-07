/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity.Factory.SCM;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author zhangshiyu
 */
@Entity
@Table(name = "GoodsReceipt")
public class GoodsReceiptEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long goodsReceiptId;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createDate;
    
    //goods receipt entity -- purchase order entity : 1 <--> 1
    @OneToOne(cascade = {CascadeType.PERSIST})
    private PurchaseOrderEntity purchaseOder;
    
    //goods receipt entity -- inbound movement enitty: 1 <--> M (from which corresponding goods receipt)
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "goodsReceipt")
    private Collection<InboundMovementEntity> inboundMovements = new ArrayList<InboundMovementEntity>();

    public GoodsReceiptEntity() {
    }

    public GoodsReceiptEntity(Long goodsReceiptId, Date createDate) {
        this.goodsReceiptId = goodsReceiptId;
        this.createDate = createDate;
    }

    public Long getGoodsReceiptId() {
        return goodsReceiptId;
    }

    public void setGoodsReceiptId(Long goodsReceiptId) {
        this.goodsReceiptId = goodsReceiptId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public PurchaseOrderEntity getPurchaseOder() {
        return purchaseOder;
    }

    public void setPurchaseOder(PurchaseOrderEntity purchaseOder) {
        this.purchaseOder = purchaseOder;
    }

    public Collection<InboundMovementEntity> getInboundMovements() {
        return inboundMovements;
    }

    public void setInboundMovements(Collection<InboundMovementEntity> inboundMovements) {
        this.inboundMovements = inboundMovements;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (goodsReceiptId != null ? goodsReceiptId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GoodsReceiptEntity)) {
            return false;
        }
        GoodsReceiptEntity other = (GoodsReceiptEntity) object;
        if ((this.goodsReceiptId == null && other.goodsReceiptId != null) || (this.goodsReceiptId != null && !this.goodsReceiptId.equals(other.goodsReceiptId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Factory.GoodsReceiptEntity[ id=" + goodsReceiptId + " ]";
    }

}
