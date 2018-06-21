package cn.dubby.test.demo.web;

import cn.dubby.test.demo.bean.User;
import cn.dubby.test.demo.config.MyBatisConfig;
import cn.dubby.test.demo.dao.DB1UserDAO;
import cn.dubby.test.demo.dao.DB2UserDAO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yangzheng03 on 2018/6/20.
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Resource
    private MyBatisConfig myBatisConfig;

    @Resource
    private DB2UserDAO db2UserDAO;

    @RequestMapping("config")
    public List<MyBatisConfig.DataSourceConfig> config() {
        List<MyBatisConfig.DataSourceConfig> list = new ArrayList<>();
        list.add(myBatisConfig.getDb1());
        list.add(myBatisConfig.getDb2());
        return list;
    }

}
