package com.EsameProgrammazione.TicketMaster.RestController;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EsameProgrammazione.OOP.TicketMaster.Model.Event;
import com.EsameProgrammazione.TicketMaster.Service.TicketService;
@RestController
public class TicketController {

		@Autowired
		private TicketService ticketservice;
		
	@GetMapping("/events")
	public List<Event> getEvents() throws IOException, ParseException
	{
		return this.ticketservice.getEvents();
		}
}
