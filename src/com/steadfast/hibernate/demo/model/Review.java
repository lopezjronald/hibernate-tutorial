package com.steadfast.hibernate.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    // define fields

    // define constructors

    // define getters/setters

    // define toString

    // annotate fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "comment")
    private String comment;

    public Review() {
    }

    public Review(String comment) {
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", comment='" + comment +
                '}';
    }
}
