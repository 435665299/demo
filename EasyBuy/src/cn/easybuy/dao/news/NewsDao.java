package cn.easybuy.dao.news;

import java.util.List;

import cn.easybuy.entity.News;

public interface NewsDao {
	
	public List<News> getNewsList() throws Exception;
}
