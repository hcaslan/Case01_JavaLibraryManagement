package org.bilgeadam.data;

import org.bilgeadam.constant.Durum;
import org.bilgeadam.constant.OutputMessage;
import org.bilgeadam.util.InputHelper;
import org.bilgeadam.util.OutputHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Uye implements IUye {
    private String username;
    private String password;
    private List<Kitap> borrowedBooks;

    public Uye(String username, String password) {
        this.username = username;
        this.password = password;
        this.borrowedBooks = new ArrayList<>();
    }

    public Uye() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Kitap> getBorrowedBooks() {
        return borrowedBooks;
    }

    public Uye findUyeByUserName(String userName, List<Uye> users) {
        return users.stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(userName))
                .findFirst()
                .orElse(null);
    }

    public Uye login(List<Uye> users) {
        Uye user = findUyeByUserName(InputHelper.getStringInput(OutputMessage.GET_NAME_FROM_USER.getMessage()), users);
        if (Objects.nonNull(user)) {
            if (InputHelper.getStringInput(OutputMessage.GET_PASSWORD_FROM_USER.getMessage()).equalsIgnoreCase(user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    public void register(List<Uye> users) {
        String userName = InputHelper.getStringInput(OutputMessage.GET_NAME_FROM_USER.getMessage());
        if (Objects.nonNull(findUyeByUserName(userName, users))) {
            OutputHelper.errorMessage(OutputMessage.USERNAME_TAKEN.getMessage());
            register(users);
        }
        Uye user = new Uye(userName,
                InputHelper.getStringInput(OutputMessage.GET_PASSWORD_FROM_USER.getMessage()));
        OutputHelper.successMessage(OutputMessage.REGISTER_SUCCESS.getMessage());
        users.add(user);
    }

    public Kitap selectBook(List<Kitap> books) {
        if (books.isEmpty() || Objects.isNull(books.getFirst()))
            OutputHelper.errorMessage(OutputMessage.EMPTY_LIST.getMessage());
        else {
            IntStream.range(0, books.size())
                    .forEach(i -> System.out.println((i + 1) + " " + books.get(i)));
            int choice = InputHelper.getIntegerInput(OutputMessage.SELECT.getMessage());
            if (choice >= 1 && choice <= books.size()) {
                return books.get(choice - 1);
            } else {
                OutputHelper.errorMessage(OutputMessage.INVALID_OPERATION.getMessage());
                selectBook(books);
            }
        }
        return null;
    }

    @Override
    public void borrowBook(Kitap book) {
        try{
            this.borrowedBooks.remove(null);
            this.borrowedBooks.add(book);
            book.setDurum(Durum.BORROWED);
            OutputHelper.successMessage(OutputMessage.SUCCESS.getMessage());
        }catch (NullPointerException ignored){

        }
    }

    @Override
    public void returnBook(Kitap book) {
        try{
            this.getBorrowedBooks().remove(book);
            book.setDurum(Durum.AVAILABLE);
            OutputHelper.successMessage(OutputMessage.SUCCESS.getMessage());
        }catch (NullPointerException ignored){

        }
    }

    public void displayBorrowedBooks() {
        if (borrowedBooks.isEmpty())
            OutputHelper.errorMessage(OutputMessage.EMPTY_LIST.getMessage());
        borrowedBooks.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Uye{" +
                "username='" + username + '\'' +
                '}';
    }
}
