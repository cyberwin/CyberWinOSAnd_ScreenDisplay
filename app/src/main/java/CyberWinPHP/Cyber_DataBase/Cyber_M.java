package CyberWinPHP.Cyber_DataBase;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashMap;
import java.util.List;

import CyberWinPHP.Cyber_Plus.LogToFile;

public class Cyber_M {
    private String _table_pre = "tb_";
    private String _table_name;
    private String _fields = "*";

    //2022-10-30 增加数据库
    private String _dbname = "";

    private String dbtype = "SQLite";//Cyber_DataBase.getDBType();

    private String _where = "";

    private String cache_sql = "";

    private String cache_error = "";

    public void where(String where)
    {
        if ( where.length()>2)
        {
            _where = " where " + where;
        }
    }

    public void fields(String fields)
    {
        if (fields.length()>2)
        {
            _fields = fields;
        }
    }



    public Cyber_M(String table_name)
    {
        _table_name = table_name;
    }

    public Cyber_M(String table_name,String table_prefix)
    {
        _table_name = table_name;
        _table_pre = table_prefix;
    }

    public Cyber_M(String db_name,String table_name,String table_prefix)
    {
        _table_name = table_name;
        _table_pre = table_prefix;
        _dbname=db_name;
    }
    //_dbname

    public boolean Add(HashMap<String,String> myCol)
    {
        //  string[] a;
        // a["111"] = "11";
        String sql = build_insert(myCol);
        // MessageBox.Show(sql);
        return Exec(sql);

    }
    public boolean Save(HashMap<String,String> myCol)
    {
        //  string[] a;
        // a["111"] = "11";
        String sql = build_update(myCol);
        // MessageBox.Show(sql);
        return Exec(sql);

    }

    public boolean Delete()
    {
        // a["111"] = "11";
        String sql = " DELETE FROM " + _table_pre + _table_name + "  " + _where;
        // MessageBox.Show(sql);
        return Exec(sql);
    }


    public DataTable Select()
    {
        Conn_CyberSQL csql = new  Conn_CyberSQL();
        csql.dbType =Cyber_DataBase.getDBType();// "MSSQL";
        csql.CreateDBLink();
        // csql.Cyber_SetConn(Cyber_DataBase.getConn());
        csql.Cyber_SetConnstring(Cyber_DataBase.getConnArray());
        csql.Open();

        String sql = "select " + _fields + " from " + _table_pre + _table_name + _where;

        sql = sql.trim();
        cache_sql = sql;//存放缓存sql

        DataSet ds = csql.Cient_ExexSql(sql);

        if (ds == null)
        {
            return new DataTable();
        }
        if (ds.Tables.length < 1)
        {
            return new DataTable();
        }

        return ds.Tables[0];

    }

    /// <summary>
    /// 数据库设置，字段
    /// </summary>
    /// <param name="field">字段名称</param>
    /// <param name="fileld_value">值</param>
    public boolean setField(String field, String fileld_value)
    {
        String sql = " UPDATE " + _table_pre + _table_name + " SET " + field + " = '" + fileld_value + "'" + _where;
        if (dbtype == "XML2016")
        {
            sql = "update " + _table_pre + _table_name + " set " + field + "=" + fileld_value + "" + _where;
        }

        cache_sql = sql;//存放缓存sql

        return Exec(sql);
    }

    /// <summary>
    /// 数据库设置自动增加1 setInc，字段
    /// </summary>
    /// <param name="field">字段名称</param>
    public boolean setInc(String field)
    {
        String sql = " UPDATE " + _table_pre + _table_name + " SET " + field + " = " + field + "+1" + _where;
        if (dbtype == "XML2016")
        {
            //sql = "update " + _table_pre + _table_name + " set " + field + "=" + fileld_value + "" + _where;
            //不支持哦
            // throw new Exception("不支持这种数据库，请使用其他方法");
        }
        cache_sql = sql;//存放缓存sql

        return Exec(sql);
    }

