package com.cont.model;

import com.cont.utils.SuperModel;

/**
 * bill报修单实体类
 
 报修单表t_bill字段
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bill_no` bigint(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `cus_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_u_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
 * @author Cao YaNan
 *
 */
public class BillModel extends SuperModel{
	
	//主键
	private long  id;
	//报修单号
	private String bill_no;
	/**
	 报修单状态
		0：提交
		1：审批通过
		2：审批拒绝
		3：正在维修
		4：已完成
	*/
	private String status;
	//客户id,外键
	private long cus_id;
	//客户中文名
	private String cus_cname;
	//客户名
	private String cus_name;
	//客户微信
	private String u_weixin;

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getCus_id() {
		return cus_id;
	}
	public void setCus_id(long cus_id) {
		this.cus_id = cus_id;
	}
	public String getCus_cname() {
		return cus_cname;
	}
	public void setCus_cname(String cus_cname) {
		this.cus_cname = cus_cname;
	}
	public String getCus_name() {
		return cus_name;
	}
	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}
	public String getBill_no() {
		return bill_no;
	}
	public void setBill_no(String bill_no) {
		this.bill_no = bill_no;
	}
	public String getU_weixin() {
		return u_weixin;
	}
	public void setU_weixin(String u_weixin) {
		this.u_weixin = u_weixin;
	}
}
