package com.zalominimenu.springboot.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table
@Data
@Builder
@AllArgsConstructor
public class Product {

    @Id
    private Long Product_id;
    private String Product_name;
    private String Description;
    private Long Product_price ;
    private Long Category_code;
    private Long Stock_quantity;
    private Date Start_date;
    private Date End_date;
    private Date Imported_date;
    private Long Store_code;
    private String Image_path;

}