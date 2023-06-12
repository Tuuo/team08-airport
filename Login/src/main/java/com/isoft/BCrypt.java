package com.isoft;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
public class BCrypt {
    public static void main(String[] args) {
        // 创建 BCryptPasswordEncoder 对象
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // 将明文密码散列加密成 bcrypt 哈希值
        String password = "123456";
        String hashedPassword = encoder.encode(password);

        // 打印生成的哈希值
        System.out.println(hashedPassword);
    }



    // 生成一个随机的盐值

}
