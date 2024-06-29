package com.zalominimenu.springboot.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Long price ;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "stock")
    private Long stock;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "imported_date")
    private Date importedDate;

    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "image_url")
    private String imageUrl;
}