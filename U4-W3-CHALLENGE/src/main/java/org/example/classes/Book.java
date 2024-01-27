package org.example.classes;

import org.example.abstractClasses.Catalog;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Book")
public class Book extends Catalog {

    private String author;

    private String genre;

    public Book() {
    }

    public Book(String title, int yearOfPublication, int numberPages, String author, String genre) {
        super(title, yearOfPublication, numberPages);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", type='" + genre + '\'' +
                ", title='" + this.getTitle() + '\'' +
                ", yearOfPublication=" + this.getYearOfPublication() +
                ", numberOfPages=" + this.getNumberPages() +
                '}';
    }

}
