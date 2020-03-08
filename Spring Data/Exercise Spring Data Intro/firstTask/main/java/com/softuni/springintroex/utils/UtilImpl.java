package com.softuni.springintroex.utils;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Component
public class UtilImpl implements Util{
    @Override
    public String[] readFileContent(String filePath) throws IOException {
        File file=new File(filePath);
        Set<String> result=  new LinkedHashSet<>();
        BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
String line;
while ((line=bufferedReader.readLine())!=null){
    if (!"".equals(line)){
        result.add(line);
    }

}

        return result.toArray(String[]::new);
    }
}
