<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>

<script>
</script>

<title>用户管理</title>

<div class="workingArea">
    <h1 class="label label-info" >用户管理</h1>
    <h1 class="label label-info" >用户添加</h1>

    <br>
    <br>

    <div class="listDataTableDiv">
        <table class="table table-striped table-bordered table-hover  table-condensed">
            <thead>
            <tr class="success">
                <th>ID</th>
                <th>用户名称</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${us}" var="u">
                <tr>
                    <td>${u.id}</td>
                    <td>${u.name}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="pageDiv">
        <%@include file="../include/admin/adminPage.jsp" %>
    </div>

    <div class="panel panel-warning addDiv">
        <div class="panel-heading">新增管理员</div>
        <div class="panel-body">
            <form method="post" id="addForm" action="admin_user_add" enctype="multipart/form-data">
                <table class="addTable">
                    <tr>
                        <td>用户名</td>
                        <td><input  id="name" name="name" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>密码</td>
                        <td><input  id="password" name="password" type="text" class="form-control"></td>
                    </tr>

                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <button type="submit" class="btn btn-success">提 交</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>


</div>

<%@include file="../include/admin/adminFooter.jsp"%>