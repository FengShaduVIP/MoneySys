package io.renren.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author FengShadu
 * @email twpvip@gmail.com
 * @date 2017-04-25 22:17:04
 */
public class ChooseSysEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//项目编号
	private String proNo;
	//项目名称
	private String proName;
	//投资日期
	private Date chooseDate;
	//投资资出
	private String putMoney;
	//投资收入
	private String inMoney;
	//投资人
	private String userName;

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
	 * 设置：项目编号
	 */
	public void setProNo(String proNo) {
		this.proNo = proNo;
	}
	/**
	 * 获取：项目编号
	 */
	public String getProNo() {
		return proNo;
	}
	/**
	 * 设置：项目名称
	 */
	public void setProName(String proName) {
		this.proName = proName;
	}
	/**
	 * 获取：项目名称
	 */
	public String getProName() {
		return proName;
	}
	/**
	 * 设置：投资日期
	 */
	public void setChooseDate(Date chooseDate) {
		this.chooseDate = chooseDate;
	}
	/**
	 * 获取：投资日期
	 */
	public Date getChooseDate() {
		return chooseDate;
	}
	/**
	 * 设置：投资资出
	 */
	public void setPutMoney(String putMoney) {
		this.putMoney = putMoney;
	}
	/**
	 * 获取：投资资出
	 */
	public String getPutMoney() {
		return putMoney;
	}
	/**
	 * 设置：投资收入
	 */
	public void setInMoney(String inMoney) {
		this.inMoney = inMoney;
	}
	/**
	 * 获取：投资收入
	 */
	public String getInMoney() {
		return inMoney;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
