package com.moviesticketwebsite.moviesticketwebsite.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tbl_movies")
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false,nullable=false)
    private Long id;

    @Column(name = "title")
    private String title;
    
    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "genre")
    private String genre;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "duration")
    private int duration;

    @Column(name = "rate")
    private String rate;

    @Column(name = "trailer")
    private String trailer;

    @Column(name = "short_description")
    private String shortDescription;

    // @OneToMany(targetEntity = Categories.class, cascade = CascadeType.ALL)
    // @JoinColumn(name = "mc_fk", referencedColumnName = "id")
    // private List<Categories> categories;

    public Movies() {
    }

    

    public Movies(Long id, String title, String imageUrl, String genre, Date releaseDate, int duration, String rate,
            String trailer, String shortDescription) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.rate = rate;
        this.trailer = trailer;
        this.shortDescription = shortDescription;
    }

    @Override
    public String toString() {
        return "Movies [title =" + title + ", genre=" + genre + ", id =" + id + ", imageUrl=" + imageUrl
                + ", releaseDate=" + releaseDate + ", duration=" + duration + ", rate=" + rate + ", trailer=" + trailer
                + ", shortDescription= " + shortDescription;
    }

}
