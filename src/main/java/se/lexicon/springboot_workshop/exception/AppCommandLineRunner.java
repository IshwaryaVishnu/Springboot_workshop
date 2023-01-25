package se.lexicon.springboot_workshop.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.springboot_workshop.dao.AppUserDao;
import se.lexicon.springboot_workshop.dao.DetailsDao;
import se.lexicon.springboot_workshop.entity.AppUser;

import java.time.LocalDate;

@Component
public class AppCommandLineRunner implements CommandLineRunner {

    @Autowired
    AppUserDao appUserDao;

    @Autowired
    DetailsDao detailsDao;
    @Override
    public void run(String... args) throws Exception {

    }

    public void exe1() {

    }
}
