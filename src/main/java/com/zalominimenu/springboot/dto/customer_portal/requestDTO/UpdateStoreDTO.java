package com.zalominimenu.springboot.dto.customer_portal.requestDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateStoreDTO extends CreateStoreDTO{
    @NotBlank(message = "ID không được để trống")
    private Long id;
}
