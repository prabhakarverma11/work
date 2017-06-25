<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
.show{
	display: block;
}
.hide{
	display: none;
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
	<div class="row" style="padding-top: 30px;">
		<div class="col-lg-9">
			<div class="panel panel-default">
				<div class="panel-heading" role="tab" id="headingOne" style="text-align:center;">
					<strong>Keyword Ideas</strong>
				</div>
				<div id="collapseOne" class="panel-collapse collapse in" style="overflow :scroll; max-height:450px;min-height: 450px;"
								role="tabpanel" aria-labelledby="headingOne">
					<div id="dataDiv">
						<div class="table-responsive">
							<table id="idReportTable1" class="table table-bordered table-hover table-condensed">
								<thead>
									<tr>
										<th>S.No.</th>
										<th></th>
										<th>Text</th>
										<th>Bid</th>
										<th>Average Monthly Search</th>
										<th>AvgCpc</th>
										<th>Competition</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${keywordDosList }" var="keywordDo">
										<tr id="${keywordDo.id}" class="">
											<td></td>
											<td>
												<i class="glyphicon glyphicon-transfer" id="${keywordDo.id }" onclick="move(event)"></i>
											</td>
											<td><c:out value="${keywordDo.text }"></c:out></td>
											<td><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${keywordDo.bid}" /></td>
											<td><c:out value="${keywordDo.avgMonthlySearch }"></c:out></td>
											<td><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${keywordDo.avgCpc}" /></td>
											<td><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${keywordDo.competition}" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-lg-3">
			<div class="panel panel-default">
				<div class="panel-heading" role="tab" id="headingOne" style="text-align:center;">
					<strong>Selected Keywords</strong>
				</div>
				<div id="collapseOne" class="panel-collapse collapse in" style="overflow :scroll; max-height:450px;min-height: 450px;"
								role="tabpanel" aria-labelledby="headingOne">
					<div id="dataDiv">
						<div class="table-responsive">
							<table id="idReportTable2" class="table table-bordered table-hover table-condensed">
								<thead>
									<tr>
										<th>S.No.</th>
										<th>Text</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${keywordDosList }" var="keywordDo">
										<tr id="${keywordDo.id}" class="">
											<td></td>
											<td><c:out value="${keywordDo.text }"></c:out></td>
											<td><i class="glyphicon glyphicon-transfer" id="${keywordDo.id }" onclick="move(event)"></i>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
function move(event){
	var id = event.target.id;
	$("#idReportTable1 tr[id='"+id+"']").toggleClass("show").toggleClass("hide");
// 	attr("style","display:none");
	$("#idReportTable2 tr[id='"+id+"']").toggleClass("show").toggleClass("hide");
// 	removeAttr("style","display:none");
}
//DataTable used for sorting starts
var t1 = $('#idReportTable1').DataTable({
	paging : false,
	pageLength: 10,
	pagingType: "simple_numbers",
	info : false,
	filter : false,
	searching : false,
	orderCellsTop : true,
	"columnDefs" : [ {
		"visible" : false,
		"orderable" : false,
		"targets" : 0
	},{
		"visible" : true,
		"orderable" : false,
		"targets" : 1
	} ],
	"order" : [ [ 1, 'asc' ] ],
});

t1.on('order.dt search.dt', function() {
	j = 0;
	t1.column(0, {
		search : 'applied',
		order : 'applied'
	}).nodes().each(function(cell) {
		cell.innerHTML = j + 1;
		j++;
	});
}).draw();

var t2 = $('#idReportTable2').DataTable({
	paging : false,
	pageLength: 10,
	pagingType: "simple_numbers",
	info : false,
	filter : false,
	searching : false,
	orderCellsTop : true,
	"columnDefs" : [ {
		"visible" : false,
		"orderable" : false,
		"targets" : 0
	},{
		"visible" : true,
		"orderable" : false,
		"targets" : [1,2]
	} ],
});

t2.on('order.dt search.dt', function() {
	j = 0;
	t2.column(0, {
		search : 'applied',
		order : 'applied'
	}).nodes().each(function(cell) {
		cell.innerHTML = j + 1;
		j++;
	});
}).draw();
// $('table.table').DataTable({
// 	paging : false,
// 	pageLength: 10,
// 	pagingType: "simple_numbers",
// 	info : false,
// 	filter : false,
// 	searching : false,
// 	orderCellsTop : true,
// 	"columnDefs" : [ {
// 		"visible" : false,
// 		"orderable" : false,
// 		"targets" : 0
// 	},{
// 		"visible" : true,
// 		"orderable" : false,
// 		"targets" : 1
// 	} ],
// 	"order" : [ [ 2, 'asc' ] ],
// }).on('order.dt search.dt', function() {
// 		j = 0;
// 		t.column(0, {
// 			search : 'applied',
// 			order : 'applied'
// 		}).nodes().each(function(cell) {
// 			cell.innerHTML = j + 1;
// 			j++;
// 		});
// 	}).draw();

//DataTable used for sorting starts

</script>