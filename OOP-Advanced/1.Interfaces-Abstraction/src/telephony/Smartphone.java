package telephony;

public class Smartphone implements Callable, Browzable {

    @Override
    public String call(String phoneNumber) {
        for( Character ch : phoneNumber.toCharArray()){
            if (!Character.isDigit(ch)){
                return "Invalid number!";
            }
        }

        return "Calling... " + phoneNumber;
    }

    @Override
    public String browze(String website) {

        for( Character ch : website.toCharArray()){
            if (Character.isDigit(ch)){
                return "Invalid URL!";
            }
        }

        return "Browsing: " + website + "!";
    }
}
