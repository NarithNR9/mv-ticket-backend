package com.moviesticketwebsite.moviesticketwebsite.model;

import java.util.List;

// import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_categories")
public class Categories {

    @Id
    // @GeneratedValue(strategy = GenerationType.SEQUENCE) 
    private String cateId;
    private String cateName;



}
