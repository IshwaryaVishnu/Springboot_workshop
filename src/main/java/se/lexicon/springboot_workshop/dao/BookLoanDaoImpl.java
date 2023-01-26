package se.lexicon.springboot_workshop.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.springboot_workshop.entity.Book;
import se.lexicon.springboot_workshop.entity.BookLoan;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
@Repository
public class BookLoanDaoImpl implements BookLoanDao{

    @PersistenceContext
    EntityManager entityManager;
    @Override
    @Transactional(readOnly = true)
    public BookLoan findById(int id) {
        return entityManager.find(BookLoan.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<BookLoan> findAll() {
        return entityManager.
                createQuery("select s from BookLoan s", BookLoan.class)
                .getResultList();
    }

    @Override
    @Transactional
    public BookLoan create(BookLoan bookLoan) {
        entityManager.persist(bookLoan);
        return bookLoan;
    }

    @Override
    @Transactional
    public BookLoan update(BookLoan bookLoan) {
        return entityManager.merge(bookLoan);
    }


    @Override
    @Transactional
    public void delete(int id) {
        BookLoan BookLoan = entityManager.find(BookLoan.class, id);
        if (BookLoan!= null) entityManager.remove(BookLoan);
    }

    }

