package my.app.switcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    Pattern pattern = Pattern.compile("-?\\d+");
    Pattern hexPattern = Pattern.compile("[0-9a-fA-F]+");

    public String convertBinaryDecimal(String binaryString){
        Matcher m = pattern.matcher(binaryString);
        String binaryToUsualString = "";
        while(m.find()){
            binaryToUsualString = binaryString.replaceAll(m.group(), Integer.toString(Integer.parseInt(m.group(), 2)));
            binaryString = binaryToUsualString;
        }
        return binaryToUsualString;
    }
    public String convertBinaryHex(String binaryString){
        Matcher m = pattern.matcher(binaryString);
        String binaryToHexString = "";
        while(m.find()){
            binaryToHexString = binaryString.replaceAll(m.group(), Integer.toHexString(Integer.parseInt(m.group(), 2)));
            binaryString = binaryToHexString;
        }
        return binaryToHexString;
    }
    public String convertDecimalBinary(String decimalString){
        Matcher m = pattern.matcher(decimalString);
        String binaryString = "";
        while(m.find()){
            binaryString = decimalString.replaceAll(m.group(), Integer.toBinaryString(Integer.parseInt(m.group())));
            decimalString = binaryString;
        }
        return binaryString;
    }
    public String convertDecimalHex(String decimalString){
        Matcher m = pattern.matcher(decimalString);
        String hexString = "";
        while(m.find()){
            hexString = decimalString.replaceAll(m.group(), Integer.toHexString(Integer.parseInt(m.group())));
            decimalString = hexString;
        }
        return hexString;
    }
    public String convertHexBinary(String hexString){
        Matcher m = hexPattern.matcher(hexString);
        String hexToBinaryString = "";
        while(m.find()){
            hexToBinaryString = hexString.replaceAll(m.group(), Integer.toBinaryString(Integer.parseInt(m.group(), 16)));
            hexString = hexToBinaryString;
        }
        return hexToBinaryString;
    }
    public String convertHexDecimal(String hexString){
        Matcher m = hexPattern.matcher(hexString);
        String hexToUsualString = "";
        while(m.find()){
            hexToUsualString = hexString.replaceAll(m.group(), Integer.toString(Integer.parseInt(m.group(), 16)));
            hexString = hexToUsualString;
        }
        return hexToUsualString;
    }
    public static void main(String[] args) {
        Object obj = new Object();
        String s = new String("asds");
        s = (String) obj;
        System.out.println(s);
    }
}
