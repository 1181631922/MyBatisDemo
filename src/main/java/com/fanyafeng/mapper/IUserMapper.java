package com.fanyafeng.mapper;

import com.fanyafeng.model.User;

import java.util.List;

/**
 * Author： fanyafeng
 * Data： 16/10/11 14:55
 * Email: fanyafeng@live.cn
 */
public interface IUserMapper {


    public List<User> queryUserByName(String name);

    public User selectUserById(int id);

    public void add();

    public void del(int id);

    public void alter(int id);

}
