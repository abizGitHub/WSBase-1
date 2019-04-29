package service;

import model.GeneralModel;
import model.ModelMap;

import java.util.ArrayList;

public interface GeneralService {
    ArrayList<GeneralModel> getTestGeneralList();

    ArrayList<GeneralModel> getAllGeneralList(Integer tableIx);

    ArrayList<GeneralModel> getGeneralListAfter(Integer tableIx, Long id);

    ArrayList<Long> getLastGeneralIds();

    ArrayList<ModelMap> getModelMapAfter(Long lastModelMapId);

    ArrayList<Long> getModelMap2DeleteAfter(Long lastModelMapId);
}
