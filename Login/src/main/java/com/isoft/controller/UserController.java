package com.isoft.controller;

import ch.qos.logback.core.joran.conditional.ElseAction;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isoft.VerifyCode;
import com.isoft.entity.Customer;
import com.isoft.entity.RespBean;
import com.isoft.repository.CustomerRepository;
import com.isoft.service.CustomerService;
import dm.jdbc.filter.stat.util.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
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
    @RequestMapping("/ARRE")
    public String getARRE(){
        return "ARRE";
    }
    @RequestMapping("/BLLS")
    public String getBLLS(){
        return "BLLS";
    }
    @RequestMapping("/CKLS")
    public String getCKLS(){
        return "CKLS";
    }
    @RequestMapping("/GTLS")
    public String getGTLS(){
        return "GTLS";
    }
    @RequestMapping("/DFDL")
    public String getDFDL(){
        return "DFDL";
    }
    @RequestMapping("/DFIE")
    public String getDFIE(){
        return "DFIE";
    }
    @RequestMapping("/STLS")
    public String getSTLS(){
        return "STLS";
    }
    //l
    @RequestMapping("/BORE")
    public String getBORE(){
        return "BORE";
    }
    @RequestMapping("/CANE")
    public String getCANE(){
        return "CANE";
    }
    @RequestMapping("/CFCE")
    public String getCFCE(){
        return "CFCE";
    }
    @RequestMapping("/CKIE")
    public String getCKIE(){
        return "CKIE";
    }
    @RequestMapping("/CKOE")
    public String getCKOE(){
        return "CKOE";
    }

    //z
    @RequestMapping("/DEPE")
    public String getDEPE(){
        return "DEPE";
    }
    @RequestMapping("/DLYE")
    public String getDLYE(){
        return "DLYE";
    }
    @RequestMapping("/FETT")
    public String getFETT(){
        return "FETT";
    }
    @RequestMapping("/FPTT")
    public String getFPTT(){
        return "FPTT";
    }
    @RequestMapping("/FRTT")
    public String getFRTT(){
        return "FRTT";
    }


    //r
    @RequestMapping("/LBDE")
    public String getLBDE(){ return "LBDE"; }
    @RequestMapping("/ONRE")
    public String getONRE(){
        return "ONRE";
    }
    @RequestMapping("/POKE")
    public String getPOKE(){
        return "POKE";
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

    @GetMapping("/verifyCode")
    public void verifyCode(HttpSession session, HttpServletResponse resp) throws IOException {
        resp.setContentType("image/jpeg");
        VerifyCode code = new VerifyCode();
        BufferedImage image = code.getImage();
        String text = code.getText();
        session.setAttribute("verify_code",text);
        VerifyCode.output(image,resp.getOutputStream());
    }

    @RequestMapping("/checkCode")
    @ResponseBody
    public RespBean checkCode(String code, HttpSession session) {
        // 获取 session 中保存的验证码
        String verify_code = (String) session.getAttribute("verify_code");
        if (verify_code == null || !verify_code.equalsIgnoreCase(code)) {
            // 验证码不正确，返回错误信息
            return RespBean.error("验证码填写错误");
        }
        return RespBean.sucess("登录成功");
    }


}
