package CyberWinPHP.Cyber_CPU;


import android.Manifest;
import android.app.Application;
import android.content.Context;

//import android.support.v7.appcompat.*;



import android.util.DisplayMetrics;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.ynwlzc.framework.cyberwinosand_ScreenDisplay.FullscreenActivity;


//import cyberWin.NET.ApplicationBrowserActivity;

/**
 * Used 自定义Application【系统上下文】
 */
public class MyApplication extends Application{

    /**系统上下文*/
    private static Context mAppContext;

    public  static FullscreenActivity m_cpu=null;

    public  static int cyber_ScreenWidth=0;


    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext = getApplicationContext();

    }

    /**获取系统上下文：用于ToastUtil类*/
    public static Context getAppContext()
    {
        return mAppContext;
    }


    /**获取系统上下文：用于ToastUtil类*/
    public static Context getContext()
    {
        return mAppContext;
    }

    public static void cyber_getPer_Ca(){
		/*

		if (!ActivityCompat.shouldShowRequestPermissionRationale(mAppContext, Manifest.permission.CAMERA)){
			ActivityCompat.requestPermissions(mAppContext, new String[]{Manifest.permission.CAMERA},0);
		}

		*/



    }

    public  static void showToast(String str) {
        Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
    }


    public static void closePopupWindow(PopupWindow pw) {
        if (pw != null && pw.isShowing()) {
            pw.dismiss();
            pw = null;
        }
    }

    public int getScreenWidth() {

        return MyApplication.cyber_ScreenWidth;
    }


}
