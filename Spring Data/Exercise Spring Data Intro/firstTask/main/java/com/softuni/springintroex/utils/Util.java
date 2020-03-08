package com.softuni.springintroex.utils;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Util {
    String[] readFileContent(String filePath) throws IOException;
}
