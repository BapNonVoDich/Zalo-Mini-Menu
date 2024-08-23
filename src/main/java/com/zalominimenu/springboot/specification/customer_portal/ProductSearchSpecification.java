package com.zalominimenu.springboot.specification.customer_portal;

import com.zalominimenu.springboot.dto.customer_portal.requestDTO.ListProductRequest;
import com.zalominimenu.springboot.model.Product;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ProductSearchSpecification {
    public static Specification<Product> findByCriteria(final ListProductRequest criteria) {
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();

                if (criteria.getProductName() != null) {
                    predicates.add(
                            cb.like(
                                    cb.upper(root.get("productName")),
                                    "%" + criteria.getProductName().toUpperCase()
                            )
                    );
                }

                if (criteria.getStoreId() != null) {
                    predicates.add(
                            cb.equal(
                                    root.get("store").get("id"),
                                    criteria.getStoreId()
                            )
                    );
                }

                if (!predicates.isEmpty()) {
                    return cb.and(predicates.toArray(new Predicate[predicates.size()]));
                } else {
                    return null;
                }
            }
        };
    }
}
