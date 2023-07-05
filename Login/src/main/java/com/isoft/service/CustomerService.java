package com.isoft.service;

import com.isoft.entity.Authority;
import com.isoft.entity.Customer;
import com.isoft.repository.AuthorityRepository;
import com.isoft.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

//通过用户的用户名查询用户信息以及权限信息
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    private RedisTemplate redisTemplate;


    //  使用用户名查询用户信息
    public Customer getCustomer(String username){

        //尝试从缓存中获取用户信息，如果缓存中不存在，则从数据库中查询用户信息，并将查询结果存储到缓存中
        Customer customer = null;
        Object obj = redisTemplate.opsForValue().get("customer_" + username);
        if (obj != null){
            customer = (Customer) obj;
        }else {
            customer = customerRepository.findByUsername(username);
            if(customer!=null){
                redisTemplate.opsForValue().set("customer_"+username,customer);
            }
        }
        return customer;
    }

    //保存用户信息，接收用户名和密码作为参数，并调用customerRepository的saveUser方法保存用户信息。
    public Integer saveUser(String username,String password){
        customerRepository.saveUser(username, password);
        return 1;
    }

    //查询所有用户，调用customerRepository的findAllUsers方法返回用户列表。
    public Customer findAll(String username ,String password){
        return customerRepository.findAllUsers(username,password);
    }

    //通过用户名查询用户权限信息，首先尝试从缓存中获取用户权限信息，
    // 如果缓存中不存在，则从数据库中查询用户权限信息，并将查询结果存储到缓存中。
    public List<Authority> getCustomerAuthority(String username){
        List<Authority> authorities = null;
        Object obj = redisTemplate.opsForValue().get("authorities_" + username);
        if(obj != null){
            authorities = (List<Authority>) obj;
        }else {
            authorities = authorityRepository.findAuthoritiesByUsername(username);
            if(authorities.size()>0){
                redisTemplate.opsForValue().set("authorities_"+username,authorities);

            }
        }
        return authorities;
    }

}
