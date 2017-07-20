package com.softserve.edu.webproject.entity;

import java.io.Serializable;

import javax.persistence.*;

@NamedQuery(name = "Order.listOrderDetailInfos",
    query = "Select new com.softserve.edu.webproject.model.OrderDetailInfo"
        + "(d.id, d.product.code, d.product.name , d.quanity,d.price,d.amount) "
        + " from OrderDetail  d  where d.order.id = :" + OrderDetail.PARAM_ORDER_ID)
@Entity
@Table(name = "order_details")
public class OrderDetail implements Serializable {

  private static final long serialVersionUID = 7550745928843183535L;
  public static final String QUERY_GET_LIST = "Order.listOrderDetailInfos";
  public static final String PARAM_ORDER_ID = "orderId";

  private String id;
  private Order order;
  private Product product;
  private int quanity;
  private double price;
  private double amount;

  @Id
  @Column(name = "id", length = 50, nullable = false)
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id", referencedColumnName = "code", nullable = false)
  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  @Column(name = "quanity", nullable = false)
  public int getQuanity() {
    return quanity;
  }

  public void setQuanity(int quanity) {
    this.quanity = quanity;
  }

  @Column(name = "price", nullable = false)
  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Column(name = "amount", nullable = false)
  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

}
