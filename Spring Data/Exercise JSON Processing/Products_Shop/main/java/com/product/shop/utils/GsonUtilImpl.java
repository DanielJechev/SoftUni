package com.product.shop.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.product.shop.utils.base.GsonUtil;

import java.io.FileWriter;
import java.io.IOException;

public class GsonUtilImpl implements GsonUtil {
    private static final String BASE_PATH = "src/main/resources/";
    private static final String OUTPUT_FOLDER = BASE_PATH + "output/";

    private final Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .setPrettyPrinting()
            .create();

    public <T> void saveJSONtoFile(String fileName, T item) throws IOException {
        try (FileWriter fileWriter = new FileWriter(OUTPUT_FOLDER + fileName +".json")) {
            gson.toJson(item, fileWriter);
        }
    }
}
