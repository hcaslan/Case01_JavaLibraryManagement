package org.bilgeadam.data;

import org.bilgeadam.constant.Durum;

import java.time.LocalDate;

public class KitapTarih extends Kitap{
    private Durum status;

    public KitapTarih(String ISBN, String title, String author, LocalDate publishDate) {
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

    public KitapTarih(String ISBN, String title, String author, LocalDate publishDate, Durum status) {
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
        return "KitapTarih{" +
                super.toString() +
                ", status=" + status +
                '}';
    }
}
