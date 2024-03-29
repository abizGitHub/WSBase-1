package model;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Abiz
 * Date: 2/28/19
 * Time: 10:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class GeneralModel implements Serializable {

    public static final String TITLE$ = "TITLE";
    public static final String HEADERL$ = "HEADER_L";
    public static final String HEADERR$ = "HEADER_R";
    public static final String BODY$ = "BODY";
    public static final String FOOTERL$ = "FOOTER_L";
    public static final String FOOTERR$ = "FOOTER_R";
    public static final String STAR$ = "STARED";

    String title;
    String body;
    String headerL;
    String headerR;
    String footerL;
    String footerR;
    Long id;
    boolean stared = false;
    //TITLE = 1;HEADER_R = 2;HEADER_L = 3;BODY = 4;FOOTER_R = 5;FOOTER_L = 6;
    public static int TITLE = 1;
    public static int HEADER_R = 2;
    public static int HEADER_L = 3;
    public static int BODY = 4;
    public static int FOOTER_R = 5;
    public static int FOOTER_L = 6;
    public static int STAR = 7;
    public static HashMap<Integer, String> columnMap;

    static {
        columnMap = new HashMap<>();
        columnMap.put(TITLE, TITLE$);
        columnMap.put(BODY, BODY$);
        columnMap.put(HEADER_L, HEADERL$);
        columnMap.put(HEADER_R, HEADERR$);
        columnMap.put(FOOTER_L, FOOTERL$);
        columnMap.put(FOOTER_R, FOOTERR$);
    }

    public GeneralModel() {

    }

    public GeneralModel(JSONObject json) throws JSONException {
        this.setId(Long.valueOf(json.get("ID").toString()));
        this.setTitle(json.get(TITLE$).toString());
        this.setHeaderL(json.get(HEADERL$).toString());
        this.setHeaderR(json.get(HEADERR$).toString());
        this.setBody(json.get(BODY$).toString());
        this.setFooterL(json.get(FOOTERL$).toString());
        this.setFooterR(json.get(FOOTERR$).toString());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getStared() {
        return stared;
    }

    public void setStared(boolean stared) {
        this.stared = stared;
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

    public void applyModelMap(ArrayList<ModelMap> modelMaps) {
        if (modelMaps.isEmpty())
            return;
        for (ModelMap modelMap : modelMaps) {
            if (TITLE == modelMap.getColumnIx() && this.getTitle().equals(modelMap.getIntValue())) {
                this.setTitle(modelMap.getStringValue());
            }
            if (HEADER_R == modelMap.getColumnIx() && this.getHeaderR().equals(modelMap.getIntValue())) {
                this.setHeaderR(modelMap.getStringValue());
            }
            if (HEADER_L == modelMap.getColumnIx() && this.getHeaderL().equals(modelMap.getIntValue())) {
                this.setHeaderL(modelMap.getStringValue());
            }
            if (BODY == modelMap.getColumnIx() && this.getBody().equals(modelMap.getIntValue())) {
                this.setBody(modelMap.getStringValue());
            }
            if (FOOTER_R == modelMap.getColumnIx() && this.getFooterR().equals(modelMap.getIntValue())) {
                this.setFooterR(modelMap.getStringValue());
            }
            if (FOOTER_L == modelMap.getColumnIx() && this.getFooterL().equals(modelMap.getIntValue())) {
                this.setFooterL(modelMap.getStringValue());
            }
        }
    }

    public void fillMock() {
        int rnd = new Random().nextInt(100);
        setTitle("title-" + rnd);
        StringBuffer buffer = new StringBuffer("<body");
        for (int i = 0; i < 200; i++) {
            buffer.append("  -" + i + "- body ");
        }
        setBody(buffer.toString() + "/>" + rnd);
        setHeaderL("headerL-" + rnd);
        setHeaderR("headerR-" + rnd);
        setFooterL("footerL-" + rnd);
        setFooterR("footerR-" + rnd);
        setId(Long.valueOf(rnd));
        //setStared(rnd > 50);
    }

    @Override
    public String toString() {
        return title + "(" + headerL + "-" + headerR + ")" + body + "(" + footerL + "-" + footerR + ")";
    }
}
