package define;

import java.util.ArrayList;
import java.util.List;

public class Smartphone implements Callable,Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;

    }

    @Override
    public String call() {
        StringBuilder sb=new StringBuilder();
        for (String number:numbers) {
boolean isValidNumber=validate(number);
if (isValidNumber){
    sb.append("Calling... ")
            .append(number).append(System.lineSeparator());
}else {
    sb.append("Invalid number!").append(System.lineSeparator());
}
        }
        return sb.toString();
    }

    private boolean validate(String number) {
        for (char symbol:number.toCharArray()) {

            if (!Character.isDigit(symbol)) {
                return false;
            }
        }
        return true;
    }














    @Override
    public String browse() {
        StringBuilder sb=new StringBuilder();
        for (String URL:urls) {
            boolean isValidURL=validateURL(URL);
            if (isValidURL){
                sb.append("Browsing: ")
                .append(URL).append("!").append(System.lineSeparator());
            }else {
                sb.append("Invalid URL!").append(System.lineSeparator());
            }


        }
        return sb.toString();
    }

    private boolean validateURL(String URL) {
        for (char symbol:URL.toCharArray()) {

            if (Character.isDigit(symbol)) {
                return false;
            }
        }
        return true;

    }
}
