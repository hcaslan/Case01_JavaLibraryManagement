package org.bilgeadam.data;

import java.util.List;

public interface IUye {
    //Üyelerin ödünç kitap alma ve iade etme gibi işlemleri gerçekleştirmelerini sağlayan metotları tanımlayan bir interface.
    //Bu interface, üyelerin kütüphane sistemiyle etkileşimini yöneten metotları içerir.
    void borrowBook(Kitap book);
    void returnBook(Kitap book);
}
