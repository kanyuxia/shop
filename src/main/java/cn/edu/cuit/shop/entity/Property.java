package cn.edu.cuit.shop.entity;

import java.util.Date;
import java.util.Objects;

/**
 * 属性表
 * @author kanyuxia
 *
 */
/**
 * @author kanyuxia
 *
 */
public class Property {
	// --------------------------field
	/**
	 * 属性id
	 */
	private long propertyID;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 属性名称
	 */
	private String name;
	
	
	// ------------------------Construct methods
	public Property() {
		super();
	}

	public Property(long propertyID, Date createTime, String name, long productID) {
		super();
		this.propertyID = propertyID;
		this.createTime = createTime;
		this.name = name;
	}
	
	// ----------------------------Override some methods

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof Property) {
			Property property = (Property) obj;
			return Objects.equals(this.name, property.getName());
		}
		return false;
	}



	@Override
	public String toString() {
		return "Property [propertyID=" + propertyID + ", createTime=" + createTime + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	// ----------------------setter、getter methods
	public long getPropertyID() {
		return propertyID;
	}

	public void setPropertyID(long propertyID) {
		this.propertyID = propertyID;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
