package cn.easybuy.dao.news;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import cn.easybuy.dao.BaseDaoImp;
import cn.easybuy.entity.News;

public class NewsDaoImp extends BaseDaoImp implements NewsDao{

	public NewsDaoImp(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	
	public News tableToClass(ResultSet rs) throws Exception{
		News news = new News();
		news.setId(rs.getInt("id"));
		news.setTitle(rs.getString("title"));
		news.setContent(rs.getString("content"));
		news.setCreatetime(rs.getDate("createtime"));
		return news;		
	}
	
	/**
	 * 获取News列表集合
	 * 
	 */
	@Override
	public List<News> getNewsList() throws Exception{
		List<News> list = new ArrayList<News>();
		StringBuffer sql = new StringBuffer("select id,title,content,createtime from easybuy_news ");
		sql.append("limit 0,7 ");
		ResultSet rs  = executeQuery(sql.toString(), null);
		while(rs.next()){
			News news = tableToClass(rs);
			list.add(news);
		}			
		return list;
	}

}
