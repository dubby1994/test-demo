package cn.dubby.test.demo.dao;

import cn.dubby.test.demo.bean.User;
import cn.dubby.test.demo.config.ConfigurationDAO;
import cn.dubby.test.demo.config.MyBatisConfig;
import cn.dubby.test.demo.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yangzheng03 on 2018/6/20.
 */
@Repository
public class DB2UserDAO extends ConfigurationDAO {

    @Resource
    private MyBatisConfig myBatisConfig;

    @PostConstruct
    public void init() {
        init(myBatisConfig.getDb2());
    }

    public List<User> userList() {
        try(SqlSession session = getSqlSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            return userMapper.selectAll();
        }
    }

}
