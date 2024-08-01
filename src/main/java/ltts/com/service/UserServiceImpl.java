package ltts.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ltts.com.dao.UserDAO;
import ltts.com.model.Booking;
import ltts.com.model.Event;
import ltts.com.model.Registration;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDao;

	@Override
	public Registration addUser(Registration registration) {
		// TODO Auto-generated method stub
		return userDao.addUser(registration);
	}

	@Override
	public Registration login(String email, String password) {
		// TODO Auto-generated method stub
		return userDao.login(email, password);
	}

	@Override
	public Event addEvent(Event event) {
		// TODO Auto-generated method stub
		return userDao.addEvent(event);
	}

	@Override
	public List<Event> findEvent(String location) {
		// TODO Auto-generated method stub
		return userDao.findEvent(location);
	}

	@Override
	public List<Event> findCategory(String category) {
		// TODO Auto-generated method stub
		return userDao.findCategory(category);
	}

	@Override
	public List<Event> findTitle(String title) {
		// TODO Auto-generated method stub
		return userDao.findTitle(title);
	}

	@Override
	public Booking addBooking(Booking booking) {
		// TODO Auto-generated method stub
		return userDao.addBooking(booking);
	}

	@Override
	public List<Event> showall() {
		// TODO Auto-generated method stub
		return userDao.showall();
	}

	@Override
	public boolean updateEvent(int eid, String details, String location, double price) {
		// TODO Auto-generated method stub
		return userDao.updateEvent(eid, details, location, price);
	}

	@Override
	public int deleteById(int eid) {
		// TODO Auto-generated method stub
		return userDao.deleteById(eid);
	}

	@Override
	public boolean updateBookingStatus(int bid, String status) {
		// TODO Auto-generated method stub
		return userDao.updateBookingStatus(bid, status);
	}

	@Override
	public int updateProfile(Registration registration) {
		// TODO Auto-generated method stub
		return userDao.updateProfile(registration);
	}

	

	

}
