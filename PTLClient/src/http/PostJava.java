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
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author wangyafei
 */
public class PostJava {

    public Map<String , String> post(String u ,String con) throws IOException {
        
        Map<String , String> map = new HashMap<String, String>();
        
        URL url = new URL(u);
        
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setDoOutput(true);
        httpCon.setRequestMethod("POST");
        OutputStreamWriter out = new OutputStreamWriter(
                httpCon.getOutputStream());
        
        out.write(con);
        out.flush();
        out.close();
        
        System.out.println(httpCon.getResponseCode());
        System.out.println(httpCon.getResponseMessage());
        String cookie = httpCon.getHeaderField("set-cookie");
    
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
        
        map.put("msg", sb);        
        map.put("cookie", cookie);
        return map;
    }
}
