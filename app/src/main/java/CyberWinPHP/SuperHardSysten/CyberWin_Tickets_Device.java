package CyberWinPHP.SuperHardSysten;
import com.fazecast.jSerialComm.SerialPort;

import java.nio.charset.StandardCharsets;

import CyberWinPHP.Cyber_Plus.LogToFile;

public class CyberWin_Tickets_Device {
    public static String 东方仙盟_测试出卡() {
        String 未来之窗ret="";

try {
    未来之窗ret = 未来之窗ret + "进入";
    LogToFile.d_windows("冥界", "吐卡及", 未来之窗ret);


    SerialPort[] ports = SerialPort.getCommPorts();
// 统一的发送指令（16 进制）
    byte[] sendCommand = new byte[]{(byte) 0xA, (byte) 0x09, (byte) 0x02,
            (byte) 0x01, (byte) 0x0A, (byte) 0xCA
            , (byte) 0x9F};
//0A 09 02 01 0A CA 9F

    未来之窗ret = 未来之窗ret + "开始tttl";
    LogToFile.d_windows("冥界", "吐卡及", 未来之窗ret);

    int i = 0;
    for (SerialPort port : ports) {
        port.openPort();
        i = i + 1;
        未来之窗ret = 未来之窗ret + "；打开" + i;
        LogToFile.d_windows("冥界", "吐卡及", 未来之窗ret);

        port.setBaudRate(115200);


        // 发送指令

        port.writeBytes(sendCommand, sendCommand.length);

        LogToFile.d_windows("冥界", "吐卡及", 未来之窗ret);

        未来之窗ret = 未来之窗ret + "；写入" + i;

        // 接收响应

        byte[] receiveBuffer = new byte[1024];

        int numRead = port.readBytes(receiveBuffer, receiveBuffer.length);

        if (numRead > 0) {
            String receivedData = new String(receiveBuffer, 0, numRead, StandardCharsets.UTF_8);

            System.out.println("从端口 " + port.getSystemPortName() + " 接收到的数据: " + receivedData);
            未来之窗ret = 未来之窗ret + port.getSystemPortName() + " 接收到的数据: " + receivedData;
        }


        port.closePort();

    }
}catch (Exception ex){
    未来之窗ret=未来之窗ret+ex.getMessage()+ex.getStackTrace();
}

        return 未来之窗ret;

    }
}
