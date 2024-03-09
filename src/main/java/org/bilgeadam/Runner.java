package org.bilgeadam;


import org.bilgeadam.constant.Durum;
import org.bilgeadam.data.*;
import org.bilgeadam.page.OperationPage;

import java.time.LocalDate;

public class Runner {
    private static final Kutuphane kutuphane = new Kutuphane("Esogu Library");

    public static void main(String[] args) {
        addBook();
        addUser();
        OperationPage operationPage = new OperationPage(kutuphane);
        operationPage.loginMenu();
    }

    private static void addUser() {
        kutuphane.getUsers().add(new Uye("Aslan", "123"));
        kutuphane.getUsers().add(new Uye("Ali", "123"));
    }

    public static void addBook() {
        kutuphane.getBooks().add(new KitapTarih("0063051338", "Sapiens Volume 1", "Yuval Noah Harari", LocalDate.of(2020, 11, 3), Durum.AVAILABLE));
        kutuphane.getBooks().add(new KitapTarih("0063212234", "Sapiens Volume 2", "Yuval Noah Harari", LocalDate.of(2021, 11, 2), Durum.AVAILABLE));
        kutuphane.getBooks().add(new KitapBilim("9780553380163", "A Brief History of Time", "Stephen Hawking", LocalDate.of(1998, 9, 1), Durum.AVAILABLE));
        kutuphane.getBooks().add(new KitapRoman("1494812452", "What Men Live By", "Lev Nikolayevich Tolstoy", LocalDate.of(2013, 12, 27), Durum.AVAILABLE));
        kutuphane.getBooks().add(new KitapRoman("9798611586020", "White Fang", "Jack London", LocalDate.of(2020, 2, 9), Durum.AVAILABLE));

    }
}
