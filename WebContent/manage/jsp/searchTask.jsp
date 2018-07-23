<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>任务查询</title>
<link href="../../static/css/base.css" rel="stylesheet">
<link rel="stylesheet" href="../../static/easyui/uimaker/easyui.css">
<link rel="stylesheet" type="text/css" href="../../static/easyui/uimaker/icon.css">
<style type="text/css">
 .a {
	text-decoration: none;
} 
</style>
</head>
<body>
	<div class="container">
		<table id="dg">
		</table>
		<div id="tb" style="padding: 0 30px;">
			<form id="conForm">
			
				<div class="conditions">
					<span class="con-span">纳税人识别号: </span><input type="text"
						name="payerCode"
						style="width: 166px; height: 35px; line-height: 35px;"> <span
						class="con-span">纳税人名称: </span><input type="text" name="payerName"
						style="width: 166px; height: 35px; line-height: 35px;"> <span
						class="con-span">税务机关: </span> <select name="subOrganId"
						style="width: 166px; height: 35px; line-height: 35px;">
						<option value="-1">请选择税务机关</option>
						   <option value="1">中国国税局</option>
                           <option value="2">北京国税局</option>
                           <option value="3">天津国税局</option>
                           <option value="4">上海国税局</option>
                           <option value="5">深圳国税局</option>
                           <option value="6">武汉国税局</option>
                           <option value="7">杭州国税局</option>
                           <option value="8">郑州国税局</option>	
					</select> <span class="con-span">行业: </span> <select name="industryId"
						style="width: 166px; height: 35px; line-height: 35px;">
						<option value="-1">请选择行业</option>
							<option value="1">计算机</option>
                           	<option value="2">房地产</option>
                            <option value="3">生物医药</option>
                            <option value="4">金融</option>
                            <option value="5">汽车工业</option>
                           	<option value="6">通讯工程</option>
					</select>
				</div>
				<div class="conditions">
					<span class="con-span">任务开始时间(执行): </span><input
						class="easyui-datebox" type="text" name="startDate"
						style="width: 166px; height: 35px; line-height: 35px;"> <span
						class="con-span">任务结束时间(执行): </span><input class="easyui-datebox"
						type="text" name="endDate"
						style="width: 166px; height: 35px; line-height: 35px;"> <a
						href="javascript:void(0);" class="easyui-linkbutton"
						iconCls="icon-search" id="searchTask" data-options="selected:true">查询</a>
					<a href="javascript:void(0);" class="easyui-linkbutton"
						id="resetTask" iconCls="icon-reload">重置</a> 
				</div>
			</form>
		</div>
	</div>

</body>
<script type="text/javascript" src="../../static/jquery/jquery.min.js"></script>
<script type="text/javascript" src="../../static/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../static/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	/**
	 *打开在父窗口中打开window
	 */
	function openTopWindow(options) {
		options = !options ? {} : options;
		options.width = !options.width ? 500 : options.width;
		options.height = !options.height ? 400 : options.height;
		options.title = !options.title ? "" : options.title;
		parent.$("#iframe").attr("src", options.url);
		parent.$("#topWindow").window({
			title : options.title,
			width : options.width,
			height : options.height,
			modal : true,
			resizable : true,
			collapsible : false,
		});
		
	}
	
    /**
	    *   添加处理函数
	  	**/
	     //查询任务详细信息
	     function detail(id){    	           
		    openTopWindow({"url":"../../Tb_Tax_SourceXiangQingServlet.do?id="+id,
		   	"title":"任务信息",	   		 	
		   	 width : 750,
	         height : 600,
			})
		    doSearch()	           	             
	     }
	     //删除任务详细
	      function removeTask(id){	
	    	  $.messager.confirm('操作提示', '确定要删除吗?', function(r){
					if (r){
					     $.post(
					    	"../../Tb_Tax_SourceUpdateServlet.do",{"id":id},function(data){
					       if(data.success){
			           			alert(data.msg)
			           			doSearch()	
			           		}else{
			           			alert(data.msg)
			           		}
					    },"json")
					    doSearch()	   
					}
	  		   });
	      }
	     //修改任务详细
	     function edit(id){
	     	openTopWindow({url:"../../Tb_Tax_SourceXiuGai01.do?id="+id,
		   		  title:"修改任务信息",	   		 	
		   		  width : 850,
	              height : 700,
			})
			doSearch() 
	     }
	 	//查询操作函数定义
	    function doSearch(){  
			$("#dg").datagrid("reload","../../Tb_Tax_SourceServlet.do?"+$("#conForm").serialize())
		}
	
</script>
<script type="text/javascript">
 $(function(){
       		//初始化表格
    $(function(){
       	   $("#dg").datagrid({
	       	   title:"纳税人信息",
	       	   toolbar:"#tb",
	       	   url:"../../Tb_Tax_SourceServlet.do",
	       	   method:"POST",
	       	   loadMsg:"数据加载中..",
	       	   coolapsible:true,
	       	   pagination:true,
	       	   striped:true,  
	       	   columns:[[
       	   	  		{field:"taskName","title":"任务名称"},
                    {field:"payerCode","title":"纳税人识别号"},
                    {field:"payerName","title":"纳税人名称"},
                    {field:"industryName","title":"行业"},
                    {field:"bizScope","title":"经营范围"},
                    {field:"executeTime","title":"执行时间"},
                    {field:"recordTaskDate","title":"录入时间"},
                    {field:"timeOut","title":"录入超时(天)"},  
                    {field:"opreation","title":"操作",formatter:function(value,row,index){
                    return "<a href='javascript:void(0)' onclick='detail("+row.id+")'>查看任务详情   </a>"
                    +"<a href='javascript:void(0)' onclick='removeTask("+row.id+")'>删除   </a>"
                    +"<a href='javascript:void(0)' onclick='edit("+row.id+")'>修改   </a>"                              
                    }}   
       	        ]]      	          	   
       	    })  
     })	
     //查询操作
     $("#searchTask").on("click",function(){   
    	 doSearch()
     })
     //重置操作
     $("#resetTask").on("click",function(){
     	$("#conForm").form("reset")
     })
     
   })       
    </script>
</html>
