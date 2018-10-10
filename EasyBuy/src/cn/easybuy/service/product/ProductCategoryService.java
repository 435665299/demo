package cn.easybuy.service.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.easybuy.dao.product.ProductCategoryDaoImp;
import cn.easybuy.entity.ProductCategory;
import cn.easybuy.utils.DataSourceUtil;
import cn.easybuy.utils.ProductCategoryVo;

public class ProductCategoryService {
	private Connection connection;
	private ProductCategoryDaoImp pcdi;
	
	public List<ProductCategory> getProductCategoryList(String parentId){
		connection = DataSourceUtil.getConnection();
		pcdi = new ProductCategoryDaoImp(connection);
		List<ProductCategory> pcList = new ArrayList<ProductCategory>();
		if(parentId==null ||parentId.equals("")){
			parentId = "0";
		}
		pcList = pcdi.getProductCategoryList(parentId);	
		DataSourceUtil.close(connection);
		return pcList;		
	}
	
	public List<ProductCategoryVo> getProductCategoryList() {
		List<ProductCategoryVo> pc1VoList = new ArrayList<ProductCategoryVo>();
		//查询一级商品分类
		List<ProductCategory> pc1List = new ArrayList<ProductCategory>();
		pc1List = getProductCategoryList(null);
		for (ProductCategory productCategory1 : pc1List) {
			ProductCategoryVo pc1Vo = new ProductCategoryVo();
			pc1Vo.setProductCategory(productCategory1);
			//查询二级商品分类
			List<ProductCategoryVo> Pc2VoList = new ArrayList<ProductCategoryVo>();
			List<ProductCategory> Pc2List = new ArrayList<ProductCategory>();
			Pc2List = getProductCategoryList(productCategory1.getId().toString());
			for (ProductCategory productCategory2 : Pc2List) {
				ProductCategoryVo pc2Vo = new ProductCategoryVo();
				pc2Vo.setProductCategory(productCategory2);
				Pc2VoList.add(pc2Vo);
			}
			pc1Vo.setProductCategoryVoList(Pc2VoList);
			pc1VoList.add(pc1Vo);
		}
				
		return pc1VoList;
	}
	
}
