<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>合同管理</title>
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
			<form id="searchForm" class="form-horizontal" role="form"
				method="post">
				<div class="row">
					<div class="form-group">
						<label class="col-lg-1 control-label">合同单编号：</label>
						<div class="col-lg-4 controls">
							<input type="text" class="control-text" name="concatNo">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-1 control-label">乙方姓名：</label>
						<div class="col-lg-4 controls">
							<input type="text" class="control-text" name="concatPerson">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-1 control-label">乙方联系方式：</label>
						<div class="col-lg-4 controls">
							<input type="text" class="control-text" name="concatPhone">
						</div>
					</div>

					<div class="form-group">
						<label class="col-lg-1 control-label">签订时间：</label>
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
							var columns = [
									{
										title : 'ID',
										dataIndex : 'id',
										width : 50,
									},
									{
										title : '合同单编号',
										dataIndex : 'concatNo',
										width : 150,
									},
									{
										title : '乙方姓名',
										dataIndex : 'concatPerson',
										width : 150
									},
									{
										title : '乙方联系方式',
										dataIndex : 'concatPhone',
										width : 150
									},
									{
										title : '签订时间',
										dataIndex : 'createTime',
										width : 150,
										renderer : BUI.Grid.Format.dateRenderer
									},
									{
										title : '创建人ID',
										dataIndex : 'createUId',
										width : 100,
									},
									{
										title : '创建人姓名',
										dataIndex : 'createUserName',
										width : 150,
									},
									{
										title : '操作',
										dataIndex : '',
										width : 200,
										renderer : function(value, obj) {
											var editStr = Search
													.createLink({ //链接使用 此方式
														id : 'edit' + obj.id,
														title : '编辑合同',
														text : '编辑',
														href : 'Api/contract/toUpdate?id='+ obj.id
													}), delStr = '<span class="grid-command btn-del" title="删除">删除</span>';//页面操作不需要使用Search.createLink
											return editStr + delStr;
										}
									} ];

							var store = Search
									.createStore('/contract2/Api/contract/contractQuery');
							var gridCfg = Search
									.createGridCfg(
											columns,
											{
												tbar : {
													items : [ {
														xclass : 'bar-item-button',
														text : '<i class="icon-plus"></i>新建',
														btnCls : 'button button-small',
														handler : function(v) {
															//在这个函数里面如何跳转到contractAdd.jsp
															top.topManager
																	.openPage({
																		id : 'contractAdd',
																		href : 'contract/contractAdd.jsp',
																		title : '合同添加'
																	});
														}
													} ,
													
													 { text : '<i class="icon-remove"></i>删除',
													    btnCls : 'button button-small',
														handler : delFunction
													 }]
												},
												plugins : [ BUI.Grid.Plugins.CheckSelection ]
											});

							var search = new Search({
								store : store,
								gridCfg : gridCfg
							}), grid = search.get('grid');
							//删除操作
							function delFunction() {
								var selections = grid.getSelection();
								delItems(selections);
							}

							function delItems(items) {
								var ids = [];
								BUI.each(items, function(item) {
									ids.push(item.id);
								});

								if (ids.length) {
									BUI.Message.Confirm('确认要删除选中的记录么？',function() {
										$.ajax({
												url : "${pageContext.request.contextPath }/Api/contract/contractDelete",
												dataType : 'json',
												contentType: "application/json;charset=utf-8",
												type : "post",
												data : JSON.stringify(ids),
												success : function(data) {
														if (data.success) { //删除成功
															BUI.Message.Alert('删除成功！')
															search.load();
														} else { //删除失败
															BUI.Message.Alert('删除失败！');
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
									delItems([ record ]);
								}
							});
						});
	</script>
<body>
</html>
