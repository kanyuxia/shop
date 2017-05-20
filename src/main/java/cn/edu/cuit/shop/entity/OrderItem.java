package cn.edu.cuit.shop.entity;

import java.util.Date;
import java.util.Objects;

/**
 * 订单项信息表
 * @author kanyuxia
 *
 */
public class OrderItem {
	// -----------------------field
	/**
	 * 订单项id
	 */
	private long orderItemID;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 商品数量
	 */
	private long Goods_number;
	
	/**
	 * 外键：商品id
	 */
	private long goodsID;
	
	/**
	 * 外键：订单id
	 */
	private long ordersID;
	
	// -------------------------Construct methods
	public OrderItem() {
		super();
	}

	public OrderItem(long orderItemID, Date createTime, long goods_number, long goodsID, long ordersID) {
		super();
		this.orderItemID = orderItemID;
		this.createTime = createTime;
		Goods_number = goods_number;
		this.goodsID = goodsID;
		this.ordersID = ordersID;
	}
	
	// -----------------------------Override some methods
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + (int) (goodsID ^ (goodsID >>> 32));
		result = prime * result + (int) (ordersID ^ (ordersID >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof OrderItem) {
			OrderItem orderItem = (OrderItem) obj;
			return Objects.equals(this.createTime, orderItem.getCreateTime())
					&& Objects.equals(this.goodsID, orderItem.getGoodsID())
					&& Objects.equals(this.ordersID, orderItem.getOrdersID());
		}
		return false;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemID=" + orderItemID + ", createTime=" + createTime + ", Goods_number=" + Goods_number
				+ ", goodsID=" + goodsID + ", ordersID=" + ordersID + "]";
	}
	
	// --------------------------setter、getter methods
	public long getOrderItemID() {
		return orderItemID;
	}

	public void setOrderItemID(long orderItemID) {
		this.orderItemID = orderItemID;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public long getGoods_number() {
		return Goods_number;
	}

	public void setGoods_number(long goods_number) {
		Goods_number = goods_number;
	}

	public long getGoodsID() {
		return goodsID;
	}

	public void setGoodsID(long goodsID) {
		this.goodsID = goodsID;
	}

	public long getOrdersID() {
		return ordersID;
	}

	public void setOrdersID(long ordersID) {
		this.ordersID = ordersID;
	}
	
	
}
