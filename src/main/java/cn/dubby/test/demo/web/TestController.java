package cn.dubby.test.demo.web;

import cn.dubby.test.demo.config.MyBatisConfig;
import cn.dubby.test.demo.dao.DB1UserDAO;
import cn.dubby.test.demo.dao.DB2UserDAO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangzheng03 on 2018/6/20.
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Resource
    private DB1UserDAO db1UserDAO;

    @Resource
    private DB2UserDAO db2UserDAO;

    @RequestMapping("config")
    public List<MyBatisConfig.DataSourceConfig> config() {
        List<MyBatisConfig.DataSourceConfig> list = new ArrayList<>();
        list.add(db1UserDAO.getConfig());
        list.add(db2UserDAO.getConfig());
        return list;
    }

}
