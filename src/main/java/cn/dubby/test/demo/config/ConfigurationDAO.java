package cn.dubby.test.demo.config;

import cn.dubby.test.demo.bean.User;
import cn.dubby.test.demo.mapper.UserMapper;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;

/**
 * Created by yangzheng03 on 2018/6/21.
 */
public class ConfigurationDAO {

    private SqlSessionFactory sqlSessionFactory;

    protected void init(String name, String driver, String url, String username, String password) {
        DataSource dataSource = new UnpooledDataSource(driver, url, username, password);
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment(name, transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        initConfiguration(configuration);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    }

    /**
     * 详细配置
     */
    private void initConfiguration(Configuration configuration) {
        // 其他配置
        configuration.getTypeAliasRegistry().registerAliases("cn.dubby.test.demo.bean");
        // 增加mapper
        configuration.addMapper(UserMapper.class);
    }

    protected SqlSession getSqlSession() {
        return getSqlSession(true);
    }

    protected SqlSession getSqlSession(boolean autoCommit) {
        return sqlSessionFactory.openSession(autoCommit);
    }

}
