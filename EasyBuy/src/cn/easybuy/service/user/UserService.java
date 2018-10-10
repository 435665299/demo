package cn.easybuy.service.user;

import java.sql.Connection;

import org.springframework.util.StringUtils;

import cn.easybuy.dao.user.UserDao;
import cn.easybuy.dao.user.UserDaoImp;
import cn.easybuy.entity.User;
import cn.easybuy.utils.DataSourceUtil;

public class UserService {
	private static Connection connection;
	private static UserDao userDaoImp;
	
	/**
	 * 获取User对象
	 * @param loginName
	 * @return
	 */
	public static User getUser(String loginName){
		User user = null;
		connection = DataSourceUtil.getConnection();
		if(!StringUtils.isEmpty(loginName)){
			userDaoImp = new UserDaoImp(connection);
			try {
				user = userDaoImp.getUser(loginName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DataSourceUtil.close(connection);
			}
		}		
		return user;		
	}
	/**
	 * 注册User对象
	 * 
	 */
	public boolean addUser(User user){
		boolean flag = false;
		connection = DataSourceUtil.getConnection();
		userDaoImp = new UserDaoImp(connection);
		try {
			int count = userDaoImp.addUser(user);
			flag = count>0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
		} finally{
			DataSourceUtil.close(connection);
		}
		return flag;		
	}
	
}
