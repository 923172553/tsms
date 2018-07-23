package com.tsms.dao.impl;

import java.util.List;
import java.util.Map;
import com.tsms.dao.Tb_Tax_PayerDao;
import com.tsms.entity.Tb_Tax_Payer;
import com.tsms.util.DBUtil;
import com.tsms.util.StringUtil;

public class Tb_Tax_PayerDaoImpl implements Tb_Tax_PayerDao {
	private DBUtil db=DBUtil.getInstance();
	/**
	 * 分页查询
	 */
	@Override
	public List<Map<String, String>> getAllTb_Tax_Payers(int pageNo, int pageSize,String payerCode,String payerName) {
		List<Map<String, String>> list=null;
		
		if(StringUtil.isNotBlank(payerCode)){
			 list = db.query("select * from tb_tax_payer p, tb_tax_organ o, tb_industry i, tb_user u where p.taxOrganId=o.id and p.industryId=i.id and p.userId=u.id and p.removeState=0  and p.payerCode=?  limit ?,?",payerCode,(pageNo - 1)*pageSize,pageSize);

		}else if(StringUtil.isNotBlank(payerName)){
			 list = db.query("select * from tb_tax_payer p, tb_tax_organ o, tb_industry i, tb_user u where p.taxOrganId=o.id and p.industryId=i.id and p.userId=u.id and p.removeState=0  and p.payerName=?  limit ?,?",payerName,(pageNo - 1)*pageSize,pageSize);

		}else if(StringUtil.isNotBlank(payerCode) && StringUtil.isNotBlank(payerName)){
			 list = db.query("select * from tb_tax_payer p, tb_tax_organ o, tb_industry i, tb_user u where p.taxOrganId=o.id and p.industryId=i.id and p.userId=u.id and p.removeState=0  and p.payerCode=? and payerName=?  limit ?,?",payerCode,payerName,(pageNo - 1)*pageSize,pageSize);

		}else if(StringUtil.isBlank(payerCode) && StringUtil.isBlank(payerName)){
			list = db.query("select * from tb_tax_payer p, tb_tax_organ o, tb_industry i, tb_user u where p.taxOrganId=o.id and p.industryId=i.id and p.userId=u.id and p.removeState=0 limit ?,?",(pageNo - 1)*pageSize,pageSize);
			
		}
		
		
		
		
		return list;
	}
	/**
	 * 总条数
	 */
	@Override
	public int listAllTb_Tax_PayersByPageCount(String payerCode,String payerName) {
		List<Map<String, String>> list=null;
		if(StringUtil.isNotBlank(payerCode)){
			 list = db.query("select count(*) cou from tb_tax_payer p, tb_tax_organ o, tb_industry i where p.taxOrganId=o.id and p.industryId=i.id and p.removeState=0 and payerCode=?",payerCode);
			
			 
		}else if(StringUtil.isNotBlank(payerName)){
			 list = db.query("select count(*) cou from tb_tax_payer p, tb_tax_organ o, tb_industry i where p.taxOrganId=o.id and p.industryId=i.id and p.removeState=0 and payerName=?",payerName);
			 
			 
		}else if(StringUtil.isNotBlank(payerCode) && StringUtil.isNotBlank(payerName)){
			 list = db.query("select count(*) cou from tb_tax_payer p, tb_tax_organ o, tb_industry i where p.taxOrganId=o.id and p.industryId=i.id and p.removeState=0 and payerCode=? and payerName=?",payerCode,payerName);
			 
			 
		}else if(StringUtil.isBlank(payerCode)  &&   StringUtil.isBlank(payerName)){
			list = db.query("select count(*) cou from tb_tax_payer p, tb_tax_organ o, tb_industry i where p.taxOrganId=o.id and p.industryId=i.id and p.removeState=0");
			
		}
		
		return Integer.parseInt(list.get(0).get("cou"));
		
		
		
	}
	/*
	 * 查询
	 */
	public List<Map<String, String>> getTax_PayerById(int id) {
		List<Map<String, String>> list = db.query("select * from tb_tax_payer p, tb_tax_organ o, tb_industry i, tb_taxer t, tb_user u where p.taxOrganId=o.id and p.industryId=i.id and o.leaderId=t.id and p.userId=u.id and p.id=?", id);
		return list;
	}
	/*
	 * 根据id删除
	 */
	public boolean deleteTb_Tax_PayerById(int id){
		
		return  db.update("update tb_tax_payer set removeState=1 where id=?", id);
		
	}
	/*
	 * 根据id查询一条数据
	 */
	public List<Map<String, String>> getTb_Tax_PayerById(int id) {
		List<Map<String, String>> list = db.query("select p.id,p.payerCode,p.payerName,p.bizAddress,p.bizAddressPhone,p.taxOrganId,o.organName,p.industryId,i.industryName,p.bizScope,p.invoiceType,p.legalPerson,p.legalIdCard,p.finaceName,p.finaceIdCard,t.taxerName as tn,p.recordDate from tb_tax_payer p,tb_tax_organ o,tb_industry i,tb_taxer t where p.taxOrganId=o.id and p.industryId=i.id and o.leaderId=t.id and p.id=?", id);
		return list;
	}
	
