package com.fanyafeng.dao;

import com.fanyafeng.model.User;

/**
 * Author： fanyafeng
 * Data： 16/10/11 14:55
 * Email: fanyafeng@live.cn
 */
public interface IUserDao {
    public User selectUserById(int id);
}
