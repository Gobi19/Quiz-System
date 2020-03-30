/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author Gobi.R
 */
public class QServer {
    /*public static String getAns(String ans, String choice){
        
    }*/
    private static Socket connectionSocket;
    public static String Question[] ={
            "What is 1+1?",
            "What is 1+2?",
            "What is 1+3?",
            "What is 1+4?",
            "What is 1+5?",
            "What is 1+6?",
    };
     
       private static String Choice[][] = {
            {"1","2","3","4"},
            {"2","1","3","4"},
            {"3","2","1","4"},
            {"2","3","4","5"},
            {"6","7","8","9"},
            {"6","7","8","9"},

    };
       
       private static String CorrectAnswer[]={"2","3","4","5","6","7"};
       public static String getQuestion(int a){
        String question = Question[a];
        return question;
    }
    public static String getChoice(int a){
        String choice = Choice[a][0];
        return choice;
    }
    public static String getChoice1(int a){
        String choice = Choice[a][1];
        return choice;
    }
    public static String getChoice2(int a){
        String choice = Choice[a][2];
        return choice;
    }
    public static String getChoice3(int a){
        String choice = Choice[a][3];
        return choice;
    }
    public static String getCorrectAnswer(int a){
        String answer = CorrectAnswer[a];
        return answer;
    }
     
   public static void main(String[] args) {
       try
        {
        //creating a server socket
             ServerSocket welcomeSocket = new ServerSocket(31190);

             while(true) {
                //wait for connection
                
                connectionSocket = welcomeSocket.accept();
                System.out.println("Client Made Connection with server");  
                //get input output streams
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                DataOutputStream  outToClient = new DataOutputStream(connectionSocket.getOutputStream());
               String Qnum = inFromClient.readLine();
               int num=Integer.parseInt(Qnum);
               

                 String question;
                 question = getQuestion(num);
                 String c1=getChoice(num);
                 String c2=getChoice1(num);
                 String c3=getChoice2(num);
                 String c4=getChoice3(num);
                 String ans=getCorrectAnswer(num);

                 outToClient.writeBytes(question+'\n');
                
                 outToClient.writeBytes(c1+'\n');
                 
                 outToClient.writeBytes(c2+'\n');
                 
                 outToClient.writeBytes(c3+'\n');
                 
                 outToClient.writeBytes(c4+'\n');
                 
                 outToClient.writeBytes(ans+'\n');
                 
                 System.out.print("Sent to Client");
               }
         }
                catch(Exception e)
                {

                 }
    }
       
       
       
}   
    
    
    