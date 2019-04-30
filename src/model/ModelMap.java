package model;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Abiz
 * Date: 3/28/19
 * Time: 12:46 AM
 * To change this template use File | Settings | File Templates.
 */

public class ModelMap extends BaseModel implements Serializable {


    public static final String COLUMNIX = "columnIx";
    public static final String INTVALUE = "intValue";
    public static final String STRINGVALUE = "stringValue";
    public static final String TABLEID = "tableId";

    private Integer tableId;
    private Integer columnIx; // GeneralModel statics;
    private Integer intValue;
    private String stringValue;
    private Long idDelete;

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Integer getColumnIx() {
        return columnIx;
    }

    public void setColumnIx(Integer columnIx) {
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

    public Long getIdDelete() {
        return idDelete;
    }

    public void setIdDelete(Long idDelete) {
        this.idDelete = idDelete;
    }

    @Override
    public String toString() {
        return tableId + " - " + columnIx + "-" + intValue + "-" + stringValue;
    }
}