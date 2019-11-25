package com.lhb.springboot.mapper;

import com.lhb.springboot.entities.Provider;

import java.util.List;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 04:38 2019/11/11
 */
//@Mapper 或 @MapperScan("com.lhb.springboot.mapper.ProviderMapper")
public interface ProviderMapper {

    List<Provider> getProviders(Provider provider);

    Provider getProviderByPid(Integer pid);

    int addProvider(Provider provider);

    int deleteProviderByPid(Integer pid);

    int updateProvider(Provider provider);
}
