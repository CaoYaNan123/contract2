package com.cont.junit;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cont.dao.BillDAO;

/**
 * 合同dao持久层测试类
 * 
 * @author Cao YaNan
 * @time 2017年6月25日下午9:05:07
 *
 */
public class BillDaoTest {

	static BillDAO billDao = null;

	static {
		// 得到springIOC容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		billDao = ac.getBean(BillDAO.class);
	}

	/**
	 * 审核通过方法测试
	 */
	@Test
	public void testPass() throws Exception {
		Integer pass = billDao.pass(1L);
		System.out.println(pass);
	}
	
	/**
	 * 审核拒绝方法测试
	 */
	@Test
	public void testRefuse() throws Exception {
		Integer pass = billDao.refuse(1L);
		System.out.println(pass);
	}
	
	/**
	 * 批量审核通过方法测试
	 */
	@Test
	public void testBatchPass() throws Exception {
		List<Long> list = new ArrayList<Long>();
		list.add(1L);
		list.add(3L);
		list.add(6L);
		Integer pass = billDao.batchPass(list);
		System.out.println(pass);
	}
	/**
	 * 批量删除方法测试
	 */
	@Test
	public void testBatchDelete() throws Exception {
		List<Long> list = new ArrayList<Long>();
		list.add(51L);
		list.add(53L);
		list.add(56L);
		Integer pass = billDao.batchPass(list);
		System.out.println(pass);
	}
}
