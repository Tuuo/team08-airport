package com.isoft.service;

import com.isoft.entity.Authority;
import com.isoft.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService{
    @Autowired
    private CustomerService customerService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       //通过业务获取用户和权限的信息
        Customer customer = customerService.getCustomer(username);
        List<Authority> authorities = customerService.getCustomerAuthority(username);
        //对用户权限进行封装
        List<SimpleGrantedAuthority> list = authorities.stream().map(authority ->
                        new SimpleGrantedAuthority(authority.getAuthority()))
                .collect(Collectors.toList());
        //返回封装的UserDetails用户信息
        if(customer != null){
            UserDetails userDetails = new User(customer.getUsername(),customer.getPassword(),list);
            return userDetails;
        }else{
            //查询用户不存在，则抛出异常
            throw  new UsernameNotFoundException("该用户不存在");
        }

    }
}
