package server.test;

// Java program to illustrate Server side
// Implementation using DatagramSocket
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;

public class UdpServer
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("args: " + Arrays.toString(args));
//        createUdp(Integer.parseInt(args[0]));
        createUdp(5012);
    }

    public static void createUdp(int port) throws Exception {
        // Step 1 : Create a socket to listen at port 1234
        DatagramSocket ds = new DatagramSocket(port);
        byte[] receive = new byte[65535];
        try {

            DatagramPacket DpReceive = null;
            System.out.println("UdpServer started");
            while (true)
            {

                // Step 2 : create a DatgramPacket to receive the data.
                DpReceive = new DatagramPacket(receive, receive.length);

                // Step 3 : revieve the data in byte buffer.
                ds.receive(DpReceive);

                System.out.println("UdpClient: " + data(receive));

                // Clear the buffer after every message.
                receive = new byte[65535];
            }
        } finally {
            ds.close();
        }
    }

    // A utility method to convert the byte array
    // data into a string representation.
    public static StringBuilder data(byte[] a)
    {
        if (a == null)
            return null;
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (a[i] != 0)
        {
            ret.append((char) a[i]);
            i++;
        }
        return ret;
    }
}

