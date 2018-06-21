package cn.dubby.test.demo.service;

import cn.dubby.test.demo.config.MyBatisConfig;
import cn.dubby.test.demo.dao.DB1UserDAO;
import cn.dubby.test.demo.dao.DB2UserDAO;
import org.apache.ibatis.io.Resources;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by yangzheng03 on 2018/6/21.
 */
@Service
public class ChangeConfigService {

    @Resource
    private DB1UserDAO db1UserDAO;

    @Resource
    private DB2UserDAO db2UserDAO;

    public boolean changeEnv(String env) {
        try {
            MyBatisConfig myBatisConfig = loadProperties(env);
            db1UserDAO.init(myBatisConfig.getDb1());
            db2UserDAO.init(myBatisConfig.getDb2());
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    private MyBatisConfig loadProperties(String env) throws IOException {
        String fileName = "application-" + env + ".properties";
        InputStream inputStream = Resources.getResourceAsStream(fileName);
        Properties properties = new Properties();
        properties.load(inputStream);

        MyBatisConfig myBatisConfig = new MyBatisConfig();
        MyBatisConfig.DataSourceConfig db1 = new MyBatisConfig.DataSourceConfig();
        initDataSourceConfig(db1, properties, "db1");
        MyBatisConfig.DataSourceConfig db2 = new MyBatisConfig.DataSourceConfig();
        initDataSourceConfig(db2, properties, "db2");
        myBatisConfig.setDb1(db1);
        myBatisConfig.setDb2(db2);

        return myBatisConfig;
    }

    private void initDataSourceConfig(MyBatisConfig.DataSourceConfig dataSourceConfig, Properties properties, String dbName) {
        dataSourceConfig.setName(properties.getProperty("mybatis." + dbName + ".name"));
        dataSourceConfig.setDriver(properties.getProperty("mybatis." + dbName + ".driver"));
        dataSourceConfig.setUrl(properties.getProperty("mybatis." + dbName + ".url"));
        dataSourceConfig.setUsername(properties.getProperty("mybatis." + dbName + ".username"));
        dataSourceConfig.setPassword(properties.getProperty("mybatis." + dbName + ".password"));
    }

}
