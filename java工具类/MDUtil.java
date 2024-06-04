package p4Download;

import java.math.BigInteger;

public class MDUtil {

    //加密：转为16进制
    public static String encrypt(String plaintext){
        byte[] bytes = plaintext.getBytes();
        BigInteger bigInteger = new BigInteger(1, bytes);
        String hexString = bigInteger.toString(16);
        return hexString;
    }


    //解密：16进制转为字符串
    public static String decrypt(String hexStrings) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < hexStrings.length(); i+=2) {
            String hexDigit = hexStrings.substring(i, i + 2);
            int decimal = Integer.parseInt(hexDigit, 16);
            result.append((char) decimal);
        }
        return result.toString();
    }



    public static void main(String[] args) {
        System.out.println(encrypt(""));
        System.out.println(decrypt(""));
    }
}
