package week7.carRental.business;

import week7.carRental.dao.BookDao;
import week7.carRental.entity.Book;

public class BookManager {
    private final BookDao bookDao;

    public BookManager(){
        this.bookDao = new BookDao();
    }

    public boolean save(Book book){
        return this.bookDao.save(book);
    }




}
