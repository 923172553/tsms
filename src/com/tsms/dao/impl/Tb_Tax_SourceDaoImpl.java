package com.tsms.dao.impl;

import java.util.List;
import java.util.Map;

import com.tsms.dao.Tb_Tax_SourceDao;
import com.tsms.entity.Tb_Tax_Source;
import com.tsms.util.DBUtil;
import com.tsms.util.StringUtil;

public class Tb_Tax_SourceDaoImpl implements Tb_Tax_SourceDao {
	private DBUtil db=DBUtil.getInstance();
	/*
	 * 分页查询
	 * @see com.tsms.dao.Tb_Tax_SourceDao#getAllTb_Tax_Sources(int, int)
	 */
	@Override
	public List<Map<String, String>> getAllTb_Tax_Sources(int pageNo, int pageSize,String payerCode,String payerName,String organName,String industryName) {
		List<Map<String, String>> list=null;
		if(StringUtil.isNotBlank(payerCode)){
			 list= db.query("select * from  tb_tax_source s, tb_tax_payer p, tb_tax_organ o, tb_industry i where s.payerId=p.id and p.industryId=i.id and p.taxOrganId=o.id and s.removeState=0 and payerCode=? limit ?,?",payerCode, (pageNo - 1)*pageSize,pageSize);	

		}else  if(StringUtil.isNotBlank(payerName)){
			 list=db.query("select * from  tb_tax_source s, tb_tax_payer p, tb_tax_organ o, tb_industry i where s.payerId=p.id and p.industryId=i.id and p.taxOrganId=o.id and s.removeState=0 and payerName=? limit ?,?",payerName, (pageNo - 1)*pageSize,pageSize);
		}else if(StringUtil.isNotBlank(organName)){
			 list= db.query("select * from  tb_tax_source s, tb_tax_payer p, tb_tax_organ o, tb_industry i where s.payerId=p.id and p.industryId=i.id and p.taxOrganId=o.id and s.removeState=0 and organName=? limit ?,?",organName, (pageNo - 1)*pageSize,pageSize);	

		}else if(StringUtil.isNotBlank(industryName)){
			 list= db.query("select * from  tb_tax_source s, tb_tax_payer p, tb_tax_organ o, tb_industry i where s.payerId=p.id and p.industryId=i.id and p.taxOrganId=o.id and s.removeState=0 and industryName=? limit ?,?",industryName, (pageNo - 1)*pageSize,pageSize);	

		}else if(StringUtil.isNotBlank(payerCode) &&  StringUtil.isNotBlank(payerName) &&  StringUtil.isNotBlank(organName) &&  StringUtil.isNotBlank(industryName) ){
			 list= db.query("select * from  tb_tax_source s, tb_tax_payer p, tb_tax_organ o, tb_industry i where s.payerId=p.id and p.industryId=i.id and p.taxOrganId=o.id and s.removeState=0 and payerCode=? and payerName=? and  organName=?  and industryName=? limit ?,?",payerCode,payerName,organName,industryName, (pageNo - 1)*pageSize,pageSize);	

		}else if(StringUtil.isBlank(payerCode) &&  StringUtil.isBlank(payerName) &&  StringUtil.isBlank(organName) &&  StringUtil.isBlank(industryName)){
			list= db.query("select * from  tb_tax_source s, tb_tax_payer p, tb_tax_organ o, tb_industry i where s.payerId=p.id and p.industryId=i.id and p.taxOrganId=o.id and s.removeState=0 limit ?,?", (pageNo - 1)*pageSize,pageSize);	
			
		}
		
		
		
		
		
	
		return list;
	}
	/*
	 * 总条数
	 * @see com.tsms.dao.Tb_Tax_SourceDao#listAllTb_Tax_SourcesByPageCount()
	 */
	@Override
	public int listAllTb_Tax_SourcesByPageCount(String payerCode,String payerName,String organName,String industryName) {
		List<Map<String, String>> list=null;
		if(StringUtil.isNotBlank(payerCode)){
			list = db.query("select count(*) cou from tb_tax_payer p, tb_tax_organ o, tb_industry i, tb_tax_source s where p.taxOrganId=o.id and p.industryId=i.id and s.payerId=p.id and s.removeState=0 and payerCode=?; ",payerCode);

		}else if(StringUtil.isNotBlank(payerName)){
			list = db.query("select count(*) cou from tb_tax_payer p, tb_tax_organ o, tb_industry i, tb_tax_source s where p.taxOrganId=o.id and p.industryId=i.id and s.payerId=p.id and s.removeState=0 and payerName=?; ",payerName);

		}else if(StringUtil.isNotBlank(organName)){
			list = db.query("select count(*) cou from tb_tax_payer p, tb_tax_organ o, tb_industry i, tb_tax_source s where p.taxOrganId=o.id and p.industryId=i.id and s.payerId=p.id and s.removeState=0 and organName=?; ",organName);

		}else if(StringUtil.isNotBlank(industryName)){
			list = db.query("select count(*) cou from tb_tax_payer p, tb_tax_organ o, tb_industry i, tb_tax_source s where p.taxOrganId=o.id and p.industryId=i.id and s.payerId=p.id and s.removeState=0 and industryName=?; ",industryName);

		}else if(StringUtil.isNotBlank(payerCode) && StringUtil.isNotBlank(payerName)  && StringUtil.isNotBlank(organName) && StringUtil.isNotBlank(industryName)){
			list = db.query("select count(*) cou from tb_tax_payer p, tb_tax_organ o, tb_industry i, tb_tax_source s where p.taxOrganId=o.id and p.industryId=i.id and s.payerId=p.id and s.removeState=0 and payerCode=? and payerName=? and organName=? industryName=?;",payerCode,payerName,organName,industryName);

		}else if(StringUtil.isBlank(payerCode) && StringUtil.isBlank(payerName)  && StringUtil.isBlank(organName) && StringUtil.isBlank(industryName)){
			list = db.query("select count(*) cou from tb_tax_payer p, tb_tax_organ o, tb_industry i, tb_tax_source s where p.taxOrganId=o.id and p.industryId=i.id and s.payerId=p.id and s.removeState=0;");
			
		}
		return Integer.parseInt(list.get(0).get("cou"));
	}
	
