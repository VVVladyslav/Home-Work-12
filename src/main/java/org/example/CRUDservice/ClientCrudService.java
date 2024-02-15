package org.example.CRUDservice;

import org.example.Entity.Client;
import org.example.Hibernate.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class ClientCrudService {
    public void createClient(Client client) {
        try (Session session = HibernateConfig.getInstance().getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(client);
            tx.commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public Client getByIdClient(Long id) {
        try (Session session = HibernateConfig.getInstance().getSessionFactory().openSession()) {
            return session.get(Client.class, id);
        }
    }

    public List<Client> getAllClients() {
        try (Session session = HibernateConfig.getInstance().getSessionFactory().openSession()) {
            return session.createQuery("FROM Client", Client.class).list();
        }
    }

    public void updateClient(Client client) {
        try (Session session = HibernateConfig.getInstance().getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(client);
            tx.commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public void deleteClient(int clientId) {
        try (Session session = HibernateConfig.getInstance().getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();

            Client clientToDelete = session.get(Client.class, clientId);
            if (clientToDelete != null) {
                session.delete(clientToDelete);
                tx.commit();
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}