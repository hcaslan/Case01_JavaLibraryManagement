package org.bilgeadam.page;

import org.bilgeadam.constant.MenuItem;
import org.bilgeadam.constant.OutputMessage;
import org.bilgeadam.data.Kutuphane;
import org.bilgeadam.data.Uye;
import org.bilgeadam.util.InputHelper;
import org.bilgeadam.util.OutputHelper;

import java.util.Objects;

public class OperationPage {
    private Kutuphane library;
    private Uye loggedUser = new Uye();

    public OperationPage(Kutuphane library) {
        this.library = library;
    }

    public void loginMenu() {
        do {
            OutputHelper.printMenu(MenuItem.EXIT.getMessage(), MenuItem.REGISTER.getMessage(), MenuItem.LOGIN.getMessage());
            switch (InputHelper.getIntegerInput(OutputMessage.SELECT.getMessage())) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    loggedUser.register(library.getUsers());
                    break;
                case 2:
                    Uye thisUser = loggedUser.login(library.getUsers());
                    if (Objects.nonNull(thisUser)) {
                        OutputHelper.successMessage(OutputMessage.LOGIN_SUCCESS.getMessage());
                        loggedUser = thisUser;
                        mainMenu();
                    } else
                        OutputHelper.errorMessage(OutputMessage.LOGIN_ERROR.getMessage());
                    break;
                default:
                    OutputHelper.errorMessage(OutputMessage.INVALID_OPERATION.getMessage());
                    break;
            }
        } while (true);
    }

    public void mainMenu() {
        boolean flag = true;
        do {
            OutputHelper.printMenu(MenuItem.PREVIOUS.getMessage(), MenuItem.USER_OPERATIONS.getMessage(), MenuItem.LIBRARY_OPERATIONS.getMessage());
            switch (InputHelper.getIntegerInput(OutputMessage.SELECT.getMessage())) {
                case 0:
                    flag = false;
                    break;
                case 1:
                    userOperations();
                    break;
                case 2:
                    libraryOperations();
                    break;
                default:
                    OutputHelper.errorMessage(OutputMessage.INVALID_OPERATION.getMessage());
                    break;
            }
        } while (flag);
    }

    public void userOperations() {
        boolean flag = true;
        do {
            OutputHelper.printMenu(MenuItem.PREVIOUS.getMessage(), MenuItem.LIST_ALL_BOOKS.getMessage(), MenuItem.BARROW_BOOK.getMessage(), MenuItem.RETURN_BOOK.getMessage(), MenuItem.LIST_MY_BOOKS.getMessage());
            switch (InputHelper.getIntegerInput(OutputMessage.SELECT.getMessage())) {
                case 0:
                    flag = false;
                    break;
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    loggedUser.borrowBook(loggedUser.selectBook(library.findBookByKeyWord()));
                    break;
                case 3:
                    loggedUser.returnBook(loggedUser.selectBook(loggedUser.getBorrowedBooks()));
                    break;
                case 4:
                    loggedUser.displayBorrowedBooks();
                    break;
                default:
                    OutputHelper.errorMessage(OutputMessage.INVALID_OPERATION.getMessage());
                    break;
            }
        } while (flag);
    }
    public void libraryOperations(){
        boolean flag = true;
        do {
            OutputHelper.printMenu(MenuItem.PREVIOUS.getMessage(),
                    MenuItem.LIST_ALL_BOOKS.getMessage(),
                    MenuItem.UPDATE_BOOK.getMessage(),
                    MenuItem.LIST_BORROWED_BOOKS.getMessage(),
                    MenuItem.LIST_USERS.getMessage(),
                    MenuItem.ADD_BOOK.getMessage());
            switch (InputHelper.getIntegerInput(OutputMessage.SELECT.getMessage())) {
                case 0:
                    flag = false;
                    break;
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    library.updateBookStatus(loggedUser.selectBook(library.getBooks()));
                    break;
                case 3:
                    library.displayBorrowedBooks();
                    break;
                case 4:
                    library.displayRegisteredUsers();
                    break;
                case 5:
                    library.addBookToLibrary();
                    break;
                default:
                    OutputHelper.errorMessage(OutputMessage.INVALID_OPERATION.getMessage());
                    break;
            }
        }while (flag);
    }
}