	/*
	 * 未被调查企业分页查询
	 */
	public List<Map<String, String>> getAllTb_Tax_Sources02(int pageNo, int pageSize,String payerCode,String payerName) {
		List<Map<String, String>> list=null;
		if(StringUtil.isNotBlank(payerCode)){
			 list= db.query("select * from   tb_tax_payer p, tb_tax_organ o, tb_industry i where   p.industryId=i.id and p.taxOrganId=o.id and payerCode =?  limit ?,?",payerCode, (pageNo - 1)*pageSize,pageSize);	

		}else if(StringUtil.isNotBlank(payerName)){
			 list= db.query("select * from   tb_tax_payer p, tb_tax_organ o, tb_industry i where   p.industryId=i.id and p.taxOrganId=o.id and payerName=? limit ?,?",payerName, (pageNo - 1)*pageSize,pageSize);	

		}else if(StringUtil.isNotBlank(payerCode) && StringUtil.isNotBlank(payerName)){
			 list= db.query("select * from   tb_tax_payer p, tb_tax_organ o, tb_industry i where   p.industryId=i.id and p.taxOrganId=o.id and payerCode=? and payerName=?   limit ?,?",payerCode,payerName, (pageNo - 1)*pageSize,pageSize);	

		}else if(StringUtil.isBlank(payerCode) && StringUtil.isBlank(payerName)){
			list= db.query("select * from   tb_tax_payer p, tb_tax_organ o, tb_industry i where   p.industryId=i.id and p.taxOrganId=o.id  limit ?,?", (pageNo - 1)*pageSize,pageSize);	
			
		}
		return list;
	}
	/*
	 * 未被调查企业总条数
	 * @return
	 */
	public int listAllTb_Tax_SourcesByPageCount02(String payerCode,String payerName) {
		List<Map<String, String>> list=null;
		
		if(StringUtil.isNotBlank(payerCode)){
		    list = db.query("select count(*) cou from tb_tax_payer p, tb_tax_organ o, tb_industry i where p.taxOrganId=o.id and p.industryId=i.id and payerCode=? ;",payerCode);

		} else if(StringUtil.isNotBlank(payerName)){
		    list = db.query("select count(*) cou from tb_tax_payer p, tb_tax_organ o, tb_industry i where p.taxOrganId=o.id and p.industryId=i.id and payerName=? ;",payerName);

		}else if(StringUtil.isNotBlank(payerCode)  && StringUtil.isNotBlank(payerName)){
		    list = db.query("select count(*) cou from tb_tax_payer p, tb_tax_organ o, tb_industry i where p.taxOrganId=o.id and p.industryId=i.id and payerCode=? and payerName=? ;",payerCode,payerName);

		}else if(StringUtil.isBlank(payerCode)  && StringUtil.isBlank(payerName)){
			list = db.query("select count(*) cou from tb_tax_payer p, tb_tax_organ o, tb_industry i where p.taxOrganId=o.id and p.industryId=i.id ;");
			
		}
		
		return Integer.parseInt(list.get(0).get("cou"));
	}
	/*
	 * 查询
	 */
/*	public List<Map<String, String>> getTb_Tax_SourceById(int id) {
//		List<Map<String, String>> list = db.query(" select * from tb_tax_source join  tb_tax_payer on  tb_tax_source .payerId = tb_tax_payer.id join tb_industry on tb_tax_payer.industryId = tb_industry.id join tb_tax_organ on  tb_tax_payer.taxOrganId = tb_tax_organ.id join tb_user on tb_tax_payer.userId = tb_user.id where tb_tax_source.id = ?", id);
		List<Map<String, String>> list = db.query("select  s.id,s.payerId,o.id as oid,i.id as iid,s.taskName,o.organName,t.taxerName,ta.taxerName as tatn,s.executeTime,s.taskState,p.payerCode,p.payerName,p.bizAddress,org.organName as orgon,i.industryName,p.bizScope,p.invoiceType,p.legalPerson,p.legalIdCard,p.finaceName,p.finaceIdCard,p.taxerName as ptn,p.recordDate,u.username from tb_tax_source s, tb_tax_payer p, tb_tax_organ o, tb_tax_organ org, tb_user u, tb_industry i, tb_taxer t, tb_taxer ta where s.payerId=p.id and s.subOrganId=o.id and p.taxOrganId=org.id and s.approverId=t.id and s.executeId=ta.id and s.recordUserId=u.id and p.industryId=i.id and s.id=?",id);
		
		return list;
	}*/
	
