package com.softserve.edu.webproject.service;

import com.softserve.edu.webproject.entity.Product;
import com.softserve.edu.webproject.model.PaginationResult;
import com.softserve.edu.webproject.model.ProductInfo;

public interface ProductService {

    Product findProductByCode(String code);

    ProductInfo findProductInfo(String code);

    PaginationResult<ProductInfo> getProducts(int page, int maxResult, int maxNavigationPage,
                                              String likeName);

    PaginationResult<ProductInfo> getProducts(int page, int maxResult, int maxNavigationPage);

    void save(ProductInfo productInfo);

}
