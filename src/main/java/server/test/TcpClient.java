package server.test;

// A Java program for a Client
import java.net.*;
import java.io.*;
import java.util.Arrays;

public class TcpClient
{
    // initialize socket and input output streams
    private Socket socket		 = null;
    private PrintStream out	 = null;

    // constructor to put ip address and port
    public TcpClient(String address, int port)
    {
        // establish a connection
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // sends output to the socket
            out = new PrintStream(socket.getOutputStream());
        }
        catch(UnknownHostException u)
        {
            u.printStackTrace();
        }
        catch(IOException i)
        {
            i.printStackTrace();
        }

        // string to read message from input
        String line = "";

        out.println("[[PING FROM TCP CLIENT]]");

        // close the connection
        try
        {
            out.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

    public static void main(String args[])
    {
        System.out.println("args: " + Arrays.toString(args));
//        new Client(args[0], Integer.parseInt(args[1]));
        new TcpClient("127.0.0.1", 5012);
    }
}

