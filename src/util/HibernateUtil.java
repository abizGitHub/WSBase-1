package util;

import model.BaseModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new Configuration().configure()
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<BaseModel> baseModels = (ArrayList<BaseModel>) session.createQuery("from BaseModel").list();
        for (BaseModel baseModel : baseModels) {

        }
    }

}
