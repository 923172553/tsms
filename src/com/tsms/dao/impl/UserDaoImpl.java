package com.tsms.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import com.tsms.dao.UserDao;
import com.tsms.entity.User;
import com.tsms.util.DBUtil;

public class UserDaoImpl implements UserDao{
	private DBUtil db=DBUtil.getInstance(); 
	@Override
	public User getallUserByUsername(String username) {
		String sql="select * from tb_user where username=? ";
		List<Map<String, String>> list=db.query(sql,username );
		User user=null;
		if(list.size()>0 ){
			user=new User();
			
			try {
				BeanUtils.populate(user, list.get(0));
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return user;
	}
	
	public List<Map<String, String>> getUserById(String username) {
		List<Map<String, String>> list = db.query("select u.id,u.permissionId,u.state,t.taxerCode,t.taxerName,t.mobile,t.address,t.sex,t.birthday,t.email,t.organId,t.state as ts,t.mgr,t.admin,t.recordDate from tb_user u,tb_taxer t where u.taxerId=t.id and u.username=?", username);
		return list;
	}
	
	public User getgetallUserByUsername02(String username){
		String sql="select username,password from tb_user where username=?";
		List<Map<String, String>> list= db.query(sql,username );
		User user=null;
		if(list.size()>0 ){
			user=new User();
			try {
				BeanUtils.populate(user, list.get(0));
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
		
	}
	
	
	
	public boolean getpasswordByUsername(String username, String password) {
		String sql="update tb_user set password=? where username=?";
		boolean b=db.update(sql,password,username );
		return b;

		
	}	
}
