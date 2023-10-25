package utils;

import com.sun.javafx.logging.Logger;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpURLConnectionHelper{
    public static String sendRequest(String urlParam,String requestType){
        HttpURLConnection con=null;
        BufferedReader buffer =null;
        StringBuffer resultBuffer=null;

        try {
            URL url = new URL(urlParam);
            con=(HttpURLConnection)url.openConnection();
            System.out.println(con);
            con.setRequestMethod(requestType);
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setUseCaches(false);
            int responseCode = con.getResponseCode();
            if(responseCode ==HttpURLConnection.HTTP_OK){
                InputStream inputStream = con.getInputStream();
                resultBuffer = new StringBuffer();
                String line ;
                buffer=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                while((line= buffer.readLine())!=null){
                    resultBuffer.append(line);
                }
//                System.out.println(resultBuffer.toString());
                return  resultBuffer.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
