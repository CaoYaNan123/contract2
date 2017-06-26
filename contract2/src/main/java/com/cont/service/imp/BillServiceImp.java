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
		/**
		List<BillModel> list = null;
		//如果记录数大于等于0，则查列表
		if(count>0){
			list = billDAO.selectByPage(vo);
			page.setResults(count);
			page.setRows(list);
		}
		为什么加上等于0之后前端就不再一直loding,
			因为list属性为null，前台框架就会一直Loging
		*/
		List<BillModel> list = new ArrayList<BillModel>();
		 
		if(count>0){
			list = billDAO.selectByPage(vo);
		}
		page.setResults(count);
		page.setRows(list);
		return page;
	}

}
