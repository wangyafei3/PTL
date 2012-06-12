/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author dell
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String push = "wangyafei";
        String pull;
        Socket s = new Socket("10.13.5.225",11111); 
        DataOutputStream outToServer = new DataOutputStream(s.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(s.getInputStream()));
        outToServer.writeBytes(push+'\n');
        pull = inFromServer.readLine();
        System.out.println(pull);
        s.close();
    }
}
