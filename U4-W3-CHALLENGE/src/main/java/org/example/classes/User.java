package org.example.classes;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    private int name;

    private String surname;

    private LocalDate dateOfBirth;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private long cardId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private Set<Loan> userLoan;

    public User (){}

    public User(int name, String surname, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public long getCardId() {
        return cardId;
    }


}
