package cash;

import model.Confiq;
import model.TagVisiblity;

import java.util.ArrayList;

public class Cash {

    Confiq confiq;
    ArrayList<TagVisiblity> tagVisiblities;


    private static Cash ourInstance = new Cash();

    public static Cash o() {
        return ourInstance;
    }

    private Cash() {
        confiq = new Confiq();
        confiq.setUserName("newSeen");
        confiq.setHaveNewChange(true);
        ArrayList<String> names = new ArrayList<>();
        names.add("one");
        names.add("two");
        confiq.setLastTablesName(names);
        confiq.setHaveNewChange(true);
        ArrayList<TagVisiblity> tagV = new ArrayList<>();
        tagV.add(new TagVisiblity(1).fillMock().doStarVisible(true));
        tagV.add(new TagVisiblity(2).fillMock().doStarVisible(true));
        confiq.setTagVisiblity(tagV);
    }

    public Confiq getConfiq() {
        return confiq;
    }

    public ArrayList<TagVisiblity> getTagVisiblities() {
        return tagVisiblities;
    }

}
