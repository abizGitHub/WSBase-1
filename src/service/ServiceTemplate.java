package service;


import model.BaseModel;

import java.util.ArrayList;
import java.util.HashMap;

public interface ServiceTemplate<M extends BaseModel, V extends BaseModel> {

    public void delete(M m);

    public void save(M m);

    public ArrayList<M> loadAll();

    public M findById(long id);

    public ArrayList<M> findBySQuery(String sql);

    public ArrayList<M> findByHQuery(String hql);

    public ArrayList<M> findByFilter(HashMap map);

    public void deleteAll();

    public ArrayList<V> loadAllView();

    public ArrayList<V> loadAllViewAfter(Long id);

    public Long getLastId();
}
