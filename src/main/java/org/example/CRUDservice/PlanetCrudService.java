package org.example.CRUDservice;

import org.example.Entity.Planet;
import org.example.Hibernate.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class PlanetCrudService {
    public void createPlanet(Planet planet) {
        try (Session session = HibernateConfig.getInstance().getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(planet);
            tx.commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
    public Planet getByNamePlanet(String id) {
        try (Session session = HibernateConfig.getInstance().getSessionFactory().openSession()) {
            return session.get(Planet.class, id);
        }
    }
    public List<Planet> getAllPlanets() {
        try (Session session = HibernateConfig.getInstance().getSessionFactory().openSession()) {
            return session.createQuery("FROM Planet", Planet.class).list();
        }
    }
    public void updatePlanet(Planet planet) {
        try (Session session = HibernateConfig.getInstance().getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(planet);
            tx.commit();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    public void deletePlanet(String planet) {
        try (Session session = HibernateConfig.getInstance().getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();

            Planet clientToDelete = session.get(Planet.class, planet);
            if (clientToDelete != null) {
                session.delete(clientToDelete);
                tx.commit();
            } else {
                System.out.println(planet + " id not found.");
            }
        } catch (RuntimeException e) {
            throw e;
        }
    }
}
