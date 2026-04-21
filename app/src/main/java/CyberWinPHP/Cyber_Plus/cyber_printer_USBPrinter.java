package CyberWinPHP.Cyber_Plus;


import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;

import CyberWinPHP.Cyber_CPU.Cyber_Public_Var;
import CyberWinPHP.Cyber_Dialog.ToastUtil;
import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbConstants;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

public class cyber_printer_USBPrinter {
    public static final String ACTION_USB_PERMISSION = "com.usb.printer.USB_PERMISSION";

    private static cyber_printer_USBPrinter mInstance;

    private Context mContext;
    private PendingIntent mPermissionIntent;
    private UsbManager mUsbManager;
    private UsbDeviceConnection mUsbDeviceConnection;

    private UsbEndpoint ep,printerEp;
    private UsbEndpoint   usbEndpointOut,usbEndpoint;
    private UsbInterface usbInterface;

    private static final int TIME_OUT = 100000;

    public static cyber_printer_USBPrinter getInstance() {
        if (mInstance == null) {
            synchronized (cyber_printer_USBPrinter.class) {
                if (mInstance == null) {
                    mInstance = new cyber_printer_USBPrinter();
                }
            }
        }
        return mInstance;
    }

    /**
     * 初始化打印机，需要与destroy对应
     *
     * @param context 上下文
     */
	    /*
	    public static void initPrinter(Context context) {
	        //getInstance().init(context);
			getInstance().init(context,true);
	    }
	    */

    //2019-12-12
    //不打印
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void initPrinter(Context context, Boolean isPrint) {
        getInstance().init(context,isPrint);
    }

    //2019-12-01
    /**
     * 销毁打印机持有的对象
     */
    public static void destroyPrinter() {
        getInstance().destroy();
    }

    private void destroy() {
        mContext.unregisterReceiver(mUsbDeviceReceiver);

        if (mUsbDeviceConnection != null) {
            mUsbDeviceConnection.close();
            mUsbDeviceConnection = null;
        }

        mContext = null;
        mUsbManager = null;
    }



    //  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void init(Context context, Boolean isPrint) {
//	        list.clear();
        mContext = context;
        mUsbManager = (UsbManager) mContext.getSystemService(Context.USB_SERVICE);

        LogToFile.d("device", "初始化USB");

        if(isPrint==true) {
            LogToFile.d("device-COMM","寻找设备 打印");
            //  Cyber_Public_Var. cyberwin_default_printer=csp.cwpd_system_get("printer","default","");
            //
            mPermissionIntent = PendingIntent.getBroadcast(mContext, 0, new Intent(ACTION_USB_PERMISSION), 0);
            IntentFilter filter = new IntentFilter(ACTION_USB_PERMISSION);
            filter.addAction(UsbManager.ACTION_USB_DEVICE_DETACHED);
            filter.addAction(UsbManager.ACTION_USB_DEVICE_ATTACHED);
            mContext.registerReceiver(mUsbDeviceReceiver, filter);

            cyber_initForPrint();
        }
        //取消原来USB  connectUsbPrinter(device);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void cyber_initForPrint() {
        LogToFile.d("device-COMM","初始化 打印");

        LogToFile.d("device-COMM","打印系统"+ Cyber_Public_Var. cyberwin_default_printer);

        String[] usb_printer = Cyber_Public_Var. cyberwin_default_printer.split(">");
        int usb_vendor=Integer.parseInt( usb_printer[0]);
        int usb_prodid=Integer.parseInt( usb_printer[1]);

        LogToFile.d("device-COMM","打印系统 v="+usb_printer[0]);
        LogToFile.d("device-COMM","打印系统 p="+usb_printer[1]);

