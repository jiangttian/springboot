package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//使用thymeleaf返回值得是一个模板页面？处理del请求时返回void时，提示没有模板
@Controller
public class thymeController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getList")
    public String getList(ModelMap map) {
        map.addAttribute("users", userService.list());
        return "list";//从resources根目录下找页面
    }

    @RequestMapping("/edit")
    public String edit(ModelMap map, @RequestParam(defaultValue = "0") Integer id) {
        System.out.println("编辑用户id：" + id);
        //isAdd : 向前端页面返回一个是新增与编辑的标识
        if (id > 0) {//更新用户信息
            map.addAttribute("isAdd", false);
            map.addAttribute("user", userService.getById(id));
        } else {//增加用户信息
            map.addAttribute("isAdd", true);
            map.addAttribute("user", new User());
        }
        return "editPage";
    }

    @RequestMapping("/del/{id}")
    public String delete(@PathVariable Integer id) {
        System.out.println("删除用户" + id.toString());
        userService.deleteUser(id);
        return "redirect:/getList";
    }

    //新增和编辑
    @PostMapping("/save")
    public String save(User user) {
        System.out.println("temp save");
        System.out.println(user.toString());
        if (user == null) {
            return "failed: user is null";
        }
        if (user.getId() == null)
            userService.addUser(user);
        else userService.updateUser(user);
        return "redirect:/getList";
    }
}

