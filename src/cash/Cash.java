package cash;

import model.Confiq;
import model.ModelMap;
import model.TagVisiblity;
import model.UserAccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Cash {

    Confiq confiq;
    ArrayList<TagVisiblity> tagVisiblities;
    ArrayList<ModelMap> modelMaps;
    ArrayList<Long> mmToDel;
    HashMap<Long, Integer> userLastTime;

    private static Cash ourInstance = new Cash();
    private Long lastModelMapId;

    public static Cash o() {
        return ourInstance;
    }

    private Cash() {
        confiq = new Confiq();
        userLastTime = new HashMap<>();
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

    public ArrayList<TagVisiblity> loadAllTagVis() {
        return tagVisiblities;
    }

    public ArrayList<ModelMap> getModelMapAfter(Long lastModelMapId) {
        return (ArrayList<ModelMap>) modelMaps.stream().filter(mm -> (mm.getId() > lastModelMapId && mm.getIdDelete() == null)).collect(Collectors.toList());
    }

    public ArrayList<Long> getModelMap2DeleteAfter(Long lastModelMapId) {
        return (ArrayList<Long>) mmToDel.stream().filter(l -> l.longValue() > lastModelMapId).collect(Collectors.toList());
    }

    public void setTagVisiblities(ArrayList<TagVisiblity> tagVisiblities) {
        this.tagVisiblities = tagVisiblities;
    }

    public void setModelMaps(ArrayList<ModelMap> modelMaps) {
        this.modelMaps = modelMaps;
    }

    public void setMmToDel(ArrayList<Long> mmToDel) {
        this.mmToDel = mmToDel;
    }

    public Long getLastModelMapId() {
        return lastModelMapId;
    }

    public void setLastModelMapId(Long lastModelMapId) {
        this.lastModelMapId = lastModelMapId;
    }

    public boolean userIntervalPassed(UserAccount loaded) {
        if (loaded == null)
            return true;
        Integer cnt = userLastTime.get(loaded.getId());
        if (cnt == null)
            cnt = 0;
        if (cnt > 6) {
            cnt = 0;
        }
        userLastTime.put(loaded.getId(), ++cnt);
        return cnt < 2;
    }
}
