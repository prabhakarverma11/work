<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%
	int totalRecords = (Integer) session.getAttribute("totalRecords");
	int recordsPerPage = (Integer) session.getAttribute("recordsPerPage");
	int pageNumber = (Integer) session.getAttribute("pageNumber");
	String userEmail = (String) session.getAttribute("userEmail");
	String col = (String)session.getAttribute("col");
	int o = (Integer)session.getAttribute("o");
%>
<style>
.dataTables_length select {
	width: 60px;
}

.paginate_button .hover {
	border: 1px;
}

th {
	text-align: right;
}

tr {
	text-align: right;
}
.ui-autocomplete {
	max-height: 150px;
	overflow-y: scroll;
	overflow-x: hidden;
}
</style>
<div class="container">
	<div class="row">
		<c:if test="${(msg!=null) and (errorMsg gt 0)}">
			<div class="alert alert-success fade in text-center">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>${msg}</div>
		</c:if>

		<c:if test="${(msg!=null) and (errorMsg eq 0)}">
			<div class="alert alert-danger  fade in text-center">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>${msg}</div>
		</c:if>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-lg-5">
				<form:form class="form-horizontal" role="form" action=""
					name="campaignSearchForm" id="idFormSearchCampaign"
					autocomplete="off">
					<div class="form-group" style="margin-bottom: 5px;">
						<label for="campid" class="col-sm-4 control-label"> Select
							Advertiser: </label>
						<div class="col-sm-8">
							<input id="idInputSearchCampaign" type="text" name="campid"
								class="form-control" placeholder="Search ..."
								onkeyup="getCampaign()" onkeydown="getCampaign()">
						</div>
					</div>
				</form:form>
			</div>
			<div class="col-lg-5">
				<form:form class="form-horizontal" role="form" action=""
					name="adgroupSearchForm" id="idFormSearchAdgroup"
					autocomplete="off">
					<input type="hidden" id="selectedAdgroupId">
					<div class="form-group" style="margin-bottom: 5px;">
						<label for="adgid" class="col-sm-4 control-label"> Select
							Product: </label>
						<div class="col-sm-8">
							<input id="idInputSearchAdgroup" type="text" name="adgid"
								class="form-control" placeholder="Search ..."
								onkeyup="getAdgroup(event)" onkeydown="getAdgroup(event)">
						</div>
					</div>
				</form:form>
			</div>
			<div class="col-lg-1">
				<form:form class="form-horizontal" role="form" action=""
					id="idFormSearch" autocomplete="off">
					<input type="hidden" id="selectedCampaignId">
					<div class="form-group pull-right" style="margin-bottom: 5px;">
						<button type="button" class="btn btn-default"
							onclick="resetAll();">Reset</button>
					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<c:if test="${campaignDo ne null}">
				<div class="col-lg-5" id="idDivCampaignName">
					<div class="form-group">
						<div class="col-sm-4">
							<code>
								<strong>Advertiser:</strong>
							</code>
						</div>
						<div class="col-sm-8">
							<strong><c:out value="${campaignDo.name }"></c:out></strong>
						</div>
					</div>
				</div>
			</c:if>
			<c:if test="${adgroupDo ne null}">
				<div class="col-lg-5" id="idDivProductName">
					<div class="form-group">
						<div class="col-sm-4">
							<code style="margin-left: 15px;">
								<strong>Product:</strong>
							</code>
						</div>
						<div class="col-sm-8">
							<strong><c:out value="${adgroupDo.productName }"></c:out></strong>
						</div>
					</div>
				</div>
			</c:if>

		</div>
		<div id="dataDiv">
			<div class="table-responsive">
				<input type="hidden" id="idRowsValue"
					value="<c:out value='${rows}'/>">
				<table id="idReportTable"
					class="table table-bordered table-hover table-condensed display">
					<thead>
						<tr style="text-align: right">
							<th>S.No.</th>
							<th>Keyword</th>
							<th>Status</th>
							<th>Impressions</th>
							<th>Clicks</th>
							<th>Cost</th>
							<th>CPCBid</th>
							<th>FirstPageCPC</th>
						</tr>
					</thead>
					<c:set var="count" value="${0 }"></c:set>
					<c:forEach items="${keywordPerformanceReportDos }"
						var="keywordPerformanceReportDo">
						<c:set var="count" value="${count +1 }"></c:set>
						<tr>
							<td><c:out value="${count}"></c:out></td>
							<td style=""><c:out
									value="${keywordPerformanceReportDo.keywordText}"></c:out> <a
								class="glyphicon glyphicon-edit" style="cursor: pointer;"
								href="editkeywords?adgid=${adgroupDo.id}&adgPage=1"></a></td>
							<td style=""><c:out
									value="${keywordPerformanceReportDo.status}"></c:out></td>
							<td style=""><c:out
									value="${keywordPerformanceReportDo.impressions}"></c:out></td>
							<td style=""><c:out
									value="${keywordPerformanceReportDo.clicks}"></c:out></td>
							<td style=""><c:out
									value="${keywordPerformanceReportDo.cost}"></c:out></td>
							<td style=""><c:out
									value="${keywordPerformanceReportDo.cpcBid}"></c:out></td>
							<td style=""><c:out
									value="${keywordPerformanceReportDo.firstPageCpc}"></c:out></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</div>


