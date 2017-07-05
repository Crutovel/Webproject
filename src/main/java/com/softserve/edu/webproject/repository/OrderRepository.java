package com.softserve.edu.webproject.repository;



import com.softserve.edu.webproject.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface OrderRepository extends JpaRepository<Order, String>, QueryDslPredicateExecutor,
        OrderRepositoryCustom {

}