        UsbDevice device = cyber_getUsbDevice(usb_vendor,usb_prodid);//1046, 20497);
        if(device!=null) {
            cyber_openPort(device);
        }else{
            //没有找到 采用默认
            cyber_waste_ori_allusb();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void cyber_waste_ori_allusb(){


        // 列出所有的USB设备，并且都请求获取USB权限
        HashMap<String, UsbDevice> deviceList = mUsbManager.getDeviceList();

        LogToFile.d("device","设备数量="+deviceList.size());

        for (UsbDevice device : deviceList.values()) {
            LogToFile.d("device","设备制造商="+device.toString());
            //Log.d("device", device.GE() + "     " + device.getManufacturerName());


            LogToFile.d("device", device.getVendorId() + "     " + device.getProductId() + "      " + device.getDeviceId());
            //	LogToFile.d("device", usbInterface.getInterfaceClass() + "");


            String deviceinfo="getDeviceName="+device.getDeviceName() + "";
            deviceinfo=deviceinfo+"制造商ID"+device.getVendorId();
            deviceinfo=deviceinfo+"产品id="+device.getProductId();
            deviceinfo=deviceinfo+"设备ID="+device.getDeviceId();
            deviceinfo=deviceinfo+"DeviceClass="+device.getDeviceClass();
            //deviceinfo=deviceinfo+"usb-usbInterface="+usbInterface.getInterfaceClass();

            LogToFile.d("DU", deviceinfo);





            usbInterface = device.getInterface(0);


            int cwpd_usbtype=usbInterface.getInterfaceClass();
            deviceinfo=deviceinfo+"usb-usbInterface="+cwpd_usbtype;
            LogToFile.d("DU", deviceinfo);

            if ( cwpd_usbtype== 7) {
                // Log.d("device", device.getProductName() + "     " + device.getManufacturerName());

                // Log.d("device", device.GE() + "     " + device.getManufacturerName());
                if (!mUsbManager.hasPermission(device)) {
                    mUsbManager.requestPermission(device, mPermissionIntent);
                }else {
                    connectUsbPrinter(device);
                }
            }else{
                // if ( cwpd_usbtype== 7) {
                if ( cwpd_usbtype== 8) {
                    LogToFile.d("device", "此设备是U盘");
                }else{
                    //
                    LogToFile.d("device", "位置设备");
                    if (!mUsbManager.hasPermission(device)) {
                        mUsbManager.requestPermission(device, mPermissionIntent);
                    }else {
                        connectUsbPrinter(device);
                    }


                }

            }
        }

    }

    /**
     * mVendorId=1137,mProductId=85  佳博 3150T 标签打印机
     *
     * @param vendorId  厂商ID
     * @param productId 产品ID
     * @return  device
     */
    public UsbDevice cyber_getUsbDevice(int vendorId, int productId) {
        LogToFile.d("device-COMM","寻找设备 id: " + vendorId+" 产品ID="+productId);


        HashMap<String, UsbDevice> deviceList = mUsbManager.getDeviceList();
        Iterator<UsbDevice> deviceIterator = deviceList.values().iterator();
        while (deviceIterator.hasNext()) {
            UsbDevice device = deviceIterator.next();
            if (device.getVendorId() == vendorId && device.getProductId() == productId) {
                LogToFile.d("device-COMM","我终于找到你了-设备: " + device.getDeviceName());


                return device;
            }
        }
        // Toast.makeText(context, "没有对应的设备", Toast.LENGTH_SHORT).show();
        return null;
    }



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public String cyber_getUsbDeviceList() {
        String cyber_ret="";
        HashMap<String, UsbDevice> deviceList = mUsbManager.getDeviceList();
        Iterator<UsbDevice> deviceIterator = deviceList.values().iterator();
        while (deviceIterator.hasNext()) {
            UsbDevice device = deviceIterator.next();
            //if (device.getVendorId() == vendorId && device.getProductId() == productId) {
            //LogToFile.d("device-COMM","我终于找到你了getDeviceList: " + device.getDeviceName());


            cyber_ret=cyber_ret+device.getVendorId()+">"+device.getProductId()+">"+device.getDeviceName()+">"+device.getManufacturerName()+"|";

        }
        // Toast.makeText(context, "没有对应的设备", Toast.LENGTH_SHORT).show();
        cyber_ret=cyber_ret.substring(0,cyber_ret.length()-1);
        return cyber_ret;
    }

    /**
     * 判断对应 USB 设备是否有权限
     */
    public boolean hasPermission(UsbDevice device) {

        if (!mUsbManager.hasPermission(device)) {
            mUsbManager.requestPermission(device, mPermissionIntent);
        }

        return mUsbManager.hasPermission(device);
    }

    public boolean cyber_openPort(UsbDevice device) {
        //获取设备接口，一般只有一个，多个的自己研究去
        usbInterface = device.getInterface(0);

        // 判断是否有权限
        if (hasPermission(device)) {
            // 打开设备，获取 UsbDeviceConnection 对象，连接设备，用于后面的通讯
            mUsbDeviceConnection = mUsbManager.openDevice(device);
            LogToFile.d("device-COMM","cyber_openPort: 打开" );

            if (mUsbDeviceConnection == null) {
                LogToFile.d("device-COMM","cyber_openPort: 打开失败" );

                return false;
            }
            if (mUsbDeviceConnection.claimInterface(usbInterface, true)) {
                //Toast.makeText(Utils.getContext(), "找到 USB 设备接口", Toast.LENGTH_SHORT).show();
                LogToFile.d("device-COMM","cyber_openPort: 找到 USB 设备接口" );

            } else {
                mUsbDeviceConnection.close();
                //Toast.makeText(Utils.getContext(), "没有找到 USB 设备接口", Toast.LENGTH_SHORT).show();
                LogToFile.d("device-COMM","cyber_openPort: 没有找到 USB 设备接口" );
                return false;
            }
        } else {
            //Toast.makeText(Utils.getContext(), "没有 USB 权限", Toast.LENGTH_SHORT).show();
            LogToFile.d("device-COMM","cyber_openPort: 没有权限" );
            return false;
        }

        //获取接口上的两个端点，分别对应 OUT 和 IN
        for (int i = 0; i < usbInterface.getEndpointCount(); ++i) {
            UsbEndpoint end = usbInterface.getEndpoint(i);
            if (end.getDirection() == UsbConstants.USB_DIR_IN) {
                //usbEndpointIn = end;
                usbEndpoint = end;
                LogToFile.d("device-COMM","cyber_openPort: USB 输入点" );

            } else if(end.getDirection() == UsbConstants.USB_DIR_OUT) {
                printerEp = end;
                LogToFile.d("device-COMM","cyber_openPort: USB 输出点" );
            }else{
                //
                LogToFile.d("device-COMM","cyber_openPort: 其他点" );

            }
        }
        return true;
    }



    private final BroadcastReceiver mUsbDeviceReceiver = new BroadcastReceiver() {
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Log.d("action", action);
            UsbDevice mUsbDevice = intent.getParcelableExtra(UsbManager.EXTRA_DEVICE);
            if (ACTION_USB_PERMISSION.equals(action)) {
                synchronized (this) {
                    if (intent.getBooleanExtra(UsbManager.EXTRA_PERMISSION_GRANTED, false) && mUsbDevice != null) {
                        Log.d("receiver", action);
                        connectUsbPrinter(mUsbDevice);
                    } else {
                        LogToFile.d("IO", "USB设备请求被拒绝");
                        ToastUtil.showShort(context, "USB设备请求被拒绝");
                    }
                }
            } else if (UsbManager.ACTION_USB_DEVICE_DETACHED.equals(action)) {
                if (mUsbDevice != null) {
                    LogToFile.d("IO", "有设备拔出");
                    ToastUtil.showShort(context, "有设备拔出");
                }
            } else if (UsbManager.ACTION_USB_DEVICE_ATTACHED.equals(action)) {
                LogToFile.d("IO", "有设备插入");
                ToastUtil.showShort(context, "有设备插入");
                if (mUsbDevice != null) {
                    if (!mUsbManager.hasPermission(mUsbDevice)) {
                        mUsbManager.requestPermission(mUsbDevice, mPermissionIntent);
                    }
                }
            }
        }
    };

