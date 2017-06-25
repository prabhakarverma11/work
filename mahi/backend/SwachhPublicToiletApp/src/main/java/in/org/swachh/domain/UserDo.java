package in.org.swachh.domain;
// default package
// Generated Sep 20, 2016 5:09:12 PM by Hibernate Tools 4.0.0

import javax.persistence.*;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user")
public class UserDo implements java.io.Serializable,HttpSessionBindingListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String email;
	private String phoneno;
	private String password;
	private String createdBy;
	private Date createdOn;
	private Boolean isVerified;
	private String uniqueId;
	//Date Strings added to store dates starts
		private String createdOnString;
		
		@Transient
		public String getCreatedOnString() {
			return createdOnString;
		}
		public void setCreatedOnString(String createdOnString) {
			this.createdOnString = createdOnString;
		}

		//Date Strings added to store dates ends
		
		//To store sessions starts
		
		private static Map<UserDo, HttpSession> usersSessions= new HashMap<UserDo, HttpSession>();
		
		public static Map<UserDo, HttpSession> getUsersSessions() {
			return usersSessions;
		}
		public static void setUsersSessions(Map<UserDo, HttpSession> usersSessions) {
			UserDo.usersSessions = usersSessions;
		}
		
		
		
		//To store sessions ends
	
	private String updatedBy;
	private Date updatedOn;

	public UserDo() {
	}

	public UserDo(String createdBy, Date createdOn) {
		this.createdBy = createdBy;
		this.createdOn = createdOn;
	}

	public UserDo(String name, String email, String phoneno, String password,
                  String createdBy, Date createdOn, String updatedBy, Date updatedOn, Boolean isVerified) {
		this.name = name;
		this.email = email;
		this.phoneno = phoneno;
		this.password = password;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
		this.isVerified = isVerified;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "email", length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phoneno", length = 100)
	public String getPhoneno() {
		return this.phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	@Column(name = "password", length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "created_by", nullable = false, length = 50)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on", nullable = false, length = 0)
	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Column(name = "updated_by", length = 50)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_on", length = 0)
	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	
	@Column(name = "is_verified")
	public Boolean getIsVerified() {
		return isVerified;
	}
	
	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}
	
	@Column(name = "unique_id")
	public String getUniqueId() {
		return uniqueId;
	}
	
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		usersSessions.put(this, event.getSession());
		
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		usersSessions.remove(this);
		
	}
	
	

}
