package com.cont.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cont.dao.BillDAO;
import com.cont.model.BillModel;
import com.cont.service.BillService;
import com.cont.utils.Page;

@Service
public class BillServiceImp implements BillService{

	@Autowired
    private BillDAO billDAO;
	
	@Override
	public Page<BillModel> selectBill(BillModel vo) {
		Page<BillModel> page = new Page<BillModel>();
		//查询总记录数
		int count = billDAO.selectCount(vo);
		List<BillModel> list = new ArrayList<BillModel>();
		 
		if(count>0){
			list = billDAO.selectByPage(vo);
		}
		page.setResults(count);
		page.setRows(list);
		return page;
	}

	@Override
	public int pass(long billId) {
		return billDAO.pass(billId);
	}

	@Override
	public int refuse(long billId) {
		return billDAO.refuse(billId);
	}

	@Override
	public int batchPass(List<Long> billIds) {
		return billDAO.batchPass(billIds);
	}
	@Override
	public int batchDelete(List<Long> billIds) {
		return billDAO.batchDelete(billIds);
	}

}
