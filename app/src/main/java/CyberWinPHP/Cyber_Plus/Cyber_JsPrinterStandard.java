package CyberWinPHP.Cyber_Plus;

import com.fazecast.jSerialComm.SerialPort;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Instrumentation;
import android.app.PendingIntent;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Icon;
import android.hardware.display.DisplayManager;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.provider.Telephony;
import android.speech.tts.TextToSpeech;
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import CyberWinPHP.Cyber_IO.CyberWin_spirits_SerialPortSenderHex;
import CyberWinPHP.Cyber_IO.CyberWin_spirits_ssttclientDevice;
import CyberWinPHP.SuperHardSysten.CyberWin_Tickets_Device;
import CyberWinPHP.cyber_printerCmdUtils_net;
import com.ynwlzc.framework.cyberwinosand_ScreenDisplay.FullscreenActivity;
import com.ynwlzc.framework.cyberwinosand_ScreenDisplay.R;

//import com.google.zxing.activity.CaptureActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipException;

import CyberWinPHP.Cyber_CPU.Cyber_Public_Function;
import CyberWinPHP.Cyber_CPU.Cyber_Public_Var;
import CyberWinPHP.Cyber_CPU.iniFile;
import CyberWinPHP.Cyber_DeviceSync.WifiAdmin;
import CyberWinPHP.Cyber_Helper.Cyber_PrinterHelper;
import CyberWinPHP.Cyber_IO.Cyber_Zip;
import CyberWinPHP.Cyber_Safe.Cyber_PackageSafeE;
import CyberWinPHP.Cyber_Server.HttpsRequestUtil;
import CyberWinPHP.Cyber_Server.Mywifiap;
import CyberWinPHP.device.MyScanV2024Activity;
import static CyberWinPHP.Cyber_CPU.Cyber_Public_Var.Application_StartupPath;
import static CyberWinPHP.Cyber_CPU.Cyber_Public_Var.m_cpu;
import static java.lang.Thread.sleep;
import android.view.Window;
//import android.support.v7.app.;
//import cyberWin.NET.ApplicationBrowserActivity;

public final  class Cyber_JsPrinterStandard {//extends Activity  {

    private static Context mContext;

    public static final int SCAN_CODE_REQUEST_CODE = 1;

    public static String cyber_scan_result = "";

    private FullscreenActivity cyber_cpu_main;

    // private List<BluetoothBean> mBluetoothList;//搜索的蓝牙设备
    //private List<BluetoothBean> mBluetoothList2;//去重的蓝牙设备


    int cyber_yourChoice_printerlinkmode;


    boolean cwpd_ret_wait_finish = false;

    private OutputStream out = null;
    private Handler handler = null;
    private Socket s = null;

    public Cyber_JsPrinterStandard(FullscreenActivity _cyber_cpu_main, Context context) {
        cyber_cpu_main = _cyber_cpu_main;
        mContext = context;
        //人脸初始
        // Cyber_Pubic_FacePay.cyber_wxface_1_initPayFace(context);

         cyber_init_tts();


    }
    //public static final int SCAN_CODE_REQUEST_CODE = 1;
    @JavascriptInterface
    public String cyber_Scan() throws InterruptedException {
        showToast("摄像头：");
       // Intent intent = new Intent();
      //  intent.setClass(RFCardActivity.this, CaptureActivity.class);
      //  intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
       // Cyber_Public_Var.m_cpu.startActivityForResult();
        // 二维码扫码
       // cyber_scan_result = "";
        Cyber_JsPrinterStandard.cyber_scan_result="";
        //    cyber_cpu_main.cwpd_Web.loadUrl(url);
        //cyber_cpu_main.cwpd_Web.
        Intent intent = new Intent(Cyber_Public_Var.cyber_main_instance, MyScanV2024Activity.class);
       // Cyber_Public_Var.m_cpu.startActivityForResult(intent, SCAN_CODE_REQUEST_CODE);
        Cyber_Public_Var.m_cpu.startActivity(intent);
        showToast("摄像头：返回");
       // Cyber_Public_Var.m_cpu.startActivity(intent);




        while (cyber_scan_result.length() < 1) {
            //等待返回
            sleep(50);
        }

        if ("cyber_error" == cyber_scan_result) {
            cyber_scan_result = "";
        }
        return cyber_scan_result;

    }
    @JavascriptInterface
    public static void showToast(String str) {
        //2022-7-27 优化子线程UI
        //Looper.prepare();
        Toast.makeText(Cyber_Public_Var.cyber_main_instance, str, Toast.LENGTH_SHORT).show();
        //Looper.loop();// 进入loop中的循环，查看消息队列
    }

    //20210217
    private   TextToSpeech tts = null;
    public void speakText_Init(){
        try {
            // showToast("首次初始化");
            tts = new TextToSpeech(Cyber_Public_Var.cyber_main_instance, new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if (status == TextToSpeech.SUCCESS) {
                        int result = tts.setLanguage(Locale.CHINA);
                        if (result != TextToSpeech.LANG_COUNTRY_AVAILABLE && result != TextToSpeech.LANG_AVAILABLE) {
                            showToast("TTS不支持");
                        }
                    }
                }
            });
            tts.setOnUtteranceCompletedListener(new TextToSpeech.OnUtteranceCompletedListener() {
                int i = 0;

                @Override
                public void onUtteranceCompleted(String s) { //这个s就是上面写的utterance，
                    //if (i<3){//简单的做了个播报三次的功能
                    //tts.speak("这是一条语音播报", TextToSpeech.QUEUE_FLUSH, ttsOptions);
                    //i++;
                    //}
                    //showToast("播放完成");
                }
            });


            tts.setLanguage(Locale.CHINA);

