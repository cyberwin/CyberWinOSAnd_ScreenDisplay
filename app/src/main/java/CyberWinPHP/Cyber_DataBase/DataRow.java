package CyberWinPHP.Cyber_DataBase;

import java.util.LinkedHashMap;
import java.util.Map;

public class DataRow {

    //定义该行记录在table所处的行数
    private int rowIndex = -1;
    private DataColumnCollection columns;
    //table的一个引用
    private DataTable table;
    //用于存储数据的Map对象，这里保存的对象不包括顺序信息，数据获取的索引通过行信息标识
    private Map<String, Object> itemMap = new LinkedHashMap<String, Object>();

    public DataRow() {

    }

    public DataRow(DataTable table) {
        this.table = table;
    }

    /**
     * 22:       * 功能描述：  获取当前行的行索引
     * 23:       * @param
     * 24:       * @return: int
     * 25:
     */
    public int getRowIndex() {
        return rowIndex;
    }

    /**
     * 31:       * 功能描述：  获取当前行所属数据表对象
     * 32:       * @param
     * 33:       * @return: DataTable
     * 34:
     */
    public DataTable getTable() {
        return this.table;
    }

    /**
     * 40:       * @param columns
     * 41:
     */
    public void setColumns(DataColumnCollection columns) {
        this.columns = columns;
    }

    /**
     * 47:       * @return  the columns
     * 48:
     */
    public DataColumnCollection getColumns() {
        return columns;
    }

    public void setValue(int index,
                         Object value) {
        setValue(this.columns.get(index), value);
    }

    public void setValue(String columnName,
                         Object value) {
        setValue(columns.get(columnName), value);
    }

    public void setValue(DataColumn column,
                         Object value) {
        if (column != null) {
            String lowerColumnName = column.getColumnName().toLowerCase();
            if (getItemMap().containsKey(lowerColumnName))
                getItemMap().remove(lowerColumnName);
            getItemMap().put(lowerColumnName, column.convertTo(value));
        }
    }

    public Object getValue(int index) {
        String colName = this.columns.get(index).getColumnName().toLowerCase();
        return this.getItemMap().get(colName);
    }

    public Object getValue(String columnName) {
        return this.getItemMap().get(columnName.toLowerCase());
    }

    /**
     * 83:       * @return  the itemMap
     * 84:
     */
    public Map<String, Object> getItemMap() {
        return itemMap;
    }

    /**
     * 90:       * @param rowIndex
     * 91:
     */
    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public void copyFrom(DataRow row) {
        this.itemMap.clear();//首先请客当前记录
             /*
                   for (Object c : this.columns) {
                          this.itemMap.put(c.toString().toLowerCase(), row.getValue(c.toString()));
                        }
                   */
    }
}

