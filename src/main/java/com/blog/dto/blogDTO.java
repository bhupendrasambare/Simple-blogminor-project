package com.blog.dto;

import com.blog.model.categories;
import com.blog.model.users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "blog")
public class blogDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    String hashtag;
    String image;
    String date;
    int views;
    int categories_id;
    int users_id;
}
