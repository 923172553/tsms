<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>任务录入</title>
    <link href="static/css/base.css" rel="stylesheet">
    <link rel="stylesheet" href="static/easyui/uimaker/easyui.css">
    <link rel="stylesheet" type="text/css" href="static/easyui/uimaker/icon.css">
    <link href="static/css/edit.css" rel="stylesheet">
  </head>
  <body>
    <div class="container">
    <div class="content">
        <div title="纳税人信息" data-options="closable:false" class="basic-info">
            <div class="column"><span class="current">纳税人基本信息</span></div>
            <table class="kv-table">
                <tbody>
                <tr>
                    <td class="kv-label">纳税人识别号</td>
                    <td class="kv-content"><label>${list1.payerCode }</label></td>
                    <td class="kv-label">纳税人名称</td>
                    <td class="kv-content"><label>${list1.payerName  }</label></td>
                    <td class="kv-label">生产经营地址</td>
                    <td class="kv-content"><label>${list1.bizAddress }</label></td>
                </tr>
                <tr>
                    <td class="kv-label">所属税务机关</td>
                    <td class="kv-content"><label>${list1.organName  }</label></td>
                    <td class="kv-label">行业</td>
                    <td class="kv-content"><label>${list1.industryName  }</label></td>
                    <td class="kv-label">经营范围</td>
                    <td class="kv-content"><label>${list1.bizScope  }</label></td>
                </tr>
                <tr>
                    <td class="kv-label">票种核定</td>
                    <td class="kv-content"><label>${list1.invoiceType }</label></td>
                    <td class="kv-label">法人代表人</td>
                    <td class="kv-content"><label>${list1.legalPerson  }</label></td>
                    <td class="kv-label">法人身份证号</td>
                    <td class="kv-content"><label>${list1.legalIdCard   }</label></td>
                </tr>
                <tr>
                    <td class="kv-label">主管财务</td>
                    <td class="kv-content"><label>${list1.finaceName  }</label></td>
                    <td class="kv-label">财务身份证号</td>
                    <td class="kv-content"><label>${list1.finaceIdCard  }</label></td>
                    <td class="kv-label">税收管理员</td>
                    <td class="kv-content"><label>${list1.taxerName   }</label></td>
                </tr>
                <tr>
                	<td class="kv-label">办税人</td>
                    <td class="kv-content"><label>${list1.taxerName }</label></td>
                    <td class="kv-label">录入日期</td>
                    <td class="kv-content"><label>${list1.recordDate }</label></td>
                    <td class="kv-label">录入人</td>
                    <td class="kv-content"><label>${list1.username  }</label></td>
                </tr>
                </tbody>
            </table>
            <div class="column"><span class="current">任务信息</span></div>
            <table class="kv-table">
                <tbody>
                <tr>
                    <td class="kv-label">任务名称</td>
                    <td class="kv-content"><label>${list2.taskName  }</label></td>
                    <td class="kv-label">下达部门</td>
                    <td class="kv-content"><label>${list1.organName  }</label></td>
                    <td class="kv-label">批准人</td>
                    <td class="kv-content"><label>${list2.taxerName }</label></td>
                </tr>
               
                <tr>
                	<td class="kv-label">执行人</td>
                    <td class="kv-content"><label>${list3.taxerName}</label></td>
                 	<td class="kv-label">执行时间</td>
                    <td class="kv-content"><label>${list2.executeTime }</label></td>
                    
                    <td class="kv-label">任务执行情况</td>
                    <td class="kv-content">
                        <textarea rows="3"  readonly style="width: 90%;">${list2.taskState }</textarea>
                    </td>
                </tr>
                </tbody>
            </table>
                      
    </div>
</div>
  </body>
</html>