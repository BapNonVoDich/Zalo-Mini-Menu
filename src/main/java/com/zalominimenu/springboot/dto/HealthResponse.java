package com.zalominimenu.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HealthResponse {
    private String message;
    private String status;
    private String version;
    private String timestamp;
    private String environment;
}
