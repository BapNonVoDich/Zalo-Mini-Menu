package com.zalominimenu.springboot.repository.customer_portal;

import com.zalominimenu.springboot.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerStoreRepository extends JpaRepository<Store, Long> {
    @Modifying
    Long deleteStoreById(Long id);

}
