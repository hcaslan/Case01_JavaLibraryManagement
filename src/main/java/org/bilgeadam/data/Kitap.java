package org.bilgeadam.data;

import org.bilgeadam.constant.Durum;

import java.time.LocalDate;

public abstract class Kitap {
    private String ISBN;
    private String title;
    private String author;
    private LocalDate publishDate;

    public Kitap(String ISBN, String title, String author, LocalDate publishDate) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
    }
    abstract void setDurum(Durum durum);
    abstract Durum getDurum();
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishDate=" + publishDate;
    }
}
