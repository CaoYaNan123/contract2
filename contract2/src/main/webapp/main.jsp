<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
 <head>
  <title>合同报修管理平台</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <link href="assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
  <link href="assets/css/bui-min.css" rel="stylesheet" type="text/css" />
   <link href="assets/css/main-min.css" rel="stylesheet" type="text/css" />
 </head>
 <body>

  <div class="header">
    
      <div class="dl-title">
          <span class="dl-title-text">合同报修管理平台</span>
      </div>

    <div class="dl-log">欢迎您，<span class="dl-log-user">**.**@alibaba-inc.com</span><a href="###" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
  </div>
   <div class="content">
    <div class="dl-main-nav">
      <div class="dl-inform"><div class="dl-inform-title">贴心小秘书<s class="dl-inform-icon dl-up"></s></div></div>
      <ul id="J_Nav"  class="nav-list ks-clear">
        <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">合同管理</div></li>
        <li class="nav-item"><div class="nav-item-inner nav-order">用户管理</div></li>
      </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
   </div>
  <script type="text/javascript" src="assets/js/jquery-1.8.1.min.js"></script>
  <script type="text/javascript" src="assets/js/bui.js"></script>
  <script type="text/javascript" src="assets/js/config.js"></script>

  <script>
    BUI.use('common/main',function(){
      var config = [{
          id:'bill', 
          homePage : 'code',
          menu:[{
              text:'合同维护',
              items:[
                {id:'code',text:'报修单管理	',href:'contract/bill.jsp',closeable : false},
                {id:'main-menu',text:'合同管理',href:'contract/contract.jsp'}
              ]
            },{
              text:'设备维护',
              items:[
                {id:'operation',text:'设备管理',href:'contract/device.jsp'},
                {id:'quick',text:'类别管理',href:'contract/category.jsp'},
                {id:'quick',text:'参数管理',href:'contract/param.jsp'}
              ]
            }]
          },{
            id:'device',
            menu:[{
                text:'用户维护',
                items:[
                  {id:'code',text:'用户管理',href:'user/usermanage.jsp'},
                  {id:'example',text:'微信客户管理',href:'user/wxuser.jsp'}
                  
                ]
              },{
                text:'权限维护',
                items:[
                	{id:'introduce',text:'角色管理',href:'user/role.jsp'},
                    {id:'valid',text:'菜单管理',href:'user/munu.jsp'}
                ]
              }]
          }];
      new PageUtil.MainPage({
        modulesConfig : config
      });
    });
  </script>
 </body>
</html>
