package cn.edu.cuit.shop.entity.back.order;

import java.util.Date;

/**
 * 订单列表实体
 * @author echo
 *
 */
public class BackOrder {
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
	 * 用户账号
	 */
	private String number;
	
	/**
	 * 用户昵称
	 */
	private String nickname;

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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
}
