package com.softserve.edu.webproject.repository;

import com.softserve.edu.webproject.model.PaginationResult;
import com.softserve.edu.webproject.model.ProductInfo;

public interface ProductRepositoryCustom {

    PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage);

    PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage,
                                                String likeName);
}
