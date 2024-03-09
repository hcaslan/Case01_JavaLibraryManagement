package org.bilgeadam.data;

import org.bilgeadam.constant.Durum;

import java.time.LocalDate;

public class KitapBilim extends Kitap{
    private Durum status;

    public KitapBilim(String ISBN, String title, String author, LocalDate publishDate) {
        super(ISBN, title, author, publishDate);
    }

    @Override
    void setDurum(Durum durum) {
        this.status = durum;
    }

    @Override
    Durum getDurum() {
        return status;
    }

    public KitapBilim(String ISBN, String title, String author, LocalDate publishDate, Durum status) {
        super(ISBN, title, author, publishDate);
        this.status = status;
    }

    public Durum getStatus() {
        return status;
    }

    public void setStatus(Durum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return  "KitapBilim{" +
                super.toString() +
                ", status=" + status +
                '}';
    }
}
