<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>更新类别</title>
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
				<input type="hidden" name="catId" value="${category.catId }">
				
				<div class="row">
					<div class="control-group span8">
						<label class="control-label"><s>*</s>类别名称：</label>
						<div class="controls">
							<input name="catName" type="text" data-rules="{required:true}"
								class="input-normal control-text" value="${category.catName }">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="control-group span8">
						<label class="control-label"><s>*</s>类别描述：</label>
						<div class="controls">
							<input name="catDesc" type="text" data-rules="{required:true}"
								class="input-normal control-text" value="${category.catDesc }">
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="control-group span8">
						<label class="control-label"><s>*</s>父类别名称：</label>
						<div class="controls">
							<select name="parentCatId" data-rules="{required:true}">
							<c:forEach items="${catList }" var="cat">
								<option value="${cat.catId }" 
									<c:if test="${cat.catId == category.parentCatId}">
										selected="selected"
	    							</c:if> >
									<c:forEach var="i" begin="2" end="${cat.catLevel }">
										&nbsp;&nbsp;
									</c:forEach>
									${cat.catName }
								</option>
							</c:forEach>
						</select>
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
					url:"${pageContext.request.contextPath }/Api/category/update",
					data:$("#J_Form").serialize(),
					dataType:"json",
					type:"post",
					success:function(data){
						if(data.success==true){
							BUI.Message.Alert("更新成功！");
						}else {
							BUI.Message.Alert("更新失败！");
						}
					},
					error:function(){
						alert("系统出现问题，请联系管理员！");
					}
				}); 
			});
		});
	</script>
<body>
</html>
