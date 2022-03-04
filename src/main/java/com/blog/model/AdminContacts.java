package com.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminContacts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String number;
    String email;
    String address;
    String map;
}
