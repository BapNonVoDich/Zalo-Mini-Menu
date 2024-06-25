package com.zalominimenu.springboot.repository;

import com.zalominimenu.springboot.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
