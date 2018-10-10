package cn.easybuy.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

import com.mysql.jdbc.Driver;

/**
 * 数据库连接工具类
 * @author ztl
 *
 */
public class DataSourceUtil {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	static{
		init();
	}
	
	public static void init(){
		Properties param = new Properties();
		String config = "database.properties";
		InputStream iStream = DataSourceUtil.class.getClassLoader().getResourceAsStream(config);
		try {
			param.load(iStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver = param.getProperty("driver");
		url = param.getProperty("url");
		user = param.getProperty("user");
		password = param.getProperty("password");
	}
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConnection(){
		Connection connection = null;
		try {
			//加载驱动
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		return connection;		
	}
	
	/**
	 * 关闭数据库连接
	 */
	public static void close(Connection connection) {
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
