package cn.easybuy.web.pre;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.easybuy.entity.News;
import cn.easybuy.entity.ProductCategory;
import cn.easybuy.service.news.NewsService;
import cn.easybuy.service.product.ProductCategoryService;
import cn.easybuy.utils.ProductCategoryVo;
import cn.easybuy.web.AbstractServlet;

/**
 * Servlet implementation class HomeSerlet
 */
@WebServlet(urlPatterns={"/home"},name="home" ) 
public class HomeSerlet extends AbstractServlet {
	private ProductCategoryService pcService;
	private NewsService ns;  

	@Override
	public void init() throws ServletException {
		pcService = new ProductCategoryService();
		ns = new NewsService();
	}

	public String index(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<ProductCategoryVo> pcList = pcService.getProductCategoryList();
		List<News> list = ns.getNewsList();
		request.setAttribute("pcList", pcList);
		request.setAttribute("newsList", list);
		String url = "/pre/index";  
		return url;		
	}
	
	@Override
	public Class getServletClass() {
		Class cla = this.getClass();
		return cla;
	}

}
