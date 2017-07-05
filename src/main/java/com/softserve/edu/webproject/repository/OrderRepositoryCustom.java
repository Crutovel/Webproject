package com.softserve.edu.webproject.repository;

import com.softserve.edu.webproject.model.OrderInfo;
import com.softserve.edu.webproject.model.PaginationResult;

import java.util.List;

public interface OrderRepositoryCustom {

    int getMaxOrderNum();

    PaginationResult<OrderInfo> listOrderInfo(int page, int maxResult, int maxNavigationPage);

    List listOrderDetailInfos(String orderId);
}
