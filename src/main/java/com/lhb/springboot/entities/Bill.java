package com.lhb.springboot.entities;

import java.util.Date;

/**
 * 帐单实体类
 * @Title: Provider
 * @Description: com.lhb.springboot.entities
 * @Auther: www.stbu.edu.com
 * @Version: 1.0
 */
public class Bill {

    private Integer bid;
    // 账单编码
    private String bill_code;
    // 商品名称
    private String bill_name;
    // 商品单位
    private String bill_com;
    // 商品数量
    private Integer bill_num;
    // 总金额
    private Double money;
    // 供应商
    private Integer pid;
    // 是否付款 0 未付款， 1已付款
    private Integer pay;
    // 创建时间
    private Date create_date;
    public Bill() {}

    public Bill(Integer bid) {
        this.bid = bid;
    }

    public Bill(Integer bid, String bill_code, String bill_name, String bill_com,
                Integer bill_num, Double money, Integer pid, Integer pay, Date create_date) {
        this.bid = bid;
        this.bill_code = bill_code;
        this.bill_name = bill_name;
        this.bill_com = bill_com;
        this.bill_num = bill_num;
        this.money = money;
        this.pid = pid;
        this.pay = pay;
        this.create_date = create_date;
    }

    public Integer getBid() {
        return bid;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "bid=" + bid +
                ", bill_code='" + bill_code + '\'' +
                ", bill_name='" + bill_name + '\'' +
                ", bill_com='" + bill_com + '\'' +
                ", bill_num=" + bill_num +
                ", money=" + money +
                ", pid=" + pid +
                ", pay=" + pay +
                ", create_date=" + create_date +
                '}';
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBill_code() {
        return bill_code;
    }

    public void setBill_code(String bill_code) {
        this.bill_code = bill_code;
    }

    public String getBill_name() {
        return bill_name;
    }

    public void setBill_name(String bill_name) {
        this.bill_name = bill_name;
    }

    public String getBill_com() {
        return bill_com;
    }

    public void setBill_com(String bill_com) {
        this.bill_com = bill_com;
    }

    public Integer getBill_num() {
        return bill_num;
    }

    public void setBill_num(Integer bill_num) {
        this.bill_num = bill_num;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getPay() {
        return pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }
}
