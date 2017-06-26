<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>添加合同</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath }/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/assets/css/page-min.css" rel="stylesheet" type="text/css" />
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
			<form id="J_Form" class="form-horizontal span24">
				<input type="hidden" name="id" value="${contract.id }">
				<div class="row">
					<div class="control-group span8">
						<label class="control-label"><s>*</s>合同编号：</label>
						<div class="controls">
							<input name="concatNo" type="text" data-rules="{required:true}"
								class="input-normal control-text" value="${contract.concatNo }"/>
						</div>
					</div>
					
				</div>
				<div class="row">
					<div class="control-group span8">
						<label class="control-label"><s>*</s>乙方姓名：</label>
						<div class="controls">
							<input name="concatPerson" type="text" data-rules="{required:true}"
								class="input-normal control-text" value="${contract.concatPerson }">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="control-group span8">
						<label class="control-label"><s>*</s>乙方联系方式：</label>
						<div class="controls">
							<input name="concatPhone" type="text" data-rules="{required:true}"
								class="input-normal control-text"  value="${contract.concatPhone }">
						</div>
					</div>
				</div>
				<div class="row form-actions actions-bar">
					<div class="span13 offset3 ">
						<button type="button" id = "savebtn" class="button button-primary">更新</button>
						<button type="reset" class="button">重置</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery-1.8.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/bui-min.js"></script>

	<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/config-min.js"></script>
	<script type="text/javascript">
		BUI.use('common/page');
	</script>
	<script type="text/javascript">
		$(function(){
			$("#savebtn").click(function(){
				 $.ajax({
					url:"${pageContext.request.contextPath }/Api/contract/contractUpdate",
					data:$("#J_Form").serialize(),
					dataType:"json",
					type:"post",
					success:function(data){
						if(data.success==true){
							BUI.Message.Alert("更新成功！");
							
						}
					},
					error:function(){
						alert("更新失败！");
					}
				}); 
			});
		});
	</script>
<body>
</html>
