package test.com.fanyafeng.mapper;

import com.fanyafeng.mapper.IOrdersCustomMapper;
import com.fanyafeng.model.Orders;
import com.fanyafeng.model.OrdersCustom;
import com.fanyafeng.model.UserCustom;
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
 * Data： 16/10/13 16:23
 * Email: fanyafeng@live.cn
 */
public class IOrdersCustomMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws Exception {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("Configuration.xml"));
    }

    @Test
    public void testFindUserByOrderId() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IOrdersCustomMapper iOrdersCustomMapper = sqlSession.getMapper(IOrdersCustomMapper.class);
//        List<OrdersCustom> userCustomList = iOrdersCustomMapper.findUserByOrderIdResultMap();
//        for (int i = 0; i < userCustomList.size(); i++) {
//            System.out.println(userCustomList.get(i).toString());
//        }

        List<Orders> ordersList = iOrdersCustomMapper.findOrderAndDetailResultMap();
        for (int i = 0; i < ordersList.size(); i++) {
            System.out.println(ordersList.get(i).toString());
        }
        sqlSession.close();
    }


}