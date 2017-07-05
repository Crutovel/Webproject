package com.softserve.edu.webproject.repository;


import com.querydsl.core.types.dsl.BooleanExpression;
import com.softserve.edu.webproject.entity.QAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import com.softserve.edu.webproject.entity.Account;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface AccountRepository extends JpaRepository<Account, String>, QueryDslPredicateExecutor{

     class Expressions {

        public static BooleanExpression getByUsername(String userName) {
            return QAccount.account.userName.eq(userName);
        }
        public static BooleanExpression getByActive(boolean activity) {
            return QAccount.account.active.eq(activity);
        }
    }
}
