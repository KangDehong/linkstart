package cn.kgc.tangcco.tcbd1015.wangxinyu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 工作实体类
 * 
 * @author 76454
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkInfo {
	private int id;
	private String company;
	private String position;
	private int workSeniorityId;
	private int degreeid;
	private String schoolTag;
	private String schoolTagDate;
	
}