    /// <summary>
    /// 数据库设置自动增加1 setInc，字段
    /// </summary>
    /// <param name="field">字段名称</param>
    /// <param name="increment">增量</param>
    public boolean setInc(String field, int increment)
    {
        String sql = " UPDATE " + _table_pre + _table_name + " SET " + field + " = " + field + "+" + increment + _where;
        if (dbtype == "XML2016")
        {
            // sql = "update " + _table_pre + _table_name + " set " + field + "=" + fileld_value + "" + _where;
            //不支持哦
            //  throw new Exception("不支持这种数据库，请使用其他方法");
        }
        cache_sql = sql;//存放缓存sql

        return Exec(sql);
    }

    /// <summary>
    /// 数据库设置自动减少1 setDec，字段
    /// </summary>
    /// <param name="field">字段名称</param>
    public boolean setDec(String field)
    {
        String sql = " UPDATE " + _table_pre + _table_name + " SET " + field + " = " + field + "-1" + _where;
        if (dbtype == "XML2016")
        {
            //sql = "update " + _table_pre + _table_name + " set " + field + "=" + fileld_value + "" + _where;
            //不支持哦
            // throw new Exception("不支持这种数据库，请使用其他方法");
        }
        cache_sql = sql;//存放缓存sql

        return Exec(sql);
    }

    /// <summary>
    /// 数据库设置自动减少1 setDec，字段
    /// </summary>
    /// <param name="field">字段名称</param>
    /// <param name="increment">负增量</param>
    public boolean setDec(String field, int increment)
    {
        String sql = " UPDATE " + _table_pre + _table_name + " SET " + field + " = " + field + "-" + increment + _where;
        if (dbtype == "XML2016")
        {
            // sql = "update " + _table_pre + _table_name + " set " + field + "=" + fileld_value + "" + _where;
            //不支持哦
            // throw new Exception("不支持这种数据库，请使用其他方法");
        }
        cache_sql = sql;//存放缓存sql

        return Exec(sql);
    }

    /// <summary>
    /// 数据库查询
    /// </summary>
    /// <param name="SqlString">SQL查询语句</param>
    public boolean Query(String SqlString)
    {
        cache_sql = SqlString;//存放缓存sql

        return Exec(SqlString);
    }

    /// <summary>
    /// 数据库查询
    /// </summary>
    /// <param name="SqlString">SQL查询语句</param>
    public DataSet QueryDataSet(String SqlString)
    {
        try
        {
            //2022-10-30 新数据
            Conn_CyberSQL csql;
            if(_dbname.equals("")==true){
                csql = new Conn_CyberSQL();
            }else{
                //2022-10-30 数据库
                csql = new Conn_CyberSQL(_dbname);
            }
            // Conn_CyberSQL csql = new Conn_CyberSQL();
            csql.dbType = Cyber_DataBase.getDBType();// "MSSQL";
            csql.CreateDBLink();
            // csql.Cyber_SetConn(Cyber_DataBase.getConn());
            csql.Cyber_SetConnstring(Cyber_DataBase.getConnArray());
            csql.Open();

            //  string sql = "select " + _fields + " from " + _table_pre + _table_name + _where;

            SqlString = SqlString.trim();
            cache_sql = SqlString;//存放缓存sql

            DataSet ds = csql.Cient_ExexSql(SqlString);

            if (ds == null)
            {
                cache_error = "没有数据";
                // return new DataTable();
            }
            if (ds.Tables.length < 1)
            {
                cache_error = "没有数据表";
                //  return new DataTable();
            }

            return ds;
        }
        catch (Exception EX)
        {
            cache_error = "CyberError-40001:QueryDataSet " + EX.getMessage();//+EX.StackTrace;
            return new DataSet();
        }


    }

    /// <summary>
    /// 数据库查询
    /// </summary>
    /// <param name="SqlString">SQL查询语句</param>
    public DataTable QueryDataTable(String SqlString)
    {
        DataSet ds = QueryDataSet(SqlString);
        if (ds == null)
        {
            cache_error = cache_error + "没有数据";
            return new DataTable();
        }
        if (ds.Tables.length < 1)
        {
            cache_error = cache_error+"没有数据表";
            return new DataTable();
        }

        return ds.Tables[0];
    }


