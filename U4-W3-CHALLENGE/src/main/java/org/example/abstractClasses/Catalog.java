package org.example.abstractClasses;


import org.example.classes.Loan;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
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
