package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class restController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/hello")
    public String hello() {

        return "HELLO";
    }
    @GetMapping(value="/{id}")
    //@RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User show(@PathVariable("id") Integer id) {
        System.out.println("查看id为：" + id + "的user");
        User user = userService.getById(id);
        return user;
    }
    @GetMapping("/list")
    //@RequestMapping("/list")
    public List<User> getList(){
        return userService.list();
    }
    @PostMapping()
    //localhost:8080/user1/?id=2&username=postadd&password=man
    //@PostMapping("/add")
    public void addUser(User user){
        System.out.println("添加"+user.toString());
        userService.addUser(user);
    }

    @PutMapping()
    public void updateUser(User user){
        System.out.println("修改信息"+user.toString());
        userService.updateUser(user);
    }

    //注意加@PathVariable，不然参数不能绑定到变量上
    //@RequestMapping("/delete/{id}")
    @DeleteMapping("/{id}")
    public int deleteUser(@PathVariable("id") Integer id){
        System.out.println("删除用户"+id);
        return userService.deleteUser(id);
    }
}
