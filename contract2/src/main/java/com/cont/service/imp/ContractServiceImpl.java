package com.cont.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cont.dao.ContractDao;
import com.cont.model.ContractModel;
import com.cont.service.ContractService;
import com.cont.utils.Page;

/**
 * 合同service实现类
 * @author Cao YaNan
 * @time 2017年6月25日下午8:28:31
 *
 */
@Service
public class ContractServiceImpl implements ContractService{

	@Autowired
    private ContractDao contractDao;
	
	@Override
	public Page<ContractModel> selectContract(ContractModel contract) {
		Page<ContractModel> page = new Page<ContractModel>();
		//查询总记录数
		int allCounts = contractDao.getAllCounts();
		List<ContractModel> list = new ArrayList<ContractModel>();
		 
		if(allCounts>0){
			list = contractDao.selectByPage(contract);
		}
		page.setResults(allCounts);
		page.setRows(list);
		return page;
	}

	@Override
	public int save(ContractModel contract) {
		return contractDao.save(contract);
	}

	@Override
	public ContractModel getContractById(long id) {
		
		return contractDao.getContractById(id);
	}

	@Override
	public int update(ContractModel contract) {
		return contractDao.update (contract);
	}

	@Override
	public int deleteById(long id) {
		return contractDao.deleteById(id);
	}

	@Override
	public int deleteByIds(List<Long> ids) {
		return contractDao.deleteByIds(ids);
	}

}