<script>
	function resetAll(){
		$("#idInputSearchCampaign").val("");
		$("#idInputSearchAdgroup").val("");
		$("#selectedCampaignId").val("");
	}
	function getCampaign() {
		var v = document.campaignSearchForm.campid.value;
		var url = "${pageContext.request.contextPath}/searchcampaignlist";

		$.ajax({
			url : url,
			data : "name=" + v,
			dataType : 'text',
			success : function(res) {
				var val = String(res).split(",");

				var campaignList = [];
				for (var i = 0; i < val.length; i++) {
					var camp = val[i].split(":");
					if (camp.length > 1) {
						campaignList.push({
							value : camp[1],
							label : camp[1],
							id : camp[0]
						});
					}
				}
				$("#idInputSearchCampaign").autocomplete(
						{
							minLength : 0,
							source : campaignList,
							autoFocus : true,
							select : function(event, ui) {
								var val1 = ui.item.id;
								$("#idDivCampaignName").remove();
								$("#idDivProductName").remove();
// 								$("#idFormSearch").attr("action",
// 										"kpreport?campid=" + val1);
								$("#selectedCampaignId").val(val1);
							}
						});
			},
			type : "GET",
			error : function(e) {
				alert("An error occurred!!! excepetion: " + e);
			}
		});
	}
	$(document).on("click", "ul.ui-autocomplete[id='ui-id-2'] li", function(e) {
		initLoader($);
		$("#idFormSearchAdgroup").submit();
// 		$("#selectedCampaignId").text(val1);
	});
	$(function() {
		$("#idInputSearchCampaign").autocomplete({
			minLength : 0
		});
	});
	$(function() {
		$("#idInputSearchAdgroup").autocomplete({
			minLength : 0
		});
	});

	function getAdgroup() {
		var v = document.adgroupSearchForm.adgid.value;
		var url = "${pageContext.request.contextPath}/searchadgrouplist";
		var campId = $("#selectedCampaignId").val();
		if(campId == null || campId ==""){
			alert("Please select advertiser first");
		}else{
			
			$.ajax({
				url : url,
				data : "cid="+campId+"&name=" + v,
				dataType : 'text',
				success : function(res) {
					var val = String(res).split(",");
					var adgList = [];
					for (var i = 0; i < val.length; i++) {
						var adg = val[i].split(":");
						if (adg.length > 1) {
							adgList.push({
								value : adg[1],
								label : adg[1],
								id : adg[0]
							});
						}
					}
					
					$("#idInputSearchAdgroup").autocomplete(
							{
								minLength : 0,
								source : adgList,
								autoFocus : true,
								select : function(event, ui) {
									var val1 = ui.item.id;
									$("#idFormSearchAdgroup").attr("action",
											"kpreport?adgid=" + val1);
									//alert(val1);
								}
							});
				},
				type : "GET",
				error : function(e) {
					alert("An error occurred!!! excepetion: " + e);
				}
			});
		}
	}
	
	
	//DataTable used for sorting starts

	var t = $('#idReportTable').DataTable({
		paging : true,
		pageLength: 10,
		pagingType: "simple_numbers",
		info : true,
		filter : true,
		searching : false,
		orderCellsTop : true,
		"columnDefs" : [ {
			"visible" : true,
			"orderable" : false,
			"targets" : 0
		}, ],
		"order" : [ [ 1, 'asc' ] ],
		"dom": '<<"pull-left"i>f<"pull-right"l>><t><p>',
		"lengthMenu": [[10, 25, 50, 100, -1], [10, 25, 50, 100, "All"]],
		"language": {
            "lengthMenu": "<code>Items per page:</code> _MENU_",
            "zeroRecords": "Please select an advertiser.",
            "infoEmpty": "",
            "infoFiltered": "(filtered from _MAX_ total records)"
        },
	});

	t.on('order.dt search.dt', function() {
		j = 0;
		t.column(0, {
			search : 'applied',
			order : 'applied'
		}).nodes().each(function(cell) {
			cell.innerHTML = j + 1;
			j++;
		});
	}).draw();

	//DataTable used for sorting starts
</script>