    public void close() {
        if(mUsbDeviceConnection != null){
            mUsbDeviceConnection.close();
            mUsbDeviceConnection = null;
        }
        mContext.unregisterReceiver(mUsbDeviceReceiver);
        mContext = null;
        mUsbManager = null;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void connectUsbPrinter(UsbDevice mUsbDevice) {
        if (mUsbDevice != null) {
            for (int i = 0; i < usbInterface.getEndpointCount(); i++) {
                String  D_C=""+mUsbDevice.getProductName().toString();
                D_C=D_C+"设备id"+mUsbDevice.getProductId()+"";

                LogToFile.d("device-COMM","设备已连接序号="+i+D_C);

                ep = usbInterface.getEndpoint(i);
                if (ep.getType() == UsbConstants.USB_ENDPOINT_XFER_BULK) {
                    if (ep.getDirection() == UsbConstants.USB_DIR_OUT) {
                        mUsbDeviceConnection = mUsbManager.openDevice(mUsbDevice);
                        printerEp = ep;
                        if (mUsbDeviceConnection != null) {
                            ToastUtil.showShort(mContext, "设备已连接");
                            LogToFile.d("device","设备已连接");
                            mUsbDeviceConnection.claimInterface(usbInterface, true);
                            mUsbDeviceConnection.releaseInterface(usbInterface);
                        }
                    }
                }
                else{
                    //
                }

            }
        } else {
            ToastUtil.showShort(mContext, "未发现可用的打印机");
            LogToFile.d("device","未发现可用的打印机");

        }
    }

    private void write(byte[] bytes) {
        LogToFile.d("deviceUSB","写入数据");

        if (mUsbDeviceConnection != null) {
            int b = mUsbDeviceConnection.bulkTransfer(printerEp, bytes, bytes.length, TIME_OUT);
            Log.i("Return Status", "b-->" + b);
        } else {
            Looper.prepare();
            handler.sendEmptyMessage(0);
            Looper.loop();
        }
    }

    public void cyber_write(byte[] bytes) {
        LogToFile.d("deviceUSB","写入数据");

        if (mUsbDeviceConnection != null) {
            int b = mUsbDeviceConnection.bulkTransfer(printerEp, bytes, bytes.length, TIME_OUT);
            Log.i("Return Status", "b-->" + b);
        } else {
            Looper.prepare();
            handler.sendEmptyMessage(0);
            Looper.loop();
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            ToastUtil.showShort(mContext, "未发现可用的打印机");
        }
    };

    /**
     * 打印文字
     * @param msg
     */
    public void printText(String msg) {
        byte[] bytes = new byte[0];
        try {
            bytes = msg.getBytes("gbk");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        write(bytes);
    }

    /* 打开钱箱指令 */
    public void cyber_openDrawer(){
	    	 /*
	        try {
	            out.write(ESC_OPEN_DRAWER);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        */
        write(ESCUtil.cyber_ESC_OPEN_DRAWER);
    }

    /**
     * 换行打印文字
     * @param msg
     */
    public void printTextNewLine(String msg) {
        byte[] bytes = new byte[0];
        try {
            bytes = msg.getBytes("gbk");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        write(new String("\n").getBytes());
        write(bytes);
    }

    /**
     * 打印空行
     * @param size
     */
    public void printLine(int size) {
        for (int i = 0; i < size; i++) {
            printText("\n");
        }
    }

    /**
     * 设置字体大小
     * @param size 0:正常大小 1:两倍高 2:两倍宽 3:两倍大小 4:三倍高 5:三倍宽 6:三倍大 7:四倍高 8:四倍宽 9:四倍大小 10:五倍高 11:五倍宽 12:五倍大小
     */
    public void setTextSize(int size) {
        write(ESCUtil.setTextSize(size));
    }

    /**
     * 字体加粗
     * @param isBold
     */
    public void bold(boolean isBold) {
        if (isBold) write(ESCUtil.boldOn());
        else write(ESCUtil.boldOff());
    }

    /**
     * 打印一维条形码
     * @param data
     */
    public void printBarCode(String data) {
        write(ESCUtil.getPrintBarCode(data, 5, 90, 5, 2));
    }

    /**
     * 设置对齐方式
     * @param position
     */
    public void setAlign(int position) {
        byte[] bytes = null;
        switch (position) {
            case 0:
                bytes = ESCUtil.alignLeft();
                break;
            case 1:
                bytes = ESCUtil.alignCenter();
                break;
            case 2:
                bytes = ESCUtil.alignRight();
                break;
        }
        write(bytes);
    }

    /**
     * 切纸
     */
    public void cutPager() {
        write(ESCUtil.cutter());
    }

    //新版未来之窗设备
    public UsbDeviceConnection getUsbDeviceConnection(){
        return mUsbDeviceConnection;
    }

    public UsbEndpoint getUsbEndpoint(){
        return printerEp;
    }

}

