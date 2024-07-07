package com.zalominimenu.springboot.repository.customer_portal;

import com.zalominimenu.springboot.model.AdminUser;
import com.zalominimenu.springboot.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerStoreRepository extends JpaRepository<Store, Long> {

}
