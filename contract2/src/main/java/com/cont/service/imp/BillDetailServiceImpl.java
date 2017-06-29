package com.cont.service.imp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cont.dao.BillDetailDao;
import com.cont.model.BillDetailModel;
import com.cont.service.IBillDetailService;
import com.cont.utils.DateUtils;

/**
 * 详情页服务层实现类
 * @author Cao YaNan
 * @time 2017年6月29日下午3:01:37
 * @instruction 
 *
 */
@Service
public class BillDetailServiceImpl implements IBillDetailService{
	
	@Autowired
	private BillDetailDao billDetailDao;

	@Override
	public BillDetailModel getBasicMsg(Long billId) {
		return billDetailDao.getBasicMsg(billId);
	}

	@Override
	public List<BillDetailModel> getLogMsg(Long billId) {
		List<BillDetailModel> logMsg = billDetailDao.getLogMsg(billId);
		for (BillDetailModel log : logMsg) {
			log.setUpdateUserName(billDetailDao.getUserNameByUserId(log.getUpdateUId()));
			log.setDealUserName(billDetailDao.getUserNameByUserId(log.getDealUId()));
			
			log.setUpdateTimeFormat(DateUtils.formatDatetime(log.getUpdateTime(), "yyyy-MM-dd HH:mm:ss"));
		}
		return logMsg;
	}

	@Override
	public String getUserNameByUserId(Long id) {
		return billDetailDao.getUserNameByUserId(id);
	}

	@Override
	public List<BillDetailModel> getDeviceMsg(Long billId) {
		List<BillDetailModel> deviceMsg = billDetailDao.getDeviceMsg(billId);
		
		for (BillDetailModel device : deviceMsg) {
			device.setStartTimeFormat(DateUtils.formatDatetime(device.getStartTime(), "yyyy-MM-dd"));
			device.setEndTimeFormat(DateUtils.formatDatetime(device.getEndTime(), "yyyy-MM-dd"));
		}
		return deviceMsg;
	}

	@Override
	public Long getIdByBillNum(String billNo) {
		return billDetailDao.getIdByBillNum(billNo);
	}
	
	

}
