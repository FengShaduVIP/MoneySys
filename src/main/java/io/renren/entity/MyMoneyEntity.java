package io.renren.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author FengShadu
 * @email twpvip@gmail.com
 * @date 2017-05-09 21:23:40
 */
public class MyMoneyEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String userName;
	//
	private String userId;
	//
	private Integer mymoney;
	
	private String bankmoney;

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
	public void setMymoney(Integer mymoney) {
		this.mymoney = mymoney;
	}
	/**
	 * 获取：
	 */
	public Integer getMymoney() {
		return mymoney;
	}
	public String getBankmoney() {
		return bankmoney;
	}
	public void setBankmoney(String bankmoney) {
		this.bankmoney = bankmoney;
	}
	
}
