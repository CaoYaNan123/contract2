<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
 <head>
  <title>报修单管理</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <link href="../assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
   <link href="../assets/css/bui-min.css" rel="stylesheet" type="text/css" />
   <link href="../assets/css/page-min.css" rel="stylesheet" type="text/css" />   <!-- 下面的样式，仅是为了显示代码，而不应该在项目中使用-->
   <link href="../assets/css/prettify.css" rel="stylesheet" type="text/css" />
   <style type="text/css">
    code {
      padding: 0px 4px;
      color: #d14;
      background-color: #f7f7f9;
      border: 1px solid #e1e1e8;
    }
   </style>
 </head>
 <body>
  
  <div class="container">
    <div class="row">
      <form id="searchForm" class="form-horizontal" role="form">
        <div class="row">
          <div class="form-group">
            <label class="col-lg-1 control-label">报修单编号：</label>
            <div class="col-lg-4 controls">
              <input type="text" class="control-text" name="bill_no">
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-1 control-label">客户微信号：</label>
            <div class="col-lg-4 controls">
              <input type="text" class="control-text" name="u_weixin">
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-1 control-label">报修状态：</label>
            <div class="col-lg-4 controls" >
              <select  name="status">
              	<option value=""></option>
                <option value="0" selected>提交</option>
                <option value="1">审批通过</option>
                <option value="2">审批拒绝</option>
                <option value="3">正在维修</option>
                <option value="4">已完成</option>
              </select>
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-1 control-label">提交时间：</label>
            <div class="col-lg-4 controls">
              <input type="text" class=" calendar" name="startDate"><span> - </span><input name="endDate" type="text" class=" calendar">
            </div>
          </div>
          <div class="form-group">
          <div class="col-lg-5  pull-right">
            <button  type="button" id="btnSearch" class="button button-primary">搜索</button>
          </div>
          </div>
        </div>
      </form>
    </div>
    <div class="search-grid-container">
      <div id="grid"></div>
    </div>
  </div>
  <script type="text/javascript" src="../assets/js/jquery-1.8.1.min.js"></script>
  <script type="text/javascript" src="../assets/js/bui-min.js"></script>


  <script type="text/javascript" src="../assets/js/config-min.js"></script>
  <script type="text/javascript">
    BUI.use('common/page');
  </script>
<script type="text/javascript">
  BUI.use(['common/search','bui/overlay'],function (Search,Overlay) {
    
    var enumObj = {"0":"提交","1":"审批通过","2":"审批拒绝","3":"正在维修","4":"已完成"},
      columns = [
          {title:'报修单编号',dataIndex:'bill_no',width:150,renderer:function(v){
            return Search.createLink({
              id : 'detail' + v,
              title : '报修设备信息',
              text : v,
              href : 'detail/example.html'
            });
          }},
          {title:'客户微信号',dataIndex:'u_weixin',width:150},
          {title:'客户姓名',dataIndex:'cus_cname',width:150},
          {title:'状态',dataIndex:'status',width:100,renderer:BUI.Grid.Format.enumRenderer(enumObj)},
          {title:'提交时间',dataIndex:'create_time',width:150,renderer:BUI.Grid.Format.dateRenderer},
          {title:'最后更新时间',dataIndex:'update_time',width:150,renderer:BUI.Grid.Format.dateRenderer},
          {title:'最后更新人',dataIndex:'update_cname',width:100},
          {title:'操作',dataIndex:'',width:200,renderer : function(value,obj){
            var editStr =  Search.createLink({ //链接使用 此方式
                id : 'edit' + obj.id,
                title : '编辑',
                text : '编辑',
                href : 'search/edit.html'
              }),
              delStr = '<span class="grid-command btn-del" title="删除">删除</span>';//页面操作不需要使用Search.createLink
            return editStr + delStr;
          }}
        ],
      store = Search.createStore('/contract/Api/bill/billquery'),
      gridCfg = Search.createGridCfg(columns,{
        tbar : {
          items : [
            {text : '<i class="icon-plus"></i>新建',btnCls : 'button button-small',handler:function(){alert('新建');}},
            {text : '<i class="icon-edit"></i>编辑',btnCls : 'button button-small',handler:function(){alert('编辑');}},
            {text : '<i class="icon-remove"></i>删除',btnCls : 'button button-small',handler : delFunction}
          ]
        },
        plugins : [BUI.Grid.Plugins.CheckSelection] // 插件形式引入多选表格
      });

    var  search = new Search({
        store : store,
        gridCfg : gridCfg
      }),
      grid = search.get('grid');
    //删除操作
    function delFunction(){
      var selections = grid.getSelection();
      delItems(selections);
    }

    function delItems(items){
      var ids = [];
      BUI.each(items,function(item){
        ids.push(item.id);
      });

      if(ids.length){
        BUI.Message.Confirm('确认要删除选中的记录么？',function(){
          $.ajax({
            url : '../data/del',
            dataType : 'json',
            data : {ids : ids},
            success : function(data){
              if(data.success){ //删除成功
                search.load();
              }else{ //删除失败
                BUI.Message.Alert('删除失败！');
              }
            }
        });
        },'question');
      }
    }

    //监听事件，删除一条记录
    grid.on('cellclick',function(ev){
      var sender = $(ev.domTarget); //点击的Dom
      if(sender.hasClass('btn-del')){
        var record = ev.record;
        delItems([record]);
      }
    });
  });
</script>

<body>
</html>  
