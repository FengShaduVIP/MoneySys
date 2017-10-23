package io.renren.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author FengShadu
 * @email twpvip@gmail.com
 * @date 2017-04-25 22:04:33
 */
public class OutMoneyEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//借出日期
	private Date outDate;
	//收钱者姓名
	private String outName;
	//金额
	private String money;

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
	 * 设置：借出日期
	 */
	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
	/**
	 * 获取：借出日期
	 */
	public Date getOutDate() {
		return outDate;
	}
	/**
	 * 设置：收钱者姓名
	 */
	public void setOutName(String outName) {
		this.outName = outName;
	}
	/**
	 * 获取：收钱者姓名
	 */
	public String getOutName() {
		return outName;
	}
	/**
	 * 设置：金额
	 */
	public void setMoney(String money) {
		this.money = money;
	}
	/**
	 * 获取：金额
	 */
	public String getMoney() {
		return money;
	}
}
