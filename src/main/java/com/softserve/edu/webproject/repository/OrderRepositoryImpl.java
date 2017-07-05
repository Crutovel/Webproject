package com.softserve.edu.webproject.repository;


import com.softserve.edu.webproject.entity.Order;
import com.softserve.edu.webproject.entity.OrderDetail;
import com.softserve.edu.webproject.model.OrderInfo;
import com.softserve.edu.webproject.model.PaginationResult;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepositoryCustom {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager em;

    public int getMaxOrderNum(){
        Session session = em.unwrap(Session.class);
        Query query = session.createNamedQuery(Order.QUERY_GET_MAX_ORDER_NUM);
        Integer value = (Integer) query.uniqueResult();
        if (value == null) {
            return 0;
        }
        return value;
    }

    public PaginationResult<OrderInfo> listOrderInfo(int page, int maxResult, int maxNavigationPage) {
        Session session = em.unwrap(Session.class);
        Query query = session.createNamedQuery(Order.QUERY_GET_ORDERS);
        return new PaginationResult<OrderInfo>(query, page, maxResult, maxNavigationPage);
    }


    public List listOrderDetailInfos(String orderId) {
        Session session = em.unwrap(Session.class);
        Query query = session.createNamedQuery(OrderDetail.QUERY_GET_LIST);
        query.setParameter(OrderDetail.PARAM_ORDER_ID, orderId);
        return query.getResultList();
    }
}
