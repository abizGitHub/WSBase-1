package model;

import java.sql.Time;

public class UserAccountLog extends BaseModel {

    private long userAccountId;
    private Boolean hasPermission;
    private Time lastConnectTime;

    public long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(long userAccountId) {
        this.userAccountId = userAccountId;
    }

    public Time getLastConnectTime() {
        return lastConnectTime;
    }

    public void setLastConnectTime(Time lastConnectTime) {
        this.lastConnectTime = lastConnectTime;
    }

    public Boolean getHasPermission() {
        return hasPermission;
    }

    public void setHasPermission(Boolean hasPermission) {
        this.hasPermission = hasPermission;
    }
}
