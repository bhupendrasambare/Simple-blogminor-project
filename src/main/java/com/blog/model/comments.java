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
    int blog;
    int user;
    @Lob
    String text;
    String date;
}
