package CyberWinPHP.SuperHardSysten;

import android.util.Log;
//import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
//import com.vs.tool.Tool;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProgramUtil {
    private static final String PREFIX_IMAGE = "image/";

    public static List<String> getAllFileNameFromFolder(String paramString, boolean paramBoolean) {
        ArrayList<String> arrayList = new ArrayList();
        File file = new File(paramString);
        if (!file.exists())
            file.mkdirs();
        if (file.isDirectory()) {
            File[] arrayOfFile = file.listFiles();
            int j = arrayOfFile.length;
            int i = 0;
            while (true) {
                if (i < j) {
                    File file1 = arrayOfFile[i];
                    if (file1.isDirectory()) {
                        arrayList.addAll(getAllFileNameFromFolder(file1.getAbsolutePath(), paramBoolean));
                    } else if (paramBoolean) {
                       // if (Tool.cancopy(file1.getAbsolutePath()))
                         //   arrayList.add(file1.getAbsolutePath());
                    } else {
                        arrayList.add(file1.getAbsolutePath());
                    }
                    i++;
                    continue;
                }
                return arrayList;
            }
        }
        return arrayList;
    }

    public static String getFileString(String paramString) {
        String str;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(paramString)), "UTF-8"));
            paramString = "";
            while (true) {
                String str1 = bufferedReader.readLine();
                str = paramString;
                if (str1 != null) {
                    paramString = paramString + str1;
                    continue;
                }
                break;
            }
        } catch (Exception exception) {
           // ThrowableExtension.printStackTrace(exception);
            str = "";
        }
        return str;
    }

    public static String getFileString(String paramString1, String paramString2) {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File(paramString1)), paramString2);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            paramString1 = "";
            while (true) {
                String str = bufferedReader.readLine();
                if (str != null) {
                    paramString1 = paramString1 + str;
                    continue;
                }
                inputStreamReader.close();
                return paramString1;
            }
        } catch (Exception exception) {
           // ThrowableExtension.printStackTrace(exception);
            return "";
        }
    }

    public static List<String> getusbRootFileNameFromFolder(String paramString, boolean paramBoolean) {
        Log.v("getUsbRootFile", "getAllFileNameFromFolder:" + paramString);
        ArrayList<String> arrayList = new ArrayList();
        File file = new File(paramString);
        if (!file.exists())
            file.mkdirs();
        if (file.isDirectory()) {
            File[] arrayOfFile = file.listFiles();
            int j = arrayOfFile.length;
            int i = 0;
            while (true) {
                if (i < j) {
                    File file1 = arrayOfFile[i];
                    if (!file1.isDirectory())
                        if (paramBoolean) {
                           // if (Tool.cancopyusbroot(file1.getAbsolutePath()))
                             //   arrayList.add(file1.getAbsolutePath());
                        } else {
                            arrayList.add(file1.getAbsolutePath());
                        }
                    i++;
                    continue;
                }
                return arrayList;
            }
        }
        return arrayList;
    }

    public static void writeFileString(String paramString1, String paramString2) {
        File file;
        Exception exception;
        if (paramString2 != null || "".equals(paramString2)) {
            file = new File(paramString1);
            if (!file.exists())
                try {
                    file.createNewFile();
                } catch (Exception exception3) {}
            Exception exception1 = null;
            Exception exception2 = null;
            /*
            try {
                Exception exception3;
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, false));
                try {
                    return;
                } catch (Exception null) {

                } finally {
                    exception1 = null;
                    exception = exception3;
                    exception3 = exception1;
                    if (exception != null)
                        //try {
                           // exception.close();
                       // } catch (IOException iOException) {}
                }

                return;
            } catch (Exception exception3) {
                exception3 = exception2;
                return;
            } finally {
                file = null;
            }

             */
        } else {
            return;
        }
       // if (exception != null)
         //   try {
              //  exception.close();
          //  } catch (IOException iOException) {}
       // throw file;
    }
}


/* Location:              D:\wlzc_institute\wlzc\wlzc1-dex2jar.jar!\com\zcad\\util\ProgramUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
