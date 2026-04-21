package CyberWinPHP.SmartScreen;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;

import CyberWinPHP.Cyber_CPU.Cyber_Public_Var;
import CyberWinPHP.Cyber_Plus.LogToFile;

public class CyberWin_Smart_CommonFunction {

    public static String 东方仙盟_系统_获取根目录(){
        File root = Environment.getRootDirectory();
        String rootPath = root.getAbsolutePath();

        LogToFile.d_windows("智慧大屏幕","智慧大屏幕", "根目录't start server" +rootPath);
//getExternalStorageDirectory
        String rootDirectory = Environment.getExternalStorageDirectory().getAbsolutePath();
        System.out.println("文件夹根目录: " + rootDirectory);
        LogToFile.d_windows("智慧大屏幕","智慧大屏幕","文件夹根目录"+ rootDirectory);

        File sdDir = null;
        boolean sdCardExist = Environment.getExternalStorageState()
                .equals(android.os.Environment.MEDIA_MOUNTED);//判断sd卡是否存在
        if (sdCardExist) {
            sdDir = Environment.getExternalStorageDirectory();//获取跟目录
        }
      //  String 文件夹根目录 = Environment.getExternalStorageDirectory();

      // LogToFile.d_windows("智慧大屏幕","智慧大屏幕","文件夹根目录"+ 文件夹根目录);


        return rootDirectory ;
    }

    /**
     * 获得文件存储路径
     *
     * @return
     */
    public static String 获取程序运行目录() {
        Context context =Cyber_Public_Var.m_cpu;
        if (Environment.MEDIA_MOUNTED.equals(Environment.MEDIA_MOUNTED) || !Environment.isExternalStorageRemovable()) {//如果外部储存可用
            return context.getExternalFilesDir(null).getPath();//获得外部存储路径,默认路径为 /storage/emulated/0/Android/data/com.waka.workspace.logtofile/files/Logs/log_2016-03-14_16-15-09.log
        } else {
            return context.getFilesDir().getPath();//直接存在/data/data里，非root手机是看不到的
        }
    }

    public static void 东方仙盟_系统_创建多级目录(String folderPath) {


        File file = new File(folderPath);
        if (!file.exists()) {
            if (file.mkdirs()) {
                System.out.println("多级文件夹创建成功");
                LogToFile.d_windows("智慧大屏幕","智慧大屏幕", "多级文件夹创建成功" +folderPath);
            } else {
                System.out.println("多级文件夹创建失败");
                LogToFile.d_windows("智慧大屏幕","智慧大屏幕", "多级文件夹创建失败" +folderPath);

            }
        } else {
            System.out.println("文件夹已存在");
            LogToFile.d_windows("智慧大屏幕","智慧大屏幕", "文件夹已存在" +folderPath);

        }
    }
    public static void 东方仙盟_智慧大屏幕_检测资源目录() {
        // 获取根目录
        String 智慧根目录 =  东方仙盟_系统_获取根目录()+"/CyberWin/";
        智慧根目录 = 获取程序运行目录()+"/CyberWin/";
        File 未来之窗微app根目录dir = new File(智慧根目录);
        if (未来之窗微app根目录dir.exists()==false) {
            未来之窗微app根目录dir.mkdir();
        }

        String 智慧根目录2 =  东方仙盟_系统_获取根目录()+"/CyberWin/smartscreen/";
        File 未来之窗微app根目录dir2 = new File(智慧根目录2);
        if (未来之窗微app根目录dir2.exists()==false) {
            未来之窗微app根目录dir2.mkdir();
        }

        东方仙盟_系统_创建多级目录(Cyber_Public_Var.CyberWin_智能屏幕路径);
        东方仙盟_系统_创建多级目录(Cyber_Public_Var.CyberWin_智能屏幕路径+"files");
        东方仙盟_系统_创建多级目录(Cyber_Public_Var.CyberWin_智能屏幕路径+"template");
        东方仙盟_系统_创建多级目录(Cyber_Public_Var.CyberWin_智能屏幕路径+"db");
        东方仙盟_系统_创建多级目录(Cyber_Public_Var.CyberWin_智能屏幕路径+"config");
        //files
        // 要创建的文件夹名称

    }

    //StartLocalServer

    public static String 东方仙盟_系统_获取扩展名(String filePath) {
        String extension = "";
        int dotIndex = filePath.lastIndexOf('.');
        if (dotIndex > 0 && dotIndex < filePath.length() - 1) {
            extension = filePath.substring(dotIndex + 1);
        }
        return extension;
    }

}
