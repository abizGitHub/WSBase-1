package service;

import model.GeneralModel;

import java.util.ArrayList;

public class GeneralService {

    private static GeneralService ourInstance = new GeneralService();

    public static GeneralService getInstance() {
        return ourInstance;
    }

    private GeneralService() {
    }

    public ArrayList<GeneralModel> getTestGeneralList() {
        ArrayList<GeneralModel> testGeneralList = new ArrayList<>();
        for (int i = 0; i < 3000; i++) {
            GeneralModel generalModel = new GeneralModel();
            generalModel.fillMock();
            testGeneralList.add(generalModel);
        }
        return testGeneralList;
    }

}
