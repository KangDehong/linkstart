package cn.kgc.tangcco.tcbd1015.wangxinyu.dao;

import cn.kgc.tangcco.tcbd1015.wangxinyu.entity.HoppyInfo;

public interface HoppyInfoDao {
	HoppyInfo getHoppyInfo(int id);

	int updateHoppyInfo(HoppyInfo hoppy);
}
