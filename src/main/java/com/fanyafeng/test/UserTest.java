package com.fanyafeng.test;

import com.fanyafeng.mapper.IUserMapper;
import com.fanyafeng.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.List;

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
//            单个数据查询
//            User user = (User) sqlSession.selectOne("com.fanyafeng.dao.IUserDao.selectUserById", 2);
//            System.out.println(user.getAddress() + user.getSex() + user.getBirthday());
//            System.out.println(user.getId() + user.getUsername());
//
//
//            列表查询
//            List<User> userList = sqlSession.selectList("com.fanyafeng.dao.IUserDao.queryUserByName", "%李宁%");
//            for (int i = 0; i < userList.size(); i++) {
//                System.out.println(userList.get(i).toString());
//            }

//            插入操作
//            User user = new User();
//            user.setId(100);
//            user.setBirthday(new Date());
//            user.setUsername("李宁");
//            user.setSex("女");
//            user.setAddress("家里蹲");
//            int isAdd = sqlSession.insert("com.fanyafeng.dao.IUserDao.add", user);
//            进行事物操作后一定要commit,不然不会生效
//            sqlSession.commit();//不要忘记


//            根据id进行删除,感觉在删除之前应该先进行查询,存在的话删除,不存在的话给相应的提示
//            这里是初学测试没有做那么麻烦
//            sqlSession.delete("com.fanyafeng.dao.IUserDao.del", 100);
//            sqlSession.commit();


//            根据id更新数据库
//            User user = (User) sqlSession.selectOne("com.fanyafeng.dao.IUserDao.selectUserById", 1);
//            user.setBirthday(new Date());
//            user.setAddress("更新后的信息");
//            sqlSession.update("com.fanyafeng.dao.IUserDao.alter", user);
//            sqlSession.commit();

//            通过mapper映射
//            IUserMapper iUserMapper = sqlSession.getMapper(IUserMapper.class);
//            iUserMapper.selectUserById(1);
//            System.out.println(iUserMapper.selectUserById(1).toString());

        } finally {
            sqlSession.close();
        }
    }


}
