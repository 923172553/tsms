<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>添加纳税人</title>
<link rel="stylesheet" type="text/css" href="../../static/css/base.css">
<link rel="stylesheet" type="text/css" href="../../static/easyui/uimaker/easyui.css">
<link rel="stylesheet" type="text/css" href="../../static/easyui/uimaker/icon.css">
<link rel="stylesheet" type="text/css" href="../../static/css/edit.css">
<link rel="stylesheet" type="text/css" href="../../static/webuploader/webuploader.css">
</head>
<body>
	<div class="container">
		<div class="content">
			<form id="addForm" method="post">
				<div title="纳税人信息" data-options="closable:false" class="basic-info">
					<div class="column">
						<span class="current">添加纳税人信息</span>
					</div>

					<table class="kv-table" id="addPayer">
						<tbody>
							<tr>
								<td class="kv-label">纳税人识别号</td>
								<td class="kv-content"><input type="text" name="payerCode"
									placeholder="纳税人识别号"></td>
								<td class="kv-label">纳税人名称</td>
								<td class="kv-content"><input type="text" name="payerName"
									placeholder="纳税人名称"></td>
							</tr>
							<tr>
								<td class="kv-label">生产经营地址</td>
								<td class="kv-content"><input type="text" name="bizAddress"
									placeholder="生产经营地址"></td>
								<td class="kv-label">经营地电话</td>
								<td class="kv-content"><input type="text"
									name="bizAddressPhone" placeholder="生产经营地电话"></td>
							</tr>
							<tr>
								<td class="kv-label">所属税务机关</td>
								<td class="kv-content"><select name="taxOrganId"
									id="selectOrgan" >
										<option value="-1">请选择税务机关</option>
												<option value="1">中国国税局</option>
                            					<option value="2">北京国税局</option>
                            					<option value="3">天津国税局</option>
                            					<option value="4">上海国税局</option>
                            					<option value="5">深圳国税局</option>
                            					<option value="6">武汉国税局</option>
                            					<option value="7">杭州国税局</option>
                            					<option value="8">郑州国税局</option>	
								</select></td>
								<td class="kv-label">行业</td>
								<td class="kv-content"><select name="industryId"
									id="selectIndustry" >
										<option value="-1">请选择行业</option>
                            						<option value="1">计算机</option>
                           							<option value="2">房地产</option>
                            						<option value="3">生物医药</option>
                            						<option value="4">金融</option>
                            						<option value="5">汽车工业</option>
                           							<option value="6">通讯工程</option>
								</select></td>
							</tr>
							<tr>
								<td class="kv-label">生产经营范围</td>
								<td class="kv-content"><input type="text" name="bizScope"
									placeholder="生产经营范围"></td>
								<td class="kv-label">票种核定</td>
								<td class="kv-content"><select
									name="invoiceType">
										<option value="-1">请选择发票种类</option>
										<option value="1">增值税普通发票</option>
										<option value="2">增值税专用发票</option>
								</select></td>
							</tr>
							<tr>
								<td class="kv-label">法人代表人</td>
								<td class="kv-content"><input type="text"
									name="legalPerson" placeholder="法人姓名"></td>
								<td class="kv-label">法人身份证号</td>
								<td class="kv-content"><input type="text"
									name="legalIdCard" placeholder="法人代表身份证号码"></td>
							</tr>
							<tr>
								<td class="kv-label">主管财务</td>
								<td class="kv-content"><input type="text" name="finaceName"
									placeholder="主管财务"></td>
								<td class="kv-label">财务身份证号</td>
								<td class="kv-content"><input type="text"
									name="finaceIdCard" placeholder="财务身份证号"></td>
							</tr>

							<tr>
								<td class="kv-label">法人身份证照片</td>
								<td class="kv-content"><img id="chooseLegalIdCardPreview"
									alt="" src="" />
									<div id="chooseLegalIdCard">选择文件</div> <input type="hidden"
									name="legalIdCardImageURL" id="legalIdCardUrl" /></td>
								<td class="kv-label">财务身份证照片</td>
								<td class="kv-content"><img id="chooseFinaceIdCardPreview"
									alt="" src="" />
									<div id="chooseFinaceIdCard">选择文件</div> <input type="hidden"
									name="finaceIdCardImageURL" id="finaceIdCardUrl" /></td>
							</tr>
							<tr>
								<td class="kv-label">录入人员</td>
								<td class="kv-content">
								<label>章莉</label>
								</td>
								<td class="kv-label">当前时间</td>
								<td class="kv-content"  value="2017-01-20">2018-07-12
								</td>
							</tr>
						</tbody>

					</table>
				</div>
				<div class="btn-selection">
					<input type="submit" class="easyui-linkbutton submit-btn" id="savePayer" data-options="selected:true">
					<input type="reset" class="easyui-linkbutton reset-btn" id="reset" data-options="selected:true">
				</div>
			</form>
		</div>
	</div>
