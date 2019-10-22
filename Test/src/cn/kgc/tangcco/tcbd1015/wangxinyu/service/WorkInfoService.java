package cn.kgc.tangcco.tcbd1015.wangxinyu.service;

import cn.kgc.tangcco.tcbd1015.wangxinyu.entity.WorkInfo;

public interface WorkInfoService {
	WorkInfo getWorkInfo(int id);

	int updateWorkInfo(WorkInfo work);
}
