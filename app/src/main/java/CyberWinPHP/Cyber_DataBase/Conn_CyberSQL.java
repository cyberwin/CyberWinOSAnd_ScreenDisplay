package CyberWinPHP.Cyber_DataBase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import CyberWinPHP.Cyber_Plus.LogToFile;

//C#
public class Conn_CyberSQL {
    public String  dbType="";

    DBManager dbManager;

    public Conn_CyberSQL(){
        dbManager= new DBManager();



    }

    public Conn_CyberSQL(String wlzc2023other){
        dbManager= new DBManager(wlzc2023other);



    }


    public  void CreateDBLink(){
        //创建连接
    }
    public  String Cyber_SetConnstring(String[] linkStr){
           return "";
    }

    public  void Open(){
        //打开
        dbManager.Conn();

    }
    public  boolean ExexSqlCmd(String sql){
          try {

              LogToFile.d("SQLTRACE","sql="+sql);
                SQLiteDatabase sqliteDB=dbManager.Conn();
                sqliteDB.execSQL(sql);

               // Cursor c = sqliteDB.rawQuery(sql, null);
                return true;
          }catch (Exception ex){

              LogToFile.d("Exception","sql"+ex.getMessage()+sql+ex.getStackTrace());
              return false;

          }
    }

    public  DataSet Cient_ExexSql(String sql){
        return new DataSet();
    }

    //HashMap<String,String>

    public List<HashMap<String,String>> Cient_ExexSqlV2(String sql) {
        // return new DataSet();
        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

            SQLiteDatabase sqliteDB = dbManager.Conn();
            Cursor c = sqliteDB.rawQuery(sql, null);
            if (c != null) {
                String[] cyber_coluns = c.getColumnNames();
                while (c.moveToNext()) {
                    HashMap<String, String> map = new HashMap<>();
                    // map.put("id", c.getString(0));
                    // map.put("name", c.getString(1));
                    // map.put("sex", c.getString(c.getColumnIndex("sex")));

                    for (String col : cyber_coluns) {
                        map.put(col, c.getString(c.getColumnIndex(col)));
                    }


                    list.add(map);

                }
                c.close();
                sqliteDB.close();


            }

        return list;
    }

    //Cient_ExexSql
    public  void  Close(){
        //关闭
    }
    //Cyber_makeDeaulrConn
    public  String  Cyber_makeDeaulrConn(String connStr){
        //关闭
        return  "";
    }
    //Cyber_SetConn
    public  void  Cyber_SetConn(String connStr){
        //关闭
    }
}
