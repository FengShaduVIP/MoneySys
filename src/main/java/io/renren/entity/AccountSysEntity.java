package io.renren.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author FengShadu
 * @email twpvip@gmail.com
 * @date 2017-04-25 21:49:38
 */
public class AccountSysEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//银行账号
	private Integer id;
	//
	private String bankNo;
	//银行名称
	private String bankName;
	//开户人
	private String openPerson;
	//
	private String openUserId;
	//存款
	private String moneyLeft;
	//开户日期
	private Date openDate;
	//是否定期
	private Integer status;

	/**
	 * 设置：银行账号
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：银行账号
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}
	/**
	 * 获取：
	 */
	public String getBankNo() {
		return bankNo;
	}
	/**
	 * 设置：银行名称
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	/**
	 * 获取：银行名称
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * 设置：开户人
	 */
	public void setOpenPerson(String openPerson) {
		this.openPerson = openPerson;
	}
	/**
	 * 获取：开户人
	 */
	public String getOpenPerson() {
		return openPerson;
	}
	/**
	 * 设置：
	 */
	public void setOpenUserId(String openUserId) {
		this.openUserId = openUserId;
	}
	/**
	 * 获取：
	 */
	public String getOpenUserId() {
		return openUserId;
	}
	/**
	 * 设置：存款
	 */
	public void setMoneyLeft(String moneyLeft) {
		this.moneyLeft = moneyLeft;
	}
	/**
	 * 获取：存款
	 */
	public String getMoneyLeft() {
		return moneyLeft;
	}
	/**
	 * 设置：开户日期
	 */
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	/**
	 * 获取：开户日期
	 */
	public Date getOpenDate() {
		return openDate;
	}
	/**
	 * 设置：是否定期
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：是否定期
	 */
	public Integer getStatus() {
		return status;
	}
}
