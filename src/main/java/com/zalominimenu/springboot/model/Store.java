package com.zalominimenu.springboot.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Table(name = "user_admin")
@Data
@Builder
@AllArgsConstructor
public class Store {
    @Id
    @GeneratedValue
    private Long Store_id;
    private Long Admin_id;
    private String Store_name;
    private String Address;
    private String Address_ward;
    private String Address_district;
    private String Address_city;
    private Date Created_date;
    private Date End_date;
    private Date Joining_date;
    private Long Status;
    private String Image_path;
}
