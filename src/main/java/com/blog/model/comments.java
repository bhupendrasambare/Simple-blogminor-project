package com.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class comments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Lob
    String text;
    String date;

    @ManyToOne
    @JoinColumn(name = "blog_id")
    blog blog;

    @ManyToOne
    @JoinColumn(name = "users_id")
    users users;
}