            tts.setPitch(1.5f);
        }catch(Exception ex){
            LogToFile.d_windows("TTS","语音异常", ex.getMessage());

        }
    }

    @JavascriptInterface
    public String speakText(String msg)
    {
        try {
            //showToast("开始朗读"+msg);
            String ret="";
            if(tts==null){
                speakText_Init();
            }





            //  tts.speak(msg,TextToSpeech.QUEUE_FLUSH,null,null);
            tts.speak(msg, TextToSpeech.QUEUE_FLUSH, null);
            // tts.speak(msg,TextToSpeech.QUEUE_FLUSH,null,null);

            return  "{\"status\":1,\"message\":\""+ret+"\"}";
        }catch(Exception ex){
            LogToFile.d_windows("TTS","语音异常朗读", ex.getMessage());
            return  "{\"status\":0,\"message\":\""+ex.getMessage()+"\"}";
        }

    }

    @JavascriptInterface
    public void PlaySound(String filename) {
        speakText(filename);
    }
    @JavascriptInterface
    public void PlaySoundV2(String filename, int timemillsecond){
        speakText(filename);
    }
    @JavascriptInterface
    public void Dish_PlayQueueCall(String _queue_no) {
        speakText("请"+_queue_no+"就餐");
    }
    @JavascriptInterface
    public void PlayMent_PlayMoney(String _money) {
        speakText(""+_money+"元");
    }
    @JavascriptInterface
    public void Work_PlayBLYW(String _queue_no) {
        speakText("请"+_queue_no+"办理业务");
    }

    //2020-7-9
    //下载客户端默认数据
    @JavascriptInterface
    public String cyber_downfile(String  home_url_C,String keynam) {

        String CyberWinPHP_Path=  Cyber_Public_Var.App_local_path;
        //   ,mContext);

        String url_md5= "cyberwin"+Cyber_Public_Var.cyber_md5(keynam);
        String url_type="html";

        String file_cache_path = CyberWinPHP_Path;//Cyber_Public_Var.cyber_getFilePath(ApplicationBrowserActivity.this) + "/CyberCache/";
        String file_cache_path_onename = url_md5 + "." + url_type;

        Cyber_Public_Var.cyber_downloadFile1(home_url_C, file_cache_path, file_cache_path_onename);
        return file_cache_path+file_cache_path_onename;
    }

    //
    //未来之窗ajax
    @JavascriptInterface
    public String cyberwinapp_aj(String url, String method,String postdata) {

        String outputStr ="";
        try {

            //未来之窗重新打包
            HashMap<String, String> CyberWinApp_Protocol_Package_raw = new HashMap<>();
            CyberWinApp_Protocol_Package_raw.put("cwpdrawdata", postdata);
            outputStr = Cyber_Public_Function.CyberWinApp_Protocol_Package(CyberWinApp_Protocol_Package_raw);

//GET
            //从服务器下载支付配置
            String cwpd_ret = HttpsRequestUtil.httpRequest(url, method, outputStr);
            //LogToFile.d("新支付", "支付信息 服务端信息" + cwpd_ret);
            return cwpd_ret;
        } catch (Exception ex) {
            return outputStr;
        }catch (UnknownError EX){
            return outputStr;
        }
    }

    //
    @JavascriptInterface
    public String cwpd_aj(String url, String method,String postdata) {

//GET
        try{
            //从服务器下载支付配置
            String cwpd_ret = HttpsRequestUtil.httpRequest(url, method, postdata);
            //LogToFile.d("新支付", "支付信息 服务端信息" + cwpd_ret);
            //cwpd_system_config_report_set("commonreport", report_name, cwpd_ret, "20225578-2019");
            return cwpd_ret;
        } catch (Exception ex) {
            return "";
        }
    }

    @JavascriptInterface
    public String cyberwinapp_setstart_linkley(String start_linkley, String key) {
        Cyber_Public_Var.start_linkley=start_linkley;
        return Cyber_Public_Var.start_linkley;
    }
    //2022-6-27 未来之窗安全基石
    //未来之窗ajax
    @JavascriptInterface
    public String cyberwinapp_ajs(String url, String method,String postdata,String key) {

        String outputStr ="";
        try {

            String safetrans = Cyber_PackageSafeE.encrypt(postdata, key);

            //未来之窗重新打包
            HashMap<String, String> CyberWinApp_Protocol_Package_raw = new HashMap<>();
            if (safetrans == "cyberwin:safeerror") {
                CyberWinApp_Protocol_Package_raw.put("cwpdrawdata", postdata);
                // Cyber_Public_Var.client_sn
            } else {
                CyberWinApp_Protocol_Package_raw.put("cwpdrawdata_safe", safetrans);
                CyberWinApp_Protocol_Package_raw.put("client_sn", Cyber_Public_Var.client_sn);
                CyberWinApp_Protocol_Package_raw.put("start_linkley", Cyber_Public_Var.start_linkley);
                CyberWinApp_Protocol_Package_raw.put("client_os", "android");
            }
            outputStr = Cyber_Public_Function.CyberWinApp_Protocol_Package(CyberWinApp_Protocol_Package_raw);


//GET
            //从服务器下载支付配置
            String cwpd_ret = HttpsRequestUtil.httpRequest(url, method, outputStr);
            //LogToFile.d("新支付", "支付信息 服务端信息" + cwpd_ret);
            String safetrans_response = Cyber_PackageSafeE.decrypt(cwpd_ret, key);
            if (safetrans_response == "cyberwin:safeerror") {
                return cwpd_ret;
            } else {
                return safetrans_response;
            }
        } catch (Exception ex) {
            return outputStr;
        }

    }

    //未来之窗2022-10-30
    @JavascriptInterface
    public String locStorage_Cyber_M(String db, String table, String sql)
    {
        //locStorage_init(db, table);

        try {


            iniFile IR = new iniFile();

            String ret = IR.locStorage_Cyber_M(db, table, sql);
            return ret;
        }catch (Exception ex){
            return ex.getMessage();
        }


    }

    //下载为未来之窗app
    @JavascriptInterface
    public String cyber_download_apppackage(String appname ,String password ,String url) {

        try {
            String App_local_path = Cyber_Public_Var.App_local_path;
            String file_cache_path_onename = appname + ".cyberapp";
            String app_name_path=App_local_path+""+appname+"/";

            File 未来之窗微app根目录dir = new File(App_local_path);
            if (未来之窗微app根目录dir.isDirectory() && !未来之窗微app根目录dir.exists()) {
                未来之窗微app根目录dir.mkdir();
            }


            Cyber_Public_Var.cyber_downloadFile1(url, App_local_path, file_cache_path_onename);

            String unzip_Path = App_local_path + "/" + file_cache_path_onename;

            //String s = String.valueOf
            char[] password_trans = password.toCharArray();
            Cyber_Zip.unZipFile(unzip_Path, app_name_path, password_trans, true);

            return "ok";
        } catch (Exception ex){
            return "cyber-error:"+ex.getMessage();
        }


        //return home_url_C+file_cache_path+file_cache_path_onename;
    }

    //2023-11-5 资源 app
    //下载为未来之窗app
    @JavascriptInterface
    public String cyber_download_microapppackage(String appname ,String password ,String url) {

        try {
            String App_local_path = Cyber_Public_Var.CyberWin_MicroApp_local_path;
            String file_cache_path_onename = appname + "_microapp.cyberwinmicand";
            String app_name_path=App_local_path+""+appname+"/";

            File 未来之窗微app根目录dir = new File(App_local_path);
            if (未来之窗微app根目录dir.isDirectory() && !未来之窗微app根目录dir.exists()) {
                未来之窗微app根目录dir.mkdir();
            }


            Cyber_Public_Var.cyber_downloadFile1(url, App_local_path, file_cache_path_onename);

            //	String unzip_Path = App_local_path + "/" + file_cache_path_onename;

            //不解压

            return "安装"+appname+"完成";
        }catch (Exception ex){
            return "cyber-error:"+ex.getMessage();
        }


        //return home_url_C+file_cache_path+file_cache_path_onename;
    }
    //系统参数配置
    @JavascriptInterface
    public void cwpd_system_set(String section, String key, String value, String pass) {
        if (pass.equals("20225578-2019")) {
            //string 浏览器_setting_path = Public_Var.CyberWinPHP_Path + "//CyberPHP_config//CyberWin.cyber";
            //CyberSnow.VB.NET.My_.Helper.InfoControl.iniFile IR = new CyberSnow.VB.NET.My_.Helper.InfoControl.iniFile();

            //IR.WriteINI(section, key, value, 浏览器_setting_path);

            iniFile IR = new iniFile();

            IR.WriteINI(section, key, value, "CyberWin");

            // set_SetConfig("DefaultHome", urlTextBox.Text);
        }
    }

    @JavascriptInterface
    public void cwpd_system_o2o_set(String section, String key, String value, String pass) {
        if (pass.equals("20225578-2019")) {
            //String 浏览器_setting_path = Public_Var.CyberWinPHP_Path + "//CyberPHP_config//O2O_Settings.cyberphp";
            //CyberSnow.VB.NET.My_.Helper.InfoControl.iniFile IR = new CyberSnow.VB.NET.My_.Helper.InfoControl.iniFile();
            iniFile IR = new iniFile();

            IR.WriteINI(section, key, value, "O2O_Settings");

            // set_SetConfig("DefaultHome", urlTextBox.Text);
        }
    }

    @JavascriptInterface
    public String cwpd_system_get(String section, String key, String pass) {

        if (pass.equals("20225578-2019")) {
            //string 浏览器_setting_path = Public_Var.CyberWinPHP_Path + "//CyberPHP_config//CyberWin.cyber";
            //	CyberSnow.VB.NET.My_.Helper.InfoControl.iniFile IR = new CyberSnow.VB.NET.My_.Helper.InfoControl.iniFile();
            iniFile IR = new iniFile();
            //return   IR.GetINI(section, key, "", 浏览器_setting_path).Replace("%CyberWinPHP_Path%", Application.StartupPath + "/CyberWinPHP"); ;
            return IR.GetINI(section, key, "", "CyberWin").replace("%CyberWinPHP_Path%", Application_StartupPath);// Application.StartupPath + "/CyberWinPHP");;

            // set_SetConfig("DefaultHome", urlTextBox.Text);
        } else {
            return "没有权限";
        }
    }

    @JavascriptInterface
    public String cwpd_system_o2o_get(String section, String key, String value, String pass) {
        if (pass.equals("20225578-2019")) {
            //string 浏览器_setting_path = Public_Var.CyberWinPHP_Path + "//CyberPHP_config//O2O_Settings.cyberphp";
            //CyberSnow.VB.NET.My_.Helper.InfoControl.iniFile IR = new CyberSnow.VB.NET.My_.Helper.InfoControl.iniFile();
            iniFile IR = new iniFile();
            return IR.GetINI(section, key, "", "O2O_Settings").replace("%CyberWinPHP_Path%", Application_StartupPath);// Application.StartupPath + "/CyberWinPHP");;

            // set_SetConfig("DefaultHome", urlTextBox.Text);
        } else {
            return "没有权限";
        }
    }


    //系统参数配置
    @JavascriptInterface
    public void cwpd_system_config_merchant_set(String section, String key, String value, String pass) {
        if (pass.equals("20225578-2019")) {
            //string 浏览器_setting_path = Public_Var.CyberWinPHP_Path + "//CyberPHP_config//CyberWin.cyber";
            //CyberSnow.VB.NET.My_.Helper.InfoControl.iniFile IR = new CyberSnow.VB.NET.My_.Helper.InfoControl.iniFile();

            //IR.WriteINI(section, key, value, 浏览器_setting_path);

            iniFile IR = new iniFile();

            IR.WriteINI(section, key, value, "CyberMerchant");

            // set_SetConfig("DefaultHome", urlTextBox.Text);
        }


    }

    @JavascriptInterface
    public String cwpd_system_config_merchant_get(String section, String key, String value, String pass) {
        if (pass.equals("20225578-2019")) {
            //string 浏览器_setting_path = Public_Var.CyberWinPHP_Path + "//CyberPHP_config//O2O_Settings.cyberphp";
            //CyberSnow.VB.NET.My_.Helper.InfoControl.iniFile IR = new CyberSnow.VB.NET.My_.Helper.InfoControl.iniFile();
            iniFile IR = new iniFile();
            return IR.GetINI(section, key, "", "CyberMerchant").replace("%CyberWinPHP_Path%", Application_StartupPath);// Application.StartupPath + "/CyberWinPHP");;

            // set_SetConfig("DefaultHome", urlTextBox.Text);
        } else {
            return "没有权限";
        }
    }

    @JavascriptInterface
    public String cwpd_system_config_report_get(String section, String key, String pass) {
        if (pass.equals("20225578-2019")) {
            //string 浏览器_setting_path = Public_Var.CyberWinPHP_Path + "//CyberPHP_config//O2O_Settings.cyberphp";
            //CyberSnow.VB.NET.My_.Helper.InfoControl.iniFile IR = new CyberSnow.VB.NET.My_.Helper.InfoControl.iniFile();
            iniFile IR = new iniFile();
            return IR.GetINI(section, key, "", "CyberPHP_report").replace("%CyberWinPHP_Path%", Application_StartupPath);// Application.StartupPath + "/CyberWinPHP");;

            // set_SetConfig("DefaultHome", urlTextBox.Text);
        } else {
            return "没有权限";
        }
    }

    //系统参数配置
    @JavascriptInterface
    public void cwpd_system_config_report_set(String section, String key, String value, String pass) {
        if (pass.equals("20225578-2019")) {
            //string 浏览器_setting_path = Public_Var.CyberWinPHP_Path + "//CyberPHP_config//CyberWin.cyber";
            //CyberSnow.VB.NET.My_.Helper.InfoControl.iniFile IR = new CyberSnow.VB.NET.My_.Helper.InfoControl.iniFile();

            //IR.WriteINI(section, key, value, 浏览器_setting_path);

            iniFile IR = new iniFile();

            IR.WriteINI(section, key, value, "CyberPHP_report");

            // set_SetConfig("DefaultHome", urlTextBox.Text);
        }


    }


    @JavascriptInterface
    public String cwpd_getSn() {
        return
                Cyber_Public_Var.cwpd_device_sn;
    }
    //Cyber_Public_Var.cwpd_debug_mod=
    @JavascriptInterface
    public void cwpd_innder_closeLog() {
        //关闭调试
        Cyber_Public_Var.cwpd_debug_mod = false;
    }

    @JavascriptInterface
    public static String getDeviceUUid() {

//2022-7-20 bug 设定
        String ANDROID_ID = Settings.System.getString(Cyber_Public_Var.cyber_main_instance.getContentResolver(), Settings.System.ANDROID_ID);
        //String androidId = DeviceUtils.getAndroidID();


        //String ANDROID_ID = Settings.System.getString(getContentResolver(), Settings.System.ANDROID_ID);
        String SerialNumber = android.os.Build.SERIAL;
        UUID deviceUuid = new UUID(ANDROID_ID.hashCode(), ((long) ANDROID_ID.hashCode() << 32));
        return deviceUuid.toString();
    }


    @JavascriptInterface
    public static String getDeviceIP() {

        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();)
                {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address))
                    {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        }
        catch (SocketException ex){
            // ex.printStackTrace();
        }
        return "";
    }
    //2020-7-9
    //下载客户端默认数据
    @JavascriptInterface
    public String cyber_downHomeToCache() {
        String  home_url_C = Cyber_Public_Var.Application_StartupPath_Home;
        String CyberWinPHP_Path=  Cyber_Public_Var.App_localcache_resource_path;//  Cyber_Public_Var. getCyberWinPath(Cyber_Public_Var.App_localcache_resource_path
        //   ,mContext);

        String url_md5= "cyberwin"+Cyber_Public_Var.cyber_md5("cyberv20200709v3comynwlzccncyberwinserver");;//Cyber_Public_Var.cyber_md5("cyberv20200709v3comynwlzccncyberwinserver");
        String url_type="html";

        String file_cache_path = CyberWinPHP_Path;//Cyber_Public_Var.cyber_getFilePath(ApplicationBrowserActivity.this) + "/CyberCache/";
        String file_cache_path_onename = url_md5 + "." + url_type;

        Cyber_Public_Var.cyber_downloadFile1(home_url_C, file_cache_path, file_cache_path_onename);
        return home_url_C+file_cache_path+file_cache_path_onename;
    }
    @JavascriptInterface
    public static String device_create_wifiap(String ssid ,String password) {
        Mywifiap mywifiap =new Mywifiap(Cyber_Public_Var.cyber_main_instance);
        mywifiap.openwifiap(ssid,password,1);
        return "创建热带";
    }
    //未来之窗链接wifi
    //2022-10-20
    @JavascriptInterface
    public static String device_connect_wifi(String ssid ,String password) {

        try {
            WifiAdmin wifiAdmin = new WifiAdmin(Cyber_Public_Var.cyber_main_instance);
            wifiAdmin.openWifi();
            wifiAdmin.addNetwork(wifiAdmin.CreateWifiInfo(ssid,password, 3));
            return "操作完成";
        }
        catch (Exception ex){
            // ex.printStackTrace();
            return "";
        }
        //return "";
    }

    /**
     * 递归删除 文件/文件夹
     *
     * @param file
     */
    public void deleteFile(File file) {

        Log.i("TAG", "delete file path=" + file.getAbsolutePath());

        if (file.exists()) {
            if (file.isFile()) {
                if(file.getName().contains("cyberwin_application_union")){
                    //任何时候不删配置文件
                }else {
                    file.delete();
                }
            } else if (file.isDirectory()) {
                File files[] = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    deleteFile(files[i]);
                }
            }
            file.delete();
        } else {
            Log.e("TAG", "delete file no exists " + file.getAbsolutePath());
        }
    }
    //未来之窗打印接口
    @JavascriptInterface
    public String print_byprintername(String report_id, String printerdata, String printername) {
        return	print_byprintername_新思想(report_id,printerdata,printername,"commonwindowsandroid");
    }
    @JavascriptInterface
    public void cyber_openinhome(final String url) {
        cyber_cpu_main.cwpd_Web.post(new Runnable() {
            @Override
            public void run() {
                cyber_cpu_main.cwpd_Web.loadUrl(url);
            }
        });

    }
    //未来之窗打印接口
    @JavascriptInterface
    public String print_byprintername_新思想(String report_id, String printerdata, String printername,String 设备) {
        if (report_id.equals("dishfastfacepayorder")) {
            Cyber_PrinterHelper cph = new Cyber_PrinterHelper(mContext);
            return cph.print_Dishfast_FacePayOrder(printerdata);
        }
        //order_detail

        LogToFile.d("老打印", "输入模板id= " + report_id);
        LogToFile.d("老打印", "输入打印数据= " + printerdata);
        LogToFile.d("老打印", "系统设定打印类型 =" + Cyber_Public_Var.cyber_default_printer_type);
        LogToFile.d("老打印", "系统设定打印地址= " + Cyber_Public_Var.cyberwin_default_printer_net);

        LogToFile.d("老打印", "输入打印设备= " + 设备);




        try {

            Cyber_XMLSample c_xml = new Cyber_XMLSample();
            HashMap hm = c_xml.split(printerdata);
            Object okey = "order_detail";

            Object shopnameKEY = "shopname";
            Object order_idkey = "order_id";

            //orderid
            Object orderidkey_long = "orderid";

            Object order_detail = hm.get(okey);
            Object shopname = hm.get(shopnameKEY);
            Object order_id = hm.get(order_idkey);
            Object orderid_long = hm.get(orderidkey_long);//"91057772201909260911244804565";// hm.get(orderidkey_long);
            String order_beizhu = hm.get("beizhu").toString();

            Object  order_打印内容 = "";

            try{
                order_打印内容 = hm.get("print_body");
            }catch (Exception ex){

            }


            if(设备.equals("hisense_pda")==true){
                //2023-4-4
                Intent intent_未来之窗打印=new Intent();

                LogToFile.d_windows("海信","打印","进入");

                intent_未来之窗打印.setClassName("recieptservice.com.recieptservice","recieptservice.com.recieptservice.service.PrinterService");
                //String final打印内容 = 打印内容;
                Object finalOrder_打印内容 = order_打印内容;

                cyber_cpu_main.bindService(intent_未来之窗打印, new ServiceConnection() {

                    @Override
                    public void onServiceConnected(ComponentName name, final IBinder service) {
                        LogToFile.d_windows("海信","打印","进入onServiceConnected");
                        /*
                        PrinterInterface mAidl = PrinterInterface.Stub.asInterface(service);
                        try {
                            //mAidl.printText(((EditText)findViewById(R.id.test1)).getText().toString()+"\n");

                            //店名
                            mAidl.printText("\n");
                            mAidl.setTextSize(38);
                            mAidl.setTextBold(true);
                            mAidl.setAlignment(1);//ignment：0 Left 1 Center 2 right
                            mAidl.printText(shopname.toString());
                            //单据内容
                            //order_id  单号
                            mAidl.printText("\n");
                            mAidl.setAlignment(0);//ignment：0 Left 1 Center 2 right
                            mAidl.setTextBold(false);
                            mAidl.setTextSize(24);//字体
                            mAidl.printText(order_id.toString());
                            mAidl.setTextSize(24);//字体
                            mAidl.printText("\n");
                            mAidl.printText(finalOrder_打印内容.toString());
                            mAidl.printText("\n");
                        } catch (Exception ex) {
                            LogToFile.d_windows("海信","打印",ex.getMessage());
                            //e.printStackTrace();
                        }
                        */
                    }
                    @Override
                    public void onServiceDisconnected(ComponentName name) {

                    }
                }, Service.BIND_AUTO_CREATE);

                return "打印完成";

            }
            if (Cyber_Public_Var.cyber_default_printer_type.equals("blue")) {

                String print_data = "\n\n";
                print_data += shopname.toString();
                print_data += "\n";
                print_data += "单号：" + order_id.toString();
                print_data += "\n";
                print_data += "================";
                print_data += "\n";
                print_data += order_detail.toString();

                print_data += " \n\n";
                print_data += " 系统： " + orderid_long.toString();
                ;
                print_data += "\n\n\n\n";

                print_data += "  ";

                Cyber_Public_Var.mPrintContent = print_data;
                Cyber_Public_Var.mPrintContent_order_id_loong = orderid_long.toString();

                //	Cyber_Public_Var.mPrintContent_order_id_loong = orderid_long.toString();

                //	print_byprintername_blue(order_detail.toString());
              //  new ConnectThread(Cyber_Public_Var.mBluetoothAdapter.getRemoteDevice(Cyber_Public_Var.cyber_default_blue_address)).start();

                while (Cyber_Public_Var.cyber_default_printer_print_finish = false) {

                }


                return "打印完成";
            }

            if (Cyber_Public_Var.cyber_default_printer_type.equals("net")) {
                byte[] cyber_printdtat;

                Log.d("cwpd_老打印网络-ori", "网络打印");

                String ip = Cyber_Public_Var.cyberwin_default_printer_net;
                String port = "9100";

                Log.d("cwpd_print-ori", "网络打印-地址" + ip);


               cyber_printdtat = cyber_create_clientPaper_Net(printerdata, report_id);

                s = new Socket(ip, Integer.parseInt(port));

                out = s.getOutputStream();
                out.write(cyber_printdtat);

                s.close();
                out.close();

                return "打印完成";
            }

            if (Cyber_Public_Var.cyber_default_printer_type.equals("sunmiinner")) {

                String orderid_summi = hm.get("summi_printer").toString();
               // sunmifunPrinter(orderid_summi);
                return "打印完成";
            }


            //兼容windows 模式
            //androi 只打印小票
            cyber_printer_USBPrinter usbPrinter = cyber_printer_USBPrinter.getInstance();
            usbPrinter.initPrinter(mContext, true);
            usbPrinter.cyber_initForPrint();
            // usbPrinter.bold(true);

            usbPrinter.setTextSize(3);
            usbPrinter.setAlign(1);
            usbPrinter.bold(true);
            usbPrinter.printTextNewLine(shopname.toString());
            usbPrinter.setAlign(0);
            usbPrinter.setTextSize(0);
            usbPrinter.printLine(1);
            usbPrinter.bold(false);
            String order_today_id = hm.get("today_orderid_store").toString();
            if(order_today_id.length()>0) {
                usbPrinter.printTextNewLine("牌号：" + order_today_id);
            }
            if(order_id.toString().length()>0) {
                usbPrinter.printTextNewLine("单号：" + order_id.toString());
            }
            usbPrinter.printLine(1);

            usbPrinter.printTextNewLine(order_detail.toString());
            //usbPrinter.printTextNewLine("出品员："+"");
            //usbPrinter.printBarCode(orderid_long.toString());
            usbPrinter.printLine(1);
            //	usbPrinter.printBarCode(order_id.toString());
            usbPrinter.printTextNewLine(order_beizhu);
            usbPrinter.printLine(5);


            usbPrinter.cutPager();
            //打开钱箱
            usbPrinter.cyber_openDrawer();
            usbPrinter.close();//关闭打印
            usbPrinter.destroyPrinter();
            //destroyPrinter
            //

        } catch (Exception ex) {
            LogToFile.d("Printer", "打印异常" + ex.getMessage() + ";追踪=" + ex.getStackTrace() + ex.toString());
        }

        return "打印完成";

    }
    public byte[] cyber_create_clientPaper_Net(String printerdata, String report_id) {


        try {

            if (report_id.equals("kitchenv2019") == true) {


                Cyber_XMLSample c_xml = new Cyber_XMLSample();
                HashMap hm = c_xml.split(printerdata);
                Object okey = "order_detail_android";

                Object shopnameKEY = "shopname";
                Object order_idkey = "order_id";

                //orderid
                Object orderidkey_long = "orderid";

                Object order_detail = hm.get(okey);
                Object shopname = hm.get(shopnameKEY);
                Object order_id = hm.get(order_idkey);
                Object orderid_long = hm.get(orderidkey_long);//"91057772201909260911244804565";// hm.get(orderidkey_long);
                String order_beizhu = hm.get("beizhu").toString();


                byte[] next2Line = cyber_printerCmdUtils_net.nextLine(2);
                byte[] title = shopname.toString().getBytes("gb2312");// "出餐单（午餐）**万通中心店".getBytes("gb2312");

                byte[] boldOn = cyber_printerCmdUtils_net.boldOn();
                byte[] fontSize2Big = cyber_printerCmdUtils_net.fontSizeSetBig(3);
                byte[] center = cyber_printerCmdUtils_net.alignCenter();
                byte[] Focus = ("单号：" + order_id.toString()).getBytes("gb2312");
                byte[] boldOff = cyber_printerCmdUtils_net.boldOff();
                byte[] fontSize2Small = cyber_printerCmdUtils_net.fontSizeSetSmall(3);

		/*	byte[] left= cyber_printerCmdUtils_net.alignLeft();
			//byte[] orderSerinum = "订单编号：11234".getBytes("gb2312");
			boldOn = cyber_printerCmdUtils_net.boldOn();
			byte[] fontSize1Big = cyber_printerCmdUtils_net.fontSizeSetBig(2);
			byte[] FocusOrderContent = "韭菜鸡蛋饺子-小份（单）".getBytes("gb2312");
			boldOff = cyber_printerCmdUtils_net.boldOff();
			byte[] fontSize1Small = cyber_printerCmdUtils_net.fontSizeSetSmall(2);
*/
                boldOn = cyber_printerCmdUtils_net.boldOn();
                byte[] fontSize1Big = cyber_printerCmdUtils_net.fontSizeSetBig(2);
                //next2Line = cyber_printerCmdUtils_net.nextLine(2);
                byte[] priceInfo = order_detail.toString().getBytes("gb2312");
                byte[] nextLine = cyber_printerCmdUtils_net.nextLine(1);
                boldOff = cyber_printerCmdUtils_net.boldOff();
                byte[] fontSize1Small = cyber_printerCmdUtils_net.fontSizeSetSmall(2);


                //	byte[] tips_2 = order_beizhu.getBytes("gb2312");

                //	nextLine = cyber_printerCmdUtils_net.nextLine(1);

                byte[] breakPartial = cyber_printerCmdUtils_net.feedPaperCutPartial();


                byte[][] cmdBytes_kit = {
                        title, nextLine,
                        //center, boldOn, fontSize2Big, Focus, boldOff, fontSize2Small, next2Line,
                        center, boldOn, Focus, boldOff, fontSize2Small, next2Line,
                        //nextLine,
                        //center, boldOn, boldOff, nextLine,
                        //next2Line,

                        boldOn,
                        fontSize1Big,// fontSize2Big,

                        priceInfo,
                        boldOff,
                        fontSize1Small,
                        nextLine,
                        next2Line,
                        nextLine,
                        next2Line,
                        center, nextLine,

                        breakPartial
                };
                return cyber_printerCmdUtils_net.byteMerger(cmdBytes_kit);


            }
            else if (report_id.equals("kitchen") == true) {


                Cyber_XMLSample c_xml = new Cyber_XMLSample();
                HashMap hm = c_xml.split(printerdata);
                Object okey = "order_detail_android";

                Object shopnameKEY = "shopname";
                Object order_idkey = "order_id";

                //orderid
                Object orderidkey_long = "orderid";

                Object order_detail = hm.get(okey);
                Object shopname = hm.get(shopnameKEY);
                Object order_id = hm.get(order_idkey);
                Object orderid_long = hm.get(orderidkey_long);//"91057772201909260911244804565";// hm.get(orderidkey_long);
                String order_beizhu = hm.get("beizhu").toString();
                String today_orderid_store= hm.get("today_orderid_store").toString();


                byte[] next2Line = cyber_printerCmdUtils_net.nextLine(2);
                byte[] title = shopname.toString().getBytes("gb2312");// "出餐单（午餐）**万通中心店".getBytes("gb2312");
                byte[] today_orderid = today_orderid_store.toString().getBytes("gb2312");// "出餐单（午餐）**万通中心店".getBytes("gb2312");

                byte[] boldOn = cyber_printerCmdUtils_net.boldOn();
                byte[] fontSize2Big = cyber_printerCmdUtils_net.fontSizeSetBig(3);
                byte[] center = cyber_printerCmdUtils_net.alignCenter();
                byte[] align_left = cyber_printerCmdUtils_net.alignLeft();
                byte[] Focus ="".getBytes("gb2312");
                //("单号：" + order_id.toString()).getBytes("gb2312");
                byte[] boldOff = cyber_printerCmdUtils_net.boldOff();
                byte[] fontSize2Small = cyber_printerCmdUtils_net.fontSizeSetSmall(3);

                boldOn = cyber_printerCmdUtils_net.boldOn();
                byte[] fontSize1Big = cyber_printerCmdUtils_net.fontSizeSetBig(2);

                byte[] priceInfo = order_detail.toString().getBytes("gb2312");

                byte[] print_footer = order_beizhu.toString().getBytes("gb2312");


                byte[] nextLine = cyber_printerCmdUtils_net.nextLine(1);
                boldOff = cyber_printerCmdUtils_net.boldOff();
                byte[] fontSize1Small = cyber_printerCmdUtils_net.fontSizeSetSmall(2);




                byte[] breakPartial = cyber_printerCmdUtils_net.feedPaperCutPartial();


                byte[][] cmdBytes_kit = {
                        title, nextLine,
                        //center, boldOn, fontSize2Big, Focus, boldOff, fontSize2Small, next2Line,
                        center,// boldOn, Focus, boldOff, fontSize2Small, nextLine,//只要1行next2Line,
                        //nextLine,
                        //center, boldOn, boldOff, nextLine,
                        //next2Line,

                        boldOff,//关闭大写
                        fontSize1Big,// fontSize2Big,
                        today_orderid,nextLine,//今日单号换行
                        align_left,//左对齐

                        priceInfo,
                        boldOff,
                        fontSize1Small,
                        align_left,//左对齐
                        print_footer,
                        //
                        nextLine,
                        next2Line,
                        //  nextLine,//删除2行
                        //  next2Line,
                        //   center, nextLine,

                        breakPartial
                };
                return cyber_printerCmdUtils_net.byteMerger(cmdBytes_kit);


            }

            else {


                Cyber_XMLSample c_xml = new Cyber_XMLSample();
                HashMap hm = c_xml.split(printerdata);
                Object okey = "order_detail";

                Object shopnameKEY = "shopname";
                Object order_idkey = "order_id";

                //orderid
                Object orderidkey_long = "orderid";

                Object order_detail = hm.get(okey);
                Object shopname = hm.get(shopnameKEY);
                Object order_id = hm.get(order_idkey);
                Object orderid_long = hm.get(orderidkey_long);//"91057772201909260911244804565";// hm.get(orderidkey_long);
                String order_beizhu = hm.get("beizhu").toString();

                //2020-3-9 餐饮配置，零售订单不行
                String cwpd_print_header = hm.get("print_header").toString();
                String cwpd_print_body = hm.get("print_body").toString();
                String cwpd_print_footer = hm.get("print_footer").toString();


                byte[] next2Line = cyber_printerCmdUtils_net.nextLine(2);
                byte[] title = shopname.toString().getBytes("gb2312");// "出餐单（午餐）**万通中心店".getBytes("gb2312");

                byte[] boldOn = cyber_printerCmdUtils_net.boldOn();
                byte[] fontSize2Big = cyber_printerCmdUtils_net.fontSizeSetBig(3);
                byte[] fontSize1Big = cyber_printerCmdUtils_net.fontSizeSetBig(2);
                byte[] fontSize_80 = cyber_printerCmdUtils_net.fontSize_cwpd_width2x();
                byte[] center = cyber_printerCmdUtils_net.alignCenter();
                byte[] cwpd_left = cyber_printerCmdUtils_net.alignLeft();
                byte[] cwpd_orderidno = ("单号：" + order_id.toString()).getBytes("gb2312");
                byte[] boldOff = cyber_printerCmdUtils_net.boldOff();
                byte[] fontSize2Small = cyber_printerCmdUtils_net.fontSizeSetSmall(3);


                next2Line = cyber_printerCmdUtils_net.nextLine(2);
                byte[] cwpd_order_detail = order_detail.toString().getBytes("gb2312");
                byte[] nextLine = cyber_printerCmdUtils_net.nextLine(1);


                byte[] cwpd_print_headerB = cwpd_print_header.getBytes("gb2312");
                byte[] cwpd_print_bodyB = cwpd_print_body.getBytes("gb2312");
                byte[] cwpd_print_footerB = cwpd_print_footer.getBytes("gb2312");


                nextLine = cyber_printerCmdUtils_net.nextLine(1);
                byte[] cwpd_order_beizhu = order_beizhu.getBytes("gb2312");

                nextLine = cyber_printerCmdUtils_net.nextLine(1);

                byte[] breakPartial = cyber_printerCmdUtils_net.feedPaperCutPartial();


                byte[][] cmdBytes_80 = {
                        boldOn, fontSize1Big,//店名加粗
                        title, nextLine,
                        center, boldOn, fontSize1Big,//单号1倍大小
                        cwpd_orderidno, boldOff, fontSize2Small, next2Line,
                        nextLine,
                        //center, boldOn, boldOff, nextLine,
                        //next2Line,
                        cwpd_left, boldOn,//左对齐
                        //fontSize_80,//2倍高和宽失败
                        fontSize1Big,
                        cwpd_order_detail, nextLine,
                        next2Line, boldOff,
                        nextLine,
                        //next2Line,
                        //字体变小
                        center, fontSize2Small, nextLine,
                        center, cwpd_order_beizhu, nextLine,
                        breakPartial
                };

                byte[][] cmdBytes_80zbody = {
                        boldOn, fontSize1Big,//店名加粗
                        title, nextLine,
                        center, boldOn, fontSize1Big,//单号1倍大小
                        cwpd_orderidno, boldOff, fontSize2Small, next2Line,
                        nextLine,
                        //center, boldOn, boldOff, nextLine,
                        //next2Line,
                        cwpd_left, boldOn,//左对齐
                        //fontSize_80,//2倍高和宽失败
                        cwpd_print_headerB,
                        nextLine,//换行
                        cwpd_left, boldOn,//左对齐

                        fontSize1Big,
                        cwpd_print_bodyB, nextLine,
                        next2Line, boldOff,
                        cwpd_left, fontSize2Small,//左对齐
                        nextLine,
                        cwpd_print_footerB,

                        //next2Line,
                        //字体变小
                        center, fontSize2Small, nextLine,
                        center, cwpd_order_beizhu, nextLine,
                        breakPartial
                };

                byte[][] cmdBytes_58 = {
                        boldOn, fontSize1Big,//店名加粗
                        title, nextLine,
                        center, boldOn, fontSize1Big,//单号1倍大小
                        cwpd_orderidno, boldOff, fontSize2Small, next2Line,
                        nextLine,
                        //center, boldOn, boldOff, nextLine,
                        //next2Line,
                        cwpd_left, boldOn,//左对齐
                        //fontSize_80,//2倍高和宽失败
                        //fontSize1Big,不放大信息
                        cwpd_order_detail, nextLine,
                        next2Line, boldOff,
                        nextLine,
                        //next2Line,
                        //字体变小
                        center, fontSize2Small, nextLine,
                        center, cwpd_order_beizhu, nextLine,
                        breakPartial
                };

                if (Cyber_Public_Var.cyber_default_printer_report_width.equals("80") == true) {
                    return cyber_printerCmdUtils_net.byteMerger(cmdBytes_80);
                }

                if (Cyber_Public_Var.cyber_default_printer_report_width.equals("80zbody") == true) {
                    return cyber_printerCmdUtils_net.byteMerger(cmdBytes_80zbody);
                }

                if (Cyber_Public_Var.cyber_default_printer_report_width.equals("58") == true) {
                    return cyber_printerCmdUtils_net.byteMerger(cmdBytes_58);
                }

                //80zbody
                return cyber_printerCmdUtils_net.byteMerger(cmdBytes_58);
            }


        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;


    }

    @JavascriptInterface
    public String wlzc_softhost_control( String action,String password) {
        if(action.equals("hideleftmenu")==true){


            new Thread(new Runnable() {
                @Override
                public void run() {
                    // 这里编写线程执行的任务
                    cyber_cpu_main.未来之窗_左侧工具栏_隐藏();
                }
            }).start();
            return "隐藏设置";
        }
        if(action.equals("hideleftmenuV2")==true){


            new Thread(new Runnable() {
                @Override
                public void run() {
                    // 这里编写线程执行的任务
                    Cyber_Public_Var.m_cpu.未来之窗_左侧工具栏_隐藏();
                }
            }).start();
            return "隐藏设置v2";
        }
        if(action.equals("hideleftmenuV3")==true){
   try {
           LinearLayout 未来之窗工具栏目 = Cyber_Public_Var.m_cpu.findViewById(R.id.cyberwin_ly_toolbars);
           LinearLayout.LayoutParams 未来之窗工具栏目params = (LinearLayout.LayoutParams) 未来之窗工具栏目.getLayoutParams();
               //设置宽度值
           未来之窗工具栏目params.width = dip2px(Cyber_Public_Var.m_cpu, 18);
           未来之窗工具栏目.setLayoutParams(未来之窗工具栏目params);

           }catch (Exception ex){
              return "隐藏设置v3"+ex.getMessage();
          }catch (UnknownError ex2) {
                // 处理视图未找到的异常
                Log.e("LayoutException", "View not found");
                 return "隐藏设置v3"+ex2.getMessage();
            }


            return "隐藏设置v3";
        }
        //
        if(action.equals("hideleftmenuV5")==true){
            try {
                //Cyber_Public_Var.m_cpu
               // FullscreenActivity
                cyber_cpu_main.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        LinearLayout 未来之窗工具栏目 = Cyber_Public_Var.m_cpu.findViewById(R.id.cyberwin_ly_toolbars);
                        LinearLayout.LayoutParams 未来之窗工具栏目params = (LinearLayout.LayoutParams) 未来之窗工具栏目.getLayoutParams();
                        //设置宽度值
                        未来之窗工具栏目params.width = dip2px(Cyber_Public_Var.m_cpu, 18);
                        未来之窗工具栏目.setLayoutParams(未来之窗工具栏目params);
                    }
                });


            }catch (Exception ex){
                return "隐藏设置v3"+ex.getMessage();
            }catch (UnknownError ex2) {
                // 处理视图未找到的异常
                Log.e("LayoutException", "View not found");
                return "隐藏设置v3"+ex2.getMessage();
            }


            return "隐藏设置v5";
        }

        if(action.equals("hidesysmenu")==true){
            try {

                cyber_cpu_main.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                       // LinearLayout 未来之窗工具栏目 = Cyber_Public_Var.m_cpu.findViewById(R.id.cyberwin_ly_toolbars);
                      //  LinearLayout.LayoutParams 未来之窗工具栏目params = (LinearLayout.LayoutParams) 未来之窗工具栏目.getLayoutParams();
                        //设置宽度值
                       // 未来之窗工具栏目params.width = dip2px(Cyber_Public_Var.m_cpu, 18);
                      //  未来之窗工具栏目.setLayoutParams(未来之窗工具栏目params);
                        // 获取当前窗口对象
                        Window window = Cyber_Public_Var.m_cpu.getWindow();

// 隐藏状态栏
                        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

// 隐藏导航栏
                        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

                           }
                });


            }catch (Exception ex){
                return "隐藏设置v3"+ex.getMessage();
            }catch (UnknownError ex2) {
                // 处理视图未找到的异常
                Log.e("LayoutException", "View not found");
                return "隐藏设置v3"+ex2.getMessage();
            }


            return "隐藏设置v5";
        }

        if(action.equals("showleftmenu")==true){


            cyber_cpu_main.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    // 这里编写线程执行的任务
                    cyber_cpu_main.未来之窗_左侧工具栏_展开();
                }
              });
            return "显示d设置";
        }

        if(action.equals("setleftmenuV5")==true){
            try {
                float 左侧宽度 = Float.parseFloat(password);
                cyber_cpu_main.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        LinearLayout 未来之窗工具栏目 = Cyber_Public_Var.m_cpu.findViewById(R.id.cyberwin_ly_toolbars);
                        LinearLayout.LayoutParams 未来之窗工具栏目params = (LinearLayout.LayoutParams) 未来之窗工具栏目.getLayoutParams();
                        //设置宽度值
                        未来之窗工具栏目params.width = dip2px(Cyber_Public_Var.m_cpu, 左侧宽度);
                        未来之窗工具栏目.setLayoutParams(未来之窗工具栏目params);
                    }
                });


            }catch (Exception ex){
                return "隐藏设置v3"+ex.getMessage();
            }catch (UnknownError ex2) {
                // 处理视图未找到的异常
                Log.e("LayoutException", "View not found");
                return "隐藏设置v3"+ex2.getMessage();
            }


            return "隐藏设置v5";
        }

        //屏幕方向

        if(action.equals("setscreentorientationv5")==true){
            try {
                //float 左侧宽度 = Float.parseFloat(password);
                cyber_cpu_main.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                       // LinearLayout 未来之窗工具栏目 = Cyber_Public_Var.m_cpu.findViewById(R.id.cyberwin_ly_toolbars);
                        //LinearLayout.LayoutParams 未来之窗工具栏目params = (LinearLayout.LayoutParams) 未来之窗工具栏目.getLayoutParams();
                        //设置宽度值
                      //  未来之窗工具栏目params.width = dip2px(Cyber_Public_Var.m_cpu, 左侧宽度);
                        //未来之窗工具栏目.setLayoutParams(未来之窗工具栏目params);
                        //
                        if(password.equals("水平")){
                            cyber_cpu_main.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                            //setRequestedOrientation
                        }
                        if(password.equals("垂直")){

                            cyber_cpu_main.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

                        }
                        if(password.equals("传感器")){

                            cyber_cpu_main.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);

                        }
                    }
                });


            }catch (Exception ex){
                return "隐藏设置v3"+ex.getMessage();
            }catch (UnknownError ex2) {
                // 处理视图未找到的异常
                Log.e("LayoutException", "View not found");
                return "隐藏设置v3"+ex2.getMessage();
            }


            return "设置方向";
        }





        return "错误命令";


    }



    /**
     * dp转为px
     *
     * @param context  上下文
     * @param dipValue dp值
     * @return
     */
    private int dip2px(Context context, float dipValue) {
        Resources r = context.getResources();
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dipValue, r.getDisplayMetrics());
    }

    //2024-12-03
    public void cyber_init_tts() {
        tts = new TextToSpeech(mContext, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = tts.setLanguage(Locale.CHINA);
                    if (result != TextToSpeech.LANG_COUNTRY_AVAILABLE && result != TextToSpeech.LANG_AVAILABLE) {
                        Toast.makeText(mContext, "TTS不支持", Toast.LENGTH_SHORT).show();
                        LogToFile.d_windows("TTS","TTS","TTS不支持");

                    }
                }
            }
        });
    }

    //
    //2024-12-03
    @JavascriptInterface
    public void cyber_downfile_forsmartscreen(String  downurl,String foldername,String uid,String filename,String filetype) {
       //String filenamewithext
        String CyberWinPHP_Path=  Cyber_Public_Var.CyberWin_智能屏幕路径;
        //   ,mContext);

        String url_md5= uid+"_"+Cyber_Public_Var.cyber_md5(filename);
        String url_type=filetype;//"html";

        String file_cache_path = CyberWinPHP_Path+"/"+foldername;//Cyber_Public_Var.cyber_getFilePath(ApplicationBrowserActivity.this) + "/CyberCache/";
        String file_cache_path_onename = url_md5 + "." + url_type;

         new Thread(new Runnable() {
            @Override
            public void run() {
                // 这里编写线程执行的任务
                //多线程处理
                Cyber_Public_Var.cyber_downloadFile1(downurl, file_cache_path, file_cache_path_onename);

            }
        }).start();
      //  return file_cache_path+file_cache_path_onename;
    }


    @JavascriptInterface
    public String cyberWin_Device_AIOT_Monitor( String action,String param) {
        if (action.equals("测试吐卡") == true) {
/*
            m_cpu.runOnUiThread(new Runnable() {
                @Override
                public void run() {


                   // String 测试结果=  CyberWin_Tickets_Device.东方仙盟_测试出卡();
                   // return "测试吐卡"+测试结果;
                }
            });
            */
            /*
            String 未来之窗ret="";
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

             */

            CyberWin_spirits_SerialPortSenderHex sender = new CyberWin_spirits_SerialPortSenderHex();
            sender.init("/dev/ttyS0");
            sender.sendHexCommand("0A09020103CC5F");  // 发送 16 进制数据
            sender.release();

            String 未来之窗ret=  "";//CyberWin_Tickets_Device.东方仙盟_测试出卡();
            return "测试吐卡"+未来之窗ret;
        }
        if (action.equals("测试吐卡V2") == true) {
            CyberWin_spirits_ssttclientDevice.东方仙盟_冥界_传送("/dev/ttyS0",115200,"0A 09 02 01 03 CC 5F");
            String 未来之窗ret=  "";//CyberWin_Tickets_Device.东方仙盟_测试出卡();
            return "测试吐卡V2"+未来之窗ret;
        }


        if (action.equals("spiritsssttclient") == true) {
            //CyberWinApp_Protocol_Package_raw
            try {
                HashMap<String, String> 未来之窗解码 = Cyber_Public_Function.CyberWinApp_Protocol_unPackage(param);
                String 地址 = 未来之窗解码.get("device_address");
                String 波特率 = 未来之窗解码.get("device_baudrate");
                String 命令 = 未来之窗解码.get("device_command");
                Integer 波特率i = Integer.valueOf(波特率);
                //  CyberWin_spirits_ssttclientDevice.东方仙盟_冥界_传送(地址,波特率i,命令);
                CyberWin_spirits_ssttclientDevice.东方仙盟_冥界_传送(地址, 波特率i, 命令);

                return "专用指令"+命令;
            }catch(Exception ex){
                return "专用指令错误"+"param="+param+ex.getMessage()+ex.getStackTrace()+ex.toString()+ex.getLocalizedMessage();
            }


            //return "专用指令--unk";
           /*
            CyberWin_spirits_SerialPortSenderHex sender = new CyberWin_spirits_SerialPortSenderHex();
            sender.init(地址);
            sender.sendHexCommand(命令);  // 发送 16 进制数据
            sender.release();
            */

        }
        return "反向传送";

        }




    }