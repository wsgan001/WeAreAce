/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean.CommonInFrastructure;

import Entity.Factory.BOMEntity;
import Entity.Factory.FactoryRawMaterialEntity;
import Entity.Factory.RawMaterialEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author dan zy
 */
@Stateful
public class EnterpriseInventoryManagementModule_RawMaterial implements EnterpriseInventoryManagementModule_RawMaterialLocal, EnterpriseInventoryManagementModule_RawMaterialRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    private EntityManager em;

    public EnterpriseInventoryManagementModule_RawMaterial() {
    }

    @Override
    public void addRawMaterial(String name, String description, String unit) throws Exception {
        System.out.println("EnterpriseInventoryManagementModule_RawMaterial: add Raw Material()");
        if (name.equals("")) {
           System.out.println("Name cannot be empty!");
           throw new Exception("Name cannot be empty!");
        } else {
            RawMaterialEntity rawMaterial = new RawMaterialEntity();
            rawMaterial.setMaterialName(name);
            rawMaterial.setDescription(description);
            rawMaterial.setUnit(unit);
            em.persist(rawMaterial);
            em.flush();
        }
    }

    @Override
    public int deleteRawMaterial(Long rawMaterialId) throws Exception {
        System.out.println("EnterpriseInventoryManagementModule_RawMaterial: delete Raw Material()");
        RawMaterialEntity rawMaterial = em.find(RawMaterialEntity.class, rawMaterialId);
        if (rawMaterial == null) {
            throw new Exception("Raw Material is not found.");
        } else {
            List<BOMEntity> listBom = rawMaterial.getBomList();
            Collection<FactoryRawMaterialEntity> listFactory = rawMaterial.getFactoryRawMaterials();
            Boolean flagBom = true;
            Boolean flagFactory = true;
            if(!listBom.isEmpty()){
                for(BOMEntity b: listBom){
                    if(!b.getIsDeleted()) flagBom = false;
                }
            }
            if(!listFactory.isEmpty()){
                for(FactoryRawMaterialEntity f: listFactory){
                    if(!f.getIsDeleted()) flagFactory = false;
                }
            }
            
            if(flagBom && flagFactory){ 
                rawMaterial.setIsDeleted(Boolean.TRUE);
                em.persist(rawMaterial);
                em.flush();
                return 1;
            }else if(!flagBom) return -1;
            else if(!flagFactory) return -2;
        }
        return 0;
    }

    @Override
    public void modifyRawMaterial(Long rawMaterialId, String name, String description, String unit) throws Exception {
        System.out.println("EnterpriseInventoryManagementModule_RawMaterial: modify Raw Material()");
        RawMaterialEntity rawMaterial = em.find(RawMaterialEntity.class, rawMaterialId);
        if (rawMaterial == null) {
            throw new Exception("Raw Material is not found.");
        } else {
            rawMaterial.setMaterialName(name);
            rawMaterial.setDescription(description);
            rawMaterial.setUnit(unit);
        }

        em.persist(rawMaterial);
    }

    @Override
    public ArrayList<RawMaterialEntity> listRawMaterial() {
        System.out.println("EnterpriseInventoryManagementModule_RawMaterial: list Material()");
        ArrayList<RawMaterialEntity> rmList = new ArrayList<RawMaterialEntity>();
        Query q = em.createQuery("Select rm From RawMaterialEntity rm");
        for (Object o : q.getResultList()) {
            RawMaterialEntity rm = (RawMaterialEntity) o;
            if (!rm.isDeleteFlag()) {
                rmList.add(rm);
            }
        }
        return rmList;
    }

}
