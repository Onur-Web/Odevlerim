package carRental.business;

import carRental.dao.BookDao;
import carRental.entity.Book;

public class BookManager {
    private final BookDao bookDao;

    public BookManager(){
        this.bookDao = new BookDao();
    }

    public boolean save(Book book){
        return this.bookDao.save(book);
    }




}
