package com.lhb.springboot.controller;

import com.lhb.springboot.dao.UserDao;
import com.lhb.springboot.entities.User;
import com.lhb.springboot.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 7:38 2019/11/1
 */
@Controller
public class UserController {
    Logger logger = LoggerFactory.getLogger(getClass());
//    @Autowired
//    UserDao userDao ;
//    @GetMapping("/users")
//    public String list(@RequestParam(value = "username",required = false)String username, Map<String,Object> map){
//        if (username != null) {
//            logger.info("按关键字：" + username+ "查询.");
//        }
//        Collection<User> users = userDao.getAll(username);
//        map.put("users",users);
//        map.put("username",username);
//        return "user/list";
//    }
//
//    @GetMapping("/user/{id}")
//    public String info(@RequestParam(value = "type",defaultValue = "view")String type,
//                       @PathVariable(value = "id")Integer id,
//                       Map<String,Object> map){
//        User user = userDao.get(id);
//        map.put("user",user);
//        return "user/" + type;
//    }
//
//    @PutMapping("/user")
//    public String update(User user){
//
//        user.setUser_name(userDao.get(user.getUser_uuid()).getUsername());
//        userDao.save(user);
//        return "redirect:/users";
//    }
//
//    @DeleteMapping("/user/{id}")
//    public String delete(@PathVariable(value = "id",required = false)Integer id){
//        userDao.delete(id);
//        return "redirect:/users";
//    }
//
//    @GetMapping("/user")
//    public String toAddPage(){
//        return "user/add";
//    }
//
//    @PostMapping("/user")
//    public String add(User user){
//
//        userDao.save(user);
//        return "redirect:/users";
//    }
    @Autowired
    UserMapper userMapper;
    @GetMapping("/users")
    public String list(User user,
                       Map<String,Object> map){
        List<User> users = userMapper.getUsers(user);
        map.put("users",users);
        map.put("userName",user.getUserName());
        return "user/list";
    }
    @GetMapping("/user")
    public String toAddPage(){
        return "user/add";
    }

    @PostMapping("/user")
    public String add(@RequestParam(value = "password")String password,User user,
                      Map<String,Object> map){
        if(password.equals(user.getUserPassword())){
            userMapper.addUser(user);
            return "redirect:users";
        }
        map.put("msg","两次密码不一致，请从新输入");
        return "user/add";
    }
    @GetMapping("/user/{userUuid}")
    public String info(@PathVariable(value = "userUuid")Integer userUuid,
                       @RequestParam(value = "type",defaultValue = "view")String type,
                       Map<String,Object> map){
        User uer = userMapper.getUerByUid(userUuid);
        map.put("user",uer);
        return "user/"+type;
    }
    @PutMapping("/user")
    public String update(User user){
        userMapper.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/user/{userUuid}")
    public String delete(@PathVariable(value = "userUuid",required = false)Integer userUuid){
        userMapper.deleteUserByUid(userUuid);
        return "redirect:/users";
    }
}
