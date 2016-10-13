package com.fanyafeng.mapper;

import com.fanyafeng.model.User;
import com.fanyafeng.model.UserCustom;
import com.fanyafeng.model.UserQueryVo;

import java.util.List;

/**
 * Author： fanyafeng
 * Data： 16/10/11 14:55
 * Email: fanyafeng@live.cn
 */
public interface IUserMapper {

//    只能传一个参数,当需要多个参数时,可以采用pojo

    public List<User> queryUserByName(String name);

    public User selectUserById(int id);

    public void add();

    public void del(int id);

    public void alter(int id);

    public List<UserCustom> findUserByUserQuery(UserQueryVo userQueryVo);

    public int findUserCount(UserQueryVo userQueryVo);

    public User findUserByIdResultMap(int id);

    public List<UserCustom> findUserList(UserQueryVo userQueryVo);

    public List<UserCustom> queryUserList(UserQueryVo userQueryVo);
}
