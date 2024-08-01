package ltts.com.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {
	
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private int bid;
	
	@ManyToOne
	@JoinColumn(name="event_id")
	private Event event;
	private String title;
	@Column(name="event_date")
	private Date edate;
	private double amt;
	@Column(name="user_email")
	private String uemail;
	@Column(name="exec_status")
	private String status;
	
	public Booking() {
		super();
	}

	public Booking(int bid, Event event, String title, Date edate, double amt, String uemail, String status) {
		super();
		this.bid = bid;
		this.event = event;
		this.title = title;
		this.edate = edate;
		this.amt = amt;
		this.uemail = uemail;
		this.status = status;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getEdate() {
		return edate;
	}

	public void setEdate(Date edate) {
		this.edate = edate;
	}

	public double getAmt() {
		return amt;
	}

	public void setAmt(double amt) {
		this.amt = amt;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

}
