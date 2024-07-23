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


public class Product extends BaseEntity{
    @Column(name = "name")
    private String productName;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Long productPrice ;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> category;
    @Column(name = "quantity")
    private Long stockQuantity;
    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;
    @Column(name = "image_url")
    private String imageURL;
}