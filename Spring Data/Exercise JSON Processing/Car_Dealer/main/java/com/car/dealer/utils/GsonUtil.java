package com.car.dealer.utils;

import java.io.IOException;

public interface GsonUtil {
    <T> void saveJSONtoFile(String fileName, T[] items) throws IOException;
}
