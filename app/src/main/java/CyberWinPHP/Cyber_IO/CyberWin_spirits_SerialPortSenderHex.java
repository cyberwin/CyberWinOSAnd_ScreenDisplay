package CyberWinPHP.Cyber_IO;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import CyberWinPHP.Cyber_Plus.LogToFile;

public class CyberWin_spirits_SerialPortSenderHex {


    private static final String TAG = "串口指令无波特率";
    private static final int MSG_SEND_DATA = 1;

    private HandlerThread mWorkerThread;
    private Handler mWorkerHandler;
    private FileDescriptor mFd;

    public void init(String portPath) {
        mWorkerThread = new HandlerThread("SerialPortWorker");
        mWorkerThread.start();
        LogToFile.d_windows("冥界", TAG, "初始化");


        Looper looper = mWorkerThread.getLooper();
        mWorkerHandler = new Handler(looper) {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == MSG_SEND_DATA) {
                    String data = (String) msg.obj;
                    sendHexData(data);
                }
            }
        };

        try {
            File deviceFile = new File(portPath);
            mFd = openSerialPort(deviceFile);
        } catch (IOException e) {
            Log.e(TAG, "Error initializing serial port", e);
            LogToFile.d_windows("冥界", TAG, e.getMessage());
        }
    }

    public void sendHexCommand(String hexData) {
        LogToFile.d_windows("冥界", TAG, "sendHexCommand");
        Message msg = mWorkerHandler.obtainMessage(MSG_SEND_DATA, hexData);
        mWorkerHandler.sendMessage(msg);
    }

    @SuppressLint("LongLogTag")
    private void sendHexData(String hexData) {
        try {
            FileOutputStream outputStream = new FileOutputStream(mFd);

            // 将 16 进制字符串转换为字节数组
            byte[] dataBytes = hexStringToByteArray(hexData);

            outputStream.write(dataBytes);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            Log.e(TAG, "Error sending hex data", e);
            LogToFile.d_windows("冥界", TAG, e.getMessage());
        }
    }

    private FileDescriptor openSerialPort(File deviceFile) throws IOException {
        return new FileInputStream(deviceFile).getFD();
    }

    @SuppressLint("LongLogTag")
    public void release() {
        try {
            if (mFd!= null) {
                closeSerialPort(mFd);
            }
        } catch (IOException e) {
            Log.e(TAG, "Error closing serial port", e);
            LogToFile.d_windows("冥界", TAG, e.getMessage());
        }

        mWorkerThread.quit();
    }

    private void closeSerialPort(FileDescriptor fd) throws IOException {
        // 关闭串口的实际实现
    }

    // 将 16 进制字符串转换为字节数组的方法
    private byte[] hexStringToByteArray(String hexString) {
        int len = hexString.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                    + Character.digit(hexString.charAt(i + 1), 16));
        }
        return data;
    }
}
