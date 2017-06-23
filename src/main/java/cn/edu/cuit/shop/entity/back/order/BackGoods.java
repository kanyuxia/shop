package cn.edu.cuit.shop.entity.back.order;

import java.util.Date;

public class BackGoods {
	// ----------------------field
	/**
	 * 外键：产品id
	 */
	private long productID;
	/**
	 * 商品id
	 */
	private long goodsID;

	/**
	 * 创建时间
	 */
	private Date createTime;

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

	/**
	 * 库存
	 */
	private int inventoryNumber;

	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}

	public long getGoodsID() {
		return goodsID;
	}

	public void setGoodsID(long goodsID) {
		this.goodsID = goodsID;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

	public int getInventoryNumber() {
		return inventoryNumber;
	}

	public void setInventoryNumber(int inventoryNumber) {
		this.inventoryNumber = inventoryNumber;
	}

}
