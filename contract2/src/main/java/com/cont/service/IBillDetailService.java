package com.cont.service;

import java.util.List;

import com.cont.model.BillDetailModel;

/**
 * 详情页service层接口
 * @author Cao YaNan
 * @time 2017年6月29日下午3:00:17
 * @instruction 
 *
 */
public interface IBillDetailService {

	/**
	 * 通过报修单id得到基本信息
	 */
	public BillDetailModel getBasicMsg(Long billId);
	
	/**
	 * 通过报修单id得到日志信息(第一步)
	 */
	public List<BillDetailModel> getLogMsg(Long billId);
	
	/**
	 * 通过报修单id得到日志信息(第二步)
	 */
	public String getUserNameByUserId(Long id);
	
	/**
	 * 第三模块设备信息
	 */
	public List<BillDetailModel> getDeviceMsg(Long billId);
	
	/**
	 * 通过报修单号获取报修主键id
	 */
	public Long getIdByBillNum(String billNo);
}
