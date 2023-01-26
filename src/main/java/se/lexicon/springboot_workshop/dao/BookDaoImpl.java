package se.lexicon.springboot_workshop.dao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.springboot_workshop.entity.Book;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
@Repository
public class BookDaoImpl implements BookDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public Book findById(int id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Book> findAll() {
        return entityManager.
                createQuery("select s from Book s", Book.class)
                .getResultList();
    }

    @Override
    @Transactional
    public Book create(Book book) {
        entityManager.persist(book);
        return book;
    }

    @Override
    @Transactional
    public Book update(Book book) {
        return entityManager.merge(book);
    }


    @Override
    @Transactional
    public void delete(int id) {
        Book Book = entityManager.find(Book.class, id);
        if (Book!= null) entityManager.remove(Book);
    }
}
