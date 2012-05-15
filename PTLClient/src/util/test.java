/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author dell
 */
public class test {
    public static void main(String[] args){
        String a = "name,pass";
        TransData td = new TransData();
        td.dataToPost(a);
        System.out.println(a);
    }
    
}