    /// <summary>
    /// 数据库查询
    /// </summary>
    /// <param name="SqlString">SQL查询语句</param>
    public String QueryJsonV2023(String SqlString)
    {
        Conn_CyberSQL csql ;
        if(_dbname.equals("")==true){
            csql = new Conn_CyberSQL();
        }else{
            //2022-10-30 数据库
            csql = new Conn_CyberSQL(_dbname);
        }
        csql.dbType = Cyber_DataBase.getDBType();//"MSSQL";
        csql.CreateDBLink();
        // csql.Cyber_SetConn(Cyber_DataBase.getConn());
        csql.Cyber_SetConnstring(Cyber_DataBase.getConnArray());
        csql.Open();


        List<HashMap<String, String>>  ds = csql.Cient_ExexSqlV2(SqlString);
        if (ds == null) {
            cache_error = "没有数据";
            return "";//new HashMap<String, String>();
        }
        if (ds.size() < 1) {
            cache_error = "没有数据表";
            return "";//new HashMap<String, String>();
        }
        //  ret_dt= ds.get(0);
        String 未来之窗返回= "[";

        int 未来之窗行数=  ds.size();
        for(int 未来之窗行i=0 ;未来之窗行i<未来之窗行数;未来之窗行i++ ) {
            HashMap<String,String>  未来之窗行 =ds.get(未来之窗行i);

            String 数据库one=  "{";
            // 未来之窗行.k
            for (String key : 未来之窗行.keySet()) {
                // System.out.println("Key = " + key);
                String 表头名称=key;




                数据库one = 数据库one + "\"" + 表头名称+ "\":" + "\"" +  未来之窗行.get(表头名称) + "\"";
                数据库one = 数据库one + ",";
            }
            数据库one  = 数据库one.substring(0, 数据库one.length() - 1);;
            数据库one = 数据库one + "}";
            未来之窗返回 = 未来之窗返回 + 数据库one + ",";

        }
        未来之窗返回 =  未来之窗返回.substring(0, 未来之窗返回.length() - 1);;
        未来之窗返回 = 未来之窗返回 + "]";




        return 未来之窗返回;
    }

    //Helper.DataSet

    /// <summary>
    /// 数据库查询
    /// </summary>
    /// <param name="SqlString">SQL查询语句</param>
    public String QueryXML(String SqlString)
    {
        DataSet ds = QueryDataSet(SqlString);

        String XMLRETURN= "";// Helper.DataSet.XmlDatasetConvert.ConvertDataSetToXML(ds);



        return XMLRETURN;
    }

    /// <summary>
    /// 数据库单条选择
    /// </summary>
    public DataTable Find()
    {
        Conn_CyberSQL csql = new  Conn_CyberSQL();
        csql.dbType = Cyber_DataBase.getDBType();//"MSSQL";
        csql.CreateDBLink();
        // csql.Cyber_SetConn(Cyber_DataBase.getConn());
        csql.Cyber_SetConnstring(Cyber_DataBase.getConnArray());
        csql.Open();
        String sql = "";
        if (dbtype == "MSSQL")
        {
            sql = "select TOP 1 " + _fields + " from " + _table_pre + _table_name + _where;
        }
        else if (dbtype == "MySQL")
        {
            //SELECT * FROM hpyl_client_onelinelog  where client_mechid='418F96E' LIMIT 0,1;
            sql = "select " + _fields + " from " + _table_pre + _table_name + _where + "  LIMIT 0,1";
        }

        else if (dbtype == "SQLite")
        {
            //SELECT * FROM hpyl_client_onelinelog  where client_mechid='418F96E' LIMIT 0,1;
            sql = "select " + _fields + " from " + _table_pre + _table_name + _where + "  LIMIT 0,1";
        }

        else
        {
            sql = "select TOP 1 " + _fields + " from " + _table_pre + _table_name + _where;
        }

        sql = sql.trim();
        cache_sql = sql;//存放缓存sql

        DataSet ds = csql.Cient_ExexSql(sql);
        if (ds == null)
        {
            cache_error = "没有数据";
            return new DataTable();
        }
        if (ds.Tables.length < 1)
        {
            cache_error = "没有数据表";
            return new DataTable();
        }

        return ds.Tables[0];

    }

