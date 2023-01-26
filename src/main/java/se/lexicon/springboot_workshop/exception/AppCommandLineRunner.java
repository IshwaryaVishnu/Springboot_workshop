package se.lexicon.springboot_workshop.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.springboot_workshop.dao.*;
import se.lexicon.springboot_workshop.entity.AppUser;
import se.lexicon.springboot_workshop.entity.Author;
import se.lexicon.springboot_workshop.entity.Book;

import java.time.LocalDate;

@Component
public class AppCommandLineRunner implements CommandLineRunner {

    @Autowired
    AppUserDao appUserDao;

    @Autowired
    DetailsDao detailsDao;

    @Autowired
    BookDao bookDao;

    @Autowired
    BookLoanDao bookLoanDao;

    @Autowired
    AuthorDao authorDao;

    @Override
    public void run(String... args) throws Exception {

    }

    public void exe1() {


    }
            }

