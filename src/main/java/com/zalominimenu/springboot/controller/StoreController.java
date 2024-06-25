package com.zalominimenu.springboot.controller;

import com.zalominimenu.springboot.model.Store;
import com.zalominimenu.springboot.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/store")
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public ResponseEntity<List<Store>> getAllStores() {
        List<Store> Stores = storeService.getAllStores();
        return ResponseEntity.ok(Stores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Store> getStoreById(@PathVariable Long id) {
        Store store = storeService.getStoreById(id);
        return ResponseEntity.ok(store);
        //return Store.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Store> addStore(@RequestBody Store Store) {
        Store addStore = storeService.saveStore(Store);
        return ResponseEntity.ok(addStore);
    }

    @PutMapping
    public ResponseEntity<Store> updateStore(@RequestBody Store updatedStore) {
        // Call the service method to update the Store
        storeService.updateStore(updatedStore);

        return ResponseEntity.ok(updatedStore);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable Long id) {
        storeService.deleteStore(id);
        return ResponseEntity.noContent().build();
    }
}