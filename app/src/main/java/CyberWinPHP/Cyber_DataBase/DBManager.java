package CyberWinPHP.Cyber_DataBase;

import static CyberWinPHP.Cyber_Plus.LogToFile.getFilePath;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import CyberWinPHP.Cyber_CPU.Cyber_Public_Var;
import CyberWinPHP.Cyber_Plus.LogToFile;

public class DBManager {
    private String DB_NAME = "cyberwin_application_union.cyberphp";
    private Context mContext;

    public DBManager() {

        this.mContext = Cyber_Public_Var.cyber_main_instance;
    }

    public DBManager(String wlzc2023other) {

        this.mContext = Cyber_Public_Var.cyber_main_instance;
        DB_NAME=wlzc2023other+".cyberphp";
    }




    public DBManager(Context mContext) {
        this.mContext = mContext;
    }
    //把assets目录下的db文件复制到dbpath下
    public SQLiteDatabase Conn() {
        String  apppath = getFilePath(Cyber_Public_Var.cyber_main_instance) + "/databases/";

        File destDir = new File(apppath);
        if (!destDir.exists()) {
            destDir.mkdirs();
        }

        //  String dbPath = "/data/data/" + packName
        //         + "/databases/" + DB_NAME;
        String dbPath = apppath + DB_NAME;
        if (!new File(dbPath).exists()) {
            try {
                FileOutputStream out = new FileOutputStream(dbPath);
                InputStream in = mContext.getAssets().open(DB_NAME);
                byte[] buffer = new byte[1024];
                int readBytes = 0;
                while ((readBytes = in.read(buffer)) != -1)
                    out.write(buffer, 0, readBytes);
                in.close();
                out.close();
            } catch (IOException e) {
                //e.printStackTrace();
            }
        }

        //return SQLiteDatabase.openOrCreateDatabase("file:///android_asset/"+DB_NAME, null);
        return SQLiteDatabase.openOrCreateDatabase(dbPath, null);
    }

    /*
    String[] columns = new String[]{"parent", "name", "posID", "pinyin", "phone_code", "area_code"};
    String selection = "parent=?" + "AND" + " name=?";
    String[] selectionArgs = new String[]{"北京", "丰台"};
    City city = dbManager.query(sqLiteDatabase, columns, selection, selectionArgs);
     */
    public String getkey(String table ,String key, String where) {


        String  ret="";
        try {

            SQLiteDatabase sqliteDB=Conn();

            Cursor c = sqliteDB.rawQuery("select * from "+table+ " where "+where, null);
            if (c != null) {
                while (c.moveToNext()) {
                    //   Map<String, String> map = new HashMap<>();
                    //  map.put("id", c.getString(0));
                    //  map.put("name", c.getString(1));
                    //   map.put("sex", c.getString(c.getColumnIndex("sex")));
                    //   list.add(map);
                    ret =   c.getString(c.getColumnIndex(key)) ;

                }
                c.close();
                sqliteDB.close();
                // return list;
            }

            // City city = null;

           /*
            String[] columns = new String[]{key};//"parent", "name", "posID", "pinyin", "phone_code", "area_code"};
            String selection =where;// "parent=?" + "AND" + " name=?";
            String[] selectionArgs = new String[]{"北京", "丰台"};


            // String table = "city";
            Cursor cursor = sqliteDB.query(table, columns, selection, selectionArgs, null, null, null);
            if (cursor.moveToFirst()) {
               // String parentCity = cursor.getString(cursor
               //         .getColumnIndex("parent"));
                ret = cursor.getString(cursor.getColumnIndex(key));
            }
            */
        } catch (Exception e) {
            //   e.printStackTrace();
            LogToFile.d("未来之窗配置","系统异常"+e.getMessage());
            ret="";
        }
        return ret;
    }
    //查询
    /*
    public City query(SQLiteDatabase sqliteDB, String[] columns, String selection, String[] selectionArgs) {
        City city = null;
        try {
            String table = "city";
            Cursor cursor = sqliteDB.query(table, columns, selection, selectionArgs, null, null, null);
            if (cursor.moveToFirst()) {
                String parentCity = cursor.getString(cursor
                        .getColumnIndex("parent"));
                String phoneCode = cursor.getString(cursor.getColumnIndex("phone_code"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String pinyin = cursor.getString(cursor.getColumnIndex("pinyin"));
                String cityID = cursor.getString(cursor.getColumnIndex("posID"));
                String areaCode = cursor.getString(cursor.getColumnIndex("area_code"));
                city = new City(parentCity, name, pinyin, phoneCode, cityID, areaCode);
                cursor.moveToNext();
                cursor.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return city;
    }
    */

}

