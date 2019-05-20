package service;


import model.BaseModel;

import java.util.ArrayList;
import java.util.HashMap;

public interface ServiceTemplate<M extends BaseModel, V extends BaseModel> {

    public void delete(M m);

    public long save(M m);

    public ArrayList<M> loadAll();

    public M findById(long id);

    public ArrayList<M> findBySQuery(String sql);

    public ArrayList<M> findByHQuery(String hql);

    public void deleteAll();

    public ArrayList<V> loadAllView();

    public ArrayList<V> loadAllViewAfter(Long id);

    public Long getLastId();

    public ArrayList<M> loadAllAfter(Long id, String condition);

    public ArrayList<Long> loadAllIdAfter(String select, Long id, String condition);

    public ArrayList<M> findByFilter(HashMap<String,Object> filter);

    public ArrayList<V> findViewByFilter(HashMap<String, Object> filter);
}
