package com.softserve.edu.webproject.service.impl;


import com.softserve.edu.webproject.entity.Order;
import com.softserve.edu.webproject.entity.OrderDetail;
import com.softserve.edu.webproject.entity.Product;
import com.softserve.edu.webproject.model.*;
import com.softserve.edu.webproject.repository.OrderDetailRepository;
import com.softserve.edu.webproject.repository.OrderRepository;
import com.softserve.edu.webproject.repository.ProductRepository;
import com.softserve.edu.webproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.softserve.edu.webproject.repository.ProductRepository.Expressions.getByCode;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRep;
    private final ProductRepository productRep;
    private final OrderDetailRepository orderDetailRep;

    @Autowired
    public OrderServiceImpl( OrderRepository orderRep,ProductRepository productRep,
                             OrderDetailRepository orderDetailRep) {

        this.orderRep = orderRep;
        this.productRep = productRep;
        this.orderDetailRep = orderDetailRep;
    }

    public void saveOrder(CartInfo cartInfo) {

        int orderNum = orderRep.getMaxOrderNum() + 1;
        Order order = new Order();

        order.setId(UUID.randomUUID().toString());
        order.setOrderNum(orderNum);
        order.setOrderDate(new Date());
        order.setAmount(cartInfo.getAmountTotal());

        CustomerInfo customerInfo = cartInfo.getCustomerInfo();
        order.setCustomerName(customerInfo.getName());
        order.setCustomerEmail(customerInfo.getEmail());
        order.setCustomerPhone(customerInfo.getPhone());
        order.setCustomerAddress(customerInfo.getAddress());

        orderRep.save(order);

        List<CartLineInfo> lines = cartInfo.getCartLines();
        for (CartLineInfo line : lines) {
            OrderDetail detail = new OrderDetail();
            detail.setId(UUID.randomUUID().toString());
            detail.setOrder(order);
            detail.setAmount(line.getAmount());
            detail.setPrice(line.getProductInfo().getPrice());
            detail.setQuanity(line.getQuantity());

            String code = line.getProductInfo().getCode();
            Product product = (Product) productRep.findOne(getByCode(code));
            detail.setProduct(product);

            orderDetailRep.save(detail);
        }

        cartInfo.setOrderNum(orderNum);
    }

    public OrderInfo getOrderInfoByOrderId(String orderId) {
        Order order = orderRep.findOne(orderId);

        if (order == null) {
            return null;
        }
        return new OrderInfo(order.getId(), order.getOrderDate(),
                order.getOrderNum(), order.getAmount(), order.getCustomerName(),
                order.getCustomerAddress(), order.getCustomerEmail(), order.getCustomerPhone());
    }

    public List<OrderDetailInfo> listOrderDetailInfos(String orderId) {
        return orderRep.listOrderDetailInfos(orderId);
    }

    public PaginationResult<OrderInfo> listOrderInfo(int page, int maxResult, int maxNavigationPage) {
        return orderRep.listOrderInfo(page, maxResult, maxNavigationPage);
    }
}
