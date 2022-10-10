package com.moviesticketwebsite.moviesticketwebsite.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moviesticketwebsite.moviesticketwebsite.model.Ticket;

public interface TicketRepo extends JpaRepository<Ticket,Long>{
    public Ticket findTicketById(Long id);

    public void deleteById(Long id);
}
