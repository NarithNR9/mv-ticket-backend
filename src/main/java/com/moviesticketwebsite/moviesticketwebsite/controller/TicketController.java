package com.moviesticketwebsite.moviesticketwebsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moviesticketwebsite.moviesticketwebsite.model.Ticket;
import com.moviesticketwebsite.moviesticketwebsite.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Ticket>> getAll() {
        return new ResponseEntity<>(ticketService.findAllTicket(),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ticket> addTicket(@RequestBody Ticket ticket) {
        return new ResponseEntity<>(ticketService.addTicket(ticket),HttpStatus.OK);
    }

    @RequestMapping(value= {"update"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ticket> updateTicket(Long id, @RequestBody Ticket ticket) {
        return new ResponseEntity<>(ticketService.updateTicket(ticket, ticket.getId()), HttpStatus.OK);
    }
    
    @RequestMapping(value = {"/delete/{id}"}, method = RequestMethod.GET)
    public ResponseEntity<Ticket> deleteTicket(@PathVariable("id") Long id){
        Ticket ticket = ticketService.deleteTicketById(id);
        return new ResponseEntity<>(ticket,HttpStatus.OK);
    }

    @RequestMapping(value = {"/find/{id}"}, method = RequestMethod.GET)
    public ResponseEntity<Ticket> getTicketById (@PathVariable("id") Long id) {
        Ticket ticket = ticketService.findTicketById(id);
        return new ResponseEntity<>(ticket, HttpStatus.OK); 
    }
}
