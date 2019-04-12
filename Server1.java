import java.net.*;
import java.io.*;

public class Server1 extends Thread
{
   private ServerSocket serverSocket;
   String clientmsg = "";

   public Server1(int port) throws IOException
   {
      serverSocket = new ServerSocket(port);
      serverSocket.setSoTimeout(10000);
   }

    public void run()
    {
        while(true)
        {
            try
            {
                System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept();
                System.out.println("Just connected to " + server.getRemoteSocketAddress());
                BufferedReader in = new BufferedReader( new InputStreamReader(socket.getInputStream()));
                System.out.println(in.readline());
                PrintWriter out = new PrintWriter(server.getOutputStream());
                out.println("Thank you for connecting to "
                + server.getLocalSocketAddress() + "\nGoodbye!");
                server.close();
            }

            catch(SocketTimeoutException s)
            {
                System.out.println("Socket timed out!");
                break;
            }

            catch(IOException e)
            {
                e.printStackTrace();
                break;
            }
        }
    }
    public static void main(String [] args)
    {
        int port = Integer.parseInt(args[0]);
        try
        {
            Thread t = new SimpleServer(port);
            t.start();
        }

        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}