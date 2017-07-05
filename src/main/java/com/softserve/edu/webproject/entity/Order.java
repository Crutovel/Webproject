package com.softserve.edu.webproject.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name = Order.QUERY_GET_MAX_ORDER_NUM,
                query = "Select max(o.orderNum) from Order o"
        ),
        @NamedQuery(name = Order.QUERY_GET_ORDERS,
                query = "Select new com.softserve.edu.webproject.model.OrderInfo"
                        + "(ord.id, ord.orderDate, ord.orderNum, ord.amount, "
                        + " ord.customerName, ord.customerAddress, ord.customerEmail, ord.customerPhone) "
                        + " from Order ord order by ord.orderNum desc")
})

@Entity
@Table(name = "orders",
        uniqueConstraints = {@UniqueConstraint(columnNames = "order_num")})
public class Order implements Serializable {
    public static final String QUERY_GET_MAX_ORDER_NUM = "Order.getMaxOrderNum";
    public static final String QUERY_GET_ORDERS = "Order.getOrderInfoList";
    private static final long serialVersionUID = -2576670215015463100L;

    private String id;
    private Date orderDate;
    private int orderNum;
    private double amount;

    private String customerName;
    private String customerAddress;
    private String customerEmail;
    private String customerPhone;

    @Id
    @Column(name = "id", length = 50)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "order_date", nullable = false)
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Column(name = "order_num", nullable = false)
    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    @Column(name = "amount", nullable = false)
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Column(name = "customer_name", length = 255, nullable = false)
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Column(name = "customer_address", length = 255, nullable = false)
    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Column(name = "customer_email", length = 128, nullable = false)
    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Column(name = "customer_phone", length = 128, nullable = false)
    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

}