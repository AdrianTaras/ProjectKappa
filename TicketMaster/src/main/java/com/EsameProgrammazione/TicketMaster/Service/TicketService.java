package com.EsameProgrammazione.TicketMaster.Service;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;

import com.EsameProgrammazione.OOP.TicketMaster.Model.Event;

public interface TicketService {

		List<Event> getEvents() throws IOException, ParseException;
}
