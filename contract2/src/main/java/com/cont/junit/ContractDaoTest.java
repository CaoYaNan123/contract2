package com.cont.junit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cont.dao.ContractDao;
import com.cont.model.ContractModel;

/**
 * 合同dao持久层测试类
 * 
 * @author Cao YaNan
 * @time 2017年6月25日下午9:05:07
 *
 */
public class ContractDaoTest {
	
	static ContractDao contractDao = null;

	static {
		// 得到springIOC容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		contractDao = ac.getBean(ContractDao.class);
	}

	/**
	 * getAllCounts方法测试
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetAllCountsMethod() throws Exception {

		int allCounts = contractDao.getAllCounts();
		System.out.println(allCounts);
	}

	/**
	 * selectByPage方法测试
	 */
	@Test
	public void testSelectByPage() throws Exception {

		ContractModel contract = new ContractModel();
		List<ContractModel> list = contractDao.selectByPage(contract);
		for (ContractModel con : list) {
			System.out.println(con);
		}
	}
	
	/**
	 * save方法测试
	 */
	@Test
	public void testSave() throws Exception {

		ContractModel contract = new ContractModel();
		contract.setConcatNo("2017062600001");
		contract.setConcatPerson("曹亚男");
		contract.setConcatPhone("13838389438");
		contract.setCreateTime(new Date());
		contract.setCreateUId(2L);
		int i = contractDao.save(contract);
		
		System.out.println("影响行数:"+i);
	}
	
	/**
	 * getContractById方法测试
	 */
	@Test
	public void testGetContractById () throws Exception {
		ContractModel contract = contractDao.getContractById(1);
		System.out.println(contract);
	}
	
	/**
	 * update方法测试
	 */
	@Test
	public void testUpdate() throws Exception {
		ContractModel contract = new ContractModel();
		contract.setId(5L);
		contract.setConcatNo("2017062600002");
		contract.setConcatPerson("曹亚男");
		contract.setConcatPhone("13838389438");
		contract.setCreateTime(new Date());
		contract.setCreateUId(2L);
		
		contractDao.update(contract);
	}
	
	/**
	 * deleteById测试
	 */
	@Test
	public void testDeleteById() throws Exception {
		int i = contractDao.deleteById(8);
		System.out.println(i);
		
	}
	
	/**
	 * deleteByIds测试
	 */
	@Test
	public void testDeleteByIdS() throws Exception {
		List<Long> list = new ArrayList<Long>();
		list.add(8L);
		list.add(9L);
		list.add(10L);
		int i = contractDao.deleteByIds(list);
		System.out.println(i);
		
	}
}
