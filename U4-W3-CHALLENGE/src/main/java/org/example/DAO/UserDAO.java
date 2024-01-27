package org.example.DAO;

import org.example.classes.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserDAO {

    private final EntityManager entityManager;

    public UserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(User user) {

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(user);
        transaction.commit();

        System.out.println("Complimenti l'utente " + user.getName()+" " + user.getSurname() + " è stato aggiunto con successo!");
    }

    public User findById(long userId) {

        return entityManager.find(User.class, userId);

    }

    public void findAndDeleteById(long userId) {

        User user = this.findById(userId);

        if (user != null) {

            EntityTransaction transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.remove(user);
            transaction.commit();

            System.out.println("Complimenti hai eliminato con successo l'utente " + user.getName() + " " + user.getSurname());

        } else {
            System.out.println("Ops! non ho trovato nessun utente tramite l'userId che mi hai fornito ");
        }
    }


}
