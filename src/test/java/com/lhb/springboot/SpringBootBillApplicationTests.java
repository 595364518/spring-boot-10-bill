package com.lhb.springboot;

import com.lhb.springboot.entities.Bill;
import com.lhb.springboot.entities.BillProvider;
import com.lhb.springboot.entities.Provider;
import com.lhb.springboot.entities.User;
import com.lhb.springboot.mapper.BillMapper;
import com.lhb.springboot.mapper.ProviderMapper;
import com.lhb.springboot.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootBillApplicationTests {

    @Autowired
    ProviderMapper providerMapper;

    @Autowired
    BillMapper billMapper;

    @Autowired
    UserMapper userMapper;

    @Test
    public void userTest(){
        User user = new User();
        user.setUserName("admin");
        user.setUserPassword("123456");
        User user2 = new User();
        User user1 = userMapper.validatedUser(user);
        System.out.println(userMapper.getUsers(user2));
        List<User> users = userMapper.getUsers(user2);
        System.out.println(users);
        for (User u: users) {
            System.out.println(u);
        }
        System.out.println(user1);

        User uerByUid = userMapper.getUerByUid(2);
        System.out.println(uerByUid);
    }
    @Test
    public void billTest(){
        Bill bill = new Bill();
        bill.setBill_name("esc");
        List<BillProvider> bills = billMapper.getBills(bill);
        System.out.println(bills);
        Bill bill1 = new Bill(3);
        BillProvider billByBid = billMapper.getBillByBid(3);
        System.out.println(billByBid);
    }
    @Test
    public void contextLoads() {
        Provider provider = new Provider();
        provider.setProviderName("B货");
        List<Provider> provers = providerMapper.getProviders(provider);
        System.out.println(provers);

        Provider provider1 = providerMapper.getProviderByPid(2);

        System.out.println(provider1);

        providerMapper.deleteProviderByPid(1);

        Provider provider2 = new Provider();
        provider2.setPid(4);
        provider2.setProviderName("二货");
        providerMapper.updateProvider(provider2);

        Provider provider3 = new Provider();
        provider3.setProviderName("李四");
        providerMapper.addProvider(provider3);
    }

}
