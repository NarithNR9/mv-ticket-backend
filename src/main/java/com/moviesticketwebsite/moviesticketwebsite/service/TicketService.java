package com.moviesticketwebsite.moviesticketwebsite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviesticketwebsite.moviesticketwebsite.Repository.TicketRepo;
import com.moviesticketwebsite.moviesticketwebsite.model.Ticket;

@Service
public class TicketService {
    @Autowired
    private TicketRepo ticketRepo;
    
    public List<Ticket> findAllTicket() {
        return ticketRepo.findAll();
    }

    public Ticket addTicket(Ticket ticket) {
        return ticketRepo.save(ticket);
    }

    public Ticket updateTicket(Ticket ticket, Long id) {
        Optional<Ticket> optionalTicket = ticketRepo.findById(id);
        Ticket ticketFromRepo = optionalTicket.get();
        ticketFromRepo.setBranch(ticket.getBranch());
        ticketFromRepo.setMovieTitle(ticket.getMovieTitle());
        ticketFromRepo.setShowDate(ticket.getShowDate());
        ticketFromRepo.setShowTime(ticket.getShowTime());
        ticketFromRepo.setThreatre(ticket.getThreatre());
        ticketFromRepo.setSeatNO(ticket.getSeatNO());
        ticketFromRepo.setPriceUS(ticket.getPriceUS());
        ticketFromRepo.setPriceKR(ticket.getPriceKR());
        return ticketRepo.save(ticketFromRepo);
    }

    public Ticket findTicketById(Long id) {
        return ticketRepo.findTicketById(id);
    }

    public Ticket deleteTicketById(Long id) {
        Ticket ticket = ticketRepo.findTicketById(id);
        ticketRepo.deleteById(id);
        return ticket;
    }
}
