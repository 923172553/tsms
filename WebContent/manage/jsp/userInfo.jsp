<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>任务录入</title>
    <link rel="stylesheet" type="text/css" href="static/css/base.css" >
    <link rel="stylesheet" type="text/css" href="static/easyui/uimaker/easyui.css">
    <link rel="stylesheet" type="text/css" href="static/easyui/uimaker/icon.css">
    <link rel="stylesheet" type="text/css" href="static/css/edit.css">
  </head>
  <style>
  	input{
  		readonly:true
  	}  
  </style>
  <body>
   <div class="container">
    <div class="content">
        <div title="纳税人信息" data-options="closable:false" class="basic-info">
            <div class="column"><span class="current">用户基本信息</span></div>
            <table class="kv-table">
                <tbody>
                <tr>
                    <td class="kv-label">用户员工编号</td>
                    <td class="kv-content"><input type="text" value="${list.id }" name="payerCode" ></td>
                    <td class="kv-label">用户权限</td>
                    <td class="kv-content"><label>${list.permissionId }</label> </td>
                    <td class="kv-label">用户状态</td>
                    <td class="kv-content"><label>${list.state }</label> </td>
                </tr>
                <tr>
                    <td class="kv-label">税务人员工号</td>
                    <td class="kv-content"><label>${list.taxerCode }</label> </td>
                    <td class="kv-label">税务人员名称</td>
                    <td class="kv-content"><label>${list.taxerName }</label> </td>
                    <td class="kv-label">税务人员电话</td>
                    <td class="kv-content"><label>${list.mobile }</label> </td>
                </tr>
                <tr>
                    <td class="kv-label">地址</td>
                    <td class="kv-content"><label>${list.address }</label> </td>
                    <td class="kv-label">性别</td>
                    <td class="kv-content"><label>${list.sex }</label> </td>
                    <td class="kv-label">出生日期</td>
                    <td class="kv-content"><label>${list.birthday }</label> </td>
                </tr>
                <tr>
                    <td class="kv-label">邮箱</td>
                    <td class="kv-content"><label>${list.email }</label> </td>
                    <td class="kv-label">税务机关</td>
                    <td class="kv-content"><label>${list.organId }</label> </td>
                    <td class="kv-label">税务状态</td>
                    <td class="kv-content"><label>${list.state }</label> </td>
                </tr>
                <tr>
                    <td class="kv-label">上级主管</td>
                    <td class="kv-content"><label>${list.mgr }</label> </td>
                    <td class="kv-label">系统管理员标志</td>
                    <td class="kv-content"><label>${list.admin }</label> </td>
                    <td class="kv-label">记录日期</td>
                    <td class="kv-content"><label>${list.recordDate }</label> </td>
                </tr>
                </tbody>
            </table>
         </div>
    </div>
</div>
<script type="text/javascript">
    $("input[name=executeTime]").datebox({
        formatter: easyUIFormater,
        parser: easyUIparser
    });
</script>
  </body>
</html>
