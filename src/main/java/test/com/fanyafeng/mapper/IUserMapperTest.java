package test.com.fanyafeng.mapper;

import com.fanyafeng.mapper.IUserMapper;
import com.fanyafeng.model.User;
import com.fanyafeng.model.UserCustom;
import com.fanyafeng.model.UserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Author： fanyafeng
 * Data： 16/10/12 14:57
 * Email: fanyafeng@live.cn
 */
public class IUserMapperTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws Exception {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("Configuration.xml"));
    }

    @Test
    public void testSelectUserById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        通过mapper映射
        IUserMapper iUserMapper = sqlSession.getMapper(IUserMapper.class);
        iUserMapper.selectUserById(1);
        System.out.println(iUserMapper.selectUserById(1).toString());

        List<User> userList = iUserMapper.queryUserByName("%亚风%");
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i).toString());
        }
    }

    @Test
    public void testFindUserByUserQuery() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IUserMapper iUserMapper = sqlSession.getMapper(IUserMapper.class);
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setSex("男");
        userCustom.setUsername("李宁");
        userQueryVo.setUserCustom(userCustom);
        List<Integer> ids=new ArrayList<Integer>();
        ids.add(9);
        ids.add(10);
        ids.add(23);
        userQueryVo.setIds(ids);
        List<UserCustom> userCustomList = iUserMapper.queryUserList(userQueryVo);
        for (int i = 0; i < userCustomList.size(); i++) {
            System.out.println(userCustomList.get(i).toString());
        }

        int count = iUserMapper.findUserCount(userQueryVo);
        System.out.println("查询结果:" + count);

        User user = iUserMapper.findUserByIdResultMap(1);
        System.out.println(user.toString());
    }
}