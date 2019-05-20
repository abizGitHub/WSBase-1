package service;

import model.BaseModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ServiceImpl<T extends BaseModel, V extends BaseModel> implements ServiceTemplate<T, V> {

    Class<T> clazz;
    Class<V> clavv;

    public ServiceImpl(Class<T> clazz, Class<V> clavv) {
        this.clazz = clazz;
        this.clavv = clavv;
    }

    @Override
    public void delete(T t) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(t);
        transaction.commit();
        session.close();
    }

    @Override
    public long save(T t) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(t);
        transaction.commit();
        session.close();
        return t.getId();
    }

    @Override
    public ArrayList<T> loadAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<T> list = (ArrayList<T>)
                session.createQuery("from " + clazz.getName() + " p order by p.id desc")
                        .list();
        session.close();
        return list;
    }

    @Override
    public T findById(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        T t = (T) session.createQuery("from " + clazz.getName() + " p where p.id=" + id).uniqueResult();
        session.close();
        return t;
    }

    @Override
    public ArrayList<T> findBySQuery(String sql) {
        return null;
    }


    @Override
    public ArrayList<T> findByHQuery(String hql) {
        return null;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public ArrayList<V> loadAllView() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<V> list = (ArrayList<V>)
                session.createQuery("from " + clavv.getName() + " p order by p.id desc")
                        .list();
        session.close();
        return list;
    }

    @Override
    public ArrayList<V> loadAllViewAfter(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<V> list = (ArrayList<V>)
                session.createQuery("from " + clavv.getName() + " p where p.id > " + id + " order by p.id desc")
                        .list();
        session.close();
        return list;
    }

    @Override
    public Long getLastId() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Long result = (Long) session.createQuery("select max(p.id) from " + clazz.getName() + " p").uniqueResult();
        session.close();
        return result;
    }

    @Override
    public ArrayList<T> loadAllAfter(Long id, String condition) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<T> list = (ArrayList<T>)
                session.createQuery("from " + clazz.getName() + " p where p.id > " + id + " AND " + condition + " order by p.id desc")
                        .list();
        session.close();
        return list;
    }

    @Override
    public ArrayList<Long> loadAllIdAfter(String select, Long id, String condition) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Long> list = (ArrayList<Long>)
                session.createQuery(select + clazz.getName() + " p where p.id > " + id + " AND " + condition + " order by p.id desc")
                        .list();
        session.close();
        return list;
    }

    @Override
    public ArrayList<V> findViewByFilter(HashMap<String, Object> filter) {
        return (ArrayList<V>) findGenericByFilter(filter, clavv);
    }


    @Override
    public ArrayList<T> findByFilter(HashMap<String, Object> filter) {
        return (ArrayList<T>) findGenericByFilter(filter, clavv);
    }

    private List findGenericByFilter(HashMap<String, Object> map, Class cl) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        StringBuffer sql = new StringBuffer("from " + cl.getName() + " p");
        if (map.size() > 0) {
            sql.append(" where 1=1 ");
            for (String key : map.keySet()) {
                Object param = map.get(key);
                if (param instanceof String) {
                    sql.append(" and ").append(key).append("=");
                    sql.append("'").append(param).append("'");
                } else if (param instanceof Number) {
                    sql.append(" and ").append(key).append("=");
                    sql.append(param);
                }
            }
        }
        List list =
                session.createQuery(sql.toString() + " order by p.id desc")
                        .list();
        session.close();
        return list;
    }

    public Class getClazz() {
        return clazz;
    }

    public static void main(String[] args) {
        GeneralServiceImpl.getInstance().getAllGeneralList(0);
    }

}
