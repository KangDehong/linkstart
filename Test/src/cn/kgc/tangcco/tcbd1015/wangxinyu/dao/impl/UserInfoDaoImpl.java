package cn.kgc.tangcco.tcbd1015.wangxinyu.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.kgc.tangcco.tcbd1015.wangxinyu.common.BaseDao;
import cn.kgc.tangcco.tcbd1015.wangxinyu.dao.UserInfoDao;
import cn.kgc.tangcco.tcbd1015.wangxinyu.entity.UserInfo;

/**
 * 实现类
 * 
 * @author 76454
 *
 */
public class UserInfoDaoImpl implements UserInfoDao {
	QueryRunner qr = new QueryRunner(BaseDao.getDataSource());

	@Override
	public int userLogin(String userName, String passWord) {
		try {
			return (int) (long) qr.query("", new ScalarHandler<>(), userName, passWord);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public UserInfo getInfo(int id) {
		try {
			return qr.query("select * from userinfo where id=?", new BeanHandler<>(UserInfo.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int updateUserInfo(UserInfo user) {
		try {
			return qr.update(
					"UPDATE userinfo SET email=?,realName=?,phoneNum=?,tel=?,sex=?,birthday=?,address=?,typeId=?,marriage=?,family=?,incomeDescId=?,hasCar=? WHERE id=?",
					user.getEmail(), user.getRealName(), user.getPhoneNum(), user.getTel(), user.getSex(),
					user.getBirthday(), user.getAddress(), user.getTypeId(), user.getMarriage(), user.getFamily(),
					user.getIncomDescid(), user.getHasCar(), user.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int RegisterUser(UserInfo user) {
		try {
			return qr.update("Insert into", user, user);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

}
