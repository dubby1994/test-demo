package cn.dubby.test.demo.web;

import cn.dubby.test.demo.bean.User;
import cn.dubby.test.demo.dao.DB1UserDAO;
import cn.dubby.test.demo.dao.DB2UserDAO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yangzheng03 on 2018/6/20.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private DB1UserDAO db1UserDAO;

    @Resource
    private DB2UserDAO db2UserDAO;

    @RequestMapping("list")
    public List<User> list(@RequestParam(value = "db", defaultValue = "0") int dbId) {
        switch (dbId) {
            case 1:
                return db1UserDAO.userList();
            case 2:
                return db2UserDAO.userList();
            default:
                List<User> users1 = db1UserDAO.userList();
                List<User> users2 = db2UserDAO.userList();
                users1.addAll(users2);
                return users1;
        }
    }

}
