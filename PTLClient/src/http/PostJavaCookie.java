/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author dell
 */
public class PostJavaCookie {
        public void post(String u ,String con , String cookie) throws IOException {
        
        URL url = new URL(u);
        
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setDoOutput(true);
        httpCon.setRequestMethod("POST");
        httpCon.setRequestProperty("Cookie", cookie);
        OutputStreamWriter out = new OutputStreamWriter(
                httpCon.getOutputStream());
        
        out.write(con);
        out.flush();
        
        System.out.println(httpCon.getResponseCode());
        System.out.println(httpCon.getResponseMessage());
    
        InputStream is = httpCon.getInputStream();
        InputStreamReader ir = new InputStreamReader(is); 
        BufferedReader br = new BufferedReader(ir);  
        
        
        String line;
        String sb ="";
        while((line=br.readLine())!=null){
            System.out.println(line);
            sb=sb+line;
        }
        out.close();
    }
    
}
