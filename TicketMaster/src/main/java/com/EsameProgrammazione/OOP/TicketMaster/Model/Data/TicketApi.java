package com.EsameProgrammazione.OOP.TicketMaster.Model.Data;

import java.io.BufferedReader;



import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import com.EsameProgrammazione.OOP.TicketMaster.Model.Event;





public class TicketApi {

	private Vector<String> name_events = new Vector<String>(); 
	private Vector<String>  date =  new Vector<String>();
	private Vector<String>  time =  new Vector<String>();
	private Vector<String> state = new Vector<String>();
	private Vector<String> city = new Vector<String>();
	
	private Vector<String> classificazione = new Vector<String>();
    private String paese = null;

    
   public TicketApi(String paese)throws IOException, ParseException {
    	
	   this.paese = paese;
    		
	    	try {
       			URLConnection openConnection = new URL("https://app.ticketmaster.com/discovery/v2/events.json?countryCode="+ this.paese+"&apikey=XJNBvrpg2QatFlAkURTtplDdKf94B3da"
       					).openConnection();
       			InputStream in = openConnection.getInputStream();
       			
       			String data = "";
       			String line = "";
       			try {
       			   InputStreamReader inR = new InputStreamReader( in );
       			   BufferedReader buf = new BufferedReader( inR );
       			  
       			   while ( ( line = buf.readLine() ) != null ) {
       				   data+= line;
       			   }
       			} finally {
       			   in.close();
       			}
       	            
       			JSONObject obj = (JSONObject) JSONValue.parseWithException(data);
    		    
    			JSONObject json = (JSONObject) obj.get("_embedded");
    			JSONArray event= (JSONArray) json.get("events");
    			for(int i=0;i<event.size();i++) {
    				
    				JSONObject jo = (JSONObject) event.get(i);	
    				name_events.add((String) jo.get("name"));
    				JSONObject jsons = (JSONObject) jo.get("dates");
    				JSONObject ora = (JSONObject) jsons.get("start");
    				date.add((String) ora.get("localDate"));
    				time.add((String) ora.get("localTime"));
    				JSONArray array = (JSONArray) jo.get("classifications");
    				
    			for(int j = 0; j < array.size();j++) {
    			    
    			    JSONObject a = (JSONObject) array.get(j);
    			    	JSONObject jsonObject = (JSONObject)a.get("segment");
    			    	this.classificazione.add((String) jsonObject.get("name"));
    			 
    			}
    			JSONObject local =(JSONObject) jo.get("_embedded");
    			JSONArray locale = (JSONArray) local.get("venues");
    			
    			for(int k = 0; k < locale.size();k++) {
    			    
    			    JSONObject a = (JSONObject) locale.get(k);
    			    JSONObject jsonObject = (JSONObject)a.get("city");
    			    	this.city.add((String) jsonObject.get("name"));
    			    JSONObject place = (JSONObject) a.get("country");
    			    this.state.add((String) place.get("name"));
    			 
    			}
    			
    		}
    			System.out.print("file salvato");

	    	}catch(Exception e) {
	    		System.out.print(e);
	    	}
   		}
    public void saveFile()
    {try {
	   
	    	PrintWriter file_output = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\asus\\Desktop\\Events" + this.paese+ ".txt")));
	    	
				
		for(int i = 0; i < name_events.size();i++) {
		    file_output.println(name_events.get(i));
		    file_output.println(classificazione.get(i));
		    file_output.println(date.get(i));
		    file_output.println(time.get(i));
		    file_output.println(state.get(i));	
		    file_output.println(city.get(i));	
		    
		}
			
			
		file_output.close();
		System.out.print("file salvato");
	    
	} catch (IOException e) {
	    e.printStackTrace();
	} catch (Exception e) {
	    System.out.println(e);
		}
    }
    public List<Event>  fillList()
	{
	    if(this.paese != null)
	    {
	    	List<Event> lista = new ArrayList<Event>();    
		try {
    	    
		    Scanner scan = new Scanner(new BufferedReader(new FileReader("C:\\Users\\asus\\Desktop\\Events" + this.paese+ ".txt")));
    	    
		    while(scan.hasNext()) {
    		
			String name = null;
			String type = null;
			String date = null;
			String time = null;
			String state = null;
			String city = null;
			name = scan.nextLine();
			type= scan.nextLine();
			date = scan.nextLine();
			time = scan.nextLine();
			state = scan.nextLine();
			city = scan.nextLine();
			Event evento = new Event(name,type,date,time,state,city);
			lista.add(evento);
			
	    }
    	
    	 } catch(IOException e) {
    	     System.out.print(e);
    	 } catch(Exception e) {
    	     System.out.print(e);
    	 }
		return lista;
    }
	return null;
	
	}

   }

	
    

