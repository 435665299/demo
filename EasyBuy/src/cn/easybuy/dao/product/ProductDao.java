package cn.easybuy.dao.product;

import java.sql.SQLException;
import java.util.List;

import cn.easybuy.entity.Product;
import cn.easybuy.params.ProductParams;

public interface ProductDao {
	/**
	 * ����������ѯ��Ʒ�����б�
	 * @param productParams
	 * @return
	 */
	public List<Product> getProductList(ProductParams productParams) throws SQLException;
	/**
	 * ����������ѯ��Ʒ����
	 * @param productParams
	 * @return
	 */
	public int getProductCount(ProductParams productParams);
}
