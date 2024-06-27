package com.zalominimenu.springboot.dto.auth;

import com.zalominimenu.springboot.enums.UserRole;
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
