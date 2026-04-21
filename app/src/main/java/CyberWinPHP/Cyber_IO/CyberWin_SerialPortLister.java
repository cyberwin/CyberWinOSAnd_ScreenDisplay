package CyberWinPHP.Cyber_IO;

import android.content.Context;
import android.hardware.usb.UsbManager;
import android.util.Log;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class CyberWin_SerialPortLister {
    private static final String TAG = "NativeSerialPortLister";

    public static List<String> listSerialPorts(Context context) {
        List<String> serialPortPaths = new ArrayList<>();

        // 获取 USB 管理器
        UsbManager usbManager = (UsbManager) context.getSystemService(Context.USB_SERVICE);

        // 通常串口设备位于 /dev 目录下
        File devDirectory = new File("/dev");

        // 筛选出可能的串口设备文件
        File[] serialPortFiles = devDirectory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                // 这里的判断条件只是一个简单的示例，实际情况会更复杂
                String name = file.getName();
                return name.startsWith("ttyS") || name.startsWith("ttyUSB");
            }
        });

        if (serialPortFiles!= null) {
            for (File file : serialPortFiles) {
                serialPortPaths.add(file.getAbsolutePath());
                Log.d(TAG, "Found serial port: " + file.getAbsolutePath());
            }
        }

        return serialPortPaths;
    }
}
