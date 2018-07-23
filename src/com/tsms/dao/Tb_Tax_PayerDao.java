package com.tsms.dao;

import java.util.List;
import java.util.Map;

public interface Tb_Tax_PayerDao {
	
	List<Map<String, String>>getAllTb_Tax_Payers(int pageNo,int pageSize,String payerCode,String payerName);
	
	int listAllTb_Tax_PayersByPageCount(String payerCode,String payerName);
}
