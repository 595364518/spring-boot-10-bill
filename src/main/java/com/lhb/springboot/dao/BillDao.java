package com.lhb.springboot.dao;


import com.lhb.springboot.entities.Bill;
import com.lhb.springboot.entities.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.*;

@Repository
public class BillDao {
    Logger logger = LoggerFactory.getLogger(getClass());
    private static Map<Integer, Bill> billMap = null;
    private static Integer initId = 3006;

    @Autowired
    private ProviderDao providerDao;

    static {
        billMap = new HashMap<Integer, Bill>();
//        billMap.put(3001, new Bill(3001, "Bi-AA11", "粮油aaa", "斤", 80,480.8, new Provider(2002, "PR-BB", "北京市粮油总公司", "小李", "18888666982", "深圳软件园", "0911-0123453", "品质B"), 0));
//        billMap.put(3002, new Bill(3002, "Bi-BB11", "粮油bbb", "斤", 90,390.9,new Provider(2001, "PR-AA", "北京市粮油总公司", "小张", "18888666981", "深圳软件园", "0911-0123456", "品质A"), 1));
//        billMap.put(3003, new Bill(3003, "Bi-CC11", "鲜花", "朵", 99,199.9, new Provider(2003, "PR-CC", "邯郸市五得利面粉厂", "小白", "18888666983", "深圳软件园", "0911-0123454", "品质C"), 0));
//        billMap.put(3004, new Bill(3004, "Bi-DD11", "电脑", "台", 10,100000.1, new Provider(2004, "PR-DD", "邯郸市五得利面粉厂", "小梦", "18888666984", "深圳软件园", "0911-0123451", "品质D"), 0));
//        billMap.put(3005, new Bill(3005, "Bi-EE11", "手机", "部", 8,50000.6, new Provider(2005, "PR-EE", "邯郸市五得利面粉厂", "小谷", "18888666985", "深圳软件园", "0911-0123452", "品质E"), 1));

    }


    public void save(Bill bill){
        if(bill.getBid() == null){
            bill.setBid(initId++);
        }
        //添加供应商

        bill.setCreate_date(new Date());
        billMap.put(bill.getBid(), bill);
    }

    public Collection<Bill> getAll(){
        return billMap.values();
    }

    /**
     * 搜索查询
     * @param bill
     * @return
     */
    public Collection<Bill> getAll(Bill bill,Provider provider){
        Collection<Bill> bills = getAll();

        if (!StringUtils.isEmpty(bill.getBill_name())) {
            //
            if (provider.getProviderName() != null) {
                //
                if (bill.getPay() != null) {
                    //
                    int count=0;
                    for (Bill bill1: bills) {
                        if(bill1.getBill_name().toUpperCase().contains(bill.getBill_name().toUpperCase())&&
                           bill1.getPay() == bill.getPay()){
                            count++;
                            bills = count>1?bills:new ArrayList<Bill>();
                            bills.add(bill1);
                        }
                    }
                    if(count==0){
                        bills = new ArrayList<Bill>();
                    }
                }
            }
        }
        return bills;
    }

    public Bill get(Integer id){
        return billMap.get(id);
    }

    public void delete(Integer id){
        billMap.remove(id);
    }
}
