package cn.easybuy.dao.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.sun.crypto.provider.RSACipher;
import com.sun.scenario.effect.PerspectiveTransform;

import cn.easybuy.dao.BaseDaoImp;
import cn.easybuy.entity.User;
import cn.easybuy.utils.DataSourceUtil;

public class UserDaoImp extends BaseDaoImp implements UserDao {


	public UserDaoImp(Connection connection) {
		super(connection);
	}
	
	public User tableToClass(ResultSet rs) throws Exception{
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setLoginName(rs.getString("loginName"));
		user.setUserName(rs.getString("userName"));
		user.setPassword(rs.getString("password"));
		user.setSex(rs.getInt("sex"));
		user.setIdentityCode(rs.getString("identityCode"));
		user.setEmail(rs.getString("email"));
		user.setMobile(rs.getString("mobile"));
		user.setType(rs.getInt("type"));
		return user;		
	}
	
	/**
	 * 根据用户名获取User对象
	 * @return
	 */
	public User getUser(String loginName) throws Exception {
		User user = null;
		StringBuffer sql = new StringBuffer("select * from easybuy_user where 1=1");
		if(!StringUtils.isEmpty(loginName)){
			sql.append(" and loginName=?");
			List<Object> params = new ArrayList<Object>();
			params.add(loginName);
			ResultSet rs = executeQuery(sql.toString(), params.toArray());
			while(rs.next()){
				user = tableToClass(rs);
			}
		}
		
		return user;
	}
	
	/**
	 * 注册用户
	 * 
	 */
	public int addUser(User user){
		Integer id = 0;
		StringBuffer sql = new StringBuffer("insert into easybuy_user(loginName,userName,password,sex,identityCode,email,mobile) values(?,?,?,?,?,?,?) ");
		Object[] params = {user.getLoginName(),user.getUserName(),user.getPassword(),user.getSex(),user.getIdentityCode(),user.getEmail(),user.getMobile()};
		id = executeInsert(sql.toString(), params);
		return id;		
	}
}
