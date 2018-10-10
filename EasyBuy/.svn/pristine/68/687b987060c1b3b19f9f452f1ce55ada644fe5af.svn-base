package cn.easybuy.service.news;

import java.sql.Connection;
import java.util.List;

import cn.easybuy.dao.news.NewsDaoImp;
import cn.easybuy.entity.News;
import cn.easybuy.utils.DataSourceUtil;

public class NewsService {
	private Connection connection;
	
	public List<News> getNewsList(){
		List<News> list = null;
		connection = DataSourceUtil.getConnection();
		NewsDaoImp newsDaoImp = new NewsDaoImp(connection);
		try {
			list = newsDaoImp.getNewsList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DataSourceUtil.close(connection);
		}
		return list;		
	}
}
