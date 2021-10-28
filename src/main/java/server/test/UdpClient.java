package server.test;

// Java program to illustrate Client side
// Implementation using DatagramSocket
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient
{
    public static void main(String args[]) throws IOException
    {
        InetAddress ip = InetAddress.getLocalHost();
        int port = 5012;
        sendSignal(ip, port);
    }

    private static void sendSignal(InetAddress ip, int port) throws IOException {

        // Step 1:Create the socket object for
        // carrying the data.
        DatagramSocket ds = new DatagramSocket();

        byte buf[] = null;

        // loop while user not enters "bye"
        String[] lines = new String[] {
            "[[Ping from udp client]]",
        };
        for (String line : lines) {

            // convert the String input into the byte array.
            buf = line.getBytes();

            // Step 2 : Create the datagramPacket for sending
            // the data.
            DatagramPacket DpSend =
                new DatagramPacket(buf, buf.length, ip, port);

            // Step 3 : invoke the send call to actually send
            // the data.
            ds.send(DpSend);
        }
    }
}

