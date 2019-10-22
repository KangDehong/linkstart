package cn.kgc.tangcco.tcbd1015.wangxinyu.service.impl;

import cn.kgc.tangcco.tcbd1015.wangxinyu.dao.UserInfoDao;
import cn.kgc.tangcco.tcbd1015.wangxinyu.dao.impl.UserInfoDaoImpl;
import cn.kgc.tangcco.tcbd1015.wangxinyu.entity.UserInfo;
import cn.kgc.tangcco.tcbd1015.wangxinyu.service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {
	UserInfoDao uid = new UserInfoDaoImpl();

	@Override
	public int userLogin(String userName, String passWord) {
		return uid.userLogin(userName, passWord);
	}

	@Override
	public UserInfo getInfo(int id) {
		return uid.getInfo(id);
	}

	@Override
	public int updateUserInfo(UserInfo user) {
		return uid.updateUserInfo(user);
	}

	@Override
	public int RegisterUser(UserInfo user) {
		return uid.RegisterUser(user);
	}

}
