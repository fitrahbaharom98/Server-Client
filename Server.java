
import java.io.*;
import java.net.*;
class Server
{
public static void main(String[] args)throws Exception
{
ServerSocket serversocket = new ServerSocket(6789);
System.out.println("Welcome! Server is ready to start now!");
Socket sock = serversocket.accept();
System.out.println("whats up!");

BufferedReader keyRead = new BufferedReader(new 
InputStreamReader(System.in));
OutputStream ostream = sock.getOutputStream();
PrintWriter pwrite = new PrintWriter(ostream,true);

InputStream istream = sock.getInputStream();
BufferedReader receiveRead = new BufferedReader(new 
InputStreamReader(istream));

String receiveMessage,sendMessage;
while(true)
{
if((receiveMessage=receiveRead.readLine())!=null)
{
System.out.println(receiveMessage);
}
sendMessage = keyRead.readLine();
pwrite.println(sendMessage);
pwrite.flush();
}
}
}
    
