package com.zalominimenu.springboot.dto.admin_portal.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserInfo {
    private Long id;
    private String name;
    private String username;
    private String email;
}
