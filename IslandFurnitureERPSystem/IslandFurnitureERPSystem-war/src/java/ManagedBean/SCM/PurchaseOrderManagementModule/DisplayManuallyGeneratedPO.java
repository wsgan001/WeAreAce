/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean.SCM.PurchaseOrderManagementModule;

import Entity.Factory.SCM.ContractEntity;
import Entity.Factory.SCM.PurchaseOrderEntity;
import Entity.Factory.SCM.SupplierEntity;
import Entity.Store.StoreEntity;
import SessionBean.SCM.PurchaseOrderManagementModuleLocal;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author zhangshiyu
 */
@Named(value = "displayManuallyGeneratedPO")
@ViewScoped
public class DisplayManuallyGeneratedPO implements Serializable {

    @EJB
    private PurchaseOrderManagementModuleLocal pmb;

    private PurchaseOrderEntity purchaseOrder;
    private Long factoryId;
    private Double purchaseAmount;
    private String destination;
    private Calendar deliveryDate;

    private Long itemId;
    private String itemType;

    private String itemName;
    private String unit;
    private ContractEntity contract;
    private Double totalPrice;
    private String destinationAddress;
    private SupplierEntity supplier;
    private StoreEntity store;
    private Long storeId;

    @PostConstruct
    public void init() {
        try {
            System.out.println("DisplayManuallyGeneratedPO:");
            factoryId = (Long) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("departmentId");
            System.out.println("factoryId = " + factoryId);
            //be put @displaySuppliersForManuallyGeneratedPO.displaySuppliers
            itemType = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("itemType");
            System.out.println("itemType = " + itemType);

            //be put @displaySuppliersForManuallyGeneratedPO.displaySuppliers
            itemId = (Long) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("itemId");
            System.out.println("itemId = " + itemId);

            //be put @SelectedSupplierPO
            supplier = (SupplierEntity) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("selectedSupplier");

            contract = pmb.selectSupplier(itemType, itemId, supplier.getSupplierId());
            //be put @displayContractForManuallyGeneratedPO
            purchaseAmount = (Double) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("purchaseAmount");
            //be put @selectedDeliveryDestination, could be null if destination is factory
            store = (StoreEntity) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("selectedStore");
            if (store == null) {
                storeId = null;
            }

            //be put @selectedDeliveryDestination
            destination = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("destination");
            //be put @displayContractForManuallyGeneratedPO
            deliveryDate = (Calendar) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("deliveryDate");

            if (itemType.equals("RawMaterial")) {

                itemName = pmb.getFactoryRM(itemId).getMaterialName();
                unit = pmb.getFactoryRM(itemId).getUnit();

            } else {
                itemName = pmb.getFactoryRP(itemId).getName();
                unit = pmb.getFactoryRM(itemId).getUnit();
            }
            contract = pmb.getContract(contract.getContractId());
            totalPrice = purchaseAmount * contract.getContractPrice();
            System.out.println("Total Price: " + totalPrice.toString());

            this.setTotalPrice(totalPrice);
            System.out.println("destinationAddress = " + destinationAddress);

            if (destination.equals("store") && destination != null) {
                destinationAddress = pmb.getStoreEntity(store.getStoreId()).getAddress();
            } else {
                destinationAddress = pmb.getFactoryEntity(factoryId).getAddress();
                System.out.println("destinationAddress = " + destinationAddress);

            }
        } catch (Exception ex) {
            Logger.getLogger(DisplayManuallyGeneratedPO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public PurchaseOrderEntity getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrderEntity purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public Long getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Long factoryId) {
        this.factoryId = factoryId;
    }

    public Double getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(Double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDeliveryDate() {
        return deliveryDate.getTime();
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate.setTime(null);
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public ContractEntity getContract() {
        return contract;
    }

    public void setContract(ContractEntity contract) {
        this.contract = contract;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public SupplierEntity getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierEntity supplier) {
        this.supplier = supplier;
    }

    public StoreEntity getStore() {
        return store;
    }

    public void setStore(StoreEntity store) {
        this.store = store;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public DisplayManuallyGeneratedPO() {
    }

    public String generatePO() throws Exception {

        System.out.println("factoryId = " + factoryId);
        System.out.println("contractId = " + contract.getContractId());
        System.out.println("purchaseAmount = " + purchaseAmount);
        System.out.println("storeId = " + storeId);
        System.out.println("destination = " + destination);
        System.out.println("deliveryDate = " + deliveryDate);
        try {
            purchaseOrder = pmb.createPurchaseOrder(factoryId, contract.getContractId(),
                    purchaseAmount, storeId, destination, deliveryDate);

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Result: ",
                    "Purchase order [id = " + purchaseOrder.getId() + "] been created!");

            FacesContext.getCurrentInstance().addMessage(null, msg);

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("selectedSupplier");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("purchaseAmount");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("selectedStore");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("destination");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("deliveryDate");

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("po", purchaseOrder);

            return "/secured/restricted/Factory/SCM/PurchaseOrderManagementModule/GetManuallyGeneratedPO?faces-redirect=true";
        } catch (Exception ex) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Result: ",
                    "Purchase order create failed.");
            FacesContext.getCurrentInstance().addMessage(null, msg);

            return "/secured/restricted/Factory/SCM/PurchaseOrderManagementModule/GetManuallyGeneratedPO?faces-redirect=true";
        }

    }
}
