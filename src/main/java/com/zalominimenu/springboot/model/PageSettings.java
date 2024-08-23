package com.zalominimenu.springboot.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Slf4j
@Data
public class PageSettings {

    private int page = 1;

    private int limit = 10;

    private String sort = "desc";

    private String sortBy = "created_at";

    public Sort buildSort() {
        return switch (sort) {
            case "desc" -> Sort.by("id").descending();
            case "asc" -> Sort.by("id").ascending();
            default -> {
                log.warn("Invalid direction provided in PageSettings, using descending direction as default value");
                yield Sort.by("id").descending();
            }
        };
    }

    public Pageable buildPageable() {
        return PageRequest.of(page - 1, limit, buildSort());
    }

    public int getOffset() {
        return (page - 1) * limit;
    }
}