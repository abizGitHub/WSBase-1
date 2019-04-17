package model;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Abiz
 * Date: 3/28/19
 * Time: 12:46 AM
 * To change this template use File | Settings | File Templates.
 */

public class ModelMap implements Serializable {

    private int tableId;
    private int columnIx; // GeneralModel statics;
    private Integer intValue;
    private String stringValue;

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getColumnIx() {
        return columnIx;
    }

    public void setColumnIx(int columnIx) {
        this.columnIx = columnIx;
    }

    public Integer getIntValue() {
        return intValue;
    }

    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }
}
