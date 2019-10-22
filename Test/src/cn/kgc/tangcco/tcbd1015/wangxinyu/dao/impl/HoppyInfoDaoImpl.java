package cn.kgc.tangcco.tcbd1015.wangxinyu.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.kgc.tangcco.tcbd1015.wangxinyu.common.BaseDao;
import cn.kgc.tangcco.tcbd1015.wangxinyu.dao.HoppyInfoDao;
import cn.kgc.tangcco.tcbd1015.wangxinyu.entity.HoppyInfo;

public class HoppyInfoDaoImpl implements HoppyInfoDao {
	QueryRunner qr = new QueryRunner(BaseDao.getDataSource());

	@Override
	public HoppyInfo getHoppyInfo(int id) {
		try {
			return qr.query(
					"select favoriteBrand,favoriteStar,favoriteMovie,favoritePersonage from hoppyinfo where id=?",
					new BeanHandler<>(HoppyInfo.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int updateHoppyInfo(HoppyInfo hoppy) {
		try {
			return qr.update(
					"update hoppyinfo set favoriteBrand=?,favoriteStar=?,favoriteMovie=?,favoritePersonage=? where id=?",
					hoppy.getFavoriteBrand(), hoppy.getFavoriteStar(), hoppy.getFavoriteMovie(),
					hoppy.getFavoritePersonage(), hoppy.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
