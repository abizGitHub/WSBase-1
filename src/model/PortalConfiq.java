package model;

import java.util.ArrayList;

public class PortalConfiq extends BaseModel {

    private Integer lastGroupId1, lastGroupId2, lastGroupId3, lastGroupId4, lastGroupId5, lastGroupId6;
    private String tableName1, tableName2, tableName3, tableName4, tableName5, tableName6;
    private Boolean updateGroup;
    private Boolean haveNewChange;
    private Long lastModelMapId;
    private Boolean sendDetail;
    private Integer wait4Server;
    private Integer connectPeriod;
    private Boolean clearDB;
    private Long lastGMId1, lastGMId2, lastGMId3, lastGMId4, lastGMId5, lastGMId6;


    public Integer getLastGroupId1() {
        return lastGroupId1;
    }

    public void setLastGroupId1(Integer lastGroupId1) {
        this.lastGroupId1 = lastGroupId1;
    }

    public Integer getLastGroupId2() {
        return lastGroupId2;
    }

    public void setLastGroupId2(Integer lastGroupId2) {
        this.lastGroupId2 = lastGroupId2;
    }

    public Integer getLastGroupId3() {
        return lastGroupId3;
    }

    public void setLastGroupId3(Integer lastGroupId3) {
        this.lastGroupId3 = lastGroupId3;
    }

    public Integer getLastGroupId4() {
        return lastGroupId4;
    }

    public void setLastGroupId4(Integer lastGroupId4) {
        this.lastGroupId4 = lastGroupId4;
    }

    public Integer getLastGroupId5() {
        return lastGroupId5;
    }

    public void setLastGroupId5(Integer lastGroupId5) {
        this.lastGroupId5 = lastGroupId5;
    }

    public Integer getLastGroupId6() {
        return lastGroupId6;
    }

    public void setLastGroupId6(Integer lastGroupId6) {
        this.lastGroupId6 = lastGroupId6;
    }

    public Boolean getUpdateGroup() {
        return updateGroup;
    }

    public void setUpdateGroup(Boolean updateGroup) {
        this.updateGroup = updateGroup;
    }

    public Boolean getHaveNewChange() {
        return haveNewChange;
    }

    public void setHaveNewChange(Boolean haveNewChange) {
        this.haveNewChange = haveNewChange;
    }

    public Long getLastModelMapId() {
        return lastModelMapId;
    }

    public void setLastModelMapId(Long lastModelMapId) {
        this.lastModelMapId = lastModelMapId;
    }

    public Boolean getSendDetail() {
        return sendDetail;
    }

    public void setSendDetail(Boolean sendDetail) {
        this.sendDetail = sendDetail;
    }

    public Integer getWait4Server() {
        return wait4Server;
    }

    public void setWait4Server(Integer wait4Server) {
        this.wait4Server = wait4Server;
    }

    public Integer getConnectPeriod() {
        return connectPeriod;
    }

    public void setConnectPeriod(Integer connectPeriod) {
        this.connectPeriod = connectPeriod;
    }

    public Boolean getClearDB() {
        return clearDB;
    }

    public void setClearDB(Boolean clearDB) {
        this.clearDB = clearDB;
    }

    public String getTableName1() {
        return tableName1;
    }

    public void setTableName1(String tableName1) {
        this.tableName1 = tableName1;
    }

    public String getTableName2() {
        return tableName2;
    }

    public void setTableName2(String tableName2) {
        this.tableName2 = tableName2;
    }

    public String getTableName3() {
        return tableName3;
    }

    public void setTableName3(String tableName3) {
        this.tableName3 = tableName3;
    }

    public String getTableName4() {
        return tableName4;
    }

    public void setTableName4(String tableName4) {
        this.tableName4 = tableName4;
    }

    public String getTableName5() {
        return tableName5;
    }

    public void setTableName5(String tableName5) {
        this.tableName5 = tableName5;
    }

    public String getTableName6() {
        return tableName6;
    }

    public void setTableName6(String tableName6) {
        this.tableName6 = tableName6;
    }

    public Long getLastGMId1() {
        return lastGMId1;
    }

    public void setLastGMId1(Long lastGMId1) {
        this.lastGMId1 = lastGMId1;
    }

    public Long getLastGMId2() {
        return lastGMId2;
    }

    public void setLastGMId2(Long lastGMId2) {
        this.lastGMId2 = lastGMId2;
    }

    public Long getLastGMId3() {
        return lastGMId3;
    }

    public void setLastGMId3(Long lastGMId3) {
        this.lastGMId3 = lastGMId3;
    }

    public Long getLastGMId4() {
        return lastGMId4;
    }

    public void setLastGMId4(Long lastGMId4) {
        this.lastGMId4 = lastGMId4;
    }

    public Long getLastGMId5() {
        return lastGMId5;
    }

    public void setLastGMId5(Long lastGMId5) {
        this.lastGMId5 = lastGMId5;
    }

    public Long getLastGMId6() {
        return lastGMId6;
    }

    public void setLastGMId6(Long lastGMId6) {
        this.lastGMId6 = lastGMId6;
    }

    public ArrayList<Long> getLastIds() {
        ArrayList<Long> list = new ArrayList<>();
        list.add(lastGMId1);
        list.add(lastGMId2 == null ? 0 : lastGMId2);
        if(lastGMId3 == null)
            return list;
        list.add(lastGMId3);
        if(lastGMId4 == null)
            return list;
        list.add(lastGMId4);
        if(lastGMId5 == null)
            return list;
        list.add(lastGMId5);
        if(lastGMId6 == null)
            return list;
        list.add(lastGMId6);
        return list;
    }

    public ArrayList<Integer> getLastGrIds() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(lastGroupId1);
        list.add(lastGroupId2);
        list.add(lastGroupId3);
        list.add(lastGroupId4);
        list.add(lastGroupId5);
        list.add(lastGroupId6);
        return list;
    }

    public ArrayList<String> getLastTableNames() {
        ArrayList<String> list = new ArrayList<>();
        list.add(tableName1);
        list.add(tableName2);
        if (tableName3 == null || tableName3.trim().isEmpty())
            return list;
        list.add(tableName3);
        if (tableName4 == null || tableName4.trim().isEmpty())
            return list;
        list.add(tableName4);
        if (tableName5 == null || tableName5.trim().isEmpty())
            return list;
        list.add(tableName5);
        if (tableName6 == null || tableName6.trim().isEmpty())
            return list;
        list.add(tableName6);
        return list;
    }

}
