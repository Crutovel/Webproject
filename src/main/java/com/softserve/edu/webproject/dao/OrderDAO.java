package com.softserve.edu.webproject.dao;

import java.util.List;

import com.softserve.edu.webproject.model.CartInfo;
import com.softserve.edu.webproject.model.OrderDetailInfo;
import com.softserve.edu.webproject.model.OrderInfo;
import com.softserve.edu.webproject.model.PaginationResult;

public interface OrderDAO {

    void saveOrder(CartInfo cartInfo);

    PaginationResult<OrderInfo> listOrderInfo(int page, int maxResult, int maxNavigationPage);

    OrderInfo getOrderInfo(String orderId);

    List<OrderDetailInfo> listOrderDetailInfos(String orderId);

}