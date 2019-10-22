package cn.kgc.tangcco.tcbd1015.wangxinyu.service;

import cn.kgc.tangcco.tcbd1015.wangxinyu.entity.UserInfo;

public interface UserInfoService {
	// 登录
	int userLogin(String userName, String passWord);

	// 查询个人信息
	UserInfo getInfo(int id);

	// 修改个人信息
	int updateUserInfo(UserInfo user);

	// 用户注册
	int RegisterUser(UserInfo user);
}
