package utils;

import net.sf.json.JSONObject;

import javax.swing.*;
import java.io.File;
import java.io.IOException;


//------------------------------------------下载版本------------------------------------------
public class CmcDownloadTool {
    public static String saveLocal = "D:/cmc_upload_download/";

    public static void CmcDownload(String versionNumber, String cmcLocal) {
        //versionNumber 版本号
        //cmcLocal   要下载的CMC文件路径  示例   1.目录  如：BiddingDoc\config\      2.文件  如：BiddingDoc\config\base_package_config\package_define.xml
        //saveLocal  下载后保存的位置  如：D:/cmc_upload_download/
        String NoSpaceversionNumber = versionNumber.replace(" ", "%20");


        String command = "java -jar TRCartget.jar pull " + "\"" + versionNumber + "\"" + " -vp " + "\"" + cmcLocal + "\"" + " -ap " + "\"" + "D:/cmc_upload_download/" + "\"";     //下载命令


        System.out.println(command);
        try {
            Process process = Runtime.getRuntime().exec("cmd.exe /c " + command + " >>out.txt");

            try {
                int waitFor = process.waitFor();    //用于阻塞进程  下载完版本后才可进行后续操作
            } catch (InterruptedException e1) {
                // TODO 自动生成的 catch 块
                e1.printStackTrace();
            }
        } catch (IOException e1) {
            // TODO 自动生成的 catch 块
            e1.printStackTrace();
        }
    }


    public static void CmcDownload(String versionNumber, String cmcLocal, String saveLocal) {
        //versionNumber 版本号
        //cmcLocal   要下载的CMC文件路径  示例   1.目录  如：BiddingDoc\config\      2.文件  如：BiddingDoc\config\base_package_config\package_define.xml
        //saveLocal  下载后保存的位置  如：D:/cmc_upload_download/
        String NoSpaceversionNumber = versionNumber.replace(" ", "%20");

        String command = "java -jar TRCartget.jar pull " + "\"" + versionNumber + "\"" + " -vp " + "\"" + cmcLocal + "\"" + "-ap" + saveLocal;     //下载命令


        try {
            Process process = Runtime.getRuntime().exec("cmd.exe /c " + command + " >>out.txt");

            try {
                int waitFor = process.waitFor();    //用于阻塞进程  下载完版本后才可进行后续操作
            } catch (InterruptedException e1) {
                // TODO 自动生成的 catch 块
                e1.printStackTrace();
            }
        } catch (IOException e1) {
            // TODO 自动生成的 catch 块
            e1.printStackTrace();
        }
    }
}
