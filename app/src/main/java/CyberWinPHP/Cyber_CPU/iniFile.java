package CyberWinPHP.Cyber_CPU;

import com.alibaba.fastjson.JSON;
import java.util.HashMap;

import CyberWinPHP.Cyber_DataBase.Cyber_M;
import CyberWinPHP.Cyber_DataBase.DBManager;
import CyberWinPHP.Cyber_DataBase.DataRow;
import CyberWinPHP.Cyber_DataBase.DataTable;
import CyberWinPHP.Cyber_Structure.Cyber_LocalStoreKeyValue;

public class iniFile {

    public iniFile(){
        DBManager dbManager=new DBManager();
    }

    public boolean isExist(String section, String key, String value,String config_class){
        String where=" config_class = '"+config_class+"' and section = '"+section+"'  and key= '"+key+"' ";



        Cyber_M cyber_m = new Cyber_M("system_config","cyberwin_");
        cyber_m.where(where);
        HashMap<String,String> data= cyber_m.FindV2();
        if( data.size()>0){
            return true;
        }else{
            HashMap<String,String> data_add = new  HashMap<String,String>();
            data_add.put("config_class",config_class);
            data_add.put("section",section);
            data_add.put("key",key);
            data_add.put("value","");
            cyber_m.Add(data_add);
            return  false;
        }

    }

    public  boolean WriteINI(String section, String key, String value,String config_class){
        String where=" config_class = '"+config_class+"' and section = '"+section+"'  and key= '"+key+"' ";



        // Cyber_M cyber_m = new Cyber_M("system_config","cyberwin_");
        // cyber_m.where(where);
        //  String  DefaultHome2=cyber_m.GetFieldV2("value");
        //   cyber_m.setField(key,value);


        Cyber_M cyber_m = new Cyber_M("system_config","cyberwin_");
        cyber_m.where(where);
        HashMap<String,String> data= cyber_m.FindV2();

        if( data.size()>0){
            cyber_m.setField("value",value);
            return true;
        }else{
            HashMap<String,String> data_add = new  HashMap<String,String>();
            data_add.put("config_class",config_class);
            data_add.put("section",section);
            data_add.put("key",key);
            data_add.put("value",value);
            cyber_m.Add(data_add);
            return  false;
        }

    }




    public  String GetINI(String section, String key, String value,String config_class){
        String where=" config_class = '"+config_class+"' and section = '"+section+"'  and key= '"+key+"' ";

        Cyber_M cyber_m = new Cyber_M("system_config","cyberwin_");
        cyber_m.where(where);
        String  DefaultHome2=cyber_m.GetFieldV2("value");
        /*
        if(DefaultHome2.isEmpty()){
            DefaultHome2="";
        }
        */

        if(DefaultHome2==null){
            DefaultHome2="";
        }

        return  DefaultHome2;
        // LogToFile.d("未来之窗配置","系统第二梦="+DefaultHome2);
    }


    /////////

    public  boolean locStorage_setVal(String db, String table, String key, String value){
        String where="  key= '"+key+"' ";






        Cyber_M cyber_m = new Cyber_M(table,"cyberwin_");
        cyber_m.where(where);
        HashMap<String,String> data= cyber_m.FindV2();

        if( data.size()>0){
            cyber_m.setField("value",value);
            return true;
        }else{
            HashMap<String,String> data_add = new  HashMap<String,String>();
            // data_add.put("config_class",config_class);
            //  data_add.put("section",section);
            data_add.put("key",key);
            data_add.put("value",value);
            cyber_m.Add(data_add);
            return  false;
        }

    }




    public  String locStorage_getVal(String db, String table, String key){
        String where="  key= '"+key+"' ";

        Cyber_M cyber_m = new Cyber_M(table,"cyberwin_");
        cyber_m.where(where);
        String  DefaultHome2=cyber_m.GetFieldV2("value");


        if(DefaultHome2==null){
            DefaultHome2="";
        }

        return  DefaultHome2;

    }

    //2022-6-20
    public  String locStorage_getAllKeyVales(String db, String table){
        String where=" ";// key= '"+key+"' ";

        Cyber_M cyber_m = new Cyber_M(table,"cyberwin_");
        cyber_m.where(where);
        //  String  DefaultHome2=cyber_m.GetFieldV2("value");
        DataTable dt= cyber_m.Select();
        // dt.to
        // dt.rows
        int rowcount=  dt.rows.size();
        Cyber_LocalStoreKeyValue[] returkves=new Cyber_LocalStoreKeyValue[rowcount];

        for(int rowi=0 ;rowi<rowcount;rowi++ ){
            DataRow dr=dt.rows.get(rowi);
            returkves[rowi]=new Cyber_LocalStoreKeyValue(dr.getValue("key").toString(),dr.getValue("value").toString());


        }
        String ret2 = JSON.toJSONString(returkves);


        return  ret2;

    }


    //2023-10-30 数据隔离和更加松散数据接口
    //2022-6-20
    public  String locStorage_Cyber_M(String db, String table,String sql){
        String where=" ";// key= '"+key+"' ";

        Cyber_M cyber_m = new Cyber_M(db,table,"cyberwin_");

        String 数据库=cyber_m.QueryJsonV2023(sql);
        //  cyber_m.where(where);
        //  String  DefaultHome2=cyber_m.GetFieldV2("value");
        /*
        DataTable dt= cyber_m.QueryDataTableV2023(sql);
        // dt.to
        // dt.rows
        int rowcount=  dt.rows.size();
       // dt.getColumns().

        DataColumnCollection 未来之窗表头 = dt.getColumns();
       int 未来之窗表头总数=dt.getColumnsCount();
       // DataColumn dcl= 未来之窗表头.;

        String 数据库 = "[";

        for(int rowi=0 ;rowi<rowcount;rowi++ ){
            DataRow dr=dt.rows.get(rowi);

            String 数据库one=  "{";
          //  dt.getColumns();

            for (int colsi=0 ;rowi<未来之窗表头总数;colsi++)
            {
                String 表头名称=未来之窗表头.get(colsi).getColumnName();
                String 表头显示名称=未来之窗表头.get(colsi).getCaptionName();


                数据库one = 数据库one + "\"" + 表头显示名称+ "\":" + "\"" +  dr.getValue(表头名称).toString() + "\"";
                数据库one = 数据库one + ",";
            }
            数据库one  = 数据库one.substring(0, 数据库one.length() - 1);;
            数据库one = 数据库one + "}";
            数据库 = 数据库 + 数据库one + ",";

          //  returkves[rowi]=new Cyber_LocalStoreKeyValue(dr.getValue("key").toString(),dr.getValue("value").toString());


        }
        数据库 =  数据库.substring(0, 数据库.length() - 1);;
        数据库 = 数据库 + "]";
        //String ret2 = JSON.toJSONString(returkves);
*/

        return  数据库;

    }





}
