package com.product.shop.utils.base;

import java.util.List;

public interface ValidatorUtil {
    <T> List<String> getViolationsMessage(T item);
}
