package server.test;

// A Java program for a Server
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TcpServer
{
    //initialize socket and input stream
    private Socket client = null;
    private ServerSocket server = null;
    private Scanner in	 = null;

    // constructor with port
    public TcpServer(int port)
    {
        // starts server and waits for a connection
        try
        {
            server = new ServerSocket(port);
            System.out.println("TcpServer started");
            while (true) {
                accept(server);
            }
        }
        catch(IOException i)
        {
            i.printStackTrace();
        }
        finally {
            try {
                if (server != null) {
                    server.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void accept(ServerSocket server) throws IOException {
        client = server.accept();
        System.out.println("Client accepted");

        // takes input from the client socket
        in = new Scanner(
            new BufferedInputStream(client.getInputStream()));

        String line = "";

        // reads message from client until "Over" is sent
        while (in.hasNextLine())
        {
            try
            {
                line = in.nextLine();
                System.out.println("TcpClient: " + line);

            }
            catch(Exception i)
            {
                i.printStackTrace();
            }
        }
        System.out.println("Closing connection");

        // close connection
        client.close();
        in.close();
    }

    public static void main(String args[])
    {
        new TcpServer(5012);
    }
}

