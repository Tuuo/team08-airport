package com.isoft.repository;

import com.isoft.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

//@Transactional
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "insert into DB_CLOUD.t_customer(username,password) values(?1,?2)",nativeQuery = true)
    public Integer saveUser(String username,String password);
    @Query(value = "select * from DB_CLOUD.t_customer where username = ?1",nativeQuery = true)
    public Customer findByUsername(String username);
    @Query(value = "select * from DB_CLOUD.t_customer",nativeQuery = true)
    public List<Customer> findAllUsers();
}
