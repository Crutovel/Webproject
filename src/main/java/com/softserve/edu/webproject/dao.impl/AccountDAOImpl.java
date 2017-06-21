package com.softserve.edu.webproject.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import com.softserve.edu.webproject.dao.AccountDAO;
import com.softserve.edu.webproject.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
@Transactional
public class AccountDAOImpl implements AccountDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Account findAccount(String userName) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Account> crit = builder.createQuery(Account.class);
        Root<Account> acc = crit.from(Account.class);
        crit.where(builder.equal(acc.get("userName"), userName));
        TypedQuery<Account> q = session.createQuery(crit);
        return q.getSingleResult();
    }

}