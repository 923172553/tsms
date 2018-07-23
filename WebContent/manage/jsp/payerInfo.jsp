<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>修改纳税人</title>
    <link href="static/css/base.css" rel="stylesheet">
    <link rel="stylesheet" href="static/easyui/uimaker/easyui.css">
    <link rel="stylesheet" type="text/css" href="static/easyui/uimaker/icon.css">
    <link href="static/css/edit.css" rel="stylesheet">

  </head>
  <body>
     <div class="container">
        <div class="content">
            <div title="纳税人信息" class="basic-info">
                <div class="column"><span class="current">纳税人信息</span></div>
                <form id="editForm">
                <table class="kv-table">              	
                    <tbody>                 
                    <tr>
                        <td class="kv-label">纳税人识别号</td>
                        <td class="kv-content"><label>${list.payerCode}</label></td>
                        <td class="kv-label">纳税人名称</td>
                        <td class="kv-content"><label>${list.payerName}</label></td>
                    </tr>
                    <tr>
                        <td class="kv-label">生产经营地址</td>
                        <td class="kv-content"><label>${list.bizAddress }</label></td>
                        <td class="kv-label">生产经营地电话</td>
                        <td class="kv-content"><label>${ list.bizAddressPhone} </label></td>
                    </tr>
                    <tr>
                        <td class="kv-label">所属税务机关</td>
                        <td class="kv-content"> 
                           	<label>${list.organName }</label>                                           
                        </td>
                        <td class="kv-label">行业</td>
                        <td class="kv-content">
                            	<label>${ list.industryName}</label>                                     
                        </td>
                    </tr>
                    <tr>
                        <td class="kv-label">生产经营范围</td>
                        <td class="kv-content">
                            <label>${list.bizScope  }</label>
                        </td>
                        <td class="kv-label">票种核定</td>
                        <td class="kv-content">
                              <label>${ list.invoiceType }</label>                                
                        </td>
                    </tr>
                    <tr>
                        <td class="kv-label">法人代表人</td>
                        <td class="kv-content">
                            <label>${list.legalPerson}</label>
                        </td>
                        <td class="kv-label">法人身份证号</td>
                        <td class="kv-content">
                            <label>${list.legalIdCard }</label>
                        </td>
                    </tr>
                    <tr>
                        <td class="kv-label">主管财务</td>
                        <td class="kv-content">
                            <label>${ list.finaceName  }</label>
                        </td>
                        <td class="kv-label">财务身份证号</td>
                        <td class="kv-content">
                            <label>${list.finaceIdCard }</label>
                        </td>
                    </tr>
                    
                      <tr>
                        <td class="kv-label">法人身份证照片</td>
                        <td class="kv-content">
                        	<img id="chooseLegalIdCardPreview" alt=""  width="100" height="50"/>
                        </td>
                        <td class="kv-label">财务身份证照片</td>
                        <td class="kv-content">
                        	<img id="chooseFinaceIdCardPreview" alt=""  width="100" height="50"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="kv-label">录入人员</td>
                        <td class="kv-content">
                            <label>${ list.username}</label>                               
                        </td>
                        <td class="kv-label">录入日期</td>
                        <td class="kv-content">${ list.recordDate}</td>
                         
                    </tr>
                    </tbody>                                
                </table>
                </form>
            </div>         
        </div>
    </div>
  </body>
</html>