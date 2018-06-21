package cn.dubby.test.demo.web;

import cn.dubby.test.demo.service.ChangeConfigService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by yangzheng03 on 2018/6/20.
 */
@RestController
@RequestMapping("env")
public class EnvController {

    @Resource
    private ChangeConfigService changeConfigService;

    @RequestMapping("change")
    public boolean changeEnv(String env) {
        return changeConfigService.changeEnv(env);
    }

}
