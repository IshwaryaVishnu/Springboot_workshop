package se.lexicon.springboot_workshop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

import javax.persistence.*;
@Entity
public class BookLoan {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
    private int loanId;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private Boolean returned;
    private AppUser borrower;
    private Book book;
}
