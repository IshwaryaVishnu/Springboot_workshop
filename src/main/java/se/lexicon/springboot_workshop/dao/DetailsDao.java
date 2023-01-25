package se.lexicon.springboot_workshop.dao;

import se.lexicon.springboot_workshop.entity.Details;

import java.util.Collection;

public interface DetailsDao {
    Details findById(int id);
    Collection<Details> findAll();
    Details create(Details details);
    Details update(Details details);
    void delete(int id);
}
