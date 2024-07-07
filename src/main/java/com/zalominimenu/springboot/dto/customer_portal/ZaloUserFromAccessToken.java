package com.zalominimenu.springboot.dto.customer_portal;
@lombok.Data
public class ZaloUserFromAccessToken {
    private String id;
    private String name;
    private Picture picture;
    private String message;
    private int error;
}
@lombok.Data
class Picture {
    private Data data;
}
@lombok.Data
class Data {
    private String url;
}