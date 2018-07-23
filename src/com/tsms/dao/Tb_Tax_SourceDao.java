package com.tsms.dao;

import java.util.List;
import java.util.Map;

public interface  Tb_Tax_SourceDao {
	List<Map<String, String>> getAllTb_Tax_Sources(int pageNo,int pageSize,String payerCode,String payerName,String organName,String industryName);
	
	int listAllTb_Tax_SourcesByPageCount(String payerCode,String payerName,String organName,String industryName);

	List<Map<String, String>> getTb_Tax_SourceByIdb(int id);

	List<Map<String, String>> getTb_Tax_SourceByIdc(int id);
}
