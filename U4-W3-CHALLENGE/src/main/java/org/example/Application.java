package org.example;

import com.github.javafaker.Faker;
import org.example.DAO.CatalogDAO;
import org.example.DAO.LoanDAO;
import org.example.DAO.UserDAO;
import org.example.classes.Book;
import org.example.classes.Loan;
import org.example.classes.Magazine;
import org.example.classes.User;
import org.example.enums.Periodicity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Locale;

public class Application {

    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d5");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        CatalogDAO cDAO = new CatalogDAO(em);
        UserDAO uDAO = new UserDAO(em);
        LoanDAO lDAO = new LoanDAO(em);

        Faker faker = new Faker(Locale.ITALY);

        //---------------------------------------------CREAZIONE ELEMENTI---------------------------------------------------------------

        //CREO 5 UTENTI
        User user1 = new User(faker.name().firstName(), faker.name().lastName(), LocalDate.parse("2000-12-05"));
        User user2 = new User(faker.name().firstName(), faker.name().lastName(), LocalDate.parse("2000-12-05"));
        User user3 = new User(faker.name().firstName(), faker.name().lastName(), LocalDate.parse("2000-12-05"));
        User user4 = new User(faker.name().firstName(), faker.name().lastName(), LocalDate.parse("2000-12-05"));
        User user5 = new User(faker.name().firstName(), faker.name().lastName(), LocalDate.parse("2000-12-05"));
//        uDAO.save(user1);
//        uDAO.save(user2);
//        uDAO.save(user3);
//        uDAO.save(user4);
//        uDAO.save(user5);


        //CREO 10 ELEMENTI DEL CATALOGO 5 LIBRI E 5 RIVISTE
        Book book1 = new Book(faker.book().title(), faker.number().numberBetween(1900, 2023), faker.number().numberBetween(100, 780), faker.book().author(), faker.book().genre());
        Magazine magazine1 = new Magazine(faker.book().title(), faker.number().numberBetween(2010, 2024), faker.number().numberBetween(20, 90), Periodicity.HALF_YEARLY);
        Book book2 = new Book(faker.book().title(), faker.number().numberBetween(1900, 2023), faker.number().numberBetween(100, 780), faker.book().author(), faker.book().genre());
        Magazine magazine2 = new Magazine(faker.book().title(), faker.number().numberBetween(2010, 2024), faker.number().numberBetween(20, 90), Periodicity.MONTHLY);
        Book book3 = new Book(faker.book().title(), faker.number().numberBetween(1900, 2023), faker.number().numberBetween(100, 780), faker.book().author(), faker.book().genre());
        Magazine magazine3 = new Magazine(faker.book().title(), faker.number().numberBetween(2010, 2024), faker.number().numberBetween(20, 90), Periodicity.HALF_YEARLY);
        Book book4 = new Book(faker.book().title(), faker.number().numberBetween(1900, 2023), faker.number().numberBetween(100, 780), faker.book().author(), faker.book().genre());
        Magazine magazine4 = new Magazine(faker.book().title(), faker.number().numberBetween(2010, 2024), faker.number().numberBetween(20, 90), Periodicity.WEEKLY);
        Book book5 = new Book(faker.book().title(), faker.number().numberBetween(1900, 2023), faker.number().numberBetween(100, 780), faker.book().author(), faker.book().genre());
        Magazine magazine5 = new Magazine(faker.book().title(), faker.number().numberBetween(2010, 2024), faker.number().numberBetween(20, 90), Periodicity.WEEKLY);
//       cDAO.save(book1);
//        cDAO.save(book2);
//        cDAO.save(book3);
//        cDAO.save(book4);
//        cDAO.save(book5);
//        cDAO.save(magazine1);
//        cDAO.save(magazine2);
//        cDAO.save(magazine3);
//        cDAO.save(magazine4);
//        cDAO.save(magazine5);


        //CREO 5 PRESTITI
        Loan loan1 = new Loan(user1, magazine1);
        Loan loan2 = new Loan(user2, magazine3);
        loan2.setRealReturnDate(LocalDate.parse("2024-12-10"));
        Loan loan3 = new Loan(user3, magazine5);
        Loan loan4 = new Loan(user4, book2);
        loan4.setRealReturnDate(LocalDate.parse("2024-12-10"));
        Loan loan5 = new Loan(user5, book3);
//       lDAO.save(loan1);
//        lDAO.save(loan2);
//        lDAO.save(loan3);
//        lDAO.save(loan4);
//        lDAO.save(loan5);

        System.out.println("Hello World!");

        //OPERAZIONI RICHIESTE

        // 1 AGGIUNTA ELEMENTO ( FATTO SOPRA )
        System.out.println("");
        System.out.println("Esercizio 1 - creo e popolo il database");

        // 2 RIMOZIONE DI UN ELEMENTO TRAMITE ISBN
        System.out.println("");
        System.out.println("Esercizio 2 - trovo ed elimino tramite ISBN");
     //   cDAO.findAndDeleteById(book1.getCodISBN());

        // 3 RICERCA PER ISBN
        System.out.println("");
        System.out.println("Esercizio 3 - cerco per ISBN");
        cDAO.findById(book2.getCodISBN());

        // 4 RICERCA PER ANNO DI PUBBLICAZIONE
        System.out.println("");
        System.out.println("Esercizio 4 - cerco per anno di pubblicazione");
        System.out.println( cDAO.searchByPublicationYear(2002));

        // 5 RICERCA PER AUTORE
        System.out.println("");
        System.out.println("Esercizio 5 - cerco per autore");
        System.out.println(cDAO.searchByAuthor("Pietro Pellegrini"));

        // 6 RICERCA PER TITOLO O PARTE DI ESSO
        System.out.println("");
        System.out.println("Esercizio 6 - cerco per titolo o partial del titolo");
        System.out.println(cDAO.searchByTitle("passion"));

        // 7 RICERCA DEGLI ELEMENTI ATTUALMENTE IN PRESTITO DATO UN NUMERO DI TESSERA UTENTE
        System.out.println("");
        System.out.println("Esercizio 7 - cerco ele attualmente in prestito");
        System.out.println(cDAO.searchLoanByUser(3));

        // 8 RICERCA TUTTI PRESTITI SCADUTI
        System.out.println("");
        System.out.println("Esercizio 8 - cerco tutti i prestiti scaduti");


    }
}
