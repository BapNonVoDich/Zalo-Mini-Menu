package com.zalominimenu.springboot.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@SuperBuilder(toBuilder = true)
@Table(name = "product")
@Getter

public class Product extends BaseEntity{
    @Column(name = "name")
    private String productName;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Long productPrice ;
    @OneToMany
    @JoinColumn(name = "category_id")
    private Set<Category> category;
    @Column(name = "quantity")
    private Long stockQuantity;
    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;
    @Column(name = "image")
    private String imagePath;
}