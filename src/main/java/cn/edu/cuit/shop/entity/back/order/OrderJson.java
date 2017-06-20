package cn.edu.cuit.shop.entity.back.order;

import java.util.List;

/**
 * 返回前台的JSON格式数据
 * @author echo
 *
 */
public class OrderJson {
	private int total;
	private List rows;
	
	public OrderJson(int total, List list) {
		this.total = total;
		this.rows = list;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List<BackOrder> rows) {
		this.rows = rows;
	}
	
	
}
