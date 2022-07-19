<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style='text-align: center;'>
	<a class='btn btn-info'
		<c:if test="${p.pageNumber==1}">disabled</c:if>
		<c:if test="${p.pageNumber!=1}">href="${pageContext.request.contextPath}${param.url}?pageNo=1${param.param}"</c:if>>首页</a>
	<a class='btn btn-info'
		<c:if test="${p.pageNumber==1}">disabled</c:if>
		<c:if test="${p.pageNumber!=1}">href="${pageContext.request.contextPath}${param.url}?pageNo=${p.pageNumber-1}${param.param}"</c:if>>上一页</a>
	<h2 style='display: inline;'>[${p.pageNumber}/${p.totalPage}]</h2>
	<h2 style='display: inline;'>[${p.totalCount}]</h2>
	<a class='btn btn-info'
		<c:if test="${p.totalPage==0 || p.pageNumber==p.totalPage}">disabled</c:if>
		<c:if test="${p.pageNumber!=p.totalPage}">href="${pageContext.request.contextPath}${param.url}?pageNo=${p.pageNumber+1}${param.param}"</c:if>>下一页</a>
	<a class='btn btn-info'
		<c:if test="${p.totalPage==0 || p.pageNumber==p.totalPage}">disabled</c:if>
		<c:if test="${p.pageNumber!=p.totalPage}">href="${pageContext.request.contextPath}${param.url}?pageNo=${p.totalPage}${param.param}"</c:if>>尾页</a>
	<input type='text' class='form-control'
		style='display: inline; width: 60px;' value='' /><a
		class='btn btn-info' href='javascript:void(0);'
		onclick='location.href="${pageContext.request.contextPath}${param.url}?pageNo="+(this.previousSibling.value)+"${param.param}"'>GO</a>
</div>    
