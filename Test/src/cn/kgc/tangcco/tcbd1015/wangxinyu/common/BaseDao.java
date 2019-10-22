package cn.kgc.tangcco.tcbd1015.wangxinyu.common;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class BaseDao {
	private static DataSource ds = null;

	static {
		try {
			ds = new ComboPooledDataSource();
			System.out.println("数据库连接成功!");
		} catch (Exception e) {
			System.out.println("连接异常");
			e.printStackTrace();
		}
	}

	public static DataSource getDataSource() {
		return ds;
	}
}
