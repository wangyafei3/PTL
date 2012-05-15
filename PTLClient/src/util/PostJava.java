/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 *
 * @author wangyafei
 */
public class PostJava {

    public String post(String u ,String con) throws IOException {
        URL url = new URL(u);
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setDoOutput(true);
        httpCon.setRequestMethod("POST");
        OutputStreamWriter out = new OutputStreamWriter(
                httpCon.getOutputStream());
        out.write(con);
        out.flush();
        System.out.println(httpCon.getResponseCode());
        System.out.println(httpCon.getResponseMessage());
        System.out.println(httpCon.getHeaderField("set-cookie"));
        
        InputStream is = httpCon.getInputStream();
        InputStreamReader ir = new InputStreamReader(is); 
        BufferedReader br = new BufferedReader(ir);  
        String line;
        while((line=br.readLine())!=null){
            System.out.println(line); 
        }
        out.close();
        return null;
    }
}