    public HashMap<String,String> FindV2()
    {
        Conn_CyberSQL csql = new  Conn_CyberSQL();
        csql.dbType = Cyber_DataBase.getDBType();//"MSSQL";
        csql.CreateDBLink();
        // csql.Cyber_SetConn(Cyber_DataBase.getConn());
        csql.Cyber_SetConnstring(Cyber_DataBase.getConnArray());
        csql.Open();
        String sql = "";
        if (dbtype == "MSSQL")
        {
            sql = "select TOP 1 " + _fields + " from " + _table_pre + _table_name + _where;
        }
        else if (dbtype == "MySQL")
        {
            //SELECT * FROM hpyl_client_onelinelog  where client_mechid='418F96E' LIMIT 0,1;
            sql = "select " + _fields + " from " + _table_pre + _table_name + _where + "  LIMIT 0,1";
        }

        else if (dbtype == "SQLite")
        {
            //SELECT * FROM hpyl_client_onelinelog  where client_mechid='418F96E' LIMIT 0,1;
            sql = "select " + _fields + " from " + _table_pre + _table_name + _where + "  LIMIT 0,1";
        }

        else
        {
            sql = "select TOP 1 " + _fields + " from " + _table_pre + _table_name + _where;
        }

        sql = sql.trim();
        cache_sql = sql;//存放缓存sql
        // List<HashMap<String, String>> ds= new  List<HashMap<String, String>>();
        HashMap<String, String>  ret_dt=  new HashMap<String, String>();;
        try {

            List<HashMap<String, String>>  ds = csql.Cient_ExexSqlV2(sql);
            if (ds == null) {
                cache_error = "没有数据";
                return new HashMap<String, String>();
            }
            if (ds.size() < 1) {
                cache_error = "没有数据表";
                return new HashMap<String, String>();
            }
            ret_dt= ds.get(0);
        }catch (Exception e) {
            LogToFile.d("Exception", "系统异常" + e.getMessage());
            cache_error =  e.getMessage();
        }

        return ret_dt;//;

    }

    /// <summary>
    /// 数据库count计数，符合条件.
    /// </summary>
    public int Count()
    {




        DataTable dt = this.Select();

        return dt.rows.size();

    }

    public String GetField(String field)
    {

        DataTable dt = this.Find();
        if (dt.rows.size() < 1)
        {
            cache_error = "获取字段-数据为空";
            return "";
        }


        return "";//dt.rows[0][field].ToString().Trim();

    }

    public String GetFieldV2(String field)
    {

        HashMap<String,String>  dt = this.FindV2();
        if (dt.size() < 1)
        {
            cache_error = "获取字段-数据为空";
            return "";
        }


        return dt.get(field);//dt.rows[0][field].ToString().Trim();

    }

    //FindV2

    public String getCurrentSQL()
    {
        String sql = cache_sql;// "select " + _fields + " from " + _table_pre + _table_name + _where;
        return sql;
    }

    public String getLastError()
    {

        return cache_error;
    }



    private boolean Exec(String sql)
    {
        //删除首位空格
        sql = sql.trim();//.Trim();
        cache_sql = sql;//存放缓存sql




        Conn_CyberSQL csql = new  Conn_CyberSQL();
        csql.dbType = Cyber_DataBase.getDBType();// "MSSQL";
        csql.CreateDBLink();
        // csql.Cyber_SetConn(Cyber_DataBase.getConn());
        csql.Cyber_SetConnstring(Cyber_DataBase.getConnArray());
        // csql.Cyber_SetConnstring();
        csql.Open();

        boolean b = csql.ExexSqlCmd(sql);
        csql.Close();
        return b;

    }

