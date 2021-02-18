package com.EsameProgrammazione.OOP.TicketMaster.Model;

public class Event {
 
	private String name;
	private String type;
	private String date;
	private String time;
	private String state;
	private String city;
	public Event(String name, String type, String date, String time, String state, String city) {
		super();
		this.name = name;
		this.type = type;
		this.date = date;
		this.time = time;
		this.state = state;
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public String getDate() {
		return date;
	}
	public String getTime() {
		return time;
	}
	public String getState() {
		return state;
	}
	public String getCity() {
		return city;
	}
	
}
