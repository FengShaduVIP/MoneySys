package io.renren.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author FengShadu
 * @email twpvip@gmail.com
 * @date 2017-05-09 19:39:32
 */
public class InMoneySysEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//项目编号
	private String proNo;
	//项目名称
	private String proName;
	//
	private String userId;
	//
	private String userName;
	//
	private String inMoney;
	//
	private Date dateTime;
	//支出还是收入
	private Integer status;

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
	 * 设置：
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public String getUserId() {
		return userId;
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
	 * 设置：
	 */
	public void setInMoney(String inMoney) {
		this.inMoney = inMoney;
	}
	/**
	 * 获取：
	 */
	public String getInMoney() {
		return inMoney;
	}
	/**
	 * 设置：
	 */
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	/**
	 * 获取：
	 */
	public Date getDateTime() {
		return dateTime;
	}
	/**
	 * 设置：支出还是收入
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：支出还是收入
	 */
	public Integer getStatus() {
		return status;
	}
}
