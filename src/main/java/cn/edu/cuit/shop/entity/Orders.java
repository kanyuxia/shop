package cn.edu.cuit.shop.entity;

import java.util.Date;
import java.util.Objects;

import org.springframework.core.annotation.Order;

/**
 * 订单信息表
 * @author kanyuxia
 *
 */
public class Orders {
	// ---------------------------field
	/**
	 * 订单id
	 */
	private long ordersID;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 收获地址
	 */
	private String harvestAddress;
	
	/**
	 * 订单状态码
	 */
	private int status;
	
	/**
	 * 总价格
	 */
	private double totalPrice;
	
	/**
	 * 外键：用户id
	 */
	private long userID;
	
	// ---------------------------Construct methods
	public Orders() {
		super();
	}

	public Orders(long ordersID, Date createTime, String harvestAddress, int status, double totalPrice, long userID) {
		super();
		this.ordersID = ordersID;
		this.createTime = createTime;
		this.harvestAddress = harvestAddress;
		this.status = status;
		this.totalPrice = totalPrice;
		this.userID = userID;
	}
	
	// ----------------------------Override some methods
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + (int) (userID ^ (userID >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof Orders) {
			Orders orders = (Orders) obj;
			return Objects.equals(this.getCreateTime(), orders.getCreateTime())
					&& Objects.equals(this.userID, orders.getUserID());
		}
		return false;
	}

	@Override
	public String toString() {
		return "Orders [ordersID=" + ordersID + ", createTime=" + createTime + ", harvestAddress=" + harvestAddress
				+ ", status=" + status + ", totalPrice=" + totalPrice + ", userID=" + userID + "]";
	}
	
	// ----------------------setter、getter methods
	public long getOrdersID() {
		return ordersID;
	}

	public void setOrdersID(long ordersID) {
		this.ordersID = ordersID;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getHarvestAddress() {
		return harvestAddress;
	}

	public void setHarvestAddress(String harvestAddress) {
		this.harvestAddress = harvestAddress;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}
	
	
}
