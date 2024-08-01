package ltts.com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ltts.com.model.Booking;
import ltts.com.model.Event;
import ltts.com.model.Registration;
import ltts.com.service.UserService;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/api")
public class AppController {
	 @Autowired
     private UserService service;
	 
	 @PostMapping(value="/register")
	 public ResponseEntity<Registration> getRegister(@RequestBody Registration registration)   
     {
		 
		 Registration newRegistration=service.addUser(registration);
		 
         return new ResponseEntity<>(newRegistration, HttpStatus.OK);
     }
	 
	 @PutMapping(value="/profile/update")
	 public int getProfile(@RequestBody Registration registration)   
     {
		 
		 int update=service.updateProfile(registration);
		 
		return update;
     }
	 
	 @PostMapping("/login")
	public ResponseEntity<Registration> getUser(@RequestBody Registration registration ) {
			
		 Registration existingUser = service.login(registration.getEmail(), registration.getPassword());
	 		if(existingUser!=null) {
                return ResponseEntity.ok(existingUser);
	 		}else {
	 		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	 		}
		}
	 
	 @PostMapping(value="/add/event")
	 public ResponseEntity<Event> getAddEvent(@RequestBody Event event)   
     {
         Event addEvent=service.addEvent(event);
         return new ResponseEntity<>(addEvent, HttpStatus.OK);
     }
	 
	 @PutMapping("/event/update")
	 public String updateData(@RequestBody Event event) {
		 System.out.println(event);
		 if(service.updateEvent(event.getEid(), event.getDetails(), event.getLocation(), event.getPrice()))
			 return "Updated Successfully";
		 return "NO data exist to fetch";
	 }
	 
	 @DeleteMapping("/event/delete/{eid}")
	 public String deleteEvent(@PathVariable("eid") int eid) {
		 int del=service.deleteById(eid);
		 if(del>0)
			 return " Deleted Successfully !!!";
		 return "No data to Delete !!!";
	 }
	 
	 @GetMapping("/location/{location}")
	 public ResponseEntity<List<Event>> findByEvent(@PathVariable("location") String location) {
		 List<Event> loc=service.findEvent(location);
     		 return new ResponseEntity<>(loc, HttpStatus.OK);
			
	 }
	 
	 @GetMapping("/category/{category}")
	 public ResponseEntity<List<Event>>  findByCategory(@PathVariable("category") String category) {
		 
		 List<Event> catg=service.findCategory(category);
		 
     		 return new ResponseEntity<>(catg, HttpStatus.OK);
			
	 }
	 
	 @GetMapping("/title/{title}")
	 public ResponseEntity<List<Event>>  findByTitle(@PathVariable("title") String title) {
	       
		 List<Event> Title=service.findTitle(title);
		 
     		 return new ResponseEntity<>(Title, HttpStatus.OK);
		  
			
	 }
	 
	
	 @PostMapping(value="/add/booking")
	 public ResponseEntity<Booking> getAddBooking(@RequestBody Booking booking)   
     {
        
         Booking addBooking = service.addBooking(booking);
         return new ResponseEntity<>(addBooking, HttpStatus.OK);
     }
	 
	 @PutMapping("/status/update")
	 public String updateStatus(@RequestBody Booking booking) {
		 System.out.println(booking);
		 if(service.updateBookingStatus(booking.getBid(), booking.getStatus()))
			 return "Updated Successfully";
		 return "NO data exist to fetch";
	 }

	 @GetMapping("/event/show")
	 public ResponseEntity<List<Event>> showAll(){
		 List<Event> data = service.showall();
		 return new ResponseEntity<>(data, HttpStatus.OK);
	 }
	 
	

}
