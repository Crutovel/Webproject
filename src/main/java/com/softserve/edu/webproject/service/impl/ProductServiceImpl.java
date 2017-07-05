package com.softserve.edu.webproject.service.impl;

import com.softserve.edu.webproject.entity.Product;
import com.softserve.edu.webproject.model.PaginationResult;
import com.softserve.edu.webproject.model.ProductInfo;
import com.softserve.edu.webproject.repository.ProductRepository;
import com.softserve.edu.webproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static com.softserve.edu.webproject.repository.ProductRepository.Expressions.*;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRep;

    @Autowired
    public ProductServiceImpl(ProductRepository productRep) {
        this.productRep = productRep;
    }

    public Product findProductByCode(String code) {
        return (Product) productRep.findOne(getByCode(code));
    }

    public ProductInfo findProductInfo(String code) {
        Product product = (Product) productRep.findOne(getByCode(code));
        if (product == null) {
            return null;
        }
        return new ProductInfo(product.getCode(), product.getName(), product.getPrice());
    }

    public PaginationResult<ProductInfo> getProducts(int page, int maxResult, int maxNavigationPage,
                                                     String likeName) {
        return productRep.queryProducts(page, maxResult, maxNavigationPage, likeName);

    }

    public PaginationResult<ProductInfo> getProducts(int page, int maxResult, int maxNavigationPage) {
        return productRep.queryProducts(page, maxResult, maxNavigationPage);

    }

    public void save(ProductInfo productInfo) {

        String code = productInfo.getCode();
        Product product = null;
        if (code != null) {
            product = (Product) productRep.findOne(getByCode(code));
        }
        if (product == null) {
            product = new Product();
            product.setCreateDate(new Date());
        }
        product.setCode(code);
        product.setName(productInfo.getName());
        product.setPrice(productInfo.getPrice());

        if (productInfo.getFileData() != null) {
            byte[] image = productInfo.getFileData().getBytes();
            if (image != null && image.length > 0) {
                product.setImage(image);
            }
        }
            productRep.save(product);
    }
}
