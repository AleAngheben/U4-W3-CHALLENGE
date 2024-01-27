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


}
