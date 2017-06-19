package cn.edu.cuit.shop.entity;

import java.util.Date;
import java.util.Objects;

/**
 * 库存信息表
 * @author kanyuxia
 *
 */
public class Inventory {
	/**
	 * 库存id
	 */
	private long inventoryID;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 库存数量
	 */
	private long inventoryNumber;
	
	/**
	 * 销售数量
	 */
	private long sellNumber;
	
	/**
	 * 外键：商品id
	 */
	private long goodsID;
	
	private Goods goods;
	
	// ---------------------Construct method
	public Inventory() {
		super();
	}

	public Inventory(long inventoryID, Date createTime, long inventoryNumber, long sellNumber, long goodsID) {
		super();
		this.inventoryID = inventoryID;
		this.createTime = createTime;
		this.inventoryNumber = inventoryNumber;
		this.sellNumber = sellNumber;
		this.goodsID = goodsID;
	}

	
	// ------------------------Override some methods
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (goodsID ^ (goodsID >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof Inventory) {
			Inventory inventory = (Inventory) obj;
			return Objects.equals(this.getGoodsID(), inventory.getGoodsID());
		}
		return false;
	}

	
	
	@Override
	public String toString() {
		return "Inventory [inventoryID=" + inventoryID + ", createTime=" + createTime + ", inventoryNumber="
				+ inventoryNumber + ", sellNumber=" + sellNumber + ", goodsID=" + goodsID + ", goods=" + goods + "]";
	}

	// -----------------------setter、getter methods
	public long getInventoryID() {
		return inventoryID;
	}

	public void setInventoryID(long inventoryID) {
		this.inventoryID = inventoryID;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public long getInventoryNumber() {
		return inventoryNumber;
	}

	public void setInventoryNumber(long inventoryNumber) {
		this.inventoryNumber = inventoryNumber;
	}

	public long getSellNumber() {
		return sellNumber;
	}

	public void setSellNumber(long sellNumber) {
		this.sellNumber = sellNumber;
	}

	public long getGoodsID() {
		return goodsID;
	}

	public void setGoodsID(long goodsID) {
		this.goodsID = goodsID;
	}
	
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	
	public Goods getGoods() {
		return goods;
	}
}
