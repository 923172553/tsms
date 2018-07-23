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
<style type="text/css">
#editPayer{
	width:100px;
	height:40px;
	background-color: #1da02b;
	border:none;
	color: white;
	margin-left:20px; 
}
#reset{
	width:100px;
	height:40px;
	background-color: #f45438;
	border:none;
	color: white;

}


</style>    
  </head>
  <body>
     <div class="container">
        <div class="content">
        <form id="editForm" method="post">
            <div title="纳税人信息" data-options="closable:false" class="basic-info">
                <div class="column"><span class="current">修改纳税人信息</span></div>
                
                <input name="id" id="id" value="${list.id }" type="hidden">
                <table class="kv-table">              	
                    <tbody>                 
                    <tr>
                        <td class="kv-label">纳税人识别号</td>
                        <td class="kv-content"> <input type="text" name="payerCode" readonly="readonly" value="${list.payerCode }" > </td>
                        <td class="kv-label">纳税人名称</td>
                        <td class="kv-content"><input type="text" name="payerName" value="${list.payerName  }" placeholder="纳税人名称" ></td>
                    </tr>
                    <tr>
                        <td class="kv-label">生产经营地址</td>
                        <td class="kv-content"><input type="text" name="bizAddress" value="${list.bizAddress  }" placeholder="生产经营地址" ></td>
                        <td class="kv-label">生成经营地电话</td>
                        <td class="kv-content"><input type="text" name="bizAddressPhone" value="${list.bizAddressPhone   }" placeholder="生产经营地电话" ></td>
                    </tr>
                    <tr>
                        <td class="kv-label"  >所属税务机关</td>
                        <td class="kv-content">
                            <select name="taxOrganId" id="selectOrgan">
                             <option value="${list.taxOrganid }">${list.organName }</option>
                            <option value="-1">请选择所属税务机关</option>
								<option value="1">中国国税局</option>
                            	<option value="2">北京国税局</option>
                            	<option value="3">天津国税局</option>
                            	<option value="4">上海国税局</option>
                            	<option value="5">深圳国税局</option>
                            	<option value="6">武汉国税局</option>
                            	<option value="7">杭州国税局</option>
                            	<option value="8">郑州国税局</option>	
                            
                            </select>
                        </td>
                        <td class="kv-label">行业</td>
                        <td class="kv-content">
                            <select name="industryId" id="selectIndustry">
                            <option value="${list.ndustryId  }">${list.industryName}</option> 
                            <option value="-1">请选择行业</option>
                            <option value="1">计算机</option>
                            <option value="2">房地产</option>
                            <option value="3">生物医药</option>
                            <option value="4">金融</option>
                            <option value="5">汽车工业</option>
                            <option value="6">通讯工程</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="kv-label">生产经营范围</td>
                        <td class="kv-content">
                            <input type="text" name="bizScope" value="${list.bizScope   }" placeholder="生产经营范围">
                        </td>
                        <td class="kv-label">票种核定</td>
                        <td class="kv-content">
                            <select name="invoiceType">
                            	<option value="${list.invoiceType } ">${list.invoiceType }</option>
                                <option value="-1">请选择发票种类</option>
                                <option value="增值税普通发票" >增值税普通发票</option>
                                <option value="增值税专用发票" >增值税专用发票</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="kv-label">法人代表人</td>
                        <td class="kv-content">
                            <input type="text" name="legalPerson" value="${list.legalPerson  }" placeholder="法人姓名">
                        </td>
                        <td class="kv-label">法人身份证号</td>
                        <td class="kv-content">
                            <input type="text" name="legalIdCard" value="${list.legalIdCard   }"  placeholder="法人代表身份证号码">
                        </td>
                    </tr>
                    <tr>
                        <td class="kv-label">主管财务</td>
                        <td class="kv-content">
                            <input type="text" name="finaceName" value="${list.finaceName  }" placeholder="主管财务">
                        </td>
                        <td class="kv-label">财务身份证号</td>
                        <td class="kv-content">
                            <input type="text" name="finaceIdCard" value="${list.finaceIdCard   }" placeholder="财务身份证号">
                        </td>
                    </tr>
                    <tr>
                        <td class="kv-label">办税人员</td>
                        <td class="kv-content">
                           <label>${list.tn}</label>
                        </td>
                        <td class="kv-label">录入日期</td>
                        <td class="kv-content">${list.recordDate}</td>
                    </tr>
                    </tbody>                                
                </table>
               
            </div>
            <div class="btn-selection">
                <input   type="submit" class="easyui-linkbutton submit-btn" id="editPayer" data-options="selected:true" value="修改">
                <input   type="reset" class="easyui-linkbutton reset-btn" id="reset" data-options="selected:true" value="重置">
            </div>
             </form>
        </div>
    </div>
  </body>
  <script type="text/javascript" src="static/jquery/jquery.min.js"></script>
<script type="text/javascript" src="static/easyui/jquery.easyui.min.js"></script>
 <script type="text/javascript" src="static/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="static/js/calendar.js"></script>
<script type="text/javascript">
    $("input[name=executeTime]").datebox({
        formatter: easyUIFormater,
        parser: easyUIparser
    }); 
    
    $(function(){
    	$("#editPayer").on("click",function(){
    		var isValid = $('#editForm').form('validate');
			if(!isValid){
				return;
			}	
    		$.post("Tb_Tax_PayerXiuGai01Servlet.do",$("#editForm").serialize(),function(data){
    			if(data.success){
       				parent.$.messager.alert({
       					title:"提示",
       					msg:data.msg
       				})
       				parent.$("#topWindow").window("close")
					//parent.doSearch()	
     			}else{
    				$.messager.alert({
	           			title:"提示",
	           			msg:data.msg
			        })
			     } 			
    		},"json")    	    	
    	})
    	$("#reset").on("click",function(){
			$("#editForm").form("reset")
		})           
    })
    
</script>

</html>
