
package com.cont.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cont.model.BillDetailModel;


/**
 * 维修单详情页控制器口
 * 
 * @author Cao YaNan
 * @time 2017年6月24日下午5:04:02
 *
 */
@Controller
@RequestMapping("/bill")
public class BillDetailController {
	
	
    @ResponseBody
    @RequestMapping("/detail")
    public BillDetailModel detail(int id) {

    	BillDetailModel bd = new BillDetailModel();
    	bd.setC_desc("我是测试");
	    return bd;
    }
}
