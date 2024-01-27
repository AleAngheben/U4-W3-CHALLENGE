package org.example.classes;


import org.example.abstractClasses.Catalog;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "loaned_element_id")
    private Catalog loanedElement;

    @Column(name = "start_loan_date",nullable = false)
    private LocalDate startLoanDate;

    @Column(name = "expected_return_date")
    private LocalDate expectedReturnDate;

    @Column(name = "real_return_date")
    private LocalDate realReturnDate;


    public Loan(){}

    public Loan(User user, Catalog loanedElement) {
        this.user = user;
        this.loanedElement = loanedElement;
        this.startLoanDate = LocalDate.now();
        this.expectedReturnDate = startLoanDate.plusDays(30);

    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Catalog getLoanedElement() {
        return loanedElement;
    }

    public void setLoanedElement(Catalog loanedElement) {
        this.loanedElement = loanedElement;
    }

    public LocalDate getStartLoanDate() {
        return startLoanDate;
    }

    public void setStartLoanDate(LocalDate startLoanDate) {
        this.startLoanDate = startLoanDate;
    }

    public LocalDate getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public void setExpectedReturnDate(LocalDate expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }

    public LocalDate getRealReturnDate() {
        return realReturnDate;
    }

    public void setRealReturnDate(LocalDate realReturnDate) {
        this.realReturnDate = realReturnDate;
    }
}
