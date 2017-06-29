package com.cont.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cont.model.BillModel;
import com.cont.service.BillService;
import com.cont.utils.Page;

@Controller
@RequestMapping("/bill")
public class BillController {
	@Autowired
	private BillService billService;

	@ResponseBody
	@RequestMapping("/query")
	public Page<BillModel> login(BillModel vo) {
		Page<BillModel> page = billService.selectBill(vo);
		return page;
	}

	/**
	 * 批量删除
	 */
	@ResponseBody
	@RequestMapping("/batchDel")
	public Map<String, Boolean> batchDel(@RequestBody List<String> ids) {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		List<Long> list = new ArrayList<Long>();
		for (String id : ids) {
			list.add(Long.parseLong(id));
		}
		
		int counts = billService.batchDelete(list);
		if (counts == list.size()) {
			map.put("success", true);
		}else {
			map.put("success", false);
		}
		return map;
	}
	
	/**
	 * 批量通过
	 */
	@ResponseBody
	@RequestMapping("/batchPass")
	public Map<String, Boolean> batchPass(@RequestBody List<String> ids) {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		List<Long> list = new ArrayList<Long>();
		for (String id : ids) {
			list.add(Long.parseLong(id));
		}
		
		int counts = billService.batchPass(list);
		if (counts == list.size()) {
			map.put("success", true);
		}else {
			map.put("success", false);
		}
		return map;
	}

	/**
	 * 审核通过
	 */
	@ResponseBody
	@RequestMapping("/pass")
	public Map<String, Boolean> pass(String billId){
		int pass = billService.pass(Long.parseLong(billId));
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		if (pass == 1) {
			map.put("success", true);
		}else {
			map.put("success", false);
		}
		return map;
	}
	
	/**
	 * 审核拒绝
	 */
	@ResponseBody
	@RequestMapping("/refuse")
	public Map<String, Boolean> refuse(String billId){
		int refuse = billService.refuse(Long.parseLong(billId));
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		if (refuse == 1) {
			map.put("success", true);
		}else {
			map.put("success", false);
		}
		return map;
	}
	
}
