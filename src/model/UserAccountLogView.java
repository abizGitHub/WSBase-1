package model;

import java.sql.Time;
import java.util.Date;

public class UserAccountLogView extends BaseModel {

    private long userAccountId;
    private Boolean hasPermission;
    private Date lastConnectDate;
    private Time lastConnectTime;
    private Integer logType;
    private String userName;
    private Long deletedUserAccountId;

    public long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(long userAccountId) {
        this.userAccountId = userAccountId;
    }

    public Boolean getHasPermission() {
        return hasPermission;
    }

    public void setHasPermission(Boolean hasPermission) {
        this.hasPermission = hasPermission;
    }

    public UserAccountLogView() {
    }

    public Date getLastConnectDate() {
        return lastConnectDate;
    }

    public void setLastConnectDate(Date lastConnectDate) {
        this.lastConnectDate = lastConnectDate;
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public Date getLastConnectTime() {
        return lastConnectTime;
    }

    public void setLastConnectTime(Time lastConnectTime) {
        this.lastConnectTime = lastConnectTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getDeletedUserAccountId() {
        return deletedUserAccountId;
    }

    public void setDeletedUserAccountId(Long deletedUserAccountId) {
        this.deletedUserAccountId = deletedUserAccountId;
    }
}
