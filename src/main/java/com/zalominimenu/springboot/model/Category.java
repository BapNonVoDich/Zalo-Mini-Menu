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
@Table(name = "category")
@Getter
public class Category extends BaseEntity {
    @Column(name = "name")
    private String categoryName;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;
    @OneToMany
    @JoinColumn(name = "product_id")
    private Set<Product> productId;
}
