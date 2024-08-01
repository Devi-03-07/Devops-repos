package ltts.com.service;

import java.util.List;
import java.util.Optional;

import ltts.com.model.Booking;
import ltts.com.model.Event;
import ltts.com.model.Registration;

public interface UserService {
	
	public Registration addUser(Registration registration);
	public Registration login(String email,String password);
	public Event addEvent(Event event);
	public List<Event> findEvent(String location);
	public List<Event> findCategory(String category);
	public List<Event> findTitle(String title);
	public Booking addBooking(Booking booking);
	public List<Event> showall();
	public boolean updateEvent(int eid,String details,String location,double price);
	public int deleteById(int eid);
	public boolean updateBookingStatus(int bid,String status);

	
	public int updateProfile(Registration registration);
}
