package com.softserve.edu.webproject.dao;

import java.util.List;

import com.softserve.edu.webproject.model.CartInfo;
import com.softserve.edu.webproject.model.OrderDetailInfo;
import com.softserve.edu.webproject.model.OrderInfo;
import com.softserve.edu.webproject.model.PaginationResult;

public interface OrderDAO {

    public void saveOrder(CartInfo cartInfo);

    public PaginationResult<OrderInfo> listOrderInfo(int page,
                                                     int maxResult, int maxNavigationPage);

    public OrderInfo getOrderInfo(String orderId);

    public List<OrderDetailInfo> listOrderDetailInfos(String orderId);

}