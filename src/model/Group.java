package model;


/**
 * Created by abiz on 5/11/2019.
 */

public class Group  extends BaseModel{

    public static final String ORDERED$ = "ORDERED";
    public static final String REGISTERED$ = "REGISTERED";
    private String name;
    public static int UNREGISTERED = 0;
    public static int ORDERED = 1;
    public static int REGISTERED = 2;
    private int status = UNREGISTERED;
    private int tableId;

    public Group(int tableId) {
        this.tableId = tableId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public Group() {
    }
}
