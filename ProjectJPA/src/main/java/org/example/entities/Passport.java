package org.example.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "passports")
@NamedQuery(name = "Passport.findAll", query = "SELECT p FROM Passport p")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passport_id", nullable = false)
    private Long id;
    @Column(name = "number_passport", nullable = false, unique = true)
    private Integer numberPassport;
    @Column(name = "date_passport", nullable = false)
    private LocalDate datePassport;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Passport() {}

    public Passport(Integer numberPassport, LocalDate datePassport, User user) {
        this.numberPassport = numberPassport;
        this.datePassport = datePassport;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberPassport() {
        return numberPassport;
    }

    public void setNumberPassport(Integer numberPassport) {
        this.numberPassport = numberPassport;
    }

    public LocalDate getDatePassport() {
        return datePassport;
    }

    public void setDatePassport(LocalDate datePassport) {
        this.datePassport = datePassport;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", numberPassport=" + numberPassport +
                ", datePassport=" + datePassport +
                ", user=" + user.getName() + " " + user.getLastname() +
                '}';
    }
}
