package se.lexicon.springboot_workshop.dao;
import se.lexicon.springboot_workshop.entity.BookLoan;

import java.util.Collection;

public interface BookLoanDao {
    BookLoan findById(int id);
    Collection<BookLoan> findAll();
    BookLoan create(BookLoan bookLoan);
    BookLoan update(BookLoan bookLoan);
    void delete(int id);
}
