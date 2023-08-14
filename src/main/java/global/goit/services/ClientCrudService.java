package global.goit.services;


import global.goit.entities.Client;
import global.goit.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class ClientCrudService {

    public void createClient(Client client) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        } catch (SessionException e) {
            throw new RuntimeException();
        }
    }

    public Client readClient(Long clientId) {
        Client client;
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            client = session.get(Client.class, clientId);
            transaction.commit();
        } catch (SessionException e) {
            throw new RuntimeException();
        }
        return client;
    }

    public void updateClient(int clientId, String name) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createQuery("UPDATE Client SET name =: name WHERE id =: client_id")
                    .setParameter("name", name)
                    .setParameter("client_id", clientId)
                    .executeUpdate();
            transaction.commit();
        } catch (SessionException e) {
            throw new RuntimeException();
        }
    }

    public void deleteClient(int clientId) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createQuery("DELETE FROM Client WHERE id= :client_id")
                    .setParameter("client_id", clientId)
                    .executeUpdate();
            transaction.commit();
        } catch (SessionException e) {
            throw new RuntimeException();
        }
    }

    public List<Client> getAllClients() {
        List<Client> clients;
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            clients = session.createQuery("SELECT client FROM Client client", Client.class).list();
            transaction.commit();
        } catch (SessionException e) {
            throw new RuntimeException();
        }
        return clients;
    }
}
