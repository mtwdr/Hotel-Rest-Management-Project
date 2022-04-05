package webHotel;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path ("WebHotel")
public class HotelResource {
	private static List<Hotel> HotelList = new ArrayList<Hotel>();
	
	public void add(){
	HotelList.add(0, new Hotel(100, "Single", "Kimberley", "Ryan", "08.01.2022", "18.01.2022", 1));
	HotelList.add(1, new Hotel(101, "Single", "Otis", "Grace", "07.01.2022", "17.01.2022", 2));
	HotelList.add(2, new Hotel(102, "Single", "Pheonix", "John", "21.01.2022", "24.01.2022", 1));
	HotelList.add(3, new Hotel(103, "Single", null, null, null, null, 0));
	HotelList.add(4, new Hotel(104, "Single", null, null, null, null, 0));
	HotelList.add(5, new Hotel(105, "Single", null, null, null, null, 0));
	
	HotelList.add(6, new Hotel(106, "Double", "King", "Charles", "10.01.2022", "17.01.2022", 2));
	HotelList.add(7, new Hotel(107, "Double", "Christmas", "Arthur", "14.01.2022", "20.01.2022", 4));
	HotelList.add(8, new Hotel(108, "Double", null, null, null, null, 0));
	HotelList.add(9, new Hotel(109, "Double", null, null, null, null, 0));
	HotelList.add(10, new Hotel(110, "Double", null, null, null, null, 0));
	HotelList.add(11, new Hotel(111, "Double", null, null, null, null, 0));
	
	HotelList.add(12, new Hotel(112, "Triple", "Rock", "Jennifer", "11.01.2022", "13.01.2022", 3));
	HotelList.add(13, new Hotel(113, "Triple", "Rays", "Allen", "01.01.2022", "05.02.2022", 3));
	HotelList.add(14, new Hotel(114, "Triple", "Clerrance", "John", "20.01.2022", "25.01.2022", 3));
	HotelList.add(15, new Hotel(115, "Triple", null, null, null, null, 0));
	HotelList.add(16, new Hotel(116, "Triple", null, null, null, null, 0));
	HotelList.add(17, new Hotel(117, "Triple", null, null, null, null, 0));
	
	HotelList.add(18, new Hotel(118, "Deluxe", null, null, null, null, 0));
	HotelList.add(19, new Hotel(119, "Deluxe", null, null, null, null, 0));
	HotelList.add(20, new Hotel(120, "Deluxe", null, null, null, null, 0));
	
	HotelList.add(21, new Hotel(121, "Penthouse", "Ramnarine", "Matthew", "01.02.2022", "04.02.2022", 1));
	HotelList.add(22, new Hotel(122, "Penthouse", null, null, null, null, 0));
	HotelList.add(23, new Hotel(123, "Penthouse", null, null, null, null, 0));
	}
	
	@GET
	@Path("/rooms")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Hotel> RoomsInfo() {
		add();
		return HotelList;
	}
	
	@GET
	@Path("/roomsearch")
	@Produces(MediaType.APPLICATION_JSON)
	public Hotel searchRoomInfo(@QueryParam("room_no") int room_no) {
		add();
		int foundindex = -1;
		for(int i = 0; i < HotelList.size(); i++) {
			if(room_no == HotelList.get(i).getroom_no()) {
				foundindex = i;
				break;
			}
		}
		return new Hotel(HotelList.get(foundindex).getroom_no(), HotelList.get(foundindex).getroom_type(), HotelList.get(foundindex).getguest_Lname(), HotelList.get(foundindex).getguest_Fname(), HotelList.get(foundindex).getarrival(), HotelList.get(foundindex).getdeparture(), HotelList.get(foundindex).getguests());
	}

	@POST
	@Path("/registernewroom")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Hotel> registerNewRoom(@FormParam("room_no") int room_no) {
		add();
		HotelList.add(23, new Hotel(room_no, null, null, null, null, null, 0));
		return HotelList;
	}
	
	@PUT
	@Path("/updateroominfo")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Hotel> updateRoomInfo(@FormParam("room_no") int room_no, @FormParam("room_type") String room_type, @FormParam("guest_LName") String guest_LName, @FormParam("guest_FName") String guest_FName, @FormParam("arrival_date") String arrival_date, @FormParam("departure_date") String departure_date, @FormParam("guests") int guests){
		add();
		for(int i = 0; i < HotelList.size(); i++) {
			if(HotelList.get(i).getroom_no() == room_no) {
				HotelList.set(i, new Hotel(room_no, room_type, guest_LName, guest_FName, arrival_date, departure_date, guests));
			}
		}
		
		return HotelList;
	}
	
	@DELETE
	@Path("/removeroom")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Hotel> deleteParameters(@QueryParam("room_no") int room_no) {
		add();
		
		for (int i=0; i < HotelList.size(); i++) {
			if(HotelList.get(i).getroom_no() == room_no) {
				HotelList.remove(i);
			}
		}
		return HotelList;
	}
	
}