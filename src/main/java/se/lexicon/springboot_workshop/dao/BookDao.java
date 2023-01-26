package se.lexicon.springboot_workshop.dao;
import se.lexicon.springboot_workshop.entity.Book;

import java.util.Collection;

public interface BookDao {

    Book findById(int id);
    Collection<Book> findAll();
    Book create(Book book);
    Book update(Book book);
    void delete(int id);
}
