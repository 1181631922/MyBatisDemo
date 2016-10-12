package test.com.fanyafeng.mapper;

import com.fanyafeng.mapper.IUserMapper;
import com.fanyafeng.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

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
}