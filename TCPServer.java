import java.util.Scanner;

import java.io.*;

import java.net.*;

import java.net.Socket.*;


class TCPServer {

public static void main(String argv[]) throws IOException {

  String sentence;

  String modifiedSentence;
 
  Scanner n = new Scanner(System.in);

  System.out.print("Do you want to ping or send message ? ( 1 - Ping , 2 - Message) \n");

    int input = n.nextInt();
     
 if(input == 1)
{
    
    String ipAddress = "192.168.62.136"; 

    InetAddress geek = InetAddress.getByName(ipAddress); 

    System.out.println("Sending Ping Request to " + ipAddress); 

    if (geek.isReachable(5000))
     System.out.println("Host is reachable"); 

    else

      System.out.println("Sorry ! We can't reach to this host"); 

}



else
{
while(true)
{
BufferedReader inFromUser = new BufferedReader(new 
InputStreamReader(System.in));

  
  Socket serverSocket = new Socket("192.168.62.136", 22000);
  DataOutputStream outToServer = new 
DataOutputStream(serevrSocket.getOutputStream());

  BufferedReader inFromClient = new BufferedReader(new 
InputStreamReader(serverSocket.getInputStream()));


     sentence = inFromUser.readLine();
   
     outToClient.writeBytes(sentence);


  modifiedSentence = inFromClient.readLine();

  System.out.println("FROM CLIENT: " + modifiedSentence);


  serverSocket.close();
}
}
}
}

