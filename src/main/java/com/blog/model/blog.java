package com.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    String hashtag;
    String data;
    String date;
    int views;

    @ManyToOne
    @JoinColumn(name = "categories_id")
    categories categories;

    @ManyToOne
    @JoinColumn(name = "users_id")
    users users;
}
