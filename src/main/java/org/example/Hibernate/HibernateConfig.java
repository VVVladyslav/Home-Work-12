package org.example.Hibernate;
import lombok.Getter;
import org.example.Entity.Client;
import org.example.Entity.Planet;
import org.example.Entity.Ticket;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class HibernateConfig {
    private static final HibernateConfig INSTANCE;

    @Getter
    private SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateConfig();
    }

    private HibernateConfig() {
        try {
            sessionFactory = new Configuration()
                    .addAnnotatedClass(Client.class)
                    .addAnnotatedClass(Planet.class)
                    .addAnnotatedClass(Ticket.class)
                    .buildSessionFactory();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    public static HibernateConfig getInstance() {
        return INSTANCE;
    }

    public void close() throws HibernateException {
        sessionFactory.close();
    }
}
