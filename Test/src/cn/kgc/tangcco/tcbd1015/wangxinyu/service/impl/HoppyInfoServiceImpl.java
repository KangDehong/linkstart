package cn.kgc.tangcco.tcbd1015.wangxinyu.service.impl;

import cn.kgc.tangcco.tcbd1015.wangxinyu.dao.HoppyInfoDao;
import cn.kgc.tangcco.tcbd1015.wangxinyu.dao.impl.HoppyInfoDaoImpl;
import cn.kgc.tangcco.tcbd1015.wangxinyu.entity.HoppyInfo;
import cn.kgc.tangcco.tcbd1015.wangxinyu.service.HoppyInfoService;

public class HoppyInfoServiceImpl implements HoppyInfoService {
	HoppyInfoDao hid = new HoppyInfoDaoImpl();

	@Override
	public HoppyInfo getHoppyInfo(int id) {
		return hid.getHoppyInfo(id);
	}

	@Override
	public int updateHoppyInfo(HoppyInfo hoppy) {
		return hid.updateHoppyInfo(hoppy);
	}
}
