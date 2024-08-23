package com.zalominimenu.springboot.dto;

import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class Meta {
    private int page;
    private int size;
    private int total;
    private int totalPages;
    private boolean last;
    private boolean first;

    public Meta(Page p) {
        this.page = p.getNumber() + 1;
        this.size = p.getSize();
        this.total = (int) p.getTotalElements();
        this.totalPages = (int) Math.ceil((double) total / size);
        this.first = page == 1;
        this.last = page == totalPages;
    }
}
