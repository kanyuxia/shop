package cn.edu.cuit.shop.entity;

import java.util.Date;
import java.util.Objects;

/**
 * 产品信息实体
 * @author kanyuxia
 *
 */
public class Product {
	// --------------------field
	/**
	 * 产品id
	 */
	private long productID;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 产品名称
	 */
	private String name;
	
	/**
	 * 属性，如：颜色,内存
	 */
	private String attributes;
	
	/**
	 * 外键：分类id
	 */
	private long categoryID;

	// ---------------------------Construct methods
	public Product() {
		super();
	}

	public Product(long productID, Date createTime, String name, String attributes, long categoryID) {
		super();
		this.productID = productID;
		this.createTime = createTime;
		this.name = name;
		this.attributes = attributes;
		this.categoryID = categoryID;
	}

	// -------------------------Override some methods
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof Product) {
			Product product = (Product) obj;
			return Objects.equals(this.name, product.getName());
		}
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", createTime=" + createTime + ", name=" + name + ", attributes="
				+ attributes + ", categoryID=" + categoryID + "]";
	}

	// -------------------setter、getter methods
	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
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

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	public long getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(long categoryID) {
		this.categoryID = categoryID;
	}
	
	
}
