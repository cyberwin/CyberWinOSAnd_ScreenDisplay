package CyberWinPHP.Cyber_Server;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Mywifiap {
    private static final int NO_PASS=0;
    private static final int WPA_PSK=1;
    private static final int WPA2_PSK=2;

    private WifiManager wifiManager;
    private WifiConfiguration apconfig;

    public Mywifiap(Context context) {
        wifiManager= (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
    }

    //开启热点
    public void openwifiap(String name,String password,int type){
        if(wifiManager.isWifiEnabled())
            wifiManager.setWifiEnabled(false);//如果WiFi是开启的就关闭WiFi。
        apconfig=new WifiConfiguration();
        apconfig.SSID=name;//设置WiFi名字

        //热点相关设置
        switch (type){
            case NO_PASS:
                apconfig.allowedAuthAlgorithms.set(WifiConfiguration.AuthAlgorithm.OPEN);
                apconfig.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
                apconfig.wepKeys[0]="";
                apconfig.wepTxKeyIndex=0;
                break;
            case WPA_PSK:
                apconfig.allowedAuthAlgorithms.set(WifiConfiguration.AuthAlgorithm.OPEN);
                apconfig.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.WPA_PSK);
                apconfig.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.TKIP);
                apconfig.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.CCMP);
                apconfig.allowedProtocols.set(WifiConfiguration.Protocol.WPA);
                apconfig.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.CCMP);
                apconfig.preSharedKey=password;
                break;
            case WPA2_PSK:
                //由于wpa2是不能直接访问的，但是KeyMgmt中却有。所以我们这样写
                for(int i=0;i<WifiConfiguration.KeyMgmt.strings.length;i++){
                    if("WPA2_PSK".equals(WifiConfiguration.KeyMgmt.strings[i])) {
                        apconfig.allowedKeyManagement.set(i);//直接给它赋索引的值
                        //Log.e("wpa2索引", String.valueOf(i));//不同手机索引不同
                    }
                }
                apconfig.allowedAuthAlgorithms.set(WifiConfiguration.AuthAlgorithm.OPEN);
                apconfig.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.TKIP);
                apconfig.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.CCMP);
                apconfig.allowedProtocols.set(WifiConfiguration.Protocol.WPA);
                apconfig.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.CCMP);
                apconfig.preSharedKey=password;
                break;
        }

        try {

            Method method=wifiManager.getClass().getMethod("setWifiApEnabled",WifiConfiguration.class,boolean.class);
            method.invoke(wifiManager,apconfig,true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    //关闭热点
    public void closewifiap(){
        try {
//            Method method1=wifiManager.getClass().getMethod("getWifiApConfiguration");
//            method1.setAccessible(true);
//            WifiConfiguration nowconfig= (WifiConfiguration) method1.invoke(wifiManager);//获取当前热点
            Method method=wifiManager.getClass().getMethod("setWifiApEnabled",WifiConfiguration.class,boolean.class);
            method.invoke(wifiManager,apconfig,false);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    //获取连接列表
    public StringBuffer getconnectlist(){
        /*
        连接设备的信息都存在一个文件里面，读这个文件获取信息
        读取文件后每为这样的格式，每连接一个设备增加一行，没有连接时只有一行
        IP address       HW type     Flags       HW address            Mask     Device
        192.168.43.115   0x1         0x2         c4:0b:cb:8a:4c:f1     *        ap0
        192.168.43.115   0x1         0x2         c4:0b:cb:8a:4c:f1     *        ap0
         */
        StringBuffer sb=new StringBuffer();
        try {
            BufferedReader br=new BufferedReader(new FileReader("/proc/net/arp"));
            String line;
            while((line=br.readLine())!=null){
                //Log.e("连接列表",line);
                sb.append(line+"\n");
            }
        } catch (FileNotFoundException e) {
          //  e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }


}
