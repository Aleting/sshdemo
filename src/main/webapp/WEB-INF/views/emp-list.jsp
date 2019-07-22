<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script type="text/javascript" src="static/js/jquery-3.4.1.min.js" ></script>
    <title>首页</title>
    <script type="text/javascript">
        $(function () {
            $(".delete").click(function () {
                var lastName = $(this).next(":input").val();
                var flag = confirm("确定要删除"+lastName+"信息吗？");
                var $tr = $(this).parent().parent();
                if (flag){
                    var url = this.href;
                    var args = {"time":new Date()};
                    $.post(url,args,function (data) {
                       if (data == 1){
                           alert("删除成功!");
                           $tr.remove();
                       }else {
                           alert("删除失败!");
                       }
                    })

                }
                return false;
            })
        })
    </script>
</head>
<body>
<h4>Employee List Page</h4>
<s:if test="#request.employees == null || #request.employees.size() == 0">
    没有任何员工信息
</s:if>
<s:else>
    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <td>ID</td>
            <td>LASTNAME</td>
            <td>EMAIL</td>
            <td>BIRTH</td>
            <td>CREATETIME</td>
            <td>DEPT</td>
            <td>DELETE</td>
        </tr>
        <s:iterator value="#request.employees">
            <tr>
                <td>${id }</td>
                <td>${lastName }</td>
                <td>${email }</td>
                <td>${birth }</td>
                <td>${createTime }</td>
                <td>${departmentId }</td>
                <td>
                    <a href="emp-delete?id=${id }" class="delete">DELETE</a>
                    <input type="hidden" value="${lastName }">
                </td>
            </tr>
        </s:iterator>
    </table>

</s:else>
</body>
</html>