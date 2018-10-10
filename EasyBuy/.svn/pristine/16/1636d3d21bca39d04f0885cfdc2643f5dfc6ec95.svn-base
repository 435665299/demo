package cn.easybuy.dao.product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.mysql.jdbc.PreparedStatement;

import cn.easybuy.dao.BaseDaoImp;
import cn.easybuy.entity.Product;
import cn.easybuy.params.ProductParams;

public class ProductDaoImp extends BaseDaoImp implements ProductDao{
	private PreparedStatement pstm;
	public ProductDaoImp(Connection connection) {
		super(connection);
	}
	
	public Product tableToClass(ResultSet rs) throws Exception{
		Product product = new Product();
		product.setId(rs.getInt("id"));
		product.setIsDelete(rs.getInt("isDelete"));
		product.setName(rs.getString("name"));
		product.setDescription(rs.getString("description"));
		product.setFileName(rs.getString("fileName"));
		product.setPrice(rs.getFloat("price"));
		product.setStock(rs.getInt("stock"));
		product.setCategoryLevel1(rs.getInt("categoryLevel1"));
		product.setCategoryLevel2(rs.getInt("categoryLevel2"));
		product.setCategoryLevel3(rs.getInt("categoryLevel3"));		
		return product;		
	}
	
	@Override
	public List<Product> getProductList(ProductParams params) throws SQLException{
		List<Product> pList = new ArrayList<Product>();
		StringBuffer sql = new StringBuffer("select * from easybuy_product where 1=1");
		List<Object> paramsList = new ArrayList<Object>(); 
		ResultSet rs = null;
		if(!StringUtils.isEmpty(params.getKeyWords())){
			sql.append(" and name = ?");
			paramsList.add(params.getKeyWords());
		}
		if(!StringUtils.isEmpty(params.getCategoryId())){
			sql.append(" and (categoryLevel1 = ? or categoryLevel2 = ? or categoryLevel3 = ?)");
			paramsList.add(params.getCategoryId());
			paramsList.add(params.getCategoryId());
			paramsList.add(params.getCategoryId());
		}
		if(!StringUtils.isEmpty(params.getSort())){
			sql.append(" order by " + params.getSort());
		}
		if(params.isPage()){
			sql.append(" limit " + params.getStartIndex() + "," + params.getPageSize());
		}
		rs = executeQuery(sql.toString(), paramsList.toArray());
		try {
			while(rs.next()){
				Product product = tableToClass(rs);
				pList.add(product);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			this.close(pstm, rs);
		}
		return pList;
	}

	@Override
	public int getProductCount(ProductParams params) {
		int count = 0 ;
		StringBuffer sql = new StringBuffer("select count(*) from easybuy_product where 1=1");
		List<Object> paramsList = new ArrayList<Object>(); 
		ResultSet rs = null;
		if(!StringUtils.isEmpty(params.getKeyWords())){
			sql.append(" and name = ?");
			paramsList.add(params.getKeyWords());
		}
		if(!StringUtils.isEmpty(params.getCategoryId())){
			sql.append(" and (categoryLevel1 = ? or categoryLevel2 = ? or categoryLevel3 = ?)");
			paramsList.add(params.getCategoryId());
			paramsList.add(params.getCategoryId());
			paramsList.add(params.getCategoryId());
		}
		rs = executeQuery(sql.toString(), paramsList.toArray());
		try {
			while(rs.next()){
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally{
			this.close(pstm, rs);
		}
		return count;
	}

}
