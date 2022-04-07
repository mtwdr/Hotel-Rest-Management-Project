package webHotel;

public class Hotel {
	private int room_no;
	private String room_type;
	private String guest_Lname;
	private String guest_Fname;
	private String arrival;
	private String departure;
	private int guests;
	
	public Hotel(int room_no, String room_type, String guest_Lname, String guest_Fname, String arrival, String departure, int guests) {
		this.room_no = room_no;
		this.room_type = room_type;
		this.guest_Lname = guest_Lname;
		this.guest_Fname = guest_Fname;
		this.arrival = arrival;
		this.departure = departure;
		this.guests = guests;
	}
	
	public int getroom_no() {
		return this.room_no;
	}
	
	public String getroom_type() {
		return this.room_type;
	}
	
	public String getguest_Lname() {
		return this.guest_Lname;
	}
	
	public String getguest_Fname() {
		return this.guest_Fname;
	}
	
	public String getarrival() {
		return this.arrival;
	}
	
	public String getdeparture() {
		return this.departure;
	}
	
	public int getguests() {
		return this.guests;
	}
	
	public void setroom_no(int newroom_no) {
		this.room_no = newroom_no;
	}
	
	public void setroom_type(String newroom_type) {
		this.room_type = newroom_type;
	}
	
	public void setguest_Lname(String newguest_Lname) {
		this.guest_Lname = newguest_Lname;
	}
	
	public void setguest_Fname(String newguest_Fname) {
		this.guest_Lname = newguest_Fname;
	}
	
	public void setarrival(String newarrival) {
		this.arrival = newarrival;
	}
	
	public void setdeparture(String newdeparture) {
		this.departure = newdeparture;
	}
	
	public void setguests(int newguests) {
		this.guests = newguests;
	}
	
	public double roomcost() {
		int roomtypecost = 0;
		int servicefee = 0;
		int days = 0; 
		int cost = 0;
		
		String arrivaldaystring = "";
		String departuredaystring = "";
		int arrivalday = 0;
		int departureday = 0;
		
		if (this.arrival != null) {
		arrivaldaystring = this.arrival.substring(0, 2);
		departuredaystring = this.departure.substring(0, 2);
		arrivalday = Integer.parseInt(arrivaldaystring);
		departureday = Integer.parseInt(departuredaystring);
		}
		
		days = departureday - arrivalday;
		days = +days;
		
		if(this.room_type.equalsIgnoreCase("Single")) {
			roomtypecost = 150;
			servicefee = 100;
			cost = (roomtypecost + servicefee) * days;
		}
		
		if(this.room_type.equalsIgnoreCase("Double")) {
			roomtypecost = 200;
			servicefee = 150;
			cost = (roomtypecost + servicefee) * days;
		}
		
		if(this.room_type.equalsIgnoreCase("Triple")) {
			roomtypecost = 250;
			servicefee = 200;
			cost = (roomtypecost + servicefee) * days;
		}
		
		if(this.room_type.equalsIgnoreCase("Deluxe")) {
			roomtypecost = 400;
			servicefee = 300;
			cost = (roomtypecost + servicefee) * days; 
		}
		
		if(this.room_type.equalsIgnoreCase("Penthouse")) {
			roomtypecost = 700;
			servicefee = 300;
			cost = (roomtypecost + servicefee) * days;
		}
		
		return cost;
	}
	
	public String roomavailability() {
		
		String string = null; 
		
		if (this.arrival == null)
				string = "Available";
		else if (this.arrival != null)
			string = "Reserved";
		
		return string;
	}
}
