package model;

/**
 * Created by abiz on 5/12/2019.
 */

public class UserAccount extends BaseModel{

    private String userName ;
    private String password ;
    private String phone ;
    private String email ;
    private Boolean hasPermission;
    private Integer permissionDays;
    private Long lastMsgId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getHasPermission() {
        return hasPermission;
    }

    public void setHasPermission(Boolean hasPermission) {
        this.hasPermission = hasPermission;
    }

    public Integer getPermissionDays() {
        return permissionDays;
    }

    public void setPermissionDays(Integer permissionDays) {
        this.permissionDays = permissionDays;
    }

    public Long getLastMsgId() {
        return lastMsgId;
    }

    public void setLastMsgId(Long lastMsgId) {
        this.lastMsgId = lastMsgId;
    }
}
