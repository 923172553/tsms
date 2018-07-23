package com.tsms.dao;

import java.util.List;
import java.util.Map;

public interface Tb_TaxerDao {

	List<Map<String, String>>getAllTb_Taxers(int pageNo,int pageSize,String taxerName);
	
	int listAllTb_TaxersByPageCount(String taxerName);
}
