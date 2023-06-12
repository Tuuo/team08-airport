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
    public Integer saveUser(String username,String password){
        customerRepository.saveUser(username, password);
        return 1;
    }

    public List<Customer> findAll(){
        return customerRepository.findAllUsers();
    }

    //使用用户名查询用户权限
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
