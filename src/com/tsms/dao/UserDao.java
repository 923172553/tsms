package com.tsms.dao;

import com.tsms.entity.User;

/**
 *
 * @Author: zhoujunpeng
 * @Date: 2018年7月10日 上午9:40:04
 */
public interface UserDao {
	User getallUserByUsername(String username);
}
