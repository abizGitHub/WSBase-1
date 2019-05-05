package util;

import model.GeneralModel;
import model.TagVisiblity;
import ws.GetGeneralModel;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by abiz on 4/30/2019.
 */

public class Utils {

    public static ArrayList<String> extractTitles(ArrayList<GeneralModel> generalList) {
        ArrayList<String> titles = new ArrayList<>();
        if (generalList == null || generalList.isEmpty())
            return titles;
        for (GeneralModel generalModel : generalList) {
            titles.add(generalModel.getTitle());
        }
        return titles;
    }

    public static String stringList(ArrayList<Integer> ints) {
        ArrayList<String> list = new ArrayList<>();
        for (Integer anInt : ints) {
            list.add("'" + anInt + "'");
        }
        return Arrays.toString(list.toArray()).replaceAll(" ", "").replaceAll("\\[", "(").replaceAll("]", ")");
    }

    private Utils addQuery(String colName, ArrayList<Integer> l) {
        String in = stringList(l);
        if (l.isEmpty())
            in = "('9999')";
        if (query.contains("IN"))
            query += " OR " + colName + " IN " + in;
        else
            query += colName + " IN " + in;
        return utils;
    }

    private static Utils utils = new Utils();

    private static String query;

    public static Utils o() {
        return utils;
    }

    public static String getQuery() {
        return query;
    }

    private Utils() {
    }

    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<Integer>();
        l.add(1);
        l.add(2);
        l.add(3);
        System.out.println(Arrays.toString(l.toArray()).replaceAll(" ", "").replaceAll("\\[", "(").replaceAll("]", ")"));
        System.out.println(stringList(l));
        String query = Utils.o().startQuery().
                addQuery("col0", new ArrayList<>()).
                addQuery("col1", l).
                addQuery("col2", l).
                addQuery("col3", l).
                addQuery("col4", new ArrayList<>()).
                addQuery("col5", l).
                getQuery();
        System.out.println(query);
        query = Utils.o().addQuery("col0", new ArrayList<>()).
                addQuery("col1", l).
                addQuery("col2", l).
                addQuery("col3", l).
                addQuery("col4", new ArrayList<>()).
                addQuery("col5", l).
                getQuery();
        System.out.println(query);
    }

    public static Utils startQuery(){
        query = "";
        return utils;
    }

}
