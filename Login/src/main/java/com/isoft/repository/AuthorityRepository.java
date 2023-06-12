package com.isoft.repository;

import com.isoft.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorityRepository extends JpaRepository<Authority,Integer> {
    @Query(value = "select a.* from DB_CLOUD.t_customer c,DB_CLOUD.t_authority a,DB_CLOUD.t_customer_authority ca " +
            "where ca.customer_id=c.id and ca.authority_id=a.id and c.username =?1",nativeQuery = true)
            public List<Authority> findAuthoritiesByUsername(String username);

}
