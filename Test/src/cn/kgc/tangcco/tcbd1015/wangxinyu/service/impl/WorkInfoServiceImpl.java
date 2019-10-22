package cn.kgc.tangcco.tcbd1015.wangxinyu.service.impl;

import cn.kgc.tangcco.tcbd1015.wangxinyu.dao.WorkInfoDao;
import cn.kgc.tangcco.tcbd1015.wangxinyu.dao.impl.WorkInfoDaoImpl;
import cn.kgc.tangcco.tcbd1015.wangxinyu.entity.WorkInfo;
import cn.kgc.tangcco.tcbd1015.wangxinyu.service.WorkInfoService;

public class WorkInfoServiceImpl implements WorkInfoService {
	WorkInfoDao wid = new WorkInfoDaoImpl();

	@Override
	public WorkInfo getWorkInfo(int id) {
		return wid.getWorkInfo(id);
	}

	@Override
	public int updateWorkInfo(WorkInfo work) {
		return 0;
	}

}
