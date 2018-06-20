package cn.dubby.test.demo.mapper;

import cn.dubby.test.demo.bean.User;

import java.util.List;

/**
 * Created by yangzheng03 on 2018/6/20.
 */
public interface UserMapper {

    List<User> selectAll();

}
