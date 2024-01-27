package org.example.classes;

import org.example.abstractClasses.Catalog;
import org.example.enums.Periodicity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("Magazine")
public class Magazine extends Catalog {

    @Enumerated(EnumType.STRING)
    private Periodicity periodicity;

    public Magazine() {
    }

    public Magazine(String title, int yearOfPublication, int numberPages, Periodicity periodicity) {
        super(title, yearOfPublication, numberPages);
        this.periodicity = periodicity;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return "Book{" +
                ", title='" + this.getTitle() + '\'' +
                "author='" + periodicity + '\'' +
                ", yearOfPublication=" + this.getYearOfPublication() +
                ", numberPages=" + this.getNumberPages() +
                '}';
    }
}
