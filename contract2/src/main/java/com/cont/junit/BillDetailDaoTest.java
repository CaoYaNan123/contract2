package com.cont.junit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cont.dao.BillDetailDao;
import com.cont.model.BillDetailModel;

/**
 * 合同dao持久层测试类
 * 
 * @author Cao YaNan
 * @time 2017年6月25日下午9:05:07
 *
 */
public class BillDetailDaoTest {

	static BillDetailDao billDetailDao = null;

	static {
		// 得到springIOC容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		billDetailDao = ac.getBean(BillDetailDao.class);
	}

	/**
	 * 得到基本信息
	 * @throws Exception
	 */
	@Test
	public void testGetBasicMsg() throws Exception {
		BillDetailModel bill = billDetailDao.getBasicMsg(1L);
		System.out.println(bill);
	}

	/**
	 * 得到日志信息
	 * @throws Exception
	 */
	@Test
	public void testGetLogMsg() throws Exception {

		List<BillDetailModel> bill = billDetailDao.getLogMsg(1L);
		for (BillDetailModel b : bill) {
			b.setUpdateUserName(billDetailDao.getUserNameByUserId(b.getUpdateUId()));
			b.setDealUserName((billDetailDao.getUserNameByUserId(b.getDealUId())));

		}
		System.out.println(bill);
	}
	
	/**
	 * 得到设备信息
	 * @throws Exception
	 */
	@Test
	public void testGetDeviceMsg() throws Exception {

		List<BillDetailModel> bill = billDetailDao.getDeviceMsg(1L);

		System.out.println(bill);
	}
}
