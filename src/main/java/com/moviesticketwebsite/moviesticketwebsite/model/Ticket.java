package com.moviesticketwebsite.moviesticketwebsite.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tbl_tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false,nullable=false)
    private Long id;

    @Column(name = "branch")
    private String branch;

    @Column(name = "movie_title")
    private String movieTitle;

    @Column(name = "show_date")
    private Date showDate;

    @Column(name = "show_time")
    private Date showTime;

    @Column(name = "threatre")
    private String threatre;

    @Column(name = "seat_NO")
    private String seatNO;

    @Column(name = "price_US")
    private float priceUS;

    @Column(name = "price_KR")
    private float priceKR;

    public Ticket() {
    }

    public Ticket(Long id, String branch, String movieTitle, Date showDate, Date showTime, String threatre,
            String seatNO, float priceUS, float priceKR) {
        this.id = id;
        this.branch = branch;
        this.movieTitle = movieTitle;
        this.showDate = showDate;
        this.showTime = showTime;
        this.threatre = threatre;
        this.seatNO = seatNO;
        this.priceUS = priceUS;
        this.priceKR = priceKR;
    }

    
    

}