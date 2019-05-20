package model;

import java.sql.Time;
import java.util.Date;

public class UserAccountLog extends BaseModel {

    private long userAccountId;
    private Boolean hasPermission;
    private Date lastConnectDate;
    private Time lastConnectTime;
    private Integer logType;
    public static int REGISTERED = 1;
    public static int REVIVED = 2;
    public static int MODELMAPUPDATED = 3;
    public static int GROUPUPDATED = 4;
    public static int PERMISSIONUPDATED = 5;
    public static int USERUPDATED = 6;
    public static int CONFIQUPDATED = 7;


    public UserAccountLog(UserAccount user, int type) {
        this.userAccountId = user.getId();
        this.lastConnectDate = new Date();
        this.lastConnectTime = new Time(new Date().getTime());
        this.logType = type;
    }

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

    public UserAccountLog() {
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
}
