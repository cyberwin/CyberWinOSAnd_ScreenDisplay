package CyberWinPHP.Cyber_System;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ynwlzc.framework.cyberwinosand_ScreenDisplay.FullscreenActivity;
import com.ynwlzc.framework.cyberwinosand_ScreenDisplay.R;

import CyberWinPHP.Cyber_CPU.Cyber_Public_Var;
import CyberWinPHP.Cyber_Plus.LogToFile;

public class BootBroadcastReceiver extends BroadcastReceiver {
    static final String action_boot="android.intent.action.BOOT_COMPLETED";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(action_boot)){

            Intent ootStartIntent=new Intent(context, FullscreenActivity.class);
            ootStartIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(ootStartIntent);

        }
        String 东方令牌 = intent.getAction();
        //2024-12-14
        if (UsbManager.ACTION_USB_DEVICE_ATTACHED.equals(东方令牌)) {
            // USB 设备插入
/*
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // 这里编写线程执行的任务
                    try {
                        Cyber_Public_Var.m_cpu.东方仙盟_冥界_传送阵("device_usb_attached", "USB接入");
                    }catch (Exception ex){
                        //Toast.makeText(Cyber_Public_Var.cyber_main_instance, "关联启动"+ex.getMessage(),3000);
                        LogToFile.d_windows("冥界","传送阵", "启动失败Couldn't start server" + ex.getMessage());

                    }
                    }
            }).start();
            */
            Cyber_Public_Var.m_cpu.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Cyber_Public_Var.m_cpu.东方仙盟_冥界_传送阵("device_usb_attached", "USB接入");

                    // LinearLayout 未来之窗工具栏目 = Cyber_Public_Var.m_cpu.findViewById(R.id.cyberwin_ly_toolbars);
                    // LinearLayout.LayoutParams 未来之窗工具栏目params = (LinearLayout.LayoutParams) 未来之窗工具栏目.getLayoutParams();
                    //设置宽度值
                    // 未来之窗工具栏目params.width = dip2px(Cyber_Public_Var.m_cpu, 18);
                    // 未来之窗工具栏目.setLayoutParams(未来之窗工具栏目params);
                }
            });
        } else if (UsbManager.ACTION_USB_DEVICE_DETACHED.equals(东方令牌)) {
            // USB 设备拔出


            Cyber_Public_Var.m_cpu.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Cyber_Public_Var.m_cpu.东方仙盟_冥界_传送阵("device_usb_detached","USB拔出");

                    // LinearLayout 未来之窗工具栏目 = Cyber_Public_Var.m_cpu.findViewById(R.id.cyberwin_ly_toolbars);
                    // LinearLayout.LayoutParams 未来之窗工具栏目params = (LinearLayout.LayoutParams) 未来之窗工具栏目.getLayoutParams();
                    //设置宽度值
                    // 未来之窗工具栏目params.width = dip2px(Cyber_Public_Var.m_cpu, 18);
                    // 未来之窗工具栏目.setLayoutParams(未来之窗工具栏目params);
                }
            });
        }

    }

}
