<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>办税专员管理</title>

<link href="../../static/css/base.css" rel="stylesheet">
<link rel="stylesheet"
	href="../../static/easyui/uimaker/easyui.css">
<link rel="stylesheet" type="text/css"
	href="../../static/easyui/uimaker/icon.css">
<link rel="stylesheet" href="../../static/css/taxpayer.css">
  <style type="text/css">
	.a{
		text-decoration: none;
	}
</style>
</head>
<body>
	<div class="container">
		<table id="dg">
		</table>
		<div id="tb" style="padding: 0 30px;">
			办税专员名称: <input type="text" name="taxerName" id="taxerName"
				style="width: 166px; height: 35px; line-height: 35px;" />
				<a href="javascript:void(0);" id="searchBtn" class="easyui-linkbutton"
				iconCls="icon-search" data-options="selected:true">查询</a> <a
				href="javascript:void(0);" id="setBtn" class="easyui-linkbutton"
				iconCls="icon-reload">重置</a> <a href="javascript:void(0);"
				id="addBtn" class="easyui-linkbutton" iconCls="icon-add">添加办税专员</a>
		</div>
	</div>
	<script type="text/javascript"
		src="../../static/jquery/jquery.min.js"></script>
	<script type="text/javascript"
		src="../../static/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript"
		src="../../static/easyui/easyui-lang-zh_CN.js"></script>
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
		
        //查询
    	   function doSearch(){     	   
			   $("#dg").datagrid("load",{		
					"taxerName": $("#taxerName").val()
				});
			}
        //删除
        function removeTaxPayer(id){
     	   $.messager.confirm('操作提示', '确定要删除吗?', function(r){
	  				if (r){
	  					$.post("../../Tb_TaxerUpdateServlet.do",{"id":id},function(data){
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
        //详情
        function detail(id){	          
	           	openTopWindow({"url":"../../Tb_TaxerInfoServlet.do?id="+id,
	   		 	"title":"办税专员信息",	   		 	
	   		 	 width : 750,
              height : 500,
				})
	           	doSearch()	           	          
        }
        //修改 
 		function edit(id){	          
	   		 	openTopWindow({"url":"../../Tb_TaxerXiuGaiServlet.d0?id="+id,
	   		 	title:"修改办税专员信息",	   		 	
	   		 	 width : 750,
              height : 600,
				})
				doSearch()      	          
  		}    
	</script>
	
	
<script type="text/javascript">
	$('#dg').datagrid({    
	    url:'../../Tb_TaxerServlet.json',
	    method:"POST",
	    toolbar:"#tb",
	    loadMsg:'拼命加载中',
	    striped:true,
	    pagination:true,
	    resizable:false,
	    columns:[[    
	          
	        {field:'taxerCode',title:'办税专员编号',width:100},    
	        {field:'taxerName',title:'办税专员名称',width:100,align:'center'},
	        {field:'mobile',title:'手机号',width:100,align:'center'}, 
	        {field:'address',title:'地址',width:100,align:'center'}, 
	        {field:'email',title:'邮件',width:150,align:'center'}, 
	      
	        {field:'cz',title:'操作',width:100,align:'center',
	        	formatter:function(value,row,index){
	        		 return "<a href='javascript:void(0)' onclick='detail("+row.id+")'>详情   </a>"
	                    +"<a href='javascript:void(0)' onclick='removeTaxPayer("+row.id+")'>删除   </a>"
	                    +"<a href='javascript:void(0)' onclick='edit("+row.id+")'>修改   </a>" 
	        }	
	        
	        } 
	       
	    ]]    
	});
	
	
	  //查询事件
	   $("#searchBtn").on("click",function(){      	   
     	     doSearch()
     	   })
     	   
     	   //添加页面事件
     	  $("#addBtn").on("click",function(e){
            openTopWindow({
                width : 750,
                height : 600,
                title : "新增办税专员",
                url : "addTaxer.jsp"
            });
            doSearch()
         });
        //重置 
        $("#setBtn").on("click",function(e){
        //文本框的内容清空
        	$("#taxerName").val("");           
       
              
     });

</script>
</body>
</html>