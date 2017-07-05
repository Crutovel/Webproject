package com.softserve.edu.webproject.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.softserve.edu.webproject.entity.Product;
import com.softserve.edu.webproject.entity.QProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>, QueryDslPredicateExecutor,
        ProductRepositoryCustom {

    class Expressions {

        public static BooleanExpression getByCode(String code) {
            return QProduct.product.code.eq(code);
        }

    }
}
