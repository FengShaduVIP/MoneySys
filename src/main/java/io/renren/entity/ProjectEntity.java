package io.renren.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author FengShadu
 * @email twpvip@gmail.com
 * @date 2017-05-05 22:13:02
 */
public class ProjectEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//项目编号
	private String proNo;
	//项目名称
	private String proName;
	//每月收入
	private String inCash;
	//需要投资数
	private String input;

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
	 * 设置：每月收入
	 */
	public void setInCash(String inCash) {
		this.inCash = inCash;
	}
	/**
	 * 获取：每月收入
	 */
	public String getInCash() {
		return inCash;
	}
	/**
	 * 设置：需要投资数
	 */
	public void setInput(String input) {
		this.input = input;
	}
	/**
	 * 获取：需要投资数
	 */
	public String getInput() {
		return input;
	}
}
