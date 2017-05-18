package cn.edu.cuit.shop.entity;

import java.util.Date;
import java.util.Objects;

/**
 * 商品信息表
 * @author kanyuxia
 *
 */
public class Goods {
	// ----------------------field
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
	 * 外键：产品id
	 */
	private long productID;

	// -----------------------Construct method
	public Goods() {
		super();
	}

	public Goods(long goodsID, Date createTime, String attributes, double originalPrice, double sellPrice,
			long productID) {
		super();
		this.goodsID = goodsID;
		this.createTime = createTime;
		this.attributes = attributes;
		this.originalPrice = originalPrice;
		this.sellPrice = sellPrice;
		this.productID = productID;
	}
	
	// -----------------------Override some methods
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attributes == null) ? 0 : attributes.hashCode());
		result = prime * result + (int) (productID ^ (productID >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof Goods) {
			Goods goods = (Goods) obj;
			return Objects.equals(this.attributes, goods.getAttributes()) 
					&& Objects.equals(this.goodsID, goods.getGoodsID());
		}
		return false;
	}

	@Override
	public String toString() {
		return "Goods [goodsID=" + goodsID + ", createTime=" + createTime + ", attributes=" + attributes
				+ ", originalPrice=" + originalPrice + ", sellPrice=" + sellPrice + ", productID=" + productID + "]";
	}

	//--------------------setter、getter methods
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

	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}
	
	
}
