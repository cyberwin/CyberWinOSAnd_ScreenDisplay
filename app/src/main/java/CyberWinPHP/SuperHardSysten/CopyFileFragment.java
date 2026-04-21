package CyberWinPHP.SuperHardSysten;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.storage.StorageManager;
//import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

//import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
//import com.vs.tool.Tool;
//import com.zcadc.util.CommonData;
//import com.zcadc.util.ProgramUtil;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CopyFileFragment extends DialogFragment {
    static String Usbpath = "";



    long cancelTime = 11L;

    protected Context context;

    protected Handler handler = new Handler();

    int impDir = 0;

    int j = 0;

    OnCopyFile listener;

    int option = 1;

    ProgressDialog pDialog = null;

    int type = 0;

    List<String> usbFiles;

    List<String> usbPaths;

    RadioGroup usbimportGroup;
/*
    public static boolean checkMounted(Context paramContext, String paramString) {
        if (paramString == null)
            return false;
        //StorageManager storageManager = (StorageManager)paramContext.getSystemService("storage");
        try {
           // return "mounted".equals(storageManager.getClass().getMethod("getVolumeState", new Class[] { String.class }).invoke(storageManager, new Object[] { paramString }));
        } catch (Exception exception) {
           // ThrowableExtension.printStackTrace(exception);
            return false;
        }
    }
    */

    public static boolean createFolder(String paramString) {
        boolean bool = false;
        File file = new File(paramString);
        if (!file.exists())
            bool = file.mkdirs();
        return bool;
    }

    public static Boolean createUsbFolder(Context paramContext, String paramString) {
        int i = 0;
        File file = new File(paramString);
        if (file.isDirectory()) {
            if (!file.exists()) {
                file.mkdirs();
                return Boolean.valueOf(false);
            }
        } else {
            return Boolean.valueOf(false);
        }
        if (createFolder(paramString + "/" + "files")) {
            createFolder(paramString + "/" + "files" + "/" + "屏幕" + "1");
            createFolder(paramString + "/" + "files" + "/" + "屏幕" + "2");
            createFolder(paramString + "/" +"files" + "/" +"屏幕" + "3");
            createFolder(paramString + "/" + "files" + "/" + "屏幕" + "4");
            createFolder(paramString + "/" +"files" + "/" + "副屏");
            createFolder(paramString + "/" + "files" + "/" + "音乐");
            createFolder(paramString + "/" + "files" + "/" + "字幕");
           // Toast.makeText(paramContext, paramContext.getString(2131624251) + ":" + paramContext.getString(2131624023), 0).show();
            return Boolean.valueOf(true);
        }
        File[] arrayOfFile = file.listFiles();
        int j = arrayOfFile.length;
        while (true) {
            if (i < j) {
                file = arrayOfFile[i];
                if (file.isDirectory() && createUsbFolder(paramContext, file.getAbsolutePath()).booleanValue())
                    return Boolean.valueOf(true);
                i++;
                continue;
            }
            return Boolean.valueOf(false);
        }
    }

    private static void createUsbProgramPath(Context paramContext) {
        Iterator<String> iterator = getAllUsbMountedPaths(paramContext).iterator();
        do {

        } while (iterator.hasNext() && !createUsbFolder(paramContext, iterator.next()).booleanValue());
    }

    public static List<String> getAllMountedPaths(Context paramContext) {
        return getVolumePaths(paramContext);
    }

    public static List<String> getAllUsbAloneFile(Context paramContext) {
        ArrayList<String> arrayList = new ArrayList();
       // Usbpath = getProgramPath(paramContext, paramContext.getString(2131624023));
       // Log.v("getAllUsbAloneFile", "Usbpath:" + Usbpath);
       // if (!Usbpath.equals(""))
       //     arrayList.addAll(ProgramUtil.getAllFileNameFromFolder(Usbpath, true));
        return arrayList;
    }

    public static List<String> getAllUsbMountedPaths(Context paramContext) {
        List<String> list = getUsbMountedPaths(paramContext);
        ArrayList<String> arrayList = new ArrayList();
        for (String str : list) {
          //  if (checkMounted(paramContext, str))
            //    arrayList.add(str);
        }
        return getUsbMountedPaths(paramContext);
    }

    public static List<String> getAllUsbs(Context paramContext) {
        ArrayList<String> arrayList = new ArrayList();
        for (String str : getAllUsbMountedPaths(paramContext)) {
            if (ProgramUtil.getAllFileNameFromFolder(str + "/UsbProgram", true).size() > 0)
                arrayList.add(str);
        }
        return arrayList;
    }

    public static ArrayList<String> getAloneMusciFile(Context paramContext) {
        ArrayList<String> arrayList = new ArrayList();
      //  Usbpath = CommonData.playDir;
       // if (!Usbpath.equals(""))
         //   arrayList.addAll(ProgramUtil.getAllFileNameFromFolder(Usbpath + "/" + paramContext.getString(2131624241), true));
        return arrayList;
    }

    public static ArrayList<String> getAloneSubScreenFile(Context paramContext) {
        ArrayList<String> arrayList = new ArrayList();
     //  Usbpath = CommonData.playDir;
       // if (!Usbpath.equals(""))
           // arrayList.addAll(ProgramUtil.getAllFileNameFromFolder(Usbpath + "/" + paramContext.getString(2131624429), true));
        return arrayList;
    }

    public static ArrayList<String> getAloneTextFile(Context paramContext) {
        ArrayList<String> arrayList = new ArrayList();
       // Usbpath = CommonData.playDir;
       // if (!Usbpath.equals(""))
            //arrayList.addAll(ProgramUtil.getAllFileNameFromFolder(Usbpath + "/" + paramContext.getString(2131624446), true));
        return arrayList;
    }

    public static int getFileCount(String paramString) {
        int j = 0;
        File file = new File(paramString);
        if (!file.exists() || !file.isDirectory())
            return 0;
        int i = 0;
        File[] arrayOfFile = file.listFiles();
        int k = arrayOfFile.length;
        while (true) {
            int m = i;
            if (j < k) {
                File file1 = arrayOfFile[j];
                m = i;
                if (file1.isFile())
                    m = i + 1;
                i = m;
                if (file1.isDirectory())
                    i = m + getFileCount(file1.getAbsolutePath());
                j++;
                continue;
            }
            return m;
        }
    }

    private static String getFilePath(String paramString, File paramFile) {
        return (paramFile.isDirectory() && paramFile.getName().equals(paramString)) ? paramFile.getPath() : "";
    }

    private static String getProgramPath(Context paramContext, String paramString) {
        for (String str : getAllUsbMountedPaths(paramContext)) {
            Log.v("getAllUsbAloneFile", "usb:" + str);
            File[] arrayOfFile = (new File(str)).listFiles();
            for (int i = 0; i < arrayOfFile.length; i++) {
                String str1 = getFilePath(paramString, arrayOfFile[i]);
                if (!str1.equals(""))
                    return str1;
            }
        }
        return "";
    }

    public static ArrayList<String> getScreenFile(int paramInt, Context paramContext) {
        ArrayList<Comparable> arrayList = new ArrayList();
       // Usbpath = CommonData.playDir;
       // if (!Usbpath.equals(""))
            //arrayList.addAll(ProgramUtil.getAllFileNameFromFolder(Usbpath + "/" + paramContext.getString(2131624374) + paramInt, true));
        Collections.sort(arrayList);
        return (ArrayList)arrayList;
    }

    public static List<String> getServerVsFile(Context paramContext) {
        ArrayList<String> arrayList = new ArrayList();
        Usbpath = getProgramPath(paramContext, "usbfile");
        if (!Usbpath.equals(""))
            arrayList.addAll(ProgramUtil.getAllFileNameFromFolder(Usbpath, false));
        return arrayList;
    }

    public static ArrayList<String> getUsbImageFile() {
        ArrayList<String> arrayList = new ArrayList();
       // Usbpath = CommonData.playDir;
        if (!Usbpath.equals(""))
            arrayList.addAll(ProgramUtil.getAllFileNameFromFolder(Usbpath + "/Image", true));
        return arrayList;
    }

    public static List<String> getUsbMountedPaths(Context paramContext) {
        return getVolumePaths(paramContext);
    }

    public static List<String> getUsbRootFile(Context paramContext) {
        ArrayList<String> arrayList = new ArrayList();
        for (String str : getAllUsbMountedPaths(paramContext)) {
            Log.v("getUsbRootFile", "usb:" + str);
            Usbpath = str;
            arrayList.addAll(ProgramUtil.getusbRootFileNameFromFolder(str, true));
            Log.v("getUsbRootFile", "aloneFiles:" + arrayList.size());
        }
        return arrayList;
    }

    public static List<String> getVolumePaths(Context paramContext) {
        ArrayList<String> arrayList = new ArrayList();
        try {
           // StorageManager storageManager = (StorageManager)paramContext.getSystemService("storage");
          //  Method method2 = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
          //  Method method1 = storageManager.getClass().getMethod("getVolumeState", new Class[] { String.class });
          //  Object[] arrayOfObject = (Object[])method2.invoke(storageManager, new Object[0]);
           // for (int i = 0; i < arrayOfObject.length; i++) {
               // Method method4 = arrayOfObject[i].getClass().getMethod("getPath", new Class[0]);
               // Method method3 = arrayOfObject[i].getClass().getMethod("isRemovable", new Class[0]);
              //  String str = (String)method4.invoke(arrayOfObject[i], new Object[0]);
               // if ("mounted".equals(method1.invoke(storageManager, new Object[] { str })) && ((Boolean)method3.invoke(arrayOfObject[i], new Object[0])).booleanValue())
               //     arrayList.add(str);
           // }
        } catch (Exception exception) {
           // ThrowableExtension.printStackTrace(exception);
        }
        return arrayList;
    }

    public static void initAlonePlayFilePath(Context paramContext) {
      //  Usbpath = getProgramPath(paramContext, paramContext.getString(2131624023));
        if (Usbpath.equals(""))
            createUsbProgramPath(paramContext);
    }

    public boolean haveFile(String paramString, boolean paramBoolean, List<String> paramList) {
        boolean bool = true;
        File file = new File(paramString);
        if (file.exists()) {
            File[] arrayOfFile = file.listFiles();
            if (arrayOfFile != null && arrayOfFile.length > 0) {
                int j = arrayOfFile.length;
                int i = 0;
                while (i < j) {
                    if (!arrayOfFile[i].isFile() || paramBoolean) {
                        i++;
                        continue;
                    }
                    return true;
                }
                if (paramBoolean)
                    haveFile(paramString + "/text/", paramBoolean, paramList);
                return (paramBoolean && this.usbFiles.size() > 0) ? bool : false;
            }
        }
        return false;
    }

    protected boolean haveOldFullFile() {
        return false;
    }

    public void onCancel(DialogInterface paramDialogInterface) {
        super.onCancel(paramDialogInterface);
        //this.handler.removeCallbacks(this.OnTimeCancel);
        this.listener.onCancel();
    }
 /*
    public Dialog onCreateDialog(Bundle paramBundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)getActivity());
        View view = getActivity().getLayoutInflater().inflate(2131361839, null);
        TextView textView = (TextView)view.findViewById(2131230964);
        RadioButton radioButton1 = (RadioButton)view.findViewById(2131231130);
        radioButton1 = (RadioButton)view.findViewById(2131231131);
        RadioButton radioButton2 = (RadioButton)view.findViewById(2131231132);
        if (this.type == 1) {
            textView.setText("从服务器导入");
           // radioButton1.setVisibility(8);
           // radioButton2.setVisibility(8);
            this.option = 1;
        } else {
            this.option = 2;
            radioButton1.setVisibility(0);
            radioButton2.setVisibility(0);
        }
        builder.setView(view);
     //   builder.setTitle(getResources().getString(2131623975));

        builder.setPositiveButton(getResources().getString(2131623949), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                if (CopyFileFragment.this.option == 0) {
                    CopyFileFragment.this.handler.removeCallbacks(CopyFileFragment.this.OnTimeCancel);
                } else {
                    CopyFileFragment.this.handler.removeCallbacks(CopyFileFragment.this.OnTimeImport);
                }
                final CopyFileFragment.ProgressDialog pDialog = new CopyFileFragment.ProgressDialog((Context)CopyFileFragment.this.getActivity());
                progressDialog.show();
                (new AsyncTask<Void, Integer, Void>() {
                    protected Void doInBackground(Void... param2VarArgs) {
                        boolean bool2 = true;
                        CopyFileFragment.this.impDir = 0;
                        if (CopyFileFragment.this.type == 0) {
                            if (CopyFileFragment.this.option == 2)
                                Tool.deleteUsbFile(CopyFileFragment.this.context, CommonData.playDir, false);
                            boolean bool = bool2;
                            if (CopyFileFragment.this.option == 3)
                                bool = false;
                            Log.v("getUsbRootFile", "Usbpath:" + CopyFileFragment.Usbpath + "----playDir:" + CommonData.playDir);
                            Tool.copyFolder(CopyFileFragment.Usbpath, CommonData.playDir, bool, CopyFileFragment.this.impDir, CopyFileFragment.this.context, new Tool.OnCopy() {
                                public void onCopy(String param3String1, String param3String2) {
                                    CopyFileFragment.this.listener.onCopyFile(param3String1, param3String2);
                                    CopyFileFragment.null.null  = CopyFileFragment.null.null.this;
                                    CopyFileFragment copyFileFragment = CopyFileFragment.this;
                                    int i = copyFileFragment.j + 1;
                                    copyFileFragment.j = i;
                            .publishProgress((Object[])new Integer[] { Integer.valueOf(i) });
                                }
                            });
                            return null;
                        }
                        boolean bool1 = bool2;
                        if (CopyFileFragment.this.type == 2) {
                            CopyFileFragment.this.impDir = 1;
                            if (CopyFileFragment.this.option == 2)
                                Tool.deleteUsbFile(CopyFileFragment.this.context, CommonData.playDir, false);
                            bool1 = bool2;
                            if (CopyFileFragment.this.option == 3)
                                bool1 = false;
                        }
                        Log.v("getUsbRootFile", "Usbpath:" + CopyFileFragment.Usbpath + "----playDir:" + CommonData.playDir);
                        Tool.copyFolder(CopyFileFragment.Usbpath, CommonData.playDir, bool1, CopyFileFragment.this.impDir, CopyFileFragment.this.context, new Tool.OnCopy() {
                            public void onCopy(String param3String1, String param3String2) {
                                CopyFileFragment.this.listener.onCopyFile(param3String1, param3String2);
                                CopyFileFragment.null.null  = CopyFileFragment.null.null.this;
                                CopyFileFragment copyFileFragment = CopyFileFragment.this;
                                int i = copyFileFragment.j + 1;
                                copyFileFragment.j = i;
                          .publishProgress((Object[])new Integer[] { Integer.valueOf(i) });
                            }
                        });
                        return null;
                    }

                    protected void onPostExecute(Void param2Void) {
                        pDialog.dismiss();
                        CopyFileFragment.this.listener.onSuccess();
                    }

                    protected void onPreExecute() {
                        pDialog.setMaxProgress(CopyFileFragment.this.usbFiles.size());
                        CopyFileFragment.this.listener.onStart();
                    }

                    protected void onProgressUpdate(Integer... param2VarArgs) {
                        pDialog.setValue((param2VarArgs[0].intValue() * 100 / CopyFileFragment.this.usbFiles.size()) + "%", param2VarArgs[0].intValue());
                        Log.e((param2VarArgs[0].intValue() * 100 / CopyFileFragment.this.usbFiles.size()) + "%", param2VarArgs[0] + "");
                    }
                }).execute((Object[])new Void[0]);
            }
        });
        *

        builder.setNegativeButton(getResources().getString(2131624046), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                if (CopyFileFragment.this.option == 0) {
                    CopyFileFragment.this.handler.removeCallbacks(CopyFileFragment.this.OnTimeCancel);
                } else {
                    CopyFileFragment.this.handler.removeCallbacks(CopyFileFragment.this.OnTimeImport);
                }
                CopyFileFragment.this.listener.onCancel();
            }
        });
        ((RadioGroup)view.findViewById(2131231133)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup param1RadioGroup, int param1Int) {
                if (param1Int == 2131231130) {
                    CopyFileFragment.this.option = 1;
                    return;
                }
                if (param1Int == 2131231131) {
                    CopyFileFragment.this.option = 2;
                    return;
                }
                if (param1Int == 2131231132) {
                    CopyFileFragment.this.option = 3;
                    return;
                }
            }
        });


        this.usbimportGroup = (RadioGroup)view.findViewById(2131231133);
        switch (this.option) {
            default:
                if (this.option == 0) {
                    this.handler.postDelayed(this.OnTimeCancel, 1000L);
                    return (Dialog)builder.create();
                }
                break;
            case 1:
                this.usbimportGroup.check(2131231130);
            case 2:
                this.usbimportGroup.check(2131231131);
            case 3:
                this.usbimportGroup.check(2131231132);
        }
        this.handler.postDelayed(this.OnTimeImport, 1000L);
        return (Dialog)builder.create();


    }
*/
    public void onDestroyView() {
        super.onDestroyView();
      //  this.handler.removeCallbacks(this.OnTimeCancel);
      //  this.handler.removeCallbacks(this.OnTimeImport);
        this.listener.onCancel();
    }

    public void setCopylistener(Context paramContext, int paramInt, OnCopyFile paramOnCopyFile) {
        this.context = paramContext;
        switch (paramInt) {
            default:
                this.listener = paramOnCopyFile;
                return;
            case 0:
                this.type = 0;
                this.usbFiles = getAllUsbAloneFile(this.context);
            case 1:
                this.type = 2;
                this.usbFiles = getUsbRootFile(this.context);
            case 2:
                break;
        }
        this.usbFiles = getServerVsFile(this.context);
        this.type = 1;
    }

    public void setCopylistener2(Context paramContext, OnCopyFile paramOnCopyFile) {
        this.context = paramContext;
        this.usbFiles = getServerVsFile(this.context);
        this.type = 1;
        this.listener = paramOnCopyFile;
    }

    public void setCopylistener3(Context paramContext, OnCopyFile paramOnCopyFile) {
        this.context = paramContext;
        this.type = 2;
        this.usbFiles = getUsbRootFile(this.context);
        this.listener = paramOnCopyFile;
    }

    public void test() {
        if (this.option == 0) {
          //  this.handler.removeCallbacks(this.OnTimeCancel);
        } else {
           // this.handler.removeCallbacks(this.OnTimeImport);
        }
        this.listener.onCancel();
    }

    public static abstract class OnCopyFile {
        public abstract void onCancel();

        public abstract void onCopyFile(String param1String1, String param1String2);

        public abstract void onFailed();

        public abstract void onStart();

        public abstract void onSuccess();
    }

    public class ProgressDialog extends Dialog {
        ProgressBar progressBar;

        TextView txView;

        public ProgressDialog(Context param1Context) {
            super(param1Context);
            setCancelable(false);
            setCanceledOnTouchOutside(false);
        }

        protected void onCreate(Bundle param1Bundle) {
            requestWindowFeature(1);
           // View view = LayoutInflater.from(getContext()).inflate(2131361913, null);
           // this.txView = (TextView)view.findViewById(2131231157);
           // this.progressBar = (ProgressBar)view.findViewById(2131231158);
          //  setContentView(view, new ViewGroup.LayoutParams(300, -2));
        }

        public void setMaxProgress(int param1Int) {
            if (this.progressBar != null)
                this.progressBar.setMax(param1Int);
        }

        public void setValue(String param1String, int param1Int) {
            if (this.txView != null)
                this.txView.setText(param1String);
            if (this.progressBar != null)
                this.progressBar.setProgress(param1Int);
        }
    }
}


/* Location:              D:\wlzc_institute\wlzc\wlzc1-dex2jar.jar!\com\zcadc\main\CopyFileFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
