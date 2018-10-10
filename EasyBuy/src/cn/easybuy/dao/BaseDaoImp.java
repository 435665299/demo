package cn.easybuy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.util.StringUtils;

import com.mysql.jdbc.Statement;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.org.apache.regexp.internal.recompile;

public class BaseDaoImp {
	private Connection connection;
	private PreparedStatement pstm;
	private ResultSet rs;

	public BaseDaoImp(Connection connection) {
		this.connection = connection;
	}

	/**
	 * 查询数据库
	 * 
	 * @param sql 
	 * @param params
	 * @return rs
	 */
	public ResultSet executeQuery(String sql, Object[] params) {
		try {
			pstm = connection.prepareStatement(sql);
			if (!StringUtils.isEmpty(params)) {
				for (int i = 0; i < params.length; i++) {
					pstm.setObject(i + 1, params[i]);
				}
			}
			rs = pstm.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 新增数据库资源 return 主键值
	 */
	public int executeInsert(String sql, Object[] params) {
		Long id = 0L;
		try {
			pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			for (int i = 0; i < params.length; i++) {
				pstm.setObject(i + 1, params[i]);
			}
			pstm.executeUpdate();
			ResultSet rs = pstm.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getLong(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			id = null;
		}
		return id.intValue();
	}

	/**
	 * 修改数据库资源 return 影响的行数
	 */
	public int excuteUpdate(String sql, Object[] params) {
		int a = 0;
		try {
			pstm = connection.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pstm.setObject(i + 1, params[i]);
			}
			a = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	/**
	 * 关闭释放资源
	 * 
	 * @param pstm
	 * @param rs
	 */
	public void close(PreparedStatement pstm, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstm != null) {
				pstm.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
