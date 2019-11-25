package com.lhb.springboot.dao;


import com.lhb.springboot.entities.Provider;
import com.lhb.springboot.mapper.ProviderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProviderDao {

    @Autowired
    ProviderMapper providerMapper;
//    private static Map<Integer, Provider> providerMap = null;
//    private static Integer initId = 2006;
//
//    static {
//        providerMap = new HashMap<Integer, Provider>();
//
//        providerMap.put(2001, new Provider(2001, "PR-AA", "北京市粮油总公司", "小张", "18888666981", "深圳软件园", "0911-0123456", "品质A"));
//        providerMap.put(2002, new Provider(2002, "PR-BB", "北京市粮油总公司", "小李", "18888666982", "深圳软件园", "0911-0123453", "品质B"));
//        providerMap.put(2003, new Provider(2003, "PR-CC", "邯郸市五得利面粉厂", "小白", "18888666983", "深圳软件园", "0911-0123454", "品质C"));
//        providerMap.put(2004, new Provider(2004, "PR-DD", "邯郸市五得利面粉厂", "小梦", "18888666984", "深圳软件园", "0911-0123451", "品质D"));
//        providerMap.put(2005, new Provider(2005, "PR-EE", "邯郸市五得利面粉厂", "小谷", "18888666985", "深圳软件园", "0911-0123452", "品质E"));
//
//    }


    public int save(Provider provider) {
        return providerMapper.addProvider(provider);
    }

    public List<Provider> getAll(Provider provider) {

        return providerMapper.getProviders(provider);
    }

//    public Collection<Provider> getAll(String providerName) {
//        Collection<Provider> providers = getAll();
//
//        //不为空
//        if (!StringUtils.isEmpty(providerName)) {
//            int count = 0;
//            for (Provider provider : providers) {
//                //包含则存在
//                if (provider.getProviderName().toUpperCase().contains(providerName.toUpperCase())) {
//                    count++;
//                    //count>1 表示集合至少有一个存在的用户, 否则创建新的集合
//                    providers = count > 1 ? providers : new ArrayList<Provider>();
//                    providers.add(provider);
//                }
//            }
//            //查询不到包含关键字的供应商，则返回空
//            if (count == 0) {
//                providers = new ArrayList<Provider>();
//            }
//        }
//
//        return providers;
//    }

    public Provider getProvider(Integer pid) {
        return providerMapper.getProviderByPid(pid);
    }

    public int delete(Integer pid) {
        return providerMapper.deleteProviderByPid(pid);
    }
    public int update(Provider provider){
        return providerMapper.updateProvider(provider);
    }
}
