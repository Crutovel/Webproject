package com.softserve.edu.webproject.service;

import com.softserve.edu.webproject.model.CartInfo;
import com.softserve.edu.webproject.model.OrderDetailInfo;
import com.softserve.edu.webproject.model.OrderInfo;
import com.softserve.edu.webproject.model.PaginationResult;

import java.util.List;

public interface OrderService {

    void saveOrder(CartInfo cartInfo);

    PaginationResult<OrderInfo> listOrderInfo(int page, int maxResult, int maxNavigationPage);

    OrderInfo getOrderInfoByOrderId(String orderId);

    List<OrderDetailInfo> listOrderDetailInfos(String orderId);

}
