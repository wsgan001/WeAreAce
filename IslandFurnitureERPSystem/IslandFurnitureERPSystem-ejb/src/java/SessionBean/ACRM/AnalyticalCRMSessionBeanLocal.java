/*
 Session Bean for ACRM:
 Functions needs to be fulfilled:
 (Monthly for retail outlets, resturant and Quaterly/Yearly for furniture marketplace)

 1. Personalized Marketing 
 a. Segmentation of customer according to age, gender, natioanlity, member level
 b. send emails to customers 

 2. Customer Analysis
 (based on different segmentations)
 a. Customer Retention Rate
 b. Customer Lifetime Expectancy
 c. CLV ??(how)
 d. CAC of all/segmented cutomers 
 e. Customer reponse rate to vouchers/coupons 

 */
package SessionBean.ACRM;

import Entity.Store.OCRM.MemberEntity;
import java.util.Calendar;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author summer
 */
@Local
public interface AnalyticalCRMSessionBeanLocal {

    public Collection<MemberEntity> getAllMembers() throws Exception;

    public Collection<MemberEntity> getMembersByAge(Integer minAge, Integer maxAge) throws Exception;

    public Collection<MemberEntity> getMembersByGender(String gender) throws Exception;

    public Collection<MemberEntity> getMembersByNationality(String country) throws Exception;

    public Collection<MemberEntity> getMembersByMemberLevel(Integer memberLevel) throws Exception;

    public Collection<MemberEntity> getMembersByAG(Integer minAge, Integer maxAge, String gender) throws Exception;

    public Collection<MemberEntity> getMembersByAC(Integer minAge, Integer maxAge, String country) throws Exception;

    public Collection<MemberEntity> getMembersByAM(Integer minAge, Integer maxAge, Integer memberLevel) throws Exception;

    public Collection<MemberEntity> getMembersByGC(String gender, String country) throws Exception;

    public Collection<MemberEntity> getMembersByGM(String gender, Integer memberLevel) throws Exception;

    public Collection<MemberEntity> getMembersByCM(String country, Integer memberLevel) throws Exception;

    public Collection<MemberEntity> getMembersByAGC(Integer minAge, Integer maxAge, String gender, String country) throws Exception;

    public Collection<MemberEntity> getMembersByAGM(Integer minAge, Integer maxAge, String gender, Integer memberLevel) throws Exception;

    public Collection<MemberEntity> getMembersByACM(Integer minAge, Integer maxAge, String country, Integer memberLevel) throws Exception;

    public Collection<MemberEntity> getMembersByGCM(String gender, String country, Integer memberLevel) throws Exception;

    public Collection<MemberEntity> getMembersByAGCM(Integer minAge, Integer maxAge, String gender,String country, Integer memberLevel) throws Exception;

    public String sendEmailsToSegmentCustomers(Collection<Long> memberIdList) throws Exception;

    public String sendEmailsToAll(Long storeId) throws Exception;

    public Float getRetentionRate(Long storeId, Calendar time, Integer location,
            Boolean isForAllPlace, Boolean isMonthly) throws Exception;

    public Float getRetentionRateByAge(Long storeId, Calendar time, Integer location,
            Boolean isForAllPlace, Boolean isMonthly, Integer minAge, Integer maxAge) throws Exception;

    public Float getRetentionRateByGender(Long storeId, Calendar time, Integer location,
            Boolean isForAllPlace, Boolean isMonthly, String gender) throws Exception;

    public Float getRetentionRateByNationality(Long storeId, Calendar time, Integer location,
            Boolean isForAllPlace, Boolean isMonthly, String country) throws Exception;

    public Float getRetentionRateByMemberLevel(Long storeId, Calendar time, Integer location,
            Boolean isForAllPlace, Boolean isMonthly, Integer memberLevel) throws Exception;

    public Float getCLV(Long storeId, Calendar time, Integer location,
            Boolean isForAllPlace, Double grossProfitMargin, Double aveAcquisitionCost) throws Exception;

    public Float getCACMonthly(Long storeId, Calendar time, Double totalCost) throws Exception;

//    public Collection<MemberEntity> getActiveMembersMonthly(Collection<MemberEntity> memberList, Calendar month, Integer place, Boolean isForAllPlace) throws Exception;
}
