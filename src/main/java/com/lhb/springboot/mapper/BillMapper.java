package com.lhb.springboot.mapper;

import com.lhb.springboot.entities.Bill;
import com.lhb.springboot.entities.BillProvider;

import java.util.List;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 04:38 2019/11/11
 */
//@Mapper 或 @MapperScan("com.lhb.springboot.mapper.ProviderMapper")
public interface BillMapper {

    List<BillProvider> getBills(Bill bill);

    BillProvider getBillByBid(Integer bid);

    int addBill(Bill bill);

    int updateBill(Bill bill);

    int deleteBillByBid(Integer bid);
}
