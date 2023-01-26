package se.lexicon.springboot_workshop.dao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.springboot_workshop.entity.Author;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
@Repository
public class AuthorDaoImpl implements AuthorDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public Author findById(int id) {
        return entityManager.find(Author.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Author> findAll() {
        return entityManager.
                createQuery("select s from Author s", Author.class)
                .getResultList();
    }

    @Override
    @Transactional
    public Author create(Author author) {
        entityManager.persist(author);
        return author;
    }

    @Override
    @Transactional
    public Author update(Author author) {
            return entityManager.merge(author);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Author author = entityManager.find(Author.class, id);
        if (author!= null) entityManager.remove(author);
    }

    }

