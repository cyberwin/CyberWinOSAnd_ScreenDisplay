package CyberWinPHP.Cyber_DataBase;

public class DataColumnCollection {
    private  int 未来之窗总数=0;

    public  DataColumn addColumn(String columnName,
                           int dataType){
          未来之窗总数=未来之窗总数+1;
        return new DataColumn(columnName);

    }

    public  boolean add(DataColumn row){
        return  true;
    }

    public  DataColumn get(int row){
        return  new DataColumn();
    }

    public  DataColumn get(String row){
        return  new DataColumn();
    }
//2022-10-30 未来之窗总数
    public  int count(){
        return  未来之窗总数;
    }


}
