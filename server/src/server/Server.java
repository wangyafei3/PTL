/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author dell
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        String sen;
        ServerSocket s = new ServerSocket(6789);
        while(true){
            
            Socket socket = s.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
            sen = inFromClient.readLine();
            System.out.println(sen);
            outToClient.writeBytes("123"+'\n');
        }
        
    }
}
