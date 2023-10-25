package utils;


import java.io.*;

public class ReadFileUtil {

    public static void main(String[] args) {
        read("C:\\Users\\lwx1091923\\AppData\\Local\\Temp\\artget-client\\1698216001973\\releasenotes.txt");
    }


    public static String read(File file) {
        FileInputStream fileInputStream = null;
        String document = null;

        try {
            if (!file.exists()) {
                System.out.println("不存在 " + file.getAbsolutePath());
            } else {
                fileInputStream = new FileInputStream(file);

                int readlength = 0;
                byte[] bytes = new byte[1024];

                while ((readlength = fileInputStream.read(bytes)) != -1) {
//                    System.out.print(new String(bytes, 0, readlength));
                    document += new String(bytes, 0, readlength);
                }
//                System.out.println(document);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return document;
    }

    //重载
    public static String read(String file1) {
        FileInputStream fileInputStream = null;
        String document = null;
        try {
            File file = new File(file1);
            if (!file.exists()) {
                System.out.println("不存在 " + file.getAbsolutePath());
            } else {
                fileInputStream = new FileInputStream(file);

                int readlength = 0;
                byte[] bytes = new byte[1024];

                while ((readlength = fileInputStream.read(bytes)) != -1) {
//                    System.out.print(new String(bytes, 0, readlength));
                    document += new String(bytes, 0, readlength);
                }
//                System.out.println(document);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return document;
    }
}
