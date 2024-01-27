package org.example.abstractClasses;


import org.example.classes.Loan;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "catalogues")
@DiscriminatorColumn(name = "type")

//query per operazioni nel dao
@NamedQuery(name = "searchByPublicationYear", query = "SELECT c FROM Catalog c WHERE c.yearOfPublication = :yearOfPublication")
@NamedQuery(name = "searchByAuthor", query = "SELECT c FROM Catalog c WHERE LOWER(c.author) LIKE LOWER(:author)")
@NamedQuery(name = "searchByTitle", query = "SELECT c FROM Catalog c WHERE LOWER(c.title) LIKE LOWER(CONCAT('%' , :partial, '%'))")
@NamedQuery(name = "searchLoanByUser" , query = "SELECT c FROM Catalog c JOIN c.loanedList lo WHERE lo.user.cardId = :myId")
@NamedQuery(name = "searchExpiredLoans", query = "SELECT c FROM Catalog c JOIN c.loanedList lo WHERE lo.realReturnDate IS NULL AND lo.expectedReturnDate < NOW()  ")
public abstract class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long codISBN;

    @Column(nullable = false)
    private String title;

    @Column(name = "year_of_publication", nullable = false)
    private int yearOfPublication;

    @Column(name = "number_of_pages", nullable = false)
    private int numberPages;

    @OneToMany(mappedBy = "loanedElement", cascade = CascadeType.REMOVE)
    private List<Loan> loanedList;

    public Catalog() {
    }

    public Catalog(String title, int yearOfPublication, int numberPages) {
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.numberPages = numberPages;
    }

    public long getCodISBN() {
        return codISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public List<Loan> getLoanedList() {
        return loanedList;
    }

    public void setLoanedList(List<Loan> loanedList) {
        this.loanedList = loanedList;
    }
}
