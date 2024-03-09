package org.bilgeadam.constant;

public enum MenuItem {
    EXIT("EXIT"),
    LOGIN("LOGIN"),
    REGISTER("REGISTER"),
    PREVIOUS("PREVIOUS MENU"),
    USER_OPERATIONS("USER OPERATIONS"),
    LIBRARY_OPERATIONS("LIBRARY OPERATIONS"),
    LIST_ALL_BOOKS("LIST BOOKS IN LIBRARY"),
    LIST_MY_BOOKS("LIST BORROWED BOOKS"),
    BARROW_BOOK("BARROW A BOOK"),
    RETURN_BOOK("RETURN A BOOK"),
    UPDATE_BOOK("UPDATE BOOK STATUS"),
    LIST_BORROWED_BOOKS("LIST ALL BORROWED BOOKS"),
    LIST_USERS("LIST ALL USERS"),
    ADD_BOOK("ADD BOOK TO LIBRARY"),
    ;
    private String message;

    MenuItem(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
