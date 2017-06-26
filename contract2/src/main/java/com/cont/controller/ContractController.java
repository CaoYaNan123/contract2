package com.cont.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cont.model.ContractModel;
import com.cont.model.UserModel;
import com.cont.service.ContractService;
import com.cont.utils.Page;

/**
 * 合同控制器
 * 
 * @author Cao YaNan
 * @time 2017年6月25日下午8:22:45
 *
 */
@Controller
@RequestMapping("/contract")
public class ContractController {
	@Autowired
	private ContractService contractService;

	// http://localhost:8080/contract2/Api/contract/contractQuery
	@ResponseBody
	@RequestMapping("/contractQuery")
	public Page<ContractModel> query(ContractModel contract, HttpServletRequest request) {
		Page<ContractModel> page = contractService.selectContract(contract);
		return page;
	}

	/**
	 * 添加 异步请求， 处理结果是一个对象，交给一个那个谁转成json
	 * 
	 * @param contract
	 * @return
	 */
	// 报错:http://localhost:8080/contract2/contract/contractSave?concatNo=xxx&concatPerson=xxx&concatPhone=xxx
	// 404 (Not Found)
	@ResponseBody
	@RequestMapping("/contractSave")
	public Map<String, Boolean> save(ContractModel contract, HttpServletRequest request) {
		// 设置合同的创建时间，创建人(session域对象中登录的用户)
		UserModel user = (UserModel) request.getSession().getAttribute("userInfo");
		long id = user.getId();

		contract.setCreateUId(id);
		contract.setCreateTime(new Date());

		int i = contractService.save(contract);

		Map<String, Boolean> map = new HashMap<String, Boolean>();
		if (i != 0) {
			// if (true) {
			// 增加成功
			map.put("success", true);
		} else {
			map.put("success", false);
		}
		return map;
	}

	/**
	 * 获取要修改的合同的参数(修改的第一步)
	 */
	@RequestMapping("/toUpdate")
	public ModelAndView toUpdate(ContractModel contract) {
		ModelAndView view = new ModelAndView();
		// 查询合同id参数，通过ModelAndView放到request域对象中
		contract = contractService.getContractById(contract.getId());
		view.addObject("contract", contract);
		view.setViewName("/contract/contractUpdate");
		return view;
	}

	/**
	 * 根据id更新合同表(更新第二步) 异步请求， 处理结果是一个对象，交给一个那个谁转成json
	 */
	@ResponseBody
	@RequestMapping("/contractUpdate")
	public Map<String, Boolean> update(ContractModel contract, HttpServletRequest request) {
		// 设置合同的修改时间，修改人(session域对象中登录的用户)
		UserModel user = (UserModel) request.getSession().getAttribute("userInfo");
		long id = user.getId();

		contract.setCreateUId(id);
		contract.setCreateTime(new Date());
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		int i = contractService.update(contract);

		if (i != 0 ) {
		//if (true) {
			// 修改成功
			map.put("success", true);
		} else {
			map.put("success", false);
		}
		return map;
	}
	
	/**
	 * 删除操作(异步请求，返回对象封装成json)
	 */
	@ResponseBody
	@RequestMapping("/contractDelete")
	public Map<String, Boolean> delete(@RequestBody List<String> ids, HttpServletRequest request) {
		
		List<Long> list = new ArrayList<Long>();
		for (String id : ids) {
			list.add(Long.parseLong(id));
		}
		
		int i = contractService.deleteByIds(list);
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();

		//if (i != 0 ) {
		if ( i==list.size()) {
			// 删除成功
			map.put("success", true);
		} else {
			map.put("success", false);
		}
		return map;
	}
}
