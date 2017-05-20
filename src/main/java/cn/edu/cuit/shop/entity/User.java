package cn.edu.cuit.shop.entity;

import java.util.Date;
import java.util.Objects;

/**
 * 用户信息实体
 * @author kanyuxia
 *
 */
public class User {
	
	//-----------------------------field
	/**
	 * 用户ID
	 */
	private long userID;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 用户账号
	 */
	private String number;
	
	/**
	 * 用户密码
	 */
	private String password;
	
	/**
	 * 用户昵称
	 */
	private String nickname;
	
	/**
	 * 用户性别
	 */
	private String sex;
	
	// -------------------------Construct methods
	public User(long userID, Date createTime, String number, String password, String nickname, String sex) {
		super();
		this.userID = userID;
		this.createTime = createTime;
		this.number = number;
		this.password = password;
		this.nickname = nickname;
		this.sex = sex;
	}
	
	public User() {
		super();
	}
	
	// -------------------Override equals、hashcode、toString methods
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof User) {
			User user = (User) obj;
			return Objects.equals(this.number, user.getNumber());
		}
		return false;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", createTime=" + createTime + ", number=" + number + ", password=" + password
				+ ", nickname=" + nickname + ", sex=" + sex + "]";
	}

	// -------------------------setter、getter methods
	public long getUserID() {
		return userID;
	}


	public void setUserID(long userID) {
		this.userID = userID;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public void setId(long id) {
		this.userID = id;
	}
}
