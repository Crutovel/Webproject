package com.softserve.edu.webproject.repository;

import com.softserve.edu.webproject.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String>, QueryDslPredicateExecutor {
}