	/**
	  * 根据ID查询 Tasker详情 纳税人基本信息部分的方法1
	  * */
	public List<Map<String, String>> getTb_Tax_SourceByIda(int id) {
		List<Map<String, String>> list = db.query(" select * from tb_tax_source join  tb_tax_payer on  tb_tax_source .payerId = tb_tax_payer.id join tb_industry on tb_tax_payer.industryId = tb_industry.id join tb_tax_organ on  tb_tax_payer.taxOrganId = tb_tax_organ.id join tb_user on tb_tax_payer.userId = tb_user.id where tb_tax_source.id = ?;", id);
		if(list.size()>0){
			return list;
		}
		return null;
	}

	 
	@Override
	/**
	  * 根据ID查询 Tasker详情 任务基本信息部分部分的方法2 
	  * */
	public List<Map<String, String>> getTb_Tax_SourceByIdb(int id) {
		List<Map<String, String>> list = db.query("select * from tb_tax_source join tb_taxer on tb_tax_source.approverId = tb_taxer.id where tb_tax_source.id = ?",id); 
		if(list.size()>0){
			return list;
		}
		
		return null;
	}

	@Override
	/**
	  * 根据ID查询 Tasker详情 任务基本信息部分部分的方法3
	  * */
	public List<Map<String, String>> getTb_Tax_SourceByIdc(int id) {
		List<Map<String, String>> list = db.query("select * from tb_tax_source join tb_taxer on tb_tax_source.executeId = tb_taxer.id where tb_tax_source.id = ?",id); 
		if(list.size()>0){
			return list;
		}
		
		return null;
		 
	}
	
	
	
	
	
	/*
	 * 根据id删除
	 */
	public boolean deleteTb_Tax_SourceById(int id){
		
		return  db.update("update tb_tax_source set removeState=1 where id=?", id);
		
	}
	/*
	 * 修改
	 */
	public boolean updateTb_Tax_SourceById(Tb_Tax_Source ts) {
		boolean b = db.update("update tb_tax_source set subOrganId=?,approverId=?,executeId=?,executeTime=?,taskState=? where id=?", ts.getSubOrganId(),ts.getApproverId(),ts.getExecuteId(),ts.getExecuteTime(),ts.getTaskState(),ts.getId());
		return b;
	}

	
	
	public List<Map<String, String>> getTb_Tax_SourceById02(String payerCode) {
		
		List<Map<String, String>> list = db.query("select * from tb_tax_payer p, tb_tax_organ o, tb_industry i, tb_user u where p.taxOrganId=o.id and p.industryId=i.id and p.userId=u.id and p.payerCode=?",payerCode);
		return list;
	}
	
	/**
	  * 根据用户输入的纳税人识别号，查询纳税人基本信息
	  * 
	  * */
	public List<Map<String, String>> getPayerInfoByPayerCode(String payerCode) {
		List<Map<String, String>> list = db.query("select * from tb_tax_payer join tb_tax_organ on tb_tax_payer.taxOrganId = tb_tax_organ.id join tb_industry on tb_tax_payer.industryId = tb_industry.id join tb_user on tb_tax_payer.userId = tb_user.id join tb_taxer on tb_user.taxerId = tb_taxer.id where tb_tax_payer.payerCode =?", payerCode); 
		if(list.size()>0){
			return list;
		}
		
		return null;
	}

	
	
	/*
	 * 调查任务录入
	 */
	
	public boolean addTask(Object[] obj) {
	//	boolean boo = db.update("insert into tb_tax_source  (payerId,taskName,subOrganId,approverId,executeId,executeTime,taskState) values(0,?,?,?,?,?,?) ",obj); 

		boolean boo = db.update("insert into tb_tax_source set payerId=?,taskName=?,subOrganId=?,approverId=?,executeId=?,executeTime=?,taskState=?,recordTaskDate =?",obj); 
		if(boo==true){
			return boo;
		}
		
		return false;
	}
	
	
	

	
}
