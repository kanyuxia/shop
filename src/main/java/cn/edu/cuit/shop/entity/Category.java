package cn.edu.cuit.shop.entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 商品分类信息实体
 * @author kanyuxia
 *
 */
public class Category {
	//----------------------------filed
	/**
	 * 分类id
	 */
	private long categoryID;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 分类名
	 */
	private String name;
	
	/**
	 * 产品列表
	 */
	private List<Product> products;
	
	// -------------------------Construct methods
	
	public Category() {
	}

	public Category(long categoryID, Date createTime, String name) {
		super();
		this.categoryID = categoryID;
		this.createTime = createTime;
		this.name = name;
	}
	
	// ------------------------Override equals、hashCode、toString methods
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof Category) {
			Category category = (Category) obj;
			return Objects.equals(this.name, category.getName());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	

	@Override
	public String toString() {
		return "Category [categoryID=" + categoryID + ", createTime=" + createTime + ", name=" + name + ", products="
				+ products + "]";
	}

	// -----------------------setter、getter methods
	public long getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(long categoryID) {
		this.categoryID = categoryID;
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
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
