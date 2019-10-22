package cn.kgc.tangcco.tcbd1015.wangxinyu.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户实体类
 * 
 * @author 76454
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
	private String userName, email, realName, phoneNum, tel;
	private int sex;
	private String birthday;
	private String address;
	private int typeId, marriage, family;
	private String incomDescid;
	private int hasCar, id;
	private String password;

	@Override
	public String toString() {
		return "UserInfo [userName=" + userName + ", email=" + email + ", realName=" + realName + ", phoneNum="
				+ phoneNum + ", tel=" + tel + ", sex=" + sex + ", birthday=" + birthday + ", address=" + address
				+ ", typeId=" + typeId + ", marriage=" + marriage + ", family=" + family + ", incomDescid="
				+ incomDescid + ", hasCar=" + hasCar + ", id=" + id + ", password=" + password + "]";
	}

	public UserInfo(String email, String realName, String phoneNum, String tel, int sex, String birthday, String address,
			int typeId, int marriage, int family, String incomDescid, int hasCar, int id, String password) {
		super();
		this.email = email;
		this.realName = realName;
		this.phoneNum = phoneNum;
		this.tel = tel;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
		this.typeId = typeId;
		this.marriage = marriage;
		this.family = family;
		this.incomDescid = incomDescid;
		this.hasCar = hasCar;
		this.id = id;
		this.password = password;
	}
}