package com.product.shop.utils.base;

import java.io.IOException;

public interface GsonUtil {
    <T> void saveJSONtoFile(String fileName, T item) throws IOException;
}
