package CyberWinPHP.Cyber_DataBase;

public class DataRowCollection {
    private DataColumnCollection _columns; //用于保存DataColumn的对象

    public DataRowCollection(){

    }

    public int size(){
        return 0;
    }

    public void setColumns(DataColumnCollection columns){
        _columns=columns;
    }

    public  DataRow get(int row){
        return  new DataRow();
    }
    public  boolean add(DataRow row){
        return  true;
    }


}
