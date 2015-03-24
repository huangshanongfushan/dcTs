package com.duplicall.dao.util;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * dclog 数据库的连接池
 * 
 * @Description
 * @author mli
 * @date 2015年3月13日 下午4:40:15
 * @version V1.3.1
 */
public class DClogPool implements Pool {
	public static String url = "jdbc:mysql://localhost:3307/dclog";
	public static String user = "root";
	public static String password = "dc2014";
	// list集合保存数据库连接池中的connection对象
	private static List<Connection> pool = new LinkedList<Connection>();
	// 静态代码块，用于初始化list集合，即初始化数据库连接池，创建5个connection对象保存其中以备使用
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/*
			 * if(true){ }
			 */
			for (int i = 0; i < 2; i++) {
				Connection conn = DriverManager.getConnection(url, user,
						password);
				pool.add(conn);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	// 重写父类的getConnection()方法，返回数据库连接池中的一个connection对象，
	// 如果数据库连接池中connection对象都已被使用，即都被取走未返还,则创建3个connection对象保存其中供以后使用
	@Override
	public Connection getConnection() throws SQLException {
		if (pool == null || pool.size() < 1) {
			Connection conn = DriverManager.getConnection(url, user, password);
			pool.add(conn);
		}
		return pool.remove(0);
	}

	// 创建新方法，用于返回数据库连接对象connection，因为dao层用完数据库的连接后，不应该将其销毁，而是应该将其返还给数据库连接池
	public void returnConn(Connection conn) {
		pool.add(conn);
	}

	@Override
	public Connection getConnection(String username, String password)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void colseRsPs(ResultSet rs, PreparedStatement ps) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				rs = null;
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				ps = null;
			}
		}
	}

	@Override
	public void colsePs(PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				ps = null;
			}
		}

	}

}
