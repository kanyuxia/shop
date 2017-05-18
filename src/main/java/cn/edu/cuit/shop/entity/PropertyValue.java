package cn.edu.cuit.shop.entity;

import java.util.Date;
import java.util.Objects;

/**
 * 属性值表
 * @author kanyuxia
 *
 */
public class PropertyValue {
	// ----------------------------field
	/**
	 * 属性id
	 */
	private long propertyValueID;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 属性值
	 */
	private String value;
	
	/**
	 * 外键：属性id
	 */
	private long propertyID;

	// -------------------------Construct methods
	public PropertyValue() {
		super();
	}

	public PropertyValue(long propertyValueID, Date createTime, String value, long propertyID) {
		super();
		this.propertyValueID = propertyValueID;
		this.createTime = createTime;
		this.value = value;
		this.propertyID = propertyID;
	}
	
	//------------------------------Override some methods
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (propertyID ^ (propertyID >>> 32));
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof PropertyValue) {
			PropertyValue propertyValue = (PropertyValue) obj;
			return Objects.equals(this.value, propertyValue.getValue())
					&& Objects.equals(this.propertyID, propertyValue.getPropertyID());
		}
		return false;
	}

	@Override
	public String toString() {
		return "PropertyValue [propertyValueID=" + propertyValueID + ", createTime=" + createTime + ", value=" + value
				+ ", propertyID=" + propertyID + "]";
	}
	
	// --------------------setter、getter methods
	public long getPropertyValueID() {
		return propertyValueID;
	}

	public void setPropertyValueID(long propertyValueID) {
		this.propertyValueID = propertyValueID;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public long getPropertyID() {
		return propertyID;
	}

	public void setPropertyID(long propertyID) {
		this.propertyID = propertyID;
	}
	
	

}