    private String build_update(HashMap<String,String> myCol)
    {
        // IEnumerator myEnumerator = myCol.GetEnumerator();

        String r2_update = " SET  ";
        int i = 0;
        //INSERT INTO tb_employee_contract (
        /*
        foreach (String s in myCol.AllKeys)
        {
            */
        for (String s : myCol.keySet()) {
            // Console.WriteLine("   {0,-10} {1}", s, myCol[s]);
            if (i == 0)
            {
                if (dbtype == "XML2016")
                {
                    r2_update = r2_update + s + "=" + myCol.get(s) + "";
                }
                else
                {
                    r2_update = r2_update + s + "='" + myCol.get(s) + "' ";
                }

            }
            else
            {
                if (dbtype == "XML2016")
                {
                    r2_update = r2_update + "," + s + "=" +  myCol.get(s) + "";
                }
                else
                {

                    r2_update = r2_update + " , " + s + "='" +  myCol.get(s) + "' ";
                }
            }
            i = i + 1;

        }

        // r2_update = r2_update + ") ";

        return " UPDATE   " + _table_pre + _table_name + r2_update + " " + _where;
    }
    private String build_insert(HashMap<String,String> myCol) {

        // IEnumerator myEnumerator = myCol.GetEnumerator();
        String r = "( ";
        String r2 = " VALUES( ";
        int i_i = 0;
        //INSERT INTO tb_employee_contract (
        //  foreach (String s in myCol.AllKeys)
        for (String s : myCol.keySet()) {


            // Console.WriteLine("   {0,-10} {1}", s, myCol[s]);
            if (i_i == 0) {
                if (dbtype == "MSSQL") {
                    r = r + "[" + s + "] ";
                } else {
                    r = r + " " + s + " ";
                }
                r2 = r2 + "'" + myCol.get(s) + "'";
            } else {
                if (dbtype == "MSSQL") {
                    r = r + ",[" + s + "] ";
                } else {
                    r = r + "," + s + " ";
                }
                r2 = r2 + ",'" + myCol.get(s) + "'";
            }

            i_i = i_i + 1;

        }
        r = r + ") ";
        r2 = r2 + ") ";

        return "INSERT INTO " + _table_pre + _table_name + r + r2;




    }
    public String getConnStr ()
    {
        Conn_CyberSQL csql = new Conn_CyberSQL();
        csql.dbType = Cyber_DataBase.getDBType();// "MSSQL";
        csql.CreateDBLink();
        return csql.Cyber_SetConnstring(Cyber_DataBase.getConnArray());
    }


    private void demo_excel2003 ()
    {
        Conn_CyberSQL csql = new Conn_CyberSQL();


        csql.dbType = "EXCEL2003";
        csql.CreateDBLink();
        String constr = csql.Cyber_makeDeaulrConn("excel 路径");
        csql.Cyber_SetConn(constr);
        csql.Open();
        //  MessageBox.Show(tem_ID);
        // DataSet ds = csql.Cient_ExexSql("select * from [协警人员$] ");


        csql.Close();
    }

    private void demo_mysql()
    {
        Conn_CyberSQL csql = new Conn_CyberSQL();


        csql.dbType = "MySQL";
        csql.CreateDBLink();
        // string constr = csql.Cyber_makeDeaulrConn(path);
        //  csql.Cyber_SetConn(constr);
        String[] server_config = new String[5];
        server_config[0] = "127.0.0.1";
        server_config[1] = "hpyl";
        server_config[2] = "123456";
        server_config[3] = "checkdb";
        server_config[4] = "3306";


        csql.Cyber_SetConnstring(server_config);

        csql.Open();

        // DataSet ds = csql.Cient_ExexSql("select * from [协警人员$] ");
        boolean b = csql.ExexSqlCmd("");


        csql.Close();


    }

    public void cyber_CreateDb(Context context, String dbname) {
        Cyber_DatabaseHelper_Sqlite dbHelper = new Cyber_DatabaseHelper_Sqlite(context,dbname);

        // 步骤2：真正创建 / 打开数据库
        SQLiteDatabase sqliteDatabase = dbHelper.getWritableDatabase(); // 创建 or 打开 可读/写的数据库
        //SQLiteDatabase sqliteDatabase = dbHelper.getReadableDatabase(); // 创建 or 打开 可读的数据库
    }




}