	/*
	 * 根据Id修改数据
	 */
	public boolean updateTb_Tax_PayerById(Tb_Tax_Payer pp) {
		String sql = "update tb_tax_payer set payerName=?,bizAddress=?,bizAddressPhone=?,taxOrganId=?,industryId=?,bizScope=?,invoiceType=?,legalPerson=?,legalIdCard=?,finaceName=?,finaceIdCard=? where id =?";
	//	String sql = "update tb_tax_payer set payerName=? where id =?";
	//	return db.update(sql, pp.getPayerName(),pp.getId());
		return db.update(sql, pp.getPayerName(),pp.getBizAddress(),pp.getBizAddressPhone(),pp.getTaxOrganId(),pp.getIndustryId(),pp.getBizScope(),pp.getInvoiceType(),pp.getLegalPerson(),pp.getLegalIdCard(),pp.getFinaceName(),pp.getFinaceIdCard(),pp.getId());
	
	}

	
	
	/*
	 * 添加
	 */
	public boolean addTb_Tax_Payer(Tb_Tax_Payer p){
	boolean b=db.update("insert into tb_tax_payer (payerCode,payerName,bizAddress,bizAddressPhone,taxOrganId,industryId,bizScope,invoiceType,legalPerson,legalIdCard,finaceName,finaceIdCard,recordDate,userId) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new Object[]{p.getPayerCode(),p.getPayerName(),p.getBizAddress(),p.getBizAddressPhone(),p.getTaxOrganId(),p.getIndustryId(),p.getBizScope(),p.getInvoiceType(),p.getLegalPerson(),p.getLegalIdCard(),p.getFinaceName(),p.getFinaceIdCard(),p.getRecordDate(),p.getUserId() });
		return b;
		
	}
	
	/**
	  * 根据用户输入的纳税人识别号，查询纳税人基本信息
	  * 
	  * */
	public List<Map<String, String>> getTb_Tax_PayerById02(String payerCode) {
		
/*		List<Map<String, String>> list = db.query("select * from tb_tax_payer p, tb_tax_organ o, tb_industry i, tb_user u where p.taxOrganId=o.id and p.industryId=i.id and p.userId=u.id and p.payerCode=?",payerCode);
		return list;*/
		List<Map<String, String>> list = db.query("select * from tb_tax_payer join tb_tax_organ on tb_tax_payer.taxOrganId = tb_tax_organ.id join tb_industry on tb_tax_payer.industryId = tb_industry.id join tb_user on tb_tax_payer.userId = tb_user.id join tb_taxer on tb_user.taxerId = tb_taxer.id where tb_tax_payer.payerCode =?", payerCode); 
		if(list.size()>0){
			return list;
		}
		
		return null;
	}
	
	/*
	 * 新建任务
	 */
	
	public boolean addTask(Object[] obj) {
		boolean boo = db.update("insert into tb_tax_source set payerId=?,taskName=?,subOrganId=?,approverId=?,executeId=?,executeTime=?,taskState=?,recordTaskDate =?;",obj); 
		if(boo==true){
			return boo;
		}
		return false;
	
	
}
	
}	

