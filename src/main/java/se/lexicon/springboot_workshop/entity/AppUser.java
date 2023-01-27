package se.lexicon.springboot_workshop.entity;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int appUserId;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, length = 8)
    private String password;
    private LocalDate regDate;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name ="Details_id")
    private Details details;

    @OneToMany(mappedBy = "borrower", orphanRemoval = true)
    private List<BookLoan> loans;

    //Constructor
    public AppUser() {
        this.regDate= LocalDate.now();
    }

    public AppUser(int appUserId, String username, String password) {
        this();
        this.appUserId = appUserId;
        this.username = username;
        this.password = password;
    }

    public AppUser(int appUserId, String username, String password,  Details details) {
        this();
        this.appUserId = appUserId;
        this.username = username;
        this.password = password;
        setDetails(details);
    }

//Getters & setters

    public int getAppUserId() {
        return appUserId;
    }
    public void setAppUserId(int appUserId) {
        this.appUserId = appUserId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        //bi directional
        if (details != null) getDetails();
        this.details = details;
    }

    public List<BookLoan> getLoans() {
        return loans;
    }

    public void setLoans(List<BookLoan> loans) {
        this.loans = loans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return appUserId == appUser.appUserId && Objects.equals(username, appUser.username) && Objects.equals(password, appUser.password) && Objects.equals(regDate, appUser.regDate) && Objects.equals(details, appUser.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appUserId, username, password, regDate, details);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "appUserId=" + appUserId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", regDate=" + regDate +
                ", details=" + details +
                '}';
    }
}

