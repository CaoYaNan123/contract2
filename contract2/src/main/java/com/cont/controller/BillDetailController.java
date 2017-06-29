package com.cont.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cont.model.BillDetailModel;
import com.cont.service.IBillDetailService;

/**
 * 报修单详情页控制层
 * @author Cao YaNan
 * @time 2017年6月29日下午3:06:25
 * @instruction 
 *
 */
@Controller
@RequestMapping("/detail")
public class BillDetailController {

	@Autowired
	private IBillDetailService billDetailService;
	
	@RequestMapping("/confirm")
	public ModelAndView confirm(String idStr, String billNo) {
		long billId;
		ModelAndView mav = new ModelAndView();
		if (billNo != null && !"".equals(billNo)) {
			billId = billDetailService.getIdByBillNum(billNo);
		} else {
			billId = Long.parseLong(idStr);
		}
		
		//获取基本信息
		BillDetailModel basicMsg = billDetailService.getBasicMsg(billId);
		basicMsg.setId(billId);
		mav.addObject("basicMsg", basicMsg);
		
		//获取日志信息
		List<BillDetailModel> logMsg = billDetailService.getLogMsg(billId);
		mav.addObject("logMsg", logMsg);
		
		//获取设备信息
		List<BillDetailModel> deviceMsg = billDetailService.getDeviceMsg(billId);
		mav.addObject("deviceMsg",deviceMsg);
		
		
		mav.setViewName("/contract/detail");
		return mav;
	}
}
