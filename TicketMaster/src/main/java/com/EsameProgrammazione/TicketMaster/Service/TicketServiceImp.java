package com.EsameProgrammazione.TicketMaster.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.EsameProgrammazione.OOP.TicketMaster.Model.Event;
import com.EsameProgrammazione.OOP.TicketMaster.Model.Data.TicketApi;

@Service
public class TicketServiceImp implements TicketService {

	private List<Event> eventi =null;
	public TicketServiceImp() throws IOException, ParseException
	{   eventi = new ArrayList<Event>();
		TicketApi ticketapi = new TicketApi("AU");
		ticketapi.saveFile();
		
		eventi = ticketapi.fillList();
	}
	@Override
	public List<Event> getEvents() throws IOException, ParseException {
	
	return eventi;	
	}

	public List<Event> getEventi() {
		return eventi;
	}
	
}
