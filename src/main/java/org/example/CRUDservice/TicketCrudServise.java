package org.example.CRUDservice;
import org.example.Entity.Client;
import org.example.Entity.Planet;
import org.example.Entity.Ticket;
import org.example.Hibernate.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TicketCrudServise {
    public void createTicket(Ticket ticket) {
        try (Session session = HibernateConfig.getInstance().getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();

            Client client = ticket.getClient();
            Planet sourcePlanet = ticket.getFrom_planet();
            Planet destinationPlanet = ticket.getTo_planet();
            if (client == null || sourcePlanet == null || destinationPlanet == null ||
                    session.get(Client.class, client.getId()) == null ||
                    session.get(Planet.class, sourcePlanet.getId()) == null ||
                    session.get(Planet.class, destinationPlanet.getId()) == null) {
                throw new IllegalArgumentException("Can't save ticket");
            }
            session.save(ticket);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Ticket readTicket(long ticketId) {
        Ticket ticket = null;
        try (Session session = HibernateConfig.getInstance().getSessionFactory().openSession()) {
            ticket = session.get(Ticket.class, ticketId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticket;
    }

    public void updateTicket(Ticket ticket) {
        try (Session session = HibernateConfig.getInstance().getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(ticket);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteTicket(long ticketId) {
        try (Session session = HibernateConfig.getInstance().getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Ticket ticket = session.get(Ticket.class, ticketId);
            session.delete(ticket);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}