package com.softserve.edu.webproject.validator;

import com.softserve.edu.webproject.entity.Product;
import com.softserve.edu.webproject.model.ProductInfo;
import com.softserve.edu.webproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import static com.softserve.edu.webproject.repository.ProductRepository.Expressions.getByCode;

@Component
public class ProductInfoValidator implements Validator {

    private final ProductRepository productRep;

    @Autowired
    public ProductInfoValidator(ProductRepository productRep) {
        this.productRep = productRep;
    }

    public boolean supports(Class<?> clazz) {
        return clazz == ProductInfo.class;
    }

    public void validate(Object target, Errors errors) {
        ProductInfo productInfo = (ProductInfo) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "NotEmpty.productForm.code");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.productForm.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty.productForm.price");

        String code = productInfo.getCode();
        if (code != null && code.length() > 0) {
            if (code.matches("\\s+")) {
                errors.rejectValue("code", "Pattern.productForm.code");
            } else if (productInfo.isNewProduct()) {
                Product product = (Product) productRep.findOne(getByCode(code));
                if (product != null) {
                    errors.rejectValue("code", "Duplicate.productForm.code");
                }
            }
        }

    }
}
