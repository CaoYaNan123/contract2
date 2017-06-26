package com.cont.model;

import java.util.Date;

/**
 * 维修单详情实体类
 * 
 * 
 * 	明细表中的字段有：
 
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bill_id` bigint(20) DEFAULT NULL,
  `device_id` bigint(20) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `c_desc` varchar(200) DEFAULT NULL,
  
  //以下两个字段有待讨论
  `create_time` datetime DEFAULT NULL,
  `create_u_id` bigint(20) DEFAULT NULL,
  
  	维修单表中的字段
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bill_no` bigint(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `cus_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_u_id` bigint(20) DEFAULT NULL,
  
  
  
 * @author Cao YaNan
 * @time 2017年6月24日下午3:27:28
 *
 */
public class BillDetailModel {

	//主键id
	private long id;
	//维修表外键id，对应维修单表中的id字段
	private long bill_id;
	//设备编号
	private long device_id;
	//第几次维修
	private int num;
	//损坏描述
	private String c_desc;
	
	
	//维修单单号
	private long bill_no;
	//维修单状态
	private int status;
	//用户id
	private int cus_id;
	//创建时间
	private Date create_time;
	//更新时间
	private Date update_time;
	//更新人
	private long update_u_id;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getBill_id() {
		return bill_id;
	}
	public void setBill_id(long bill_id) {
		this.bill_id = bill_id;
	}
	public long getDevice_id() {
		return device_id;
	}
	public void setDevice_id(long device_id) {
		this.device_id = device_id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getC_desc() {
		return c_desc;
	}
	public void setC_desc(String c_desc) {
		this.c_desc = c_desc;
	}
	public long getBill_no() {
		return bill_no;
	}
	public void setBill_no(long bill_no) {
		this.bill_no = bill_no;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getCus_id() {
		return cus_id;
	}
	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public long getUpdate_u_id() {
		return update_u_id;
	}
	public void setUpdate_u_id(long update_u_id) {
		this.update_u_id = update_u_id;
	}
	
	
	
	
	
}