</body>

<script type="text/javascript" src="../../static/jquery/jquery.min.js"></script>
<script type="text/javascript" src="../../static/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../static/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../../static/js/calendar.js"></script>
<script type="text/javascript">
	$(function() {
		$("#savePayer").click(function() {
			$("#addForm").submit(function(e) {
			e.preventDefault();
			$.post(
			"../../Tb_Tax_PayerAddServlet.json",
			$(this).serialize(),
			function(data) {
				if(data.success){
					parent.$.messager.alert({
	       				title:"提示",
	       				msg:data.msg,
       				}) 
       				parent.$("#topWindow").window("close") 
				}else{
					$.messager.alert({
	           			title:"提示",
	           			msg:data.msg,
        			})
				}
			},
			"json"
			)	
			})
		})
		
		
		
		
		
		
		
	})


</script>
<!-- <script type="text/javascript">
	//添加纳税人
		$("#savePayer").on("click",function(){
			var isValid = $('#addForm').form('validate');
			if(!isValid){
				return;
			}	
			$.post("../../Tb_Tax_PayerAddServlet.json",$("#addForm").serialize(),function(data){				
				if(data.success){
       				parent.$.messager.alert({
	       				title:"提示",
	       				msg:data.msg,
       				}) 
       				parent.$("#topWindow").window("close")      				
     			}else{
    				$.messager.alert({
	           			title:"提示",
	           			msg:data.msg,
        			})
     			}
			},"json")			
		})
		//重置
		$("#reset").on("click",function(){
			$("#addForm").form("reset")
		})
	</script>
	
	<script type="text/javascript">
		//上传处理
		var chooseLegalIdCardUploader = WebUploader.create({
			// 选完文件后，是否自动上传。
		    auto: true,
		    // swf文件路径
		    swf: 'https://cdn.bootcss.com/webuploader/0.1.1/Uploader.swf',		
		    // 文件接收服务端。
		    server: 'http://localhost:8080/TaxSource/uploadImg.do',		
		    // 选择文件的按钮。可选。
		    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
		    pick: '#chooseLegalIdCard',		
		    // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
		    resize: false,
		    // 只允许选择图片文件。
		    accept: {
		        title: 'Images',
		        extensions: 'gif,jpg,jpeg,bmp,png',
		        mimeTypes: 'image/*'
		    }
		});
		chooseLegalIdCardUploader.on('fileQueued', function( file ) {
			chooseLegalIdCardUploader.makeThumb( file, function( error, src ) {
		        if (error) {
		            $("#chooseLegalIdCardPreview").replaceWith('<span>不能预览</span>');
		            return;
		        }
		        $("#chooseLegalIdCardPreview").attr( 'src', src );
		    }, 100, 100 );
		});
		//文件上传成功接受回调信息
		chooseLegalIdCardUploader.on('uploadSuccess', function (file,response) {
			 alert('文件上传成功');
			 $("#legalIdCardUrl").val(response.url);
	    });
		
		//上传处理
		var chooseFinaceIdCardUploader = WebUploader.create({	
			// 选完文件后，是否自动上传。
		    auto: true,
		    // swf文件路径
		    swf: 'https://cdn.bootcss.com/webuploader/0.1.1/Uploader.swf',		
		    // 文件接收服务端。
		    server: '/TaxSource/uploadImg.do',		
		    // 选择文件的按钮。可选。
		    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
		    pick: '#chooseFinaceIdCard',		
		    // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
		    resize: false,
		    // 只允许选择图片文件。
		    accept: {
		        title: 'Images',
		        extensions: 'gif,jpg,jpeg,bmp,png',
		        mimeTypes: 'image/*'
		    }
		});
		
		chooseFinaceIdCardUploader.on('fileQueued', function( file ) {
			chooseFinaceIdCardUploader.makeThumb( file, function( error, src ) {
		        if (error) {
		            $("#chooseFinaceIdCardPreview").replaceWith('<span>不能预览</span>');
		            return;
		        }
		        $("#chooseFinaceIdCardPreview").attr( 'src', src );
		    }, 100, 100 );
		});
		//文件上传成功接受回调信息
		chooseFinaceIdCardUploader.on('uploadSuccess', function (file,response) {
			 alert('文件上传成功');
			 $("#finaceIdCardUrl").val(response.url);
	    });
	</script> -->
</html>
