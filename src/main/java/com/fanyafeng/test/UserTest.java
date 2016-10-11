package com.fanyafeng.test;

import com.fanyafeng.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Author： fanyafeng
 * Data： 16/10/11 14:58
 * Email: fanyafeng@live.cn
 */
public class UserTest {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("Configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            User user = (User) sqlSession.selectOne("com.fanyafeng.dao.IUserDao.selectUserById", 2);
            System.out.println(user.getAddress() + user.getSex() + user.getBirthday());
            System.out.println(user.getId() + user.getUsername());
        } finally {
            sqlSession.close();
        }
    }
}
