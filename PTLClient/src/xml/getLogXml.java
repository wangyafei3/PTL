/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author dell
 */

public class getLogXml {
        public List<Map<String, ?>> getXML(String cookie , String URL , String h , List<String> list) {
        String request_url = URL;
        List<Map<String, ?>> items = new ArrayList<Map<String, ?>>();
        try {
            DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
            //读取服务器地址
            URL url = new URL(request_url);
            DocumentBuilder dber = domfac.newDocumentBuilder();
//            InputStream is = url.openStream();
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setDoOutput(true);
            httpCon.setRequestMethod("GET");
            httpCon.setRequestProperty("Cookie", cookie);
            OutputStreamWriter out = new OutputStreamWriter(
                httpCon.getOutputStream());
            out.flush();
            
            InputStream is = httpCon.getInputStream();  
            
            Document doc = dber.parse(is);
            NodeList nl = doc.getElementsByTagName(h);
       
            for (int i = 0; i < nl.getLength(); i++) {
                Map<String, Object> item = new HashMap<String, Object>(); 

                for( int index=0 ; index<list.size() ; index++ ){
                    String name = list.get(index);
                    item.put(name,doc.getElementsByTagName(name).item(i).getFirstChild().getNodeValue());                    
                }
                items.add(item);
            }
            
            
        } catch (Exception e) {
        }
        return items;
    }   
}
