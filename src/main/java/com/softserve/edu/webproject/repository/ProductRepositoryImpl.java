package com.softserve.edu.webproject.repository;

import com.querydsl.jpa.impl.JPAQuery;
import com.softserve.edu.webproject.entity.Product;
import com.softserve.edu.webproject.entity.QOrder;
import com.softserve.edu.webproject.model.PaginationResult;
import com.softserve.edu.webproject.model.ProductInfo;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ProductRepositoryImpl implements ProductRepositoryCustom {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager em;

    public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage,
                                                       String likeName) {
        String sql = "Select new " + ProductInfo.class.getName()
                + "(p.code, p.name, p.price) " + " from "
                + Product.class.getName() + " p ";
        if (likeName != null && likeName.length() > 0) {
            sql += " Where lower(p.name) like :likeName ";
        }
        sql += " order by p.createDate desc ";

        Session session = em.unwrap(Session.class);

        Query query = session.createQuery(sql);


        if (likeName != null && likeName.length() > 0) {
            query.setParameter("likeName", "%" + likeName.toLowerCase() + "%");
        }
        return new PaginationResult<ProductInfo>(query, page, maxResult, maxNavigationPage);
    }

    public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage) {
        return queryProducts(page, maxResult, maxNavigationPage, null);
    }
}
