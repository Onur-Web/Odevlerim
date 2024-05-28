package week5.kitapSiralayici;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Book> bookSetByName = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                return book1.getBookName().compareTo(book2.getBookName());
            }
        });
        TreeSet<Book> bookSetByPageCount = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                return Integer.compare(book1.getPageCount(), book2.getPageCount());
            }
        });
        bookSetByName.add(new Book("The Last Wish",280,"Andrzej Sapkowski","1993"));
        bookSetByName.add(new Book("Sword of Destiny",384,"Andrzej Sapkowski","1992"));
        bookSetByName.add(new Book("Blood of Elves",324,"Andrzej Sapkowski","1994"));
        bookSetByName.add(new Book("Time of Contempt",337,"Andrzej Sapkowski","1995"));
        bookSetByName.add(new Book("Baptism of Fire",378,"Andrzej Sapkowski","1996"));
        System.out.println("------------------------------------------");
        System.out.println("Eserlerin Alfabetik Sıralanması");
        System.out.println("------------------------------------------");
        for (Book name : bookSetByName){
            System.out.println(name);
        }
        bookSetByPageCount.addAll(bookSetByName);
        System.out.println("------------------------------------------");
        System.out.println("Eserlerin Sayfa Sayısına Göre Sıralanması");
        System.out.println("------------------------------------------");
        for (Book page : bookSetByPageCount){
            System.out.println(page);
        }
    }
}
