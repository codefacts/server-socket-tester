package server.test;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("args: " + Arrays.toString(args));
        int port = Integer.parseInt(args[0]);
//        int port = 5012;
        System.out.println("Listening on port: " + port);
        new Thread(() -> {
            new TcpServer(port);
        }).start();
        new Thread(() -> {
            try {
                UdpServer.createUdp(port);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
