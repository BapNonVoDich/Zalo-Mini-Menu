package com.zalominimenu.springboot.dto.customer_portal;


import lombok.Data;
@Data
public class ZaloUserPhoneNumberFromAccessToken {
    private ZaloUserPhoneNumberData data;
    private String message;
    private int error;
}

