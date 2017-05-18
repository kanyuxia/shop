package cn.edu.cuit.shop.entity;

import java.util.Date;
import java.util.Objects;

/**
 * 购物车信息表
 * @author kanyuxia
 *
 */
public class ShopCart {
	// ---------------------------field
	/**
	 * 购物车id
	 */
	private long shopCartID;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 商品数量
	 */
	private long goodsNumber;
	
	/**
	 * 商品id
	 */
	private long goodsId;
	
	/**
	 * 用户id
	 */
	private long userId;
	
	// --------------------------Construct methods
	public ShopCart() {
		super();
	}

	public ShopCart(long shopCartID, Date createTime, long goodsNumber, long goodsId, long userId) {
		super();
		this.shopCartID = shopCartID;
		this.createTime = createTime;
		this.goodsNumber = goodsNumber;
		this.goodsId = goodsId;
		this.userId = userId;
	}
	
	//------------------------------Override some methods
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (goodsId ^ (goodsId >>> 32));
		result = prime * result + (int) (userId ^ (userId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof ShopCart) {
			ShopCart shopCart = (ShopCart) obj;
			return Objects.equals(this.getGoodsId(), shopCart.getGoodsId())
					&& Objects.equals(this.userId, shopCart.getUserId());
		}
		return false;
	}

	@Override
	public String toString() {
		return "ShopCart [shopCartID=" + shopCartID + ", createTime=" + createTime + ", goodsNumber=" + goodsNumber
				+ ", goodsId=" + goodsId + ", userId=" + userId + "]";
	}
	
	// ------------------setter、getter methodss
	public long getShopCartID() {
		return shopCartID;
	}

	public void setShopCartID(long shopCartID) {
		this.shopCartID = shopCartID;
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

	public long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	
}
