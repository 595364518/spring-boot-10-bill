package com.lhb.springboot.mapper;

import com.lhb.springboot.entities.Bill;
import com.lhb.springboot.entities.BillProvider;
import com.lhb.springboot.entities.User;

import java.util.List;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 04:38 2019/11/11
 */
//@Mapper 或 @MapperScan("com.lhb.springboot.mapper.ProviderMapper")
public interface UserMapper {

    List<User> getUsers(User user);

    User getUerByUid(Integer userUuid);

    User validatedUser(User user);

    int addUser(User user);

    int updateUser(User user);

    int deleteUserByUid(Integer userUuid);
}
