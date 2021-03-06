package cn.easybuy.dao.product;

import java.sql.SQLException;
import java.util.List;
import cn.easybuy.entity.ProductCategory;
import cn.easybuy.utils.ProductCategoryVo;

public interface ProductCategoryDao {
	
	/**
	 * 查询一级商品分类信息
	 * @author ztl
	 * @param parentId
	 * @return List
	 */
	
	public List<ProductCategory> getProductCategoryList(String parentId);

}

