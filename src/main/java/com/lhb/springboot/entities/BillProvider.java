package com.lhb.springboot.entities;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 08:09 2019/11/16
 */
public class BillProvider extends Bill {
    private String providerName;

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
}
