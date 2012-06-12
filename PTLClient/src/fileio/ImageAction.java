/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fileio;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.*;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author xuEy
 */
public class ImageAction {
    
    
    //将图片进行Base64编码
    public String codeBase64(String url) throws FileNotFoundException, IOException{
        
        //获取图片文件大小
        File file = new File(url);
        int fileLength = (int)file.length();
        
        //根据获取图片大小初始化按位读取图片的Byte数组
        byte[] buffer_code = new byte[fileLength];
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        
        StringBuffer sbf = new StringBuffer();
        int cut = 0;
        
        while((cut=inputStream.read(buffer_code))!=-1){
            //使用sun的BASE64Encoder类对图片进行Base64位编码
            String string = new BASE64Encoder().encode(buffer_code);
            sbf.append(string);
        }
        
        String base64String = sbf.toString();
        //输出编码后得到的字符串
        return base64String;
    }
    
    
    //对Base64编码进行解码
    public Image decodeBase64(String base64String) throws IOException{
        
        //将字符串解码为byte数组
        byte[] buffer_decode=new BASE64Decoder().decodeBuffer(base64String);
        
        //将byte数组读取为Image类型
        Image IMGdecode=Toolkit.getDefaultToolkit().createImage(buffer_decode);
        return IMGdecode;
    }
    
}
