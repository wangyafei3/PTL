/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author dell
 */
public class GetJava {
    public void getKey(String u ) throws IOException {
        URL url = new URL(u);
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setDoOutput(true);
        httpCon.setRequestMethod("GET");
        System.out.println(httpCon.getResponseCode());
        System.out.println(httpCon.getResponseMessage());
        System.out.println(httpCon.getHeaderFields());
        System.out.println(httpCon.getHeaderField("set-cookie"));

        InputStream is = httpCon.getInputStream();
        InputStreamReader ir = new InputStreamReader(is); 
        BufferedReader br = new BufferedReader(ir);  
        String line;
        while((line=br.readLine())!=null){
            System.out.println(line);         
        }
    }
}
