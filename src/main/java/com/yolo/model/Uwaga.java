package com.yolo.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity()
@Table(name = "uwaga", schema = "dzienniczekdbapp")
public class Uwaga {

    public enum Rate {
        POSSITIVE,
        NEGATIVE
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "rate")
    private Rate rate;

    @Column(name = "description")
    private String description;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "uwaga_date", nullable = false)
    private LocalDate uwagaDate;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "user_id")
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getUwagaDate() {
        return uwagaDate;
    }

    public void setUwagaDate(LocalDate uwagaDate) {
        this.uwagaDate = uwagaDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Uwaga uwaga = (Uwaga) o;
        return id == uwaga.id &&
                userId == uwaga.userId &&
                Objects.equals(description, uwaga.description) &&
                Objects.equals(uwagaDate, uwaga.uwagaDate) &&
                Objects.equals(createDate, uwaga.createDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, rate, description, uwagaDate, createDate, userId);
    }


}
