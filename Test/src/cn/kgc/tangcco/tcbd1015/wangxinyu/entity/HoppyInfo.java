package cn.kgc.tangcco.tcbd1015.wangxinyu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 爱好实体类
 * 
 * @author 76454
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HoppyInfo {
	private int id;
	private String favoriteBrand, favoriteStar, favoriteMovie, favoritePersonage;
}
