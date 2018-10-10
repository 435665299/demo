package cn.easybuy.service.product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.easybuy.dao.product.ProductDaoImp;
import cn.easybuy.entity.Product;
import cn.easybuy.params.ProductParams;
import cn.easybuy.utils.DataSourceUtil;

public class ProductService {
	private Connection connection;
	private ProductDaoImp productDaoImp;
	
	public List<Product> getProductList(ProductParams params){
		connection = DataSourceUtil.getConnection();
		productDaoImp = new ProductDaoImp(connection);
		List<Product> pList = new ArrayList<Product>();
		try {
			pList = productDaoImp.getProductList(params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DataSourceUtil.close(connection);
		}
		return pList;		
	}
	
	public int getProductCount(ProductParams params){
		int count = 0;
		connection = DataSourceUtil.getConnection();
		productDaoImp = new ProductDaoImp(connection);
		count = productDaoImp.getProductCount(params);		
		return count;		
	}
	
}
