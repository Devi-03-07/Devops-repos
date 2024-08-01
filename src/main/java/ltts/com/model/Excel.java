package ltts.com.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Excel {
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true)
	private int id;
	@NotNull(message="Name is required")
	@Column(unique=true)
	@Size(min=3,max=50)
	private  String name;
	@NotNull(message="phone number is required")
	@Pattern(regexp="\\d{10}",message="phone number must contain 10 digits")
	@Column(unique=true)
	private long mobileno;
	
	@NotNull(message="Email is required")
	@Column(unique=true)
	
	private String emailid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public Excel(int id, String name, long mobileno, String emailid) {
		super();
		this.id = id;
		this.name = name;
		this.mobileno = mobileno;
		this.emailid = emailid;
	}

	public Excel() {
		super();
	
		
	}
	

	
	

}
