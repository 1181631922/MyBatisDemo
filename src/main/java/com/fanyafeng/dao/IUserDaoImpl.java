package com.fanyafeng.dao;

import com.fanyafeng.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Author： fanyafeng
 * Data： 16/10/12 11:25
 * Email: fanyafeng@live.cn
 */
public class IUserDaoImpl implements IUserDao {

    //    需要向dao中注入sqlsessionfactory
//    通过构造方法注入session工厂
    private SqlSessionFactory sqlSessionFactory;

    public IUserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<User> queryUserByName(String name) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userList = sqlSession.selectList("com.fanyafeng.dao.IUserDao.queryUserByName", name);
        sqlSession.close();
        return userList;
    }

    public User selectUserById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("com.fanyafeng.dao.IUserDao.selectUserById", id);
        sqlSession.close();
        return user;
    }

    public void add() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("com.fanyafeng.dao.IUserDao.selectUserById");
        sqlSession.close();
    }

    public void del(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("com.fanyafeng.dao.IUserDao.del", id);
        sqlSession.commit();
        sqlSession.close();
    }

    public void alter(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("com.fanyafeng.dao.IUserDao.alter", id);
        sqlSession.commit();
        sqlSession.close();
    }
}
