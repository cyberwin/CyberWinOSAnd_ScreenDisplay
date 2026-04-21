package CyberWinPHP.Cyber_DeviceSync;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class CyberWin_udpBroadCast  extends Thread {
    MulticastSocket sender = null;
    DatagramPacket dj = null;
    InetAddress group = null;

    byte[] data = new byte[1024];

    public CyberWin_udpBroadCast(String dataString) {
        data = dataString.getBytes();
    }

    @Override
    public void run() {
        try {
            sender = new MulticastSocket();
            group = InetAddress.getByName("224.0.0.1");
            dj = new DatagramPacket(data,data.length,group,19876);
            sender.send(dj);
            sender.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}