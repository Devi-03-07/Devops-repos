package ltts.com.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import ltts.com.jpa.MyJPABookingRepository;
import ltts.com.jpa.MyJPAEventRepository;
import ltts.com.jpa.MyJPARepository;
import ltts.com.model.Booking;
import ltts.com.model.Event;
import ltts.com.model.Registration;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private MyJPARepository myRepo;
	
	@Autowired
	private MyJPAEventRepository myRepo2;
	
	@Autowired
	private MyJPABookingRepository myRepo3;

	@Override
	public Registration addUser(Registration registration) {
		String encrptedPassword=hashPassword(registration.getPassword());
		System.out.println("gpwd:"+encrptedPassword);
		registration.setPassword(encrptedPassword);
		if(myRepo.findById(registration.getEmail()).isPresent()) {
			System.out.println("Email is Already exist.");
			return null;
		}else if(myRepo.save(registration)!=null)
			return myRepo.save(registration);
		return registration;
	
	}
	
	@Override
	@Transactional
	public int updateProfile(Registration registration) {
		// TODO Auto-generated method stub
		String encrptedPassword=hashPassword(registration.getPassword());
		System.out.println("gpwd:"+encrptedPassword);
		registration.setPassword(encrptedPassword);
		if(myRepo.findById(registration.getEmail()).isPresent() && (myRepo.save(registration)!=null)) {
			return myRepo.updateDataByEmail(registration.getEmail(), registration.getMobile_no(),registration.getPassword());
		}else {
			System.out.println("Email is Not valid");
			return (Integer) null;
		}
	}

	@Override
	public String hashPassword(String plainTextPassword) {
		// TODO Auto-generated method stub
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}

	@Override
	public boolean checkPass(String plainPassword, String hashedPassword) {
		// TODO Auto-generated method stub
		return BCrypt.checkpw(plainPassword, hashedPassword);
	}

	@Override
	public Registration login(String email, String password) {
		// TODO Auto-generated method stub
		Optional<Registration> getData = myRepo.findById(email);
		if(getData.isPresent()) {
			Registration registration = getData.get();
			String existingPassword = registration.getPassword();
			System.out.println("epwd:"+existingPassword);
			if(checkPass(password,existingPassword )) {
				return registration;
			}else {
				return null;
			}
		}
		return null;
	}
	
	
	@Override
	public Event addEvent(Event event) {
		// TODO Auto-generated method stub
		if(myRepo2.save(event)!=null)
			return myRepo2.save(event);
		return null;
	}

	@Override
	public List<Event> findEvent(String location) {
		// TODO Auto-generated method stub
		
		return myRepo2.findByLocation(location);
	}

	@Override
	public List<Event> findCategory(String category) {
		// TODO Auto-generated method stub
		return myRepo2.findByCategoryContaining(category);
	}

	@Override
	public List<Event> findTitle(String title) {
		// TODO Auto-generated method stub
		return myRepo2.findByTitleContaining(title);
	}

	@Override
	public Booking addBooking(Booking booking) {
		// TODO Auto-generated method stub
		if(myRepo3.save(booking)!=null)
			return myRepo3.save(booking);
		return null;
		
	}

	@Override
	public List<Event> showall() {
		// TODO Auto-generated method stub
		List<Event> data=(List<Event>)myRepo2.findAll();
		return data;
	}

	@Override
	@Transactional
	public boolean updateEvent(int eid, String details, String location, double price) {
		// TODO Auto-generated method stub
		if(myRepo2.updateDataById(eid, details, location, price)>0)
			return true;
		return false;
	}

	@Override
	@Transactional
	public int deleteById(int eid) {
		// TODO Auto-generated method stub
		if(myRepo2.deleteByEid(eid)>0)
			return 1;
		return 0;
	}

	@Override
	@Transactional
	public boolean updateBookingStatus(int bid, String status) {
		// TODO Auto-generated method stub
		if(myRepo3.updateDataById(bid, status)>0)
			return true;
		return false;
	}

	
	

}
