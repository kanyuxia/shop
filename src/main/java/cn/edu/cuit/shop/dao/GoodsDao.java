package cn.edu.cuit.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.cuit.shop.entity.Goods;
import cn.edu.cuit.shop.entity.OrderItem;
import cn.edu.cuit.shop.entity.Product;

public interface GoodsDao {

	/**
	 * 插入商品
	 * @param goods 要插入的实体
	 * @return 收影响的行数
	 */
	int insertGoods(@Param("goods") Goods goods);
	
	/**
	 * 更新商品
	 * @param goods
	 * @return
	 */
	int updateGoods(@Param("goods") Goods goods);
	
	/**
	 * 根据条件查找
	 * @param goods 查询条件
	 * @return 查询结果
	 */
//	List<Goods> selectWithClean(@Param("goods") Goods goods);
	
	/**
	 * 根据ID查找(不关联)
	 * @param goodsId 商品id
	 * @return 查询结果
	 */
	Goods selectWithCleanById(@Param("goodsId") long goodsId);
	
	/**
	 * 根据ID查找(关联其他)
	 * @param goodsId 商品id
	 * @return 查询结果
	 */
	Goods selectWithOneById(@Param("goodsId") long goodsId);
	
	/**
	 * 根据ID删除
	 * @param goodsId 商品id
	 * @return 影响的行数
	 */
	int deleteById(@Param("goodsId") long goodsId);
	
}
