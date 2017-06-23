package com.cont.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cont.model.BillModel;
import com.cont.service.BillService;
import com.cont.utils.Page;

/**
 * Controller
 * //@RequestParam(value="ids",required=false) String ids
 */
@Controller
@RequestMapping("/bill")
public class BillController {
	@Autowired
    private BillService billService;   
	
	
	
    @ResponseBody
    @RequestMapping("/billquery")
    public Page<BillModel> login(BillModel vo) {
	    Page<BillModel> page = billService.selectBill(vo);
	    return page;
    }
}
