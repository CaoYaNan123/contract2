package com.cont.model;

import java.util.Date;

/**
 * 维修单详情实体类
 * @author Cao YaNan
 * @time 2017年6月24日下午3:27:28
 * @instruction
 * 
   		//基本信息的封装，报修单号：合同单号 用户姓名 用户微信号 联系方式 
		//日志信息的封装，状态，操作人，维修师，操作事件，操作时间
		//设备信息的封装，设备编号，设备名称，设备保修期，损坏描述，报修图片的展示
 *
 */
public class BillDetailModel {
	
	/**
	 * 基本信息属性
	 */
	//报修单号(t_bill表bill_no字段)
	private String billNo;
	
	//合同单号(t_contract表concat_no字段)
	private String contractNum;
	
	//用户姓名(t_user表u_cname字段)
	private String cusName;
	
	//客户微信(t_user表u_weixin字段)
	private String uWeixin;
	
	// 联系方式(t_user表u_phone字段)
	private String uPhone;
	
	//状态(t_bill表status字段)
	private int status;
	
	//状态含义(t_bill表status_mean映射)
	private String statusMean;
	
	/**
	 * 日志信息属性
	 */
	//操作人，(t_service_log表update_u_id字段)
	private long updateUId;
	//(update_user_name字段映射)
	private String updateUserName;
	
	//维修师(t_service_log表deal_u_id字段)
	private long dealUId;
	//(deal_user_name映射)
	private String dealUserName;
	
	//操作事件(t_service_log表opreate_event字段)
	private String opreateEvent;
	

	/**
	 * 设备信息的属性
	 */
	//设备主键(t_device表id字段)
	private long deviceId;
	
	//设备名称(t_device表device_name字段)
	private String deviceName;
	
	//设备出场日期(t_device表start_time字段)
	private Date startTime;
	
	//设备保修截止日期(t_device表end_time字段)
	private Date endTime;
	
	//损坏描述(t_bill_detail表c_desc字段)
	private String deviceDesc;
	
	//照片路径(t_img表img_url字段)
	private String imgUrl;
	
	/**
	 * 报修单主键
	 */
	private long id;
	

	//操作时间(t_service_log表update_time字段)
	private Date updateTime;
	private String updateTimeFormat;
	
	private String startTimeFormat;
	private String endTimeFormat;
	
	public String getStartTimeFormat() {
		return startTimeFormat;
	}

	public void setStartTimeFormat(String startTimeFormat) {
		this.startTimeFormat = startTimeFormat;
	}

	public String getEndTimeFormat() {
		return endTimeFormat;
	}

	public void setEndTimeFormat(String endTimeFormat) {
		this.endTimeFormat = endTimeFormat;
	}

	public String getUpdateTimeFormat() {
		return updateTimeFormat;
	}

	public void setUpdateTimeFormat(String updateTimeFormat) {
		this.updateTimeFormat = updateTimeFormat;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getContractNum() {
		return contractNum;
	}

	public void setContractNum(String contractNum) {
		this.contractNum = contractNum;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getuWeixin() {
		return uWeixin;
	}

	public void setuWeixin(String uWeixin) {
		this.uWeixin = uWeixin;
	}

	public String getuPhone() {
		return uPhone;
	}

	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getStatusMean() {
		return statusMean;
	}

	public void setStatusMean(String statusMean) {
		this.statusMean = statusMean;
	}

	public long getUpdateUId() {
		return updateUId;
	}

	public void setUpdateUId(long updateUId) {
		this.updateUId = updateUId;
	}

	public String getUpdateUserName() {
		return updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

	public long getDealUId() {
		return dealUId;
	}

	public void setDealUId(long dealUId) {
		this.dealUId = dealUId;
	}

	public String getDealUserName() {
		return dealUserName;
	}

	public void setDealUserName(String dealUserName) {
		this.dealUserName = dealUserName;
	}

	public String getOpreateEvent() {
		return opreateEvent;
	}

	public void setOpreateEvent(String opreateEvent) {
		this.opreateEvent = opreateEvent;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(long deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getDeviceDesc() {
		return deviceDesc;
	}

	public void setDeviceDesc(String deviceDesc) {
		this.deviceDesc = deviceDesc;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Override
	public String toString() {
		return "BillDetailModel [billNo=" + billNo + ", contractNum=" + contractNum + ", cusName=" + cusName
				+ ", uWeixin=" + uWeixin + ", uPhone=" + uPhone + ", status=" + status + ", statusMean=" + statusMean
				+ ", updateUId=" + updateUId + ", updateUserName=" + updateUserName + ", dealUId=" + dealUId
				+ ", dealUserName=" + dealUserName + ", opreateEvent=" + opreateEvent + ", updateTime=" + updateTime
				+ ", deviceId=" + deviceId + ", deviceName=" + deviceName + ", startTime=" + startTime + ", endTime="
				+ endTime + ", deviceDesc=" + deviceDesc + ", imgUrl=" + imgUrl + ", id=" + id + "]";
	}
	
	
	
	
}