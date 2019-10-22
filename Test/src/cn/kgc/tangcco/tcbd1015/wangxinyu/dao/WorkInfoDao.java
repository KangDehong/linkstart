package cn.kgc.tangcco.tcbd1015.wangxinyu.dao;

import cn.kgc.tangcco.tcbd1015.wangxinyu.entity.WorkInfo;

public interface WorkInfoDao {
	WorkInfo getWorkInfo(int id);

	int updateWorkInfo(WorkInfo work);
}
