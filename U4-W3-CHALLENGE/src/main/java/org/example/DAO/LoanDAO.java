package org.example.DAO;

import org.example.classes.Loan;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LoanDAO {

    private final EntityManager entityManager;

    public LoanDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void save(Loan loan){

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(loan);
        transaction.commit();

        System.out.println("Complimenti il prestito con id " + loan.getId() + " è stato aggiunto con successo!");
    }

    public Loan findById ( long idLoan){

        return entityManager.find(Loan.class, idLoan);

    }

    public void findAndDeleteById(long idLoan){

        Loan loan = this.findById(idLoan);

        if (loan != null) {

            EntityTransaction transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.remove(loan);
            transaction.commit();

            System.out.println("Complimenti hai eliminato con successo il prestito con id " + loan.getId());

        } else {
            System.out.println("Ops! non ho trovato nessun elemento tramite l'idLoan che mi hai fornito ");
        }
    }

}
