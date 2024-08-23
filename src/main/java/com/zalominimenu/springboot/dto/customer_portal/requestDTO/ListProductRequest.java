package com.zalominimenu.springboot.dto.customer_portal.requestDTO;

import com.zalominimenu.springboot.model.PageSettings;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ListProductRequest extends PageSettings {
    private String productName;

    @Min(value = 1, message = "Id danh mục không được nhỏ hơn 1")
    private Long categoryId;

    @NotNull(message = "Id cửa hàng không được để trống")
    @Min(value = 1, message = "Id cửa hàng không được nhỏ hơn 1")
    private Long storeId;
}
