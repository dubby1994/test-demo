package cn.dubby.test.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by yangzheng03 on 2018/6/21.
 */
@Component
@ConfigurationProperties(prefix="mybatis")
public class MyBatisConfig {

    private DataSourceConfig db1;

    private DataSourceConfig db2;

    public DataSourceConfig getDb1() {
        return db1;
    }

    public void setDb1(DataSourceConfig db1) {
        this.db1 = db1;
    }

    public DataSourceConfig getDb2() {
        return db2;
    }

    public void setDb2(DataSourceConfig db2) {
        this.db2 = db2;
    }

    public static class DataSourceConfig {
        private String name;
        private String driver;
        private String url;
        private String username;
        private String password;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDriver() {
            return driver;
        }

        public void setDriver(String driver) {
            this.driver = driver;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

}
