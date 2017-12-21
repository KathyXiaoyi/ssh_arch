package ilv.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * IlvUser entity.
 */
@Entity
@Table(name = "ilv_user", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class IlvUser implements java.io.Serializable {

	// Fields

	private String id;
	private IlvUser ilvUser;
	private String username;
	private String realname;
	private String password;
	private Timestamp logintime;
	private String islock;
	private String status;
	private Timestamp createtime;
	private Set<IlvUser> ilvUsers = new HashSet<IlvUser>(0);

	// Constructors

	/** default constructor */
	public IlvUser() {
	}

	/** minimal constructor */
	public IlvUser(String id, String username, String realname, String password, String islock, String status,
			Timestamp createtime) {
		this.id = id;
		this.username = username;
		this.realname = realname;
		this.password = password;
		this.islock = islock;
		this.status = status;
		this.createtime = createtime;
	}

	/** full constructor */
	public IlvUser(String id, IlvUser ilvUser, String username, String realname, String password, Timestamp logintime,
			String islock, String status, Timestamp createtime, Set<IlvUser> ilvUsers) {
		this.id = id;
		this.ilvUser = ilvUser;
		this.username = username;
		this.realname = realname;
		this.password = password;
		this.logintime = logintime;
		this.islock = islock;
		this.status = status;
		this.createtime = createtime;
		this.ilvUsers = ilvUsers;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 36)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "createId")
	public IlvUser getIlvUser() {
		return this.ilvUser;
	}

	public void setIlvUser(IlvUser ilvUser) {
		this.ilvUser = ilvUser;
	}

	@Column(name = "username", unique = true, nullable = false, length = 36)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "realname", nullable = false, length = 100)
	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Column(name = "password", nullable = false, length = 32)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "logintime", length = 19)
	public Timestamp getLogintime() {
		return this.logintime;
	}

	public void setLogintime(Timestamp logintime) {
		this.logintime = logintime;
	}

	@Column(name = "islock", nullable = false, length = 1)
	public String getIslock() {
		return this.islock;
	}

	public void setIslock(String islock) {
		this.islock = islock;
	}

	@Column(name = "status", nullable = false, length = 1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "createtime", nullable = false, length = 19)
	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ilvUser")
	public Set<IlvUser> getIlvUsers() {
		return this.ilvUsers;
	}

	public void setIlvUsers(Set<IlvUser> ilvUsers) {
		this.ilvUsers = ilvUsers;
	}

}