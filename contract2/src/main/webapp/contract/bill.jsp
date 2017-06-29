<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>报修单管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
<link href="../assets/css/bui-min.css" rel="stylesheet" type="text/css" />
<link href="../assets/css/page-min.css" rel="stylesheet" type="text/css" />
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
						<div class="col-lg-4 controls">
							<select name="status">
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
							<input type="text" class=" calendar" name="startDate"><span>
								- </span><input name="endDate" type="text" class=" calendar">
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-5  pull-right">
							<button type="button" id="btnSearch"
								class="button button-primary">搜索</button>
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
		BUI
				.use(
						[ 'common/search', 'bui/overlay' ],
						function(Search, Overlay) {
							var enumObj = {
								"0" : "提交",
								"1" : "审核通过",
								"2" : "审核拒绝",
								"3" : "正在维修",
								"4" : "完成"
							};

							var columns = [
									{
										title : '报修单编号',
										dataIndex : 'bill_no',
										width : 150,
										renderer : function(v) {
											return Search
													.createLink({
														id : 'detail' + v,
														title : '报修设备信息',
														text : v,
														href : 'Api/detail/confirm?billNo='
																+ v
													});
										}
									},

									{
										title : '客户微信号',
										dataIndex : 'u_weixin',
										width : 150
									},

									{
										title : '客户姓名',
										dataIndex : 'cus_cname',
										width : 150
									},

									{
										title : '状态',
										dataIndex : 'status',
										width : 100,
										renderer : BUI.Grid.Format
												.enumRenderer(enumObj)
									},

									{
										title : '提交时间',
										dataIndex : 'create_time',
										width : 150,
										renderer : BUI.Grid.Format.dateRenderer
									},

									{
										title : '最后更新时间',
										dataIndex : 'update_time',
										width : 150,
										renderer : BUI.Grid.Format.dateRenderer
									},

									{
										title : '最后更新人',
										dataIndex : 'update_cname',
										width : 100
									},

									{
										title : '操作',
										dataIndex : '',
										width : 200,
										renderer : function(value, obj) {
											var passStr = Search
													.createLink({ //链接使用 此方式
														id : 'edit' + obj.id,
														title : '审核',
														text : '审核',
														href : 'Api/detail/confirm?idStr='
																+ obj.id
													});
											var delStr = '<span class="grid-command btn-del" title="删除">删除</span>';
											return passStr + delStr;
										}
									} ];

							var store = Search
									.createStore('/contract2/Api/bill/query');
							var gridCfg = Search.createGridCfg(columns, {
								tbar : {
									items : [ {
										text : '审核通过',
										btnCls : 'button button-small',
										handler : function() {
											commonOperateFunction(1);
										}
									},

									{
										text : '<i class="icon-remove"></i>删除',
										btnCls : 'button button-small',
										handler : function() {
											commonOperateFunction(-1);
										}
									} ]
								},
								plugins : [ BUI.Grid.Plugins.CheckSelection ]
							});

							var search = new Search({
								store : store,
								gridCfg : gridCfg
							});
							var grid = search.get('grid');

							//删除操作
							function commonOperateFunction(v) {
								var selections = grid.getSelection();
								operateItems(selections, v);
							}

							function operateItems(items, v) {
								var ids = [];
								BUI.each(items, function(item) {
									ids.push(item.id);
								});
								var apiUrl = null;
								if (v == -1) {
									//批量删除
									apiUrl = "${pageContext.request.contextPath }/Api/bill/batchDel";
								} else if (v == 1) {
									//批量审核通过
									apiUrl = "${pageContext.request.contextPath }/Api/bill/batchPass";
								}

								var msg = "删除"
								if (v != -1) {
									msg = enumObj[v];
								}
								if (ids.length) {
									BUI.Message
											.Confirm(
													'确认要' + msg + '选中的记录么？',
													function() {
														$
																.ajax({

																	url : apiUrl,
																	dataType : 'json',
																	contentType : "application/json;charset=utf-8",
																	type : "post",
																	data : JSON
																			.stringify(ids),
																	success : function(
																			data) {

																		if (data.success) { //删除成功
																			BUI.Message
																					.Alert(msg
																							+ '成功！');
																			search
																					.load();
																		} else { //删除失败
																			BUI.Message
																					.Alert(msg
																							+ '失败！');
																		}
																	}

																});
													}, 'question');
								}
							}

							//监听事件，删除一条记录
							grid.on('cellclick', function(ev) {
								var sender = $(ev.domTarget); //点击的Dom
								if (sender.hasClass('btn-del')) {
									var record = ev.record;
									operateItems([ record ], -1);
								} else if (sender.hasClass('btn-pass')) {
									var record = ev.record;
									operateItems([ record ], 1);
								}
							});
						});
	</script>
<body>
</html>
