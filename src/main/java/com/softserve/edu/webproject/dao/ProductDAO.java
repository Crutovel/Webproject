package com.softserve.edu.webproject.dao;

import com.softserve.edu.webproject.entity.Product;
import com.softserve.edu.webproject.model.PaginationResult;
import com.softserve.edu.webproject.model.ProductInfo;

public interface ProductDAO {

    Product findProduct(String code);

    ProductInfo findProductInfo(String code);


    PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage);

    PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage, String likeName);

    void save(ProductInfo productInfo);

}
