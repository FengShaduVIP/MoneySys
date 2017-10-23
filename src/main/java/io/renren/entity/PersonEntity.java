package io.renren.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author FengShadu
 * @email twpvip@gmail.com
 * @date 2017-05-09 17:49:03
 */
public class PersonEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String userName;
	//姓名
	private String personName;
	//
	private String userPass;
	//称呼
	private String chenghu;
	//出生日期
	private Date bronDate;
	//家庭等级
	private Integer level;
	//家庭代码
	private String familyCode;
	//是否是子节点
	private Integer isleaf;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：姓名
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	/**
	 * 获取：姓名
	 */
	public String getPersonName() {
		return personName;
	}
	/**
	 * 设置：
	 */
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	/**
	 * 获取：
	 */
	public String getUserPass() {
		return userPass;
	}
	/**
	 * 设置：称呼
	 */
	public void setChenghu(String chenghu) {
		this.chenghu = chenghu;
	}
	/**
	 * 获取：称呼
	 */
	public String getChenghu() {
		return chenghu;
	}
	/**
	 * 设置：出生日期
	 */
	public void setBronDate(Date bronDate) {
		this.bronDate = bronDate;
	}
	/**
	 * 获取：出生日期
	 */
	public Date getBronDate() {
		return bronDate;
	}
	/**
	 * 设置：家庭等级
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * 获取：家庭等级
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * 设置：家庭代码
	 */
	public void setFamilyCode(String familyCode) {
		this.familyCode = familyCode;
	}
	/**
	 * 获取：家庭代码
	 */
	public String getFamilyCode() {
		return familyCode;
	}
	/**
	 * 设置：是否是子节点
	 */
	public void setIsleaf(Integer isleaf) {
		this.isleaf = isleaf;
	}
	/**
	 * 获取：是否是子节点
	 */
	public Integer getIsleaf() {
		return isleaf;
	}
}
