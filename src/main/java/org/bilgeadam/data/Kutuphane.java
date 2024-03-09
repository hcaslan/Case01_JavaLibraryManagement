package org.bilgeadam.data;

import org.bilgeadam.constant.BookType;
import org.bilgeadam.constant.Durum;
import org.bilgeadam.constant.OutputMessage;
import org.bilgeadam.util.InputHelper;
import org.bilgeadam.util.OutputHelper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Kutuphane {
    private String name;
    private List<Kitap> books;
    private List<Uye> users;

    public Kutuphane(String name) {
        this.name = name;
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public List<Kitap> getBooks() {
        return books;
    }

    public List<Uye> getUsers() {
        return users;
    }

    public List<Kitap> findBookByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase().trim()))
                .collect(Collectors.toList());
    }

    public List<Kitap> findBookByIsbn(String Isbn) {
        return books.stream()
                .filter(book -> book.getISBN().contains(Isbn.trim()))
                .collect(Collectors.toList());
    }

    public List<Kitap> findBookByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().toLowerCase().contains(author.toLowerCase().trim()))
                .collect(Collectors.toList());
    }

    public List<Kitap> findBookByKeyWord() {
        String keyWord = InputHelper.getStringInput(OutputMessage.GET_KEYWORD_FROM_USER.getMessage());
        List<Kitap> searchResult = new ArrayList<>();
        searchResult.addAll(findBookByAuthor(keyWord));
        searchResult.addAll(findBookByIsbn(keyWord));
        searchResult.addAll(findBookByTitle(keyWord));
        return searchResult.stream()
                .filter(book -> book.getDurum().equals(Durum.AVAILABLE))
                .toList();
    }

    public void displayBooks() {
        if (books.isEmpty())
            OutputHelper.errorMessage(OutputMessage.EMPTY_LIST.getMessage());
        books.forEach(book -> System.out.println(book.toString()));
    }

    public void updateBookStatus(Kitap book) {
        OutputHelper.printMenu(Durum.AVAILABLE.name(), Durum.BORROWED.name(), Durum.UNAVAILABLE.name());
        switch (InputHelper.getIntegerInput(OutputMessage.SELECT.getMessage())) {
            case 0:
                book.setDurum(Durum.AVAILABLE);
                break;
            case 1:
                book.setDurum(Durum.BORROWED);
                break;
            case 2:
                book.setDurum(Durum.UNAVAILABLE);
                break;
            default:
                OutputHelper.errorMessage(OutputMessage.INVALID_OPERATION.getMessage());
                updateBookStatus(book);
        }
    }

    public void displayBorrowedBooks() {
        List<Kitap> borrowedBooks = books.stream()
                .filter(book -> book.getDurum().equals(Durum.BORROWED))
                .toList();
        if (borrowedBooks.isEmpty())
            OutputHelper.errorMessage(OutputMessage.EMPTY_LIST.getMessage());
        borrowedBooks.forEach(System.out::println);

    }

    public void displayRegisteredUsers() {
        if (users.isEmpty())
            OutputHelper.errorMessage(OutputMessage.EMPTY_LIST.getMessage());
        users.forEach(System.out::println);
    }

    public void addBookToLibrary(){
        OutputHelper.printMenu(BookType.KitapRoman.name(), BookType.KitapBilim.name(), BookType.KitapTarih.name());
        int bookTypeIndex = InputHelper.getIntegerInput(OutputMessage.SELECT.getMessage());
        if (bookTypeIndex >= 0 && bookTypeIndex < BookType.values().length) {
            BookType selectedBookType = BookType.values()[bookTypeIndex];
            String isbn = InputHelper.getStringInput(OutputMessage.GET_ISBN_FROM_USER.getMessage());
            String title = InputHelper.getStringInput(OutputMessage.GET_TITLE_FROM_USER.getMessage());
            String author = InputHelper.getStringInput(OutputMessage.GET_AUTHOR_FROM_USER.getMessage());
            LocalDate date = InputHelper.getLocalDateInput();

            switch (selectedBookType) {
                case KitapRoman:
                    books.add(new KitapRoman(isbn, title, author, date));
                    break;
                case KitapBilim:
                    books.add(new KitapBilim(isbn, title, author, date));
                    break;
                case KitapTarih:
                    books.add(new KitapTarih(isbn, title, author, date));
                    break;
            }
        }else
            OutputHelper.errorMessage(OutputMessage.INVALID_OPERATION.getMessage());
    }
}

