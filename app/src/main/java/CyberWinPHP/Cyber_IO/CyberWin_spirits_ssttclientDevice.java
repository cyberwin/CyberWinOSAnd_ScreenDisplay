package CyberWinPHP.Cyber_IO;



import CyberWinPHP.Cyber_Plus.LogToFile;
import android_serialport_api.SerialPort;
import tp.xmaihh.serialport.SerialHelper;
import tp.xmaihh.serialport.bean.ComBean;

public class CyberWin_spirits_ssttclientDevice {
    private static final String TAG = "仙盟串口";
    public static void 东方仙盟_冥界_传送(String portName,int 波特率,String 指令){
        LogToFile.d_windows("冥界", TAG, "东方仙盟_冥界_传送");
        // String portName = "/dev/ttys0";
        try {
            // 1. 创建SerialHelper实例并打开串口
            SerialHelper serialHelper = new SerialHelper(portName,波特率) {
                @Override
                protected void onDataReceived(ComBean comBean) {

                          LogToFile.d_windows("冥界", TAG, "接受"+comBean.toString());
                }
            };
            serialHelper.open();

            // 2. 设置串口参数
            serialHelper.setBaudRate(波特率);//9600);
            serialHelper.setDataBits(8);
            serialHelper.setStopBits(1);
            serialHelper.setParity(0);

            // 3. 准备十六进制数据
            byte[] hexData = 东方仙盟_冥界_炼化器_硬件指令(指令);//"01 02 03 04");

            // 4. 发送十六进制数据
            serialHelper.send(hexData);
            System.out.println("十六进制数据已发送");

            // 5. 关闭串口
            serialHelper.close();
            LogToFile.d_windows("冥界", TAG, "portName="+portName);
            System.out.println("串口 " + portName + " 已关闭");
        } catch (Exception e) {
            LogToFile.d_windows("冥界", TAG, e.getMessage());
            e.printStackTrace();
        }
}

// 辅助方法，将十六进制字符串转换为字节数组（示例转换方法，你可以根据更严格要求优化）
public static byte[] 东方仙盟_冥界_炼化器_硬件指令(String hexString) {
    hexString = hexString.replaceAll("\\s", "");
    int len = hexString.length();
    byte[] data = new byte[len / 2];
    for (int i = 0; i < len; i += 2) {
        data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                + Character.digit(hexString.charAt(i + 1), 16));
    }
    return data;
}
}
