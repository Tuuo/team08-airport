package com.isoft.controller;

import ch.qos.logback.core.joran.conditional.ElseAction;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isoft.entity.Customer;
import com.isoft.repository.CustomerRepository;
import com.isoft.service.CustomerService;
import dm.jdbc.filter.stat.util.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
//@RestController
@Controller
//@RequestMapping("/user")
public class UserController {

    @Autowired
    CustomerService customerService;

    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }


    @RequestMapping("/toLogin")
    public String toLogin() {
        return "userLogin";
    }

    @RequestMapping("/level1/{id}")
    public String level1(@PathVariable("id") Integer id) {
        return "views/level1/" + id;
    }

    @RequestMapping("/level2/{id}")
    public String level2(@PathVariable("id") Integer id) {
        return "views/level2/" + id;
    }

    @RequestMapping("/level3/{id}")
    public String level3(@PathVariable("id") Integer id) {
        return "views/level3/" + id;
    }

    /**
     * 查询页面
     * @return
     */
    @RequestMapping("/APUE")
    public String getAPUE(){
        return "APUE";
    }

    @RequestMapping("/CFUE")
    public String getCFUE(){
        return "CFUE";
    }
    @RequestMapping("/AFID")
    public String getAFID(){
        return "AFID";
    }
    @RequestMapping("/AIRL")
    public String getAIRL(){
        return "AIRL";
    }

    /**
     * 注册
     * @return
     */
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    // 注册接口
    @PostMapping("/register")
    @ResponseBody
    public Map<String, Object> registerUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.println(username);
        System.out.println(password);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        // 将明文密码散列加密成 bcrypt 哈希值
        String hashedPassword = encoder.encode(password);
        Map<String, Object> map = new HashMap<>();
        System.out.println(hashedPassword);
//        System.out.println(customerService.saveUser(username,hashedPassword));
        if (customerService.saveUser(username,hashedPassword)!=null) {
            map.put("code", 200);
            map.put("message", "注册成功");
        } else {
            map.put("code", -1);
            map.put("message", "注册失败");
        }
        return map;
    }


//    @GetMapping("/toLoginU")
//    @ResponseBody
//    public Map<String, Object> login(@RequestParam("username") String username, @RequestParam("password") String password) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        // 将明文密码散列加密成 bcrypt 哈希值
//        String hashedPassword = encoder.encode(password);
//        Map<String, Object> map = new HashMap<>();
//        List<Customer> all = customerService.findAll();
//        for (Customer customer : all) {
//            System.out.println(customer);
//            if (username.equals(customer.getUsername()) && hashedPassword.equals(customer.getPassword())) {
//                map.put("code", 200);
//                map.put("message", "登录成功");
//                System.out.println("登录成功");
//                return map;
//            }
//        }
//        System.out.println("用户名密码错误");
//        map.put("code", -1);
//        map.put("message", "用户名密码错误!");
//        return map;
//    }

}
