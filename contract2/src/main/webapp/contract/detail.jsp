<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML>

<html>
<head>
<title>维修单审核</title>
<link href="${pageContext.request.contextPath }/assets/css/mine.css"
	type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/assets/css/dpl-min.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/assets/css/bui-min.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/assets/css/page-min.css"
	rel="stylesheet" type="text/css" />

<style type="text/css">
.imgShow {
	border: 0px solid red;
}

img {
	height: 100px;
}

#operateTab {
	border: 0px solid red;
	margin: 50px auto;
	text-align: center;
}
}
</style>
</head>

<body>
	<div class="container">
		<input type="hidden" id="billId" value="${basicMsg.id }"/>
		<table border="1" class="table_a" style="margin: auto">

			<tr>
				<td colspan="3" height="50" style="text-align: center;">
					<h2>基本信息</h2>
				</td>
			</tr>
			<tr>
				<td>
					<div class="span8">
						<label>报修单号：</label><span class="detail-text">${basicMsg.billNo }</span>
					</div>
				</td>
				<td>
					<div class="span8">
						<label>合同单号：</label><span class="detail-text">${basicMsg.contractNum }</span>
					</div>
				</td>
				<td>
					<div class="span8">
						<label>用户姓名：</label><span class="detail-text">${basicMsg.cusName }</span>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="span8">
						<label>用户微信号：</label><span class="detail-text">${basicMsg.uWeixin }</span>
					</div>
				</td>
				<td>
					<div class="span8">
						<label>联系方式：</label><span class="detail-text">${basicMsg.uPhone }</span>
					</div>
				</td>
				<td>
					<div class="span8">
						<label>报修单状态：</label><span class="detail-text">${basicMsg.statusMean }</span>
					</div>
				</td>
			</tr>



			<!-- 第二部分，报修日志的展示 -->

			<tr>
				<td colspan="3" height="50" style="text-align: center;">
					<h2>报修日志</h2>
				</td>
			</tr>
			<c:forEach var="log" items="${logMsg }">
				<tr>
					<td>
						<div class="span8">
							<label>操作人：</label><span class="detail-text"> <c:if
									test="${empty log.updateUserName}">
							无操作人
						</c:if> ${log.updateUserName }
							</span>
						</div>
					</td>
					<td>
						<div class="span8">
							<label>维修师：</label><span class="detail-text"> <c:if
									test="${empty log.dealUserName}">
							无维修师
						</c:if> ${log.dealUserName }
							</span>
						</div>
					</td>
					<td>
						<div class="span8">
							<label>操作事件：</label><span class="detail-text">${log.opreateEvent }</span>
						</div>
					</td>
				</tr>
				<tr>

					<td>
						<div class="span8">
							<label>操作时间：</label><span class="detail-text">${log.updateTimeFormat }</span>
						</div>
					</td>
				</tr>
			</c:forEach>
			<!-- 第三部分，最重要的一部分，设备信息 -->
			<c:forEach var="device" items="${deviceMsg }" varStatus="vs">
				<tr>
					<td colspan="3" height="50" style="text-align: center;">
						<h2>设备信息</h2>
					</td>
				</tr>

				<tr>
					<td colspan="3">
						<h3>报修设备序号:${vs.count }</h3>
					</td>
				</tr>
				<tr>
					<td>
						<div class="span8">
							<label>设备名称：</label><span class="detail-text">${device.deviceName }</span>
						</div>
					</td>
					<td>
						<div class="span8">
							<label>设备保修期：</label><span class="detail-text">${device.startTimeFormat }--${device.endTimeFormat }</span>
						</div>
					</td>
					<td>
						<div class="span8">
							<label>损坏描述：</label><span class="detail-text">${device.deviceDesc }</span>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<div class="imgShow">
							<label>图片展示：</label><span class="detail-text"> <img
								alt="损坏设备展示图片" src="${pageContext.request.contextPath }${device.imgUrl}">
							</span>
						</div>
					</td>
				</tr>
			</c:forEach>


		</table>

		<div id="operateTab">
			<button id="btnPass" class="button button-primary">审核通过</button>
			&nbsp;&nbsp;
			<button id="btnRefuse" class="button button-primary">审核拒绝</button>
			&nbsp;&nbsp;
			<button id="btnReload" class="button">刷新</button>
		</div>

		<video src=""></video>
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
		/*$(function(){
			$("#btnPass").click(function(){})
		}*/
		$(function() {
			$("#btnPass").click(function() {
				//alert($("#billId").val());
					 $.ajax({
						url:"${pageContext.request.contextPath }/Api/bill/pass",
						data:{billId:$("#billId").val()},
						dataType:"json",
						type:"post",
						success:function(data){
							if(data.success==true){
								BUI.Message.Alert("审核通过成功！");
								
							} else {
								BUI.Message.Alert("审核通过失败！");
							}
						},
						error:function(){
							BUI.Message.Alert("出现错误，请联系管理员");
						}
					}); 
				
			});

			$("#btnRefuse").click(function() {
				 $.ajax({
						url:"${pageContext.request.contextPath }/Api/bill/refuse",
						data:{billId:$("#billId").val()},
						dataType:"json",
						type:"post",
						success:function(data){
							if(data.success==true){
								BUI.Message.Alert("审核拒绝成功！");
								
							} else {
								BUI.Message.Alert("审核拒绝失败！");
							}
						},
						error:function(){
							BUI.Message.Alert("出现错误，请联系管理员");
						}
					}); 
				
			});
			$("#btnReload").click(function() {
				top.topManager.reloadPage();
			});
		});
	</script>
</body>
</html>