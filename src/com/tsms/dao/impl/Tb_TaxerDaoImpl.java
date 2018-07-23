package com.tsms.dao.impl;

import java.util.List;
import java.util.Map;
import com.tsms.dao.Tb_TaxerDao;
import com.tsms.entity.Tb_Taxer;
import com.tsms.util.DBUtil;
import com.tsms.util.StringUtil;

public class Tb_TaxerDaoImpl implements Tb_TaxerDao {
	private DBUtil db=DBUtil.getInstance();
	/**
	 * 分页查询
	 */
	@Override
	public List<Map<String, String>> getAllTb_Taxers(int pageNo, int pageSize,String taxerName) {
		List<Map<String, String>> list=null;
		if(StringUtil.isNotBlank(taxerName)){
			list = db.query("select * from  tb_taxer p, tb_tax_organ o where p.organId=o.id and p.state=0 and taxerName=? limit ?,?",taxerName, (pageNo - 1)*pageSize,pageSize);

		}else if(StringUtil.isBlank(taxerName)){
			list = db.query("select * from  tb_taxer p, tb_tax_organ o where p.organId=o.id and p.state=0 limit ?,?",(pageNo - 1)*pageSize,pageSize);
			
		}
		
		

		return list;
	}
	/**
	 * 总条数
	 */
	@Override
	public int listAllTb_TaxersByPageCount(String taxerName) {
		List<Map<String, String>> list=null;
		if(StringUtil.isNotBlank(taxerName)){
			list = db.query("select count(*) cou  from tb_taxer p, tb_tax_organ o where p.organId=o.id and p.state=0 and taxerName=?",taxerName);

		}else if(StringUtil.isBlank(taxerName)){
			list = db.query("select count(*) cou  from tb_taxer p, tb_tax_organ o where p.organId=o.id and p.state=0");

		}
		return Integer.parseInt(list.get(0).get("cou"));
	
	}
	/*
	 * 查询
	 */
	public List<Map<String, String>> getTb_TaxerById(int id) {
		List<Map<String, String>> list = db.query("select * from tb_taxer p, tb_tax_organ o where p.organId=o.id  and p.id=?", id);
		return list;
	}
	
	 /*
	  *  根据id删除
	  */
	 
	public boolean deleteTb_TaxerById(int id){
		
		return  db.update("update tb_taxer set state=1 where id=?", id);
		
	}
	/*
	 * 根据id查询一条数据
	 */
//	public List<Map<String, String>> getTb_TaxerById1(int id) {
//		List<Map<String, String>> list = db.query("select p.taxerCode,p.taxerName,p.mobile,p.address,p.sex,p.birthday,p.email,p.organId    from tb_tax_organ o,tb_taxer p where  o.leaderId=p.id and p.id=?", id);
//		return list;
//	}
	
	/*
	 * 根据Id修改数据
	 */
	public boolean updateTb_TaxerById(Tb_Taxer pp) {
		String sql = "update tb_taxer set taxerCode=?,taxerName=?,mobile=?,address=?,sex=?,birthday=?,email=?,organId=?    where id =?";
		return db.update(sql, pp.getTaxerCode(),pp.getTaxerName(),pp.getMobile(),pp.getAddress(),pp.getSex(),pp.getBirthday(),pp.getEmail(),pp.getOrganId(),pp.getId());

	}

	 /*
	  * 添加
	  */
	 
	public boolean addTb_Taxer(Tb_Taxer p){
	boolean b=db.update("insert into tb_taxer (taxerCode,taxerName,mobile,address,sex,birthday,email,organId) values (?,?,?,?,?,?,?,?)", new Object[]{p.getTaxerCode(),p.getTaxerName(),p.getMobile(),p.getAddress(),p.getSex(),p.getBirthday(),p.getEmail(),p.getOrganId()});
		return b;
		
	}
	
	
	
	
}
