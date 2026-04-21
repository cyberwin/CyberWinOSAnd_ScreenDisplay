package CyberWinPHP.Cyber_Plus;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.webkit.JavascriptInterface;

import androidx.core.app.ActivityCompat;

import com.ynwlzc.framework.cyberwinosand_ScreenDisplay.FullscreenActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Cyber_JsVOS_Studio {
    private static Context mContext;





    private FullscreenActivity cyber_cpu_main;
    public Cyber_JsVOS_Studio(FullscreenActivity _cyber_cpu_main, Context context) {
        cyber_cpu_main = _cyber_cpu_main;
        mContext = context;
    }

    @JavascriptInterface
    public  String fileManager_listDisks_old() {
        // 检查外部存储是否可用
        String externalPath="";
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
              externalPath = Environment.getExternalStorageDirectory().getPath();
           // Log.d("DiskInfo", "外部存储路径: " + externalPath);

            StatFs externalStatFs = new StatFs(externalPath);
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
                long totalBlocks = externalStatFs.getBlockCountLong();
                long availableBlocks = externalStatFs.getAvailableBlocksLong();
                long blockSize = externalStatFs.getBlockSizeLong();
            }


            // Log.d("DiskInfo", "外部存储总大小: " + totalBlocks * blockSize / (1024 * 1024) + " MB");
           // Log.d("DiskInfo", "外部存储可用大小: " + availableBlocks * blockSize / (1024 * 1024) + " MB");
        }

        // 内部存储
        String internalPath = Environment.getDataDirectory().getPath();
       // Log.d("DiskInfo", "内部存储路径: " + internalPath);

        StatFs internalStatFs = new StatFs(internalPath);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
            long totalBlocksInternal = internalStatFs.getBlockCountLong();
            long availableBlocksInternal = internalStatFs.getAvailableBlocksLong();
            long blockSizeInternal = internalStatFs.getBlockSizeLong();

        }

       // Log.d("DiskInfo", "内部存储总大小: " + totalBlocksInternal * blockSizeInternal / (1024 * 1024) + " MB");
        //Log.d("DiskInfo", "内部存储可用大小: " + availableBlocksInternal * blockSizeInternal / (1024 * 1024) + " MB");
        String 未来之窗RET;
        未来之窗RET ="{0:{\"phone_root\":\""+internalPath+"\"},1:{\"sdcard\":\""+externalPath+"\"}}";
        return 未来之窗RET;
    }
    @JavascriptInterface
    public  String fileManager_listFilesAndFolders( String folderPath) {
       // mContext
        String 未来之窗RET="{";
        Integer 文件数量=0;
        Integer 文件夹数量=0;
        String 未来之窗RET_文件="{";
        String 未来之窗RET_文件夹="{";
        File file = new File(folderPath);
        if (file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();
            if (files!= null) {
                for (File f : files) {
                    if (f.isDirectory()) {
                       // Log.d("Folder", f.getName());

                        String 未来之窗one=文件夹数量+":{\"type\":\"folder\",\"path\":\""+ f.getName()+"\"}";
                        文件夹数量 = 文件夹数量+1;
                        未来之窗RET_文件夹 = 未来之窗RET_文件夹 + 未来之窗one+",";
                    } else {
                       // Log.d("File", f.getName());
                        String 未来之窗onefile=文件数量+":{\"type\":\"file\",\"path\":\""+ f.getName()+"\"}";
                        文件数量 = 文件数量+1;
                        未来之窗RET_文件 = 未来之窗RET_文件 + 未来之窗onefile+",";
                    }
                }
            }
        }

        未来之窗RET_文件夹 = 未来之窗RET_文件夹 + "last:0}";
        未来之窗RET_文件 = 未来之窗RET_文件 + "last:0}";


       // 未来之窗RET ="{0:{\"phone_root\":\""+internalPath+"\"},1:{\"sdcard\":\""+externalPath+"\"}}";
        未来之窗RET = 未来之窗RET+"\"folder_list\":"+未来之窗RET_文件夹+"}";
        未来之窗RET = 未来之窗RET+",\"file_list\":"+未来之窗RET_文件+"}";

        未来之窗RET = 未来之窗RET+"}";
        return 未来之窗RET;
    }


    @JavascriptInterface
    public String fileManager_listDisks() {
        JSONArray disks = new JSONArray();
        // 检查外部存储是否可用
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            String externalPath = Environment.getExternalStorageDirectory().getPath();
            JSONObject externalDisk = new JSONObject();
            try {
                externalDisk.put("name", "外部存储");
                externalDisk.put("path", externalPath);

                StatFs externalStatFs = new StatFs(externalPath);
                long totalBlocks = 0;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
                    totalBlocks = externalStatFs.getBlockCountLong();
                    long availableBlocks = externalStatFs.getAvailableBlocksLong();
                    long blockSize = externalStatFs.getBlockSizeLong();
                    externalDisk.put("totalSize", totalBlocks * blockSize / (1024 * 1024));
                    externalDisk.put("availableSize", availableBlocks * blockSize / (1024 * 1024));
                }



            } catch (JSONException e) {
                e.printStackTrace();
            }
            disks.put(externalDisk);
        }

        // 内部存储
        String internalPath = Environment.getDataDirectory().getPath();
        JSONObject internalDisk = new JSONObject();
        try {
            internalDisk.put("name", "内部存储");
            internalDisk.put("path", internalPath);

            StatFs internalStatFs = new StatFs(internalPath);
            long totalBlocksInternal = 0;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
                totalBlocksInternal = internalStatFs.getBlockCountLong();
                long availableBlocksInternal = internalStatFs.getAvailableBlocksLong();
                long blockSizeInternal = internalStatFs.getBlockSizeLong();

                internalDisk.put("totalSize", totalBlocksInternal * blockSizeInternal / (1024 * 1024));
                internalDisk.put("availableSize", availableBlocksInternal * blockSizeInternal / (1024 * 1024));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        disks.put(internalDisk);

        return disks.toString();
    }

    @JavascriptInterface
    public String fileManager_FolderList(String folderPath) {
        //检测文件管理权限
        未来之窗_人工智能_存储_权限_文件系统();

        JSONArray jsonArray = new JSONArray();
        File file = new File(folderPath);
        if (file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();
            if (files!= null) {
                for (File f : files) {
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("name", f.getName());
                        jsonObject.put("isDirectory", f.isDirectory());
                        if(f.isDirectory()==true) {
                            jsonObject.put("type", "folder");
                        }
                        if(f.isFile()==true){
                            jsonObject.put("type", "file");
                        }
                        jsonObject.put("path", f.getPath());
                        jsonObject.put("fullpath", f.getAbsolutePath());

                        jsonArray.put(jsonObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return "错误"+e.getMessage();
                    }
                }
            }
        }
        return jsonArray.toString();
    }



    @JavascriptInterface
    public String fileManager_open(String filePath) throws FileNotFoundException {
        StringBuilder content = new StringBuilder();

            File file_原始 = new File(filePath);
            if (file_原始.exists() && file_原始.canRead()) {
               // BufferedReader reader = new BufferedReader(new FileReader(file));
                try {
                    File file = new File(filePath);
                    if (file.exists() && file.canRead()) {
                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        String line;
                        while ((line = reader.readLine()) != null) {
                            content.append(line).append("\n");
                        }
                        reader.close();
                    } else {
                        return "文件不存在或无法读取";
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return "读取文件时出错";
                }
                return content.toString();
            }else{
                return "文件不可读";
            }

    }

    @JavascriptInterface
    public String fileManager_saveFile(String data, String fileName) {
        未来之窗_人工智能_存储_权限_写入();
        try {
          //  FileOutputStream outputStream = mContext.openFileOutput(fileName, Context.MODE_PRIVATE);
            //FileOutputStream outputStream = mContext.openFileOutput(fileName, Context.MODE_WORLD_WRITEABLE);
            FileOutputStream 未来之窗fos = new FileOutputStream(fileName);

           // outputStream.write(data.getBytes());
           // outputStream.close();

            未来之窗fos.write(data.getBytes());
            未来之窗fos.close();
            return "保存成功";
        } catch (IOException e) {
          //  e.printStackTrace();
            return "保存失败"+e.getMessage();
        }
    }

    @JavascriptInterface
    public String fileManager_createFolder(String folderName) {
        //File folder = new File(mContext.getFilesDir(), folderName);
        File folder = new File( folderName);
        if (!folder.exists()) {
           // boolean success = folder.mkdir();
            boolean success = folder.mkdirs();
            if (success) {
                // 可以在这里根据需要进行后续处理，比如通知 WebView 新建成功
                return "创建成功";
            } else {
                // 处理新建失败的情况
                return "创建失败";
            }
        }else{
            return "已经存在";
        }
    }

    @JavascriptInterface
    public String fileManager_createFile(String fileName) {
        try {
           // File file = new File(mContext.getFilesDir(), fileName);
            //MODE_WORLD_WRITEABLE
           // File file = new File(fileName);
           // FileOutputStream outputStream = new FileOutputStream(file);
            //未来之窗2024-09-15
            FileOutputStream 未来之窗fos = new FileOutputStream(fileName);
            未来之窗fos.close();
            //outputStream.close();
            //
            return "创建成功";
        } catch (IOException e) {
           // e.printStackTrace();
            return "创建失败"+e.getMessage();

        }
        //return "创建失败";
    }



    ////////////


    public static String listFilesAndFoldersAsJson(Context context, String folderPath) {
        File file = new File(folderPath);
        if (file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();
            if (files!= null) {
                JSONArray jsonArray = new JSONArray();
                for (File f : files) {
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("name", f.getName());
                        jsonObject.put("isDirectory", f.isDirectory());
                        jsonArray.put(jsonObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                return jsonArray.toString();
            }
        }
        return "{}";
    }

//未来之窗_人工智能_前端口_数据渲染到界面
   private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.MANAGE_EXTERNAL_STORAGE
    };
    private static final int REQUEST_EXTERNAL_MANAGE = 2;
    //verifyStoragePermissions
    // public void 未来之窗_人工智能_存储_权限(Activity activity) {
    //cyber_cpu_main
    public void 未来之窗_人工智能_存储_权限_写入() {
        // 检查是否已经拥有权限

        //mContext
        int permission = ActivityCompat.checkSelfPermission(cyber_cpu_main, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // 没有权限，请求权限
            ActivityCompat.requestPermissions(
                    cyber_cpu_main,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE

            );
        }
    }
    public void 未来之窗_人工智能_存储_权限_文件管理() {
        // 检查是否已经拥有权限

        //mContext
        int permission = ActivityCompat.checkSelfPermission(cyber_cpu_main, Manifest.permission.MANAGE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // 没有权限，请求权限
            ActivityCompat.requestPermissions(
                    cyber_cpu_main,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_MANAGE


            );
        }
    }

    public void 未来之窗_人工智能_存储_权限_文件系统() {
        // 检查是否已经拥有权限

        //mContext
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (!Environment.isExternalStorageManager()) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                Uri uri = Uri.fromParts("package", mContext.getPackageName(), null);
                intent.setData(uri);
                mContext.startActivity(intent);
            }
        }
    }


}
