package org.example.DAO;

import org.example.abstractClasses.Catalog;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class CatalogDAO {

    private final EntityManager entityManager;

    public CatalogDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Catalog ele) {

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(ele);
        transaction.commit();

        System.out.println("Complimenti " + ele.getTitle() + " è stato aggiunto con successo!");
    }

    public Catalog findById(long idISBN) {

        return entityManager.find(Catalog.class, idISBN);

    }

    public void findAndDeleteById(long idISBN) {

        Catalog ele = this.findById(idISBN);

        if (ele != null) {

            EntityTransaction transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.remove(ele);
            transaction.commit();

            System.out.println("Complimenti hai eliminato con successo " + ele.getTitle());

        } else {
            System.out.println("Ops! non ho trovato nessun elemento tramite il codice ISBN che mi hai fornito ");
        }
    }

// RICERCA PER ANNO DI PUBBLICAZIONE

    public List<Catalog> searchByPublicationYear(int year) {

        TypedQuery<Catalog> query = entityManager.createNamedQuery("searchByPublicationYear", Catalog.class);
        query.setParameter("yearOfPublication", year);

        if (query.getResultList().isEmpty()) {

        System.out.println("Mi dispiace , nell anno " + year + " non è stato pubblicato nessun elemento del catalogo");

        }
        return query.getResultList();
    }


    // RICERCA PER AUTORE

    public List<Catalog> searchByAuthor(String author) {

        TypedQuery<Catalog> query = entityManager.createNamedQuery("searchByAuthor", Catalog.class);
        query.setParameter("author", author);

        if (query.getResultList().isEmpty()) {

            System.out.println("Mi dispiace ,non è stato pubblicato nessun elemento del catalogo dall autore di nome " + author);

        }
        return query.getResultList();
    }


    //RICERCA PER TITOLO O PARTIAL DEL TITOLO

    public List<Catalog> searchByTitle(String partialTitle) {

        TypedQuery<Catalog> query = entityManager.createNamedQuery("searchByTitle", Catalog.class);
        query.setParameter("partial", partialTitle);

        if (query.getResultList().isEmpty()) {

            System.out.println("Mi dispiace ,non è stato pubblicato nessun elemento intitolato in questo modo ");

        }
        return query.getResultList();
    }


    // RICERCA ELEMENTI IN PRESTITO TRAMITE USER

    public List<Catalog> searchLoanByUser(long myId) {

        TypedQuery<Catalog> query = entityManager.createNamedQuery("searchLoanByUser", Catalog.class);
        query.setParameter("myId", myId);

        if (query.getResultList().isEmpty()) {

            System.out.println("Nessun elemento attualmente in prestito per l'utente con l'id inserito");

        }
        return query.getResultList();
    }


    // RICERCA DEI PRESTITI SCADUTI

    public List<Catalog> searchExpiredLoans() {

        TypedQuery<Catalog> query = entityManager.createNamedQuery("searchExpiredLoans", Catalog.class);
        if (query.getResultList().isEmpty()) {

            System.out.println("non ho trovato nessun elemento con il prestito scaduto , tutto in regola!");

        }
        return query.getResultList();
    }
}
