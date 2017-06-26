package com.cont.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cont.model.BillModel;
import com.cont.model.ContractModel;
import com.cont.service.BillService;
import com.cont.service.ContractService;
import com.cont.utils.Page;

@Controller
@RequestMapping("/bill")
public class BillController {
	@Autowired
    private BillService billService;  
	
	//http://localhost:8080/contract/Api/bill/billquery
    @ResponseBody
    @RequestMapping("/billquery")
    public Page<BillModel> login(BillModel vo) {
	    Page<BillModel> page = billService.selectBill(vo);
	    return page;
    }
    
}
