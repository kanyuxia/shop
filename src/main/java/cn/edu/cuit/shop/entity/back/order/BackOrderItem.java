package cn.edu.cuit.shop.entity.back.order;

import java.util.Date;

/**
 * 后台页面显示的订单项实体
 * @author echo
 *
 */
public class BackOrderItem {
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
	private long goodsNumber;
	
	/**
	 * 属性，如：白,32G
	 */
	private String attributes;
	
	/**
	 * 原价
	 */
	private double originalPrice;
	
	/**
	 * 售价
	 */
	private double sellPrice;

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

	public long getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(long goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	public double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}
	
	
}
