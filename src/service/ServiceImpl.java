package service;

import model.BaseModel;
import model.GMStruct;
import model.GeneralModel;
import model.TableTag;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Consts;
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
    public T findLastByFilter(HashMap<String, Object> filter) {
        return (T) findLastGenericByFilter(filter, clazz);
    }


    public ArrayList<T> findByFilterAndQuery(HashMap<String, Object> filter, String clause) {
        return (ArrayList<T>) findGenericByFilterAndQuery(filter, clazz, clause);
    }

    public ArrayList<V> findViewByFilterAndQuery(HashMap<String, Object> filter, String clause) {
        return (ArrayList<V>) findGenericByFilterAndQuery(filter, clavv, clause);
    }

    @Override
    public V findLastViewByFilter(HashMap<String, Object> filter) {
        return (V) findLastGenericByFilter(filter, clavv);
    }


    @Override
    public ArrayList<T> findByFilter(HashMap<String, Object> filter) {
        return (ArrayList<T>) findGenericByFilter(filter, clazz);
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

    private Object findLastGenericByFilter(HashMap<String, Object> map, Class cl) {
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
            sql.append(" and rownum = 1");
        }
        Object o = session.createQuery(sql.toString() + " order by p.id desc")
                .uniqueResult();
        session.close();
        return o;
    }

    private List findGenericByFilterAndQuery(HashMap<String, Object> map, Class cl, String clause) {
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
            sql.append(clause);
        }
        List list = session.createQuery(sql.toString() + " order by p.id desc")
                .list();
        session.close();
        return list;
    }

    @Override
    public ArrayList<GeneralModel> generalModelAfter(Integer tableIx, Long id) {
        ServiceImpl<GMStruct, GMStruct> service = ServiceFactory.getInstance().o().get(GMStruct.class);
        HashMap<String, Object> filter = new HashMap<>();
        filter.put("tableIx", tableIx);
        GMStruct struct = service.findByFilter(filter).get(0);
        StringBuffer query = new StringBuffer("SELECT ");
        //if (struct.getTitle() != null && struct.getTitle().trim().length() > 0)
        query.append(" TB." + struct.getTitle() + " AS title,");
        //if (struct.getBody() != null && struct.getBody().trim().length() > 0)
        query.append(" TB." + struct.getBody() + " AS body,");
        //if (struct.getHeaderR() != null && struct.getHeaderR().trim().length() > 0)
        query.append(" TB." + struct.getHeaderR() + " AS headerR,");
        //if (struct.getHeaderL() != null && struct.getHeaderL().trim().length() > 0)
        query.append(" TB." + struct.getHeaderL() + " AS headerL,");
        //if (struct.getFooterR() != null && struct.getFooterR().trim().length() > 0)
        query.append(" TB." + struct.getFooterR() + " AS footerR,");
        //if (struct.getFooterL() != null && struct.getFooterL().trim().length() > 0)
        query.append(" TB." + struct.getFooterL() + " AS footerL,");

        query.append("TB.id as id FROM ");
        query.append(struct.getTableName());
        query.append(" TB WHERE TB.id > " + id + " ORDER BY TB.id desc");
        Session session = HibernateUtil.getSessionFactory().openSession();
        List list = session.createSQLQuery(query.toString().replace("TB.null", "null")).addEntity(GeneralModel.class).list();
        session.close();
        return (ArrayList<GeneralModel>) list;
    }

    @Override
    public ArrayList<TableTag> tableTags() {
        ServiceImpl<TableTag, TableTag> service = ServiceFactory.getInstance().o().get(TableTag.class);
        return service.loadAll();
    }

    @Override
    public void deleteById(long id) {
        T byId = findById(id);
        delete(byId);
    }

    @Override
    public V findViewById(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        V v = (V) session.createQuery("from " + clavv.getName() + " p where p.id=" + id).uniqueResult();
        session.close();
        return v;
    }

    @Override
    public T findLastByAccountId(long id) {
        HashMap<String, Object> filter = new HashMap<>();
        filter.put(Consts.USERACCOUNTID, id);
        return findLastByFilter(filter);
    }

    @Override
    public ArrayList<T> findByAccountId(long id) {
        HashMap<String, Object> filter = new HashMap<>();
        filter.put(Consts.USERACCOUNTID, id);
        return findByFilter(filter);
    }

    public Class getClazz() {
        return clazz;
    }

    public static void main(String[] args) {
        GeneralServiceImpl.getInstance().getAllGeneralList(0);
    }

}
