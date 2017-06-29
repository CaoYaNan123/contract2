<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>编辑学生信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath }/assets/css/dpl-min.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/assets/css/bui-min.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/assets/css/page-min.css"
	rel="stylesheet" type="text/css" />
<!-- 下面的样式，仅是为了显示代码，而不应该在项目中使用-->
<link href="${pageContext.request.contextPath }/assets/css/prettify.css"
	rel="stylesheet" type="text/css" />
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
		<form id="J_Form" class="form-horizontal" action="success.html">
			<div class="row">
				<div class="control-group span12">
					<label class="control-label"><s>*</s>类别名称：</label>
					<div class="controls">
						<input name="catName" type="text" class="control-text"
							data-rules="{required:true}">
					</div>
				</div>
				<div class="control-group span12">
					<label class="control-label">类别描述：</label>
					<div class="controls">
						<input name="catDesc" type="text" class="control-text"
							data-rules="{required:false}">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="control-group span12">
					<label class="control-label"><s>*</s>父类别名称：</label>
					<div class="controls">
						<select name="parentCatId" data-rules="{required:true}">
							<c:forEach items="${category }" var="cat">
								<option value="${cat.catId }">
								<c:forEach var="i" begin="2" end="${cat.catLevel }">
									&nbsp;&nbsp;
								</c:forEach>
								${cat.catName }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="row form-actions actions-bar">
				<div class="span13 offset3 ">
					<button type="button" id="savebtn" class="button button-primary">保存</button>
					<button type="reset" class="button">重置</button>
				</div>
			</div>
		</form>
	</div>


	<script type="text/javascript"
		src="${pageContext.request.contextPath }/assets/js/jquery-1.8.1.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/assets/js/bui-min.js"></script>

	<script type="text/javascript"
		src="${pageContext.request.contextPath }/assets/js/config-min.js"></script>
	<script type="text/javascript">
		BUI.use('common/page');
	</script>
	<script type="text/javascript">
		$(function() {
			$("#savebtn")
					.click(
							function() {
								$
										.ajax({
											url : "${pageContext.request.contextPath }/Api/category/save",
											data : $("#J_Form").serialize(),
											dataType : "json",
											type : "post",
											success : function(data) {
												if (data.success == true) {
													BUI.Message.Alert("新增成功！");

												}
											},
											error : function() {
												alert("新增失败！");
											}
										});
							});
		});
	</script>
<body>
</html>
