package io.renren.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author FengShadu
 * @email twpvip@gmail.com
 * @date 2017-04-25 22:04:32
 */
public class InMoneyEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//借出日期
	private Date inDate;
	//收钱者姓名
	private String inName;
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
	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	/**
	 * 获取：借出日期
	 */
	public Date getInDate() {
		return inDate;
	}
	/**
	 * 设置：收钱者姓名
	 */
	public void setInName(String inName) {
		this.inName = inName;
	}
	/**
	 * 获取：收钱者姓名
	 */
	public String getInName() {
		return inName;
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
