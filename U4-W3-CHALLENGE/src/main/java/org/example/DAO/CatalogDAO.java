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
}
