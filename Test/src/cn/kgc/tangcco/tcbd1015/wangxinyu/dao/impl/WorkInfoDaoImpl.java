package cn.kgc.tangcco.tcbd1015.wangxinyu.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.kgc.tangcco.tcbd1015.wangxinyu.common.BaseDao;
import cn.kgc.tangcco.tcbd1015.wangxinyu.dao.WorkInfoDao;
import cn.kgc.tangcco.tcbd1015.wangxinyu.entity.WorkInfo;

public class WorkInfoDaoImpl implements WorkInfoDao {
	QueryRunner qr = new QueryRunner(BaseDao.getDataSource());

	@Override
	public WorkInfo getWorkInfo(int id) {
		try {
			return qr.query(
					"select company,position,workSeniorityId,degreeId,schoolTag,schoolTagDate from workinfo where id = ?",
					new BeanHandler<>(WorkInfo.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int updateWorkInfo(WorkInfo work) {
		try {
			return qr.update(
					"UPDATE workinfo SET company=?,POSITION=?,workSeniorityId=?,degreeId=?,schoolTag=?,schoolTagDate=? WHERE id = ?",
					work.getCompany(), work.getPosition(), work.getWorkSeniorityId(), work.getDegreeid(),
					work.getSchoolTag(), work.getSchoolTagDate(), work.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

}
