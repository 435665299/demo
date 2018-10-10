package cn.easybuy.dao.product;

import java.sql.SQLException;
import java.util.List;

import cn.easybuy.entity.Product;
import cn.easybuy.params.ProductParams;

public interface ProductDao {
	/**
	 * 根据条件查询商品分类列表
	 * @param productParams
	 * @return
	 */
	public List<Product> getProductList(ProductParams productParams) throws SQLException;
	/**
	 * 根据条件查询商品数量
	 * @param productParams
	 * @return
	 */
	public int getProductCount(ProductParams productParams);
}
