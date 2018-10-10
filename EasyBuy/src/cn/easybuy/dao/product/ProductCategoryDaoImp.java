package cn.easybuy.dao.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.regexp.internal.recompile;

import cn.easybuy.dao.BaseDaoImp;
import cn.easybuy.entity.ProductCategory;
import cn.easybuy.utils.DataSourceUtil;
import cn.easybuy.utils.ProductCategoryVo;

public class ProductCategoryDaoImp extends BaseDaoImp implements ProductCategoryDao {
	private Connection connection;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	public ProductCategoryDaoImp(Connection connection){
		super(connection);
	}
	
	public ProductCategory tableToClass(){
		ProductCategory pr = new ProductCategory();
		try {
			pr.setId(rs.getInt("id"));
			pr.setName(rs.getString("name"));
			pr.setParentId(rs.getInt("parentId"));
			pr.setType(rs.getInt("type"));
			pr.setIconClass(rs.getString("iconClass"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return pr;		
	}
	
	@Override
	public List<ProductCategory> getProductCategoryList(String parentId) {
		List<ProductCategory> list = new ArrayList<ProductCategory>();
		List<Object> params = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer(
				"select id,name,parentId,type,iconClass from easybuy_product_category where 1=1");
		if (parentId != null && !"".equals(parentId)) {
			sql.append(" and parentId = ?");
			params.add(parentId);
		}
		try {
			rs = this.executeQuery(sql.toString(),params.toArray());
			while (rs.next()) {
				ProductCategory pr = this.tableToClass();
				list.add(pr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.close(pstm, rs);
		}
		return list;
	}

}
