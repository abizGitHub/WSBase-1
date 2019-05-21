package model;


public class GMStruct extends BaseModel{

    private String tableName;
    private Integer tableIx;
    private String title;
    private String headerL;
    private String headerR;
    private String body;
    private String footerL;
    private String footerR;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Integer getTableIx() {
        return tableIx;
    }

    public void setTableIx(Integer tableIx) {
        this.tableIx = tableIx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeaderL() {
        return headerL;
    }

    public void setHeaderL(String headerL) {
        this.headerL = headerL;
    }

    public String getHeaderR() {
        return headerR;
    }

    public void setHeaderR(String headerR) {
        this.headerR = headerR;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFooterL() {
        return footerL;
    }

    public void setFooterL(String footerL) {
        this.footerL = footerL;
    }

    public String getFooterR() {
        return footerR;
    }

    public void setFooterR(String footerR) {
        this.footerR = footerR;
    }
}
