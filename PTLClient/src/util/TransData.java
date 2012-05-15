/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author dell
 */
public class TransData {
    
    public String dataToPost(String data){
        
        String[] paras = data.split(",");
        int i;
        String transData="";
        for(i=0;i<paras.length-1;i++){
            transData = paras[i]+"="+paras[i]+"&";  
        }
        transData = transData+"="+paras[i];

        return null;
    }    
}
