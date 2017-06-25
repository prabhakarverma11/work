<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<style>
.homebtn {
	font-size: 18px;
	width: 160px;
	height: 50px;
}
</style>
<script>
	$("#idDropdownHome").attr("style","color: #fff");
</script>

<div class="container" style="min-height: 500px;">
	<div class="row" style="text-align: center;">
		<div class="col-sm-3">
			<input type="button" class="btn btn-primary homebtn"
				value="Advertiser List" onclick="location.href='listcampaign'">
		</div>
		<div class="col-sm-3">
			<input type="button" class="btn btn-success homebtn"
				value="Product List" onclick="location.href='listadgroup'">
		</div>
		<div class="col-sm-3">
			<input type="button" class="btn btn-success homebtn"
				value="Product Details" onclick="location.href='adgroupdetails'">
		</div>
		<div class="col-sm-3">
			<input type="button" class="btn btn-primary homebtn"
				value="User List" onclick="location.href='listuser'">
		</div>
	</div>
	<%-- 	<c:if test="${fn:length(newCampaignDos) gt 0 }"> --%>
	<div class="row" style="padding-top: 30px;">
		<div class="col-lg-offset-1 col-lg-5">
			<div class="panel panel-default">
				<div class="panel-heading" role="tab" id="headingOne"
					style="text-align: center;">
					<strong>New Advertisers</strong>
				</div>
				<div id="collapseOne" class="panel-collapse collapse in"
					style="overflow: scroll; max-height: 300px; min-height: 300px;"
					role="tabpanel" aria-labelledby="headingOne">
					<ul class="list-group">
						<c:forEach items="${newCampaignDos }" var="campaignDo">
							<li class="list-group-item" style="margin: 2px 2px 2px 2px;">
								<strong><a
									href="${pageContext.request.contextPath}/listcampaign?userId=${campaignDo.userDo.id}"><c:out
											value="${campaignDo.userDo.name }"></c:out></a></strong> has created <strong><a
									href="${pageContext.request.contextPath}/listadgroup?cid=${campaignDo.id}"><c:out
											value="${campaignDo.name}"></c:out></a></strong> today.
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<%-- 	</c:if> --%>
		<%-- 		<c:if test="${fn:length(campaignDosExpireToday) gt 0 }"> --%>
		<div class="col-lg-5">
			<div class="panel panel-default">
				<div class="panel-heading" role="tab" id="headingOne"
					style="text-align: center;">
					<strong>Advertisers going to expire</strong>
				</div>
				<div id="collapseOne" class="panel-collapse collapse in"
					role="tabpanel" aria-labelledby="headingOne"
					style="overflow: scroll; max-height: 300px; min-height: 300px;">
					<ul class="list-group">
						<c:forEach items="${campaignDosExpireToday }" var="campaignDo">
							<li class="list-group-item" style="margin: 2px 2px 2px 2px;">
								<strong><a
									href="${pageContext.request.contextPath}/listadgroup?cid=${campaignDo.id}"><c:out
											value="${campaignDo.name}"></c:out></a></strong> is going to expire today.
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<%-- 		</c:if> --%>
<!-- 		<div class="col-lg-6"> -->
<!-- 			<div class="panel panel-default"> -->
<!-- 				<div class="panel-heading" role="tab" id="headingOne" -->
<!-- 					style="text-align: center;"> -->
<!-- 					<strong>Weekly Report</strong> -->
<!-- 				</div> -->
<!-- 				<div id="collapseOne" class="panel-collapse collapse in" -->
<!-- 					role="tabpanel" aria-labelledby="headingOne" -->
<!-- 					style="overflow: scroll; max-height: 300px; min-height: 300px;"> -->
<!-- 										<div id="chart-container"></div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
	</div>

</div>