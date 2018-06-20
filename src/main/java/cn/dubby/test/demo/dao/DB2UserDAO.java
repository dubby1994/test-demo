package cn.dubby.test.demo.dao;

import cn.dubby.test.demo.bean.User;
import cn.dubby.test.demo.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by yangzheng03 on 2018/6/20.
 */
@Repository
public class DB2UserDAO {

    private static SqlSessionFactory SQL_SESSION_FACTORY = null;

    static {
        String resource = "mybatis/db2-mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SQL_SESSION_FACTORY = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public List<User> userList() {
        SqlSession session = SQL_SESSION_FACTORY.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        return userMapper.selectAll();
    }

}
