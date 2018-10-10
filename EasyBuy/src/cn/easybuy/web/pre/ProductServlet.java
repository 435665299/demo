package cn.easybuy.web.pre;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

import cn.easybuy.entity.Page;
import cn.easybuy.entity.Product;
import cn.easybuy.params.ProductParams;
import cn.easybuy.service.product.ProductCategoryService;
import cn.easybuy.service.product.ProductService;
import cn.easybuy.utils.ProductCategoryVo;
import cn.easybuy.web.AbstractServlet;

@WebServlet(urlPatterns={"/product"},name="product")
public class ProductServlet extends AbstractServlet{
	private ProductService productService;
	private ProductCategoryService productCategoryService;
	@Override
	public Class getServletClass() {
		return ProductServlet.class;
	}

	@Override
	public void init() throws ServletException {
		productService = new ProductService();
		productCategoryService = new ProductCategoryService();
	}


	protected String queryProductList(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String categoryId = req.getParameter("categoryId");
		String keyWords = req.getParameter("keyWords");
		//当前页数 第几页
		String currPageNo = req.getParameter("currPageNo");
		//页面的大小
		String pageSize = req.getParameter("pageSize");
		int rowPerPage = !StringUtils.isEmpty(pageSize)?Integer.parseInt(pageSize) : 12;
		int currentPage = !StringUtils.isEmpty(currPageNo)?Integer.parseInt(currPageNo) : 1;
		ProductParams params = new ProductParams();
		params.setCategoryId(!StringUtils.isEmpty(categoryId)?Integer.parseInt(categoryId) : null);
		params.setKeyWords(keyWords);
		params.openPage((currentPage-1)*rowPerPage, rowPerPage);
		int totalCount = productService.getProductCount(params);
		Page page = new Page(rowPerPage, currentPage, totalCount);
		page.setUrl("/product?action=queryProductList&categoryId="+(!StringUtils.isEmpty(categoryId)?categoryId : null)+"&keyWords="+
				(!StringUtils.isEmpty(keyWords)?keyWords : null));
		List<Product> pList = productService.getProductList(params);
		List<ProductCategoryVo> pvList = productCategoryService.getProductCategoryList();
		req.setAttribute("pList", pList);
		req.setAttribute("page", page);
		req.setAttribute("keyWords", keyWords);
		req.setAttribute("totalCount", totalCount);		
		return "/pre/product-list";		
	}
	
}